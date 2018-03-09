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
import model.Course;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("UpdateMyCourseInfo"))
		{
			CourseNoDDL(request, response);
		}
		else if(flag.equals("ViewCourses"))
		{
			ViewCourses(request,response);
		}
		else if(flag.equals("ViewMyCourseInfo"))
		{
			ViewMyCourseInfo(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddCourse"))
		{
			AddCourse(request, response);
		}
		else if(flag.equals("UpdateMyCourseInfo"))
		{
			UpdateMyCourseInfo(request, response);
		}
		
		
	}
	void ViewCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> courselist=a.ViewAllCourses();
			//session.setAttribute("CourseNo", courselist);
			if(courselist != null)
			{
				session.setAttribute("CourseList", courselist);
				request.getRequestDispatcher("ViewCourses.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Classes are not available");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	void CourseNoDDL(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		//System.out.println(u.getFirstName());
		String FacultyId = request.getParameter("FacultyId") ;
				//(String) request.getAttribute("FacultyId");
		//System.out.println(FacultyId);
		
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
			//session.setAttribute("CourseNo", courselist);
			if(courselist != null)
			{
				session.setAttribute("CourseNo", courselist);
				request.getRequestDispatcher("UpdateMyCourseInfo.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "You have not added any courses. Would you like to add one?");
				request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void AddCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String CourseNo = request.getParameter("txtCourseNo");
		String CourseName = request.getParameter("txtCourseName");
		String CourseInfo = request.getParameter("txtCourseInfo");
		try
		{
			boolean s = a.CourseExist(CourseNo);
			if(s)
			{
				System.out.println("Course already exists");
				request.setAttribute("msg", "This course already exists.");
				request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
			else
			{
				a.CourseInsert(CourseNo, CourseName, FacultyId,CourseInfo);
				ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);
				System.out.println("Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void GetCourseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String CourseNo = request.getParameter("CourseNo") ;
		AuthDAO a=new AuthDAO();
		String CourseInfo = a.getCourseInfobyCourseNo(CourseNo);
		HttpSession session = request.getSession();
		session.setAttribute("CourseInfo", CourseInfo);
		
	}
	void UpdateMyCourseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		//System.out.println(u.getFirstName());
		String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String CourseNo = request.getParameter("CourseNo");
		String CourseInfo = request.getParameter("txtCourseDescription");
		//String CourseInfoExist = a.getCourseInfobyCourseNo(CourseNo);
		try
		{
			a.MyCourseInfoUpdate(CourseNo, CourseInfo);
			//request.getRequestDispatcher().forward(request, response);
			ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
			session.setAttribute("MyCourseInfo", courselist);
			request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);
			System.out.println("Successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewMyCourseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		//System.out.println(u.getFirstName());
		String FacultyId = request.getParameter("FacultyId") ;
				//(String) request.getAttribute("FacultyId");
		//System.out.println(FacultyId);
		
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
			//session.setAttribute("CourseNo", courselist);
			if(courselist != null)
			{
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "You have not added any courses. Would you like to add one?");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
