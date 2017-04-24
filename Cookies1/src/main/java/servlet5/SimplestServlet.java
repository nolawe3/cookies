package servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimplestServlet
 */
@WebServlet("/Simplest")
public class SimplestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimplestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		for(Cookie cook: request.getCookies()){
//			if(cook.getName().equals("user")){
//				String userName = cook.getValue();
//			}
//		}
//		PrintWriter out = response.getWriter();
//		out.print("<html><head><title>Test</title></head><body>");
//		out.print("<p>Hello 'userName'</p>");
//		out.print("<form action='Logout'>");
//		out.print("<input type='submit' value='logout'/>");
//		out.print("</form></html>");
//		
//		
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
//		Cookie[] cookie = request.getCookies();
//		if (cookie!=null){
//		String userName = "";
//		for(Cookie cook: request.getCookies()){
//			if(cook.getName().equals("user")){
//				userName = cook.getValue();
//			}
//		}
//		
		String userName = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Test</title></head><body>");
		out.print("<p>Hello </p>"+userName);
		out.print("<form action='Logout'>");
		out.print("<input type='submit' value='logout'/>");
		out.print("</form></html>");
		
		}
//		else{
//			response.sendRedirect("");
//		}
		
	}


