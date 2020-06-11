package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

/**
 * Servlet implementation class RolesServlet
 */
@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json"); //응답을 json 으로 해주기 위해 설정
		
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();
		//System.out.print(list.get(0));
		ObjectMapper objectMapper = new ObjectMapper(); // 얻어낸 리스트를 Json사용하려고 추가했던 라이브러리가 제공해주는 객체
		String json = objectMapper.writeValueAsString(list);
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

}
