package Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class ExamController
 */
@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("ViewExams"))
		{
			ViewExams(request, response);
		}
		else if(flag.equals("ViewMyExams"))
		{
			ViewMyExams(request, response);
		}
		else if(flag.equals("GetExamsInfo"))
		{
			GetExamsInfo(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddExam"))
		{
			//AddExam(request, response);
			try {
				AddExam(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(flag.equals("UpdateResult"))
		{
			UpdateResult(request, response);
		}
	}
	void AddExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String NetId = u.getNetId();
		AuthDAO a=new AuthDAO();
		//String SDate = request.getParameter("txtExamDate");
		//SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
		//surround below line with try catch block as below code throws checked exception
		//java.util.Date Date =  sdf.parse(SDate);
		String ExamName = request.getParameter("txtExamName");
		String Date = request.getParameter("txtExamDate");
		String OptionalLinks = request.getParameter("txtOptionalLinks");
		try
		{
			
				a.AddExam(ExamName, Date, OptionalLinks, NetId);
				/*ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);
				System.out.println("Successful");*/
				ArrayList<Map> Exams=a.ViewExams();
				//session.setAttribute("CourseNo", courselist);
		
					session.setAttribute("Exams", Exams);
					request.getRequestDispatcher("ViewExam.jsp").forward(request, response);
			//}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewExams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> Exams=a.ViewExams();
			//session.setAttribute("CourseNo", courselist);
			if(Exams != null)
			{
				session.setAttribute("Exams", Exams);
				request.getRequestDispatcher("ViewExam.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Exams are not available");
				request.getRequestDispatcher("AddExam.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewMyExams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String NetId = u.getNetId();
	
		AuthDAO a=new AuthDAO();
		
		try{
			ArrayList<Map> MyExams=a.getExambyNetId(NetId);
			//session.setAttribute("CourseNo", courselist);
			if(MyExams != null)
			{
				session.setAttribute("MyExams", MyExams);
				request.getRequestDispatcher("ViewMyExamDetail.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "Exams are not available");
				request.getRequestDispatcher("AddExam.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void GetExamsInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String NetId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String ExamId=request.getParameter("ExamId");
		String Call = request.getParameter("call");
		try{
			ArrayList<Map> MyExamInfo=a.getExambyExamId(ExamId);
			//session.setAttribute("CourseNo", courselist);
			if(MyExamInfo != null)
			{
				session.setAttribute("MyExamInfo", MyExamInfo);
				if(Call.equals("post"))
				{
					request.getRequestDispatcher("PostExamResult.jsp").forward(request, response);
				}
				else if(Call.equals("View"))
				{
					request.getRequestDispatcher("ViewResult.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("msg", "Exams are not available");
				request.getRequestDispatcher("AddExam.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void UpdateResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		//String AnnouncerId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String ExamId = request.getParameter("ExamId");
		//String AnnouncementId= request.getParameter("AnnouncementId");
		//String Type = request.getParameter("Type");
		String Result = request.getParameter("txtResult");
		String Action = request.getParameter("Action");
		if(Action.equals("Update"))
		{
		try
		{
				a.UpdateResult(ExamId, Result);
				ArrayList<Map> Exams=a.ViewExams();
				//session.setAttribute("CourseNo", courselist);
				session.setAttribute("Exams", Exams);
				request.getRequestDispatcher("ViewExam.jsp").forward(request, response);
				System.out.println("Successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		else if(Action.equals("Delete"))
		{
			try{
				
				a.DeleteExam(ExamId);
				ArrayList<Map> Exams=a.ViewExams();
				//session.setAttribute("CourseNo", courselist);
				session.setAttribute("Exams", Exams);
				request.getRequestDispatcher("ViewExam.jsp").forward(request, response);
					
				System.out.println("Successful");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}
	}
}
