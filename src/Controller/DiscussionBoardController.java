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
 * Servlet implementation class DiscussionBoardController
 */
@WebServlet("/DiscussionBoardController")
public class DiscussionBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussionBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		if(flag.equals("ViewDiscussion"))
		{
			ViewDiscussion(request, response);
		}		
		else if(flag.equals("AddReply"))
		{
			AddReply(request, response);
		}
		else if(flag.equals("ViewDiscussionDetails"))
		{
			ViewDiscussionDetail(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddDiscussionTopic"))
		{
			AddDiscussionTopic(request, response);
		}
		else if(flag.equals("AddQuestion"))
		{
			AddQuestion(request, response);
		}
	}
	void AddDiscussionTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String PostedBy = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Topic = request.getParameter("txtTopic");
		try
		{
			boolean s = a.DiscussionTopicExists(Topic);
			if(s)
			{
				System.out.println("Topic already exists");
				request.setAttribute("msg", "This topic already exists.");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
			else
			{
				a.AddDiscussionTopic(Topic, PostedBy);
				/*ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);*/
				ArrayList<Map> DiscussionList=a.ViewDiscussion();
				session.setAttribute("DiscussionList", DiscussionList);
				request.getRequestDispatcher("ViewDiscussion.jsp").forward(request, response);
				System.out.println("Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		//String Type="Event";
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> DiscussionList=a.ViewDiscussion();
			//session.setAttribute("CourseNo", courselist);
			if(DiscussionList != null)
			{
				session.setAttribute("DiscussionList", DiscussionList);
				request.getRequestDispatcher("ViewDiscussion.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Discussions are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewDiscussionDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		//String Type="Event";
		String DiscussionTopicId = request.getParameter("DiscussionId");
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> DiscussionDetail=a.ViewDiscussionDetails(DiscussionTopicId);
			//session.setAttribute("CourseNo", courselist);
			if(DiscussionDetail != null)
			{
//				int i = DiscussionDetail.size();
//				System.out.println(i);
				session.setAttribute("DiscussionDetail", DiscussionDetail);
				session.setAttribute("dd1", "");
				session.setAttribute("DiscussionId", DiscussionTopicId);
				request.getRequestDispatcher("ViewDiscussionDetail.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Discussions are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void AddQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String PostedBy = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Question = request.getParameter("txtQuestion");
		String DiscussionTopicId =request.getParameter("DiscussionId");
		
		try
		{
				a.AddQuestion(Question, PostedBy, DiscussionTopicId);
			
				//a.AddDiscussionTopic(Topic, PostedBy);
				/*ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);*/
				ArrayList<Map> DiscussionDetail=a.ViewDiscussionDetails(DiscussionTopicId);
				session.setAttribute("DiscussionDetail", DiscussionDetail);
				request.getRequestDispatcher("ViewDiscussionDetail.jsp").forward(request, response);
				System.out.println("Successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void AddReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String PostedBy = u.getNetId();
		AuthDAO a=new AuthDAO();
		String QuestionId = request.getParameter("QuestionId");
		String DiscussionTopicId =request.getParameter("DiscussionId");
	
		String Reply = request.getParameter("txtReply");
		try
		{
				a.AddReply(QuestionId, PostedBy, Reply);
			
				//a.AddDiscussionTopic(Topic, PostedBy);
				/*ArrayList<Map> courselist=a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);*/
				ArrayList<Map> DiscussionDetail=a.ViewDiscussionDetails(DiscussionTopicId);
				session.setAttribute("DiscussionDetail", DiscussionDetail);
				request.getRequestDispatcher("ViewDiscussionDetail.jsp").forward(request, response);
				System.out.println("Successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
