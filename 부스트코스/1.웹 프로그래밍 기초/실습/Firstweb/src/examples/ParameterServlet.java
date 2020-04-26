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
		//URL�ּ��� �Ķ���� ������ �о�鿩 ������ȭ�鿡 ����ϴ� ����
		response.setContentType("text/html"); //������ ���� ����
		PrintWriter out = response.getWriter(); 
		
		out.print("<html><head><title>form</title><head>");
		out.print("<body>");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		out.print("name:"+name+"<br>");
		out.print("age:"+ age+"<br>");
		out.print("</body></html>");
		//�Ķ���� ���� URL�� ��û���� ������ null�̴�
		//�Ķ���ʹ� �ݵ�� URL�θ� ��û�Ǿ� �Ѿ�����ʰ� form �±׿� input�� ���� �Ѱ��� �� �� �ִ�.
		
	}

}
