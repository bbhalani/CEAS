package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class PhDStudentController
 */
@WebServlet("/PhDStudentController")
public class PhDStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhDStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("ViewPhDStudents"))
		{
			ViewPhDStudents(request, response);
		}
		else if(flag.equals("ViewPhDStudentDetail"))
		{
			ViewPhDStudentDetail(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	void ViewPhDStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> studentlist=a.ViewAllPhDStudents();
			//session.setAttribute("CourseNo", courselist);
			if(studentlist != null)
			{
				session.setAttribute("StudentList", studentlist);
				request.getRequestDispatcher("ViewPhDStudents.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Ph.D Students are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewPhDStudentDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String StudentId= request.getParameter("StudentId");
		User u = (User) session.getAttribute("USER");
		//System.out.println(u.getFirstName());
		String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> studentdetail=a.ViewPhDStudentDetail(StudentId, FacultyId);
			//session.setAttribute("CourseNo", courselist);
			if(studentdetail != null)
			{
				session.setAttribute("StudentDetail", studentdetail);
				request.getRequestDispatcher("PhDStudentDetail.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Ph.D Students details are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
