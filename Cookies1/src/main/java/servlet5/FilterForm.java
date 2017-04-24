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
 * Servlet implementation class FilterForm
 */
@WebServlet("/")
public class FilterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDatatbase usDB = new UsersDatatbase();  
    private static String checkedVal;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Form</title></head><body>");
		out.print("<form action='' method='post' >");
		Cookie[] cookie = request.getCookies();
		String nameVal = "";
		String value = "";
		String checked = "";
		for(Cookie cook: cookie){
			nameVal = cook.getValue();
			if("user1".equals(nameVal)&&checkedVal!=null){
				value = nameVal;
				checked = "checked";
			}
			
		}
		
		
		out.print("User Name: <input type='text' name='userName' value="+value+"></input>");
		out.print("<pre>Password:  <input type='password' name='password'/></pre>");
		
		out.print("<input type='checkbox' name='chkbox'"+checked+">Remember Me?</input><br />");
				
		out.print("<input type='submit' value='submit'/>");
		out.print("</form>");
		out.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("userName");
		String pass = request.getParameter("password");
		String ab = request.getParameter("chkbox");
		Cookie cookie = new Cookie("user", user);
		
		if(null!=ab && !ab.isEmpty()){
			
			checkedVal =ab;
		}
		if (checkedVal==null){
			 
	        cookie.setMaxAge(-1);  
	        response.addCookie(cookie);  
		}else if(checkedVal.equals("on")){
			
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		
		if(user.equals("user1")&&pass.equals(usDB.getUserDB().get("user1"))){
			HttpSession session = request.getSession();
			session.setAttribute("userName", "user1");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Simplest");
			dispatcher.forward(request, response);
		//out.print("trial");
		}
		else{
			
			response.sendRedirect("");
		}
	}

}
