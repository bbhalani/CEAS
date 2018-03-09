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
 * Servlet implementation class AnnouncementController
 */
@WebServlet("/AnnouncementController")
public class AnnouncementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnouncementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("UpdateDeleteAnnouncement"))
		{
			UpdateDeleteAnnouncement(request, response);
		}
		else if(flag.equals("ViewJobs"))
		{
			ViewJobs(request, response);
		}
		else if(flag.equals("ViewEvent"))
		{
			ViewEvents(request, response);
		}
		else if(flag.equals("ViewNews"))
		{
			ViewNews(request, response);
		}
		else if(flag.equals("UpdateAnnouncement"))
		{
			UpdateAnnouncement(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddEvent"))
		{
			AddEvent(request, response);
		}
		else if(flag.equals("AddJob"))
		{
			AddJob(request, response);
		}
		else if(flag.equals("AddNews"))
		{
			AddNews(request, response);
		}
	}
	void AddEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String AnnouncerId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Content = request.getParameter("txtEvent");
		String Type = "Event";
		String Link = request.getParameter("txtLink");
		try
		{
			
				a.AddAnnouncement(Content, Type, Link, AnnouncerId);
				ArrayList<Map> EventList=a.ViewAnnouncement(Type);
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewAnnouncement.jsp").forward(request, response);
				System.out.println("Successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void AddJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String AnnouncerId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Content = request.getParameter("txtJob");
		String Type = "Job";
		String Link = request.getParameter("txtLink");
		try
		{
			
				a.AddAnnouncement(Content, Type, Link, AnnouncerId);
				ArrayList<Map> EventList=a.ViewAnnouncement(Type);
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewJobs.jsp").forward(request, response);
				System.out.println("Successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void AddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String AnnouncerId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Content = request.getParameter("txtNews");
		String Type = "News";
		String Link = request.getParameter("txtLink");
		try
		{
			
				a.AddAnnouncement(Content, Type, Link, AnnouncerId);
				ArrayList<Map> EventList=a.ViewAnnouncement(Type);
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewNews.jsp").forward(request, response);
				System.out.println("Successful");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String Type="Event";
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> EventList=a.ViewAnnouncement(Type);
			//session.setAttribute("CourseNo", courselist);
			if(EventList != null)
			{
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewAnnouncement.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Events are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String Type="Job";
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> EventList=a.ViewAnnouncement(Type);
			//session.setAttribute("CourseNo", courselist);
			if(EventList != null)
			{
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewJobs.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Events are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ViewNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String Type="News";
		AuthDAO a=new AuthDAO();
		try{
			ArrayList<Map> EventList=a.ViewAnnouncement(Type);
			//session.setAttribute("CourseNo", courselist);
			if(EventList != null)
			{
				session.setAttribute("EventList", EventList);
				request.getRequestDispatcher("ViewNews.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Events are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void UpdateAnnouncement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String AnnouncerId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String Content = request.getParameter("txtEvent");
		String AnnouncementId= request.getParameter("AnnouncementId");
		String Type = request.getParameter("Type");
		String Link = request.getParameter("txtLink");
		String Action = request.getParameter("Action");
		if(Action.equals("Update"))
		{
		try
		{
			
				a.UpdateAnnouncement(AnnouncementId, Content, Link);
				ArrayList<Map> EventList=a.ViewAnnouncement(Type);
				session.setAttribute("EventList", EventList);
				if(Type.equals("Event"))
				{
					request.getRequestDispatcher("ViewAnnouncement.jsp").forward(request, response);
				}
				else if(Type.equals("Job"))
				{
					request.getRequestDispatcher("ViewJobs.jsp").forward(request, response);
				}
				else if(Type.equals("News"))
				{
					request.getRequestDispatcher("ViewNews.jsp").forward(request, response);
				}
					
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
				
				a.DeleteAnnouncement(AnnouncementId);
				ArrayList<Map> EventList=a.ViewAnnouncement(Type);
				session.setAttribute("EventList", EventList);
				if(Type.equals("Event"))
				{
					request.getRequestDispatcher("ViewAnnouncement.jsp").forward(request, response);
				}
				else if(Type.equals("Job"))
				{
					request.getRequestDispatcher("ViewJobs.jsp").forward(request, response);
				}
				else if(Type.equals("News"))
				{
					request.getRequestDispatcher("ViewNews.jsp").forward(request, response);
				}
					
				System.out.println("Successful");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}	
		}
	}
	void UpdateDeleteAnnouncement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String AnnouncementId=  request.getParameter("AnnouncementId");
		//String Type="Event";
		AuthDAO a=new AuthDAO();
	
		
		try{
			ArrayList<Map> AnnouncementList=a.getAnnouncementbyId(AnnouncementId);
			//session.setAttribute("CourseNo", courselist);
			if(AnnouncementList != null)
			{
				int l = AnnouncementList.size();
				System.out.println(l);
				session.setAttribute("AnnouncementList", AnnouncementList);
				request.getRequestDispatcher("UpdateAnnouncement.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "No Events are there to show");
				//request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		
	

}
