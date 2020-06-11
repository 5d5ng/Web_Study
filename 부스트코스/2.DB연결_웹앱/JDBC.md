

# JDBC

### JDBC 를 이용한 프로그래밍

1. import java.sql.*;
2. 드라이버 로드
3. Connection 객체 생성
4. Statement 객체 생성
5. SQL에 결과물이 있다면 ResultSet 객체 생성



### JDBC 클래스 생성관계

1. DriverManager

2. Connection

3. Statement

4. ResultSet

   



## 예제

임의의 테이블 Role 에 접근하여 데이터를 가져와 출력할때

1. Maven Project 생성

2. Pom.xml에 

   ```xml
   	<dependency>
     		<groupId>
     			mysql
     		</groupId>
     		<artifactId>mysql-connector-java</artifactId>
     		<version>8.0.19</version>
     	</dependency>
   
   		<plugin>
   				<groupId>org.apache.maven.plugins</groupId>
   				<artifactId>maven-compiler-plugin</artifactId>
   				<version>3.6.1</version>
   				<configuration>
   					<source>1.8</source>
   					<target>1.8</target>
   				</configuration>
   			</plugin>
   ```

   Dependencies,plugins 태그들 내부에 각각 추가 sql버전은 내부환경에 맞게 변경

3. JDBC사용

   1. import
   2. 드라이버 로드
   3. Connection 얻기
   4.  Statement 생성
   5. 질의 수행
   6. ResultSet으로 결과 받기
   7. Close



## 소스코드



Role.java

```java
package kr.or.connect.jdbcexam.dto;

public class Role {
	
	private Integer roleId;
	private String description;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Role(Integer roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	

}

```





RoleDao.java

```java
package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";


	public List<Role> getRoles() 
	{
		List<Role> list = new LinkedList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps  = conn.prepareStatement(sql) ) {

					try(ResultSet rs = ps.executeQuery()){
						while(rs.next()) {
							String description =rs.getString(1);
							int id = rs.getInt("role_id");
							Role role = new Role(id,description);
							list.add(role);
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
		catch(Exception ex){
					ex.printStackTrace();
		}
				
		
		return list;
				
				
	}






public int addRole(Role role) {
	int insertCount = 0;

	Connection conn = null ;
	PreparedStatement ps = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
		String sql =  "INSERT INTO role (role_id,description) VALUES (?,?)";

		ps = conn.prepareStatement(sql);

		ps.setInt(1, role.getRoleId()); //1st ?
		ps.setString(2, role.getDescription()); // 2nd ?

		insertCount = ps.executeUpdate();


	}catch(Exception ex){
		ex.printStackTrace();
	}finally {
		if(ps!=null) {
			try {
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
		if(conn!=null) {
			try {
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	return insertCount;


}


public Role getRole(Integer roleId)  // 정보를 담아낼 객체 
{
	Role role  = null;

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		//Driver Load
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dburl,dbUser,dbpasswd); //커넥션객체 얻어옴 
		String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1,roleId); // 1번인자 = 몇번쨰? 2번쨰 인자 = 
		rs = ps.executeQuery();

		if(rs.next())//roleID에해당 결과값이 없다면?
		{
			String description = rs.getString(1);
			int id = rs.getInt("role_id"); 
			//파라미터 인덱스로 가져오는 것도 가능하고 컬럼명으로 가져오는 것도 가능하다.

			role = new Role(id,description);

		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	return role;

}

}

```



JDBCExam1

```java
package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 { //Select Example for  find role_id

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);

	}

}

```

JDBCExam2

```java

package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 { // Insert 예제 출력 

	public static void main(String[] args) {
		
		int roleId = 51;
		String description = "CLO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertC = dao.addRole(role);
		
		System.out.println(insertC);

	}

}

```



JDBCExam3

```java
package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam3 { //Select 예제 출력  

	public static void main(String[] args) {
		
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		for(Role role :list)
		{
				System.out.println(role);
		}
	}

}

```

