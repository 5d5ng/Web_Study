package kr.or.connect.Todo.dao;
import java.util.List;

import kr.or.connect.Todo.dto.Todo;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "justdoit";
	
	public List<Todo> getTodos(){
		return null;
		
	}
}
