package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

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
