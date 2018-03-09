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
 * Servlet implementation class AlumniController
 */
@WebServlet("/AlumniController")
public class AlumniController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumniController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("ViewAlumniInfo"))
		{
			ViewAlumniInfo(request, response);
		}
		else if(flag.equals("ViewAlumni"))
		{
			ViewAlumni(request, response);
		}
		else if(flag.equals("UpdateAlumniInfo"))
		{
			UpdateAlumniInfo(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddAlumni"))
		{
			AddAlumni(request, response);
		}
		else if(flag.equals("UpdateAlumni"))
		{
			UpdateAlumni(request, response);
		}
	}
	void AddAlumni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String Adder = u.getNetId();
		AuthDAO a=new AuthDAO();
		String FirstName = request.getParameter("txtFirstname");
		String LastName = request.getParameter("txtLastname");
		String UniversityEmail = request.getParameter("txtUniversityEmail");
		String ContactNo = request.getParameter("txtContactNo");
		String JoiningYear = request.getParameter("txtYearJoined");
		String GraduationYear = request.getParameter("txtGraduationYear");
		String Address = request.getParameter("txtAddress");
		String City = request.getParameter("txtCity");
		String State = request.getParameter("txtState");
		String Country = request.getParameter("txtCountry");
		String Zip = request.getParameter("txtZip");
		String Employer = request.getParameter("txtEmployer");
		String JobTitle = request.getParameter("txtJobTitle");
		try
		{
			boolean s = a.AlumniExist(UniversityEmail);
			if(s)
			{
				System.out.println("Course already exists");
				request.setAttribute("msg", "This Alumni already exists.");
				request.getRequestDispatcher("AddAlumniInfo.jsp").forward(request, response);
			}
			else
			{
				a.AddAlumni(FirstName, LastName, Address, City, State, Country, Zip, UniversityEmail, JoiningYear, GraduationYear, Employer, JobTitle, ContactNo, Adder);
				ArrayList<Map> AlumniList=a.ViewAlumniList();
				session.setAttribute("AlumniList", AlumniList);
				request.getRequestDispatcher("ViewAlumniList.jsp").forward(request, response);
				System.out.println("Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewAlumni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		//String AlumniId= request.getParameter("AlumniId");
		//User u = (User) session.getAttribute("USER");
		//System.out.println(u.getFirstName());
		//String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> AlumniList=a.ViewAlumniList();
			
			//session.setAttribute("CourseNo", courselist);
			if(AlumniList != null)
			{
				session.setAttribute("AlumniList", AlumniList);
				request.getRequestDispatcher("ViewAlumniList.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Alumni details are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewAlumniInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String AlumniId= request.getParameter("AlumniId");
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		//String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> AlumniList=a.getAlumnibyId(AlumniId);
			
			//session.setAttribute("CourseNo", courselist);
			if(AlumniList != null)
			{
				session.setAttribute("AlumniList", AlumniList);
				request.getRequestDispatcher("ViewAlumniInfo.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Alumni details are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void UpdateAlumniInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String AlumniId= request.getParameter("AlumniId");
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		//String FacultyId = u.getNetId();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> AlumniList=a.getAlumnibyId(AlumniId);
			
			//session.setAttribute("CourseNo", courselist);
			if(AlumniList != null)
			{
				session.setAttribute("AlumniList", AlumniList);
				request.getRequestDispatcher("UpdateAlumni.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Alumni details are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void UpdateAlumni(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		String AlumniId= request.getParameter("AlumniId");
		System.out.println(u.getFirstName());
		String Adder = u.getNetId();
		AuthDAO a=new AuthDAO();
		String FirstName = request.getParameter("txtFirstname");
		String LastName = request.getParameter("txtLastname");
		String UniversityEmail = request.getParameter("txtUniversityEmail");
		String ContactNo = request.getParameter("txtContactNo");
		String JoiningYear = request.getParameter("txtYearJoined");
		String GraduationYear = request.getParameter("txtGraduationYear");
		String Address = request.getParameter("txtAddress");
		String City = request.getParameter("txtCity");
		String State = request.getParameter("txtState");
		String Country = request.getParameter("txtCountry");
		String Zip = request.getParameter("txtZip");
		String Employer = request.getParameter("txtEmployer");
		String JobTitle = request.getParameter("txtJobTitle");
		try
		{
			
				a.UpdateAlumni(AlumniId, FirstName, LastName, Address, City, State, Country, Zip, UniversityEmail, JoiningYear, GraduationYear, Employer, JobTitle, ContactNo, Adder);
				ArrayList<Map> AlumniList=a.ViewAlumniList();
				session.setAttribute("AlumniList", AlumniList);
				request.getRequestDispatcher("ViewAlumniList.jsp").forward(request, response);
				System.out.println("Successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
