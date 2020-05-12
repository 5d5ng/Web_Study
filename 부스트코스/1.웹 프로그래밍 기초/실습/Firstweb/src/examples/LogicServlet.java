package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int v1 = (int)(Math.random()*100) +1;
		int v2 = (int)(Math.random()*100) +1;
		int res = v1 + v2;
		
		req.setAttribute("v1", v1);
		req.setAttribute("v2", v2);
		req.setAttribute("res", res);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(req, resp);
		
		
		
		
	}

	

}
