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
