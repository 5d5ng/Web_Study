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
