package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URL주소의 파라미터 정보를 읽어들여 브라우저화면에 출력하는 예제
		response.setContentType("text/html"); //응답할 파일 형식
		PrintWriter out = response.getWriter(); 
		
		out.print("<html><head><title>form</title><head>");
		out.print("<body>");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		out.print("name:"+name+"<br>");
		out.print("age:"+ age+"<br>");
		out.print("</body></html>");
		//파라미터 값을 URL에 요청하지 않으면 null이다
		//파라미터는 반드시 URL로만 요청되어 넘어오지않고 form 태그에 input을 통해 넘겨줄 수 도 있다.
		
	}

}
