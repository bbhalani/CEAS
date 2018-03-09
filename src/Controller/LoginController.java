package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		String NetId = request.getParameter("txtNetId");
		String Password = request.getParameter("txtPassword");
		boolean status = false, status1 = false;
		AuthDAO login = new AuthDAO();
		status1 = login.checkid("NetId");
		
		ResultSet rs = login.validate(NetId, Password);
		HttpSession session = request.getSession(true);
		User user = new User();;
		try {
			while(rs.next()){
				if(rs.getString(1).equals(NetId)){
					status = true;
					user = new User(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status){
			session.setMaxInactiveInterval(20*60);
			//request.setAttribute("ID", NetId);
			session.setAttribute("USER", user);
			session.setAttribute("NetId", user.getNetId());
			session.setAttribute("username",user.getFirstName());
			request.getRequestDispatcher("header.jsp").forward(request, response);
		}
		else{
			if(status1){
				request.setAttribute("msg","Account not present...");
				request.getRequestDispatcher("Registeration.jsp").forward(request, response);
			}else{
				request.setAttribute("msg","Username or password is wrong");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
	}
}
}
