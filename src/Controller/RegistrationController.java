package Controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.*;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String txtNetId= request.getParameter("txtNetId");
		String txtPassword= request.getParameter("txtPassword");
		String rdbtnRole= request.getParameter("rdbtnRole");
		String txtFirstname= request.getParameter("txtFirstname");
		String txtLastname= request.getParameter("txtLastname");
		String txtYearJoined= request.getParameter("txtYearJoined");
		String rdbtnProgram= request.getParameter("rdbtnProgram");
		//Date date = new Date();
		//String d = date.getDay()+ "" +date.getMonth()+ "" +date.getYear();
		AuthDAO a=new AuthDAO();
		
	
		try
		{
			boolean s = a.UserExist(txtNetId);
			if(s)
			{
				System.out.println("User already exists");
				request.setAttribute("msg", "User already exists. Would you like to login?");
				request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
			else
			{
				a.RegistrationInsert(txtNetId, txtPassword, rdbtnRole, txtFirstname, txtLastname, txtYearJoined, rdbtnProgram);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("Successful");
				
			}
		}

			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}

}
