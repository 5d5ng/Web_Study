package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 오동의
 *
 */
@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성!!");
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init! ㄴ호출");
	}

	
	public void destroy() {
		System.out.println("destroy! 호출");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//URL직접넘겼을때
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title> form </title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/Firstweb/LifecycleServlet'>"); //POST방식으로 요청
		out.println("name <input type='text' name = 'name'><br> ");
		out.println("<input type ='submit' value='ok'><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.print("<h1>hello "+name+"</h1>");
		out.close();
	}
	


//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service! 호출");
//	}

}
