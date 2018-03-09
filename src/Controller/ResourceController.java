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
 * Servlet implementation class ResourceController
 */
@WebServlet("/ResourceController")
public class ResourceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("GetResourceType"))
		{
			GetRecourceType(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("AddResourceType"))
		{
			AddResourceType(request, response);
		}
		else if(flag.equals("AddResource"))
		{
			AddResource(request, response);
		}
	}
	void AddResourceType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String NetId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String ResourceType = request.getParameter("txtResourceType");
		String ResourceTypeDetail = request.getParameter("txtResourceTypeDetail");
		String CourseInfo = request.getParameter("txtCourseInfo");
		try
		{
			boolean s = a.ResourceTypeExist(ResourceType);
			if(s)
			{
				System.out.println("Resource Type already exists");
				request.setAttribute("msg", "This type already exists.");
				request.getRequestDispatcher("AddResourceType.jsp").forward(request, response);
			}
			else
			{
				a.AddResourceType(ResourceType, ResourceTypeDetail, NetId);
				/*ArrayList<Map> =a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);*/
				request.getRequestDispatcher("AddResource.jsp").forward(request, response);
				System.out.println("Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void GetRecourceType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//String CourseNo = request.getParameter("CourseNo") ;
		AuthDAO a=new AuthDAO();
		HttpSession session = request.getSession();
		
		
		try{
			ArrayList<Map> ResourceType = a.getResourceType();
			//session.setAttribute("CourseNo", courselist);
			if(ResourceType != null)
			{
				
				session.setAttribute("ResourceType", ResourceType);
				request.getRequestDispatcher("AddResource.jsp").forward(request, response);
			}
			else 
			{
				request.setAttribute("msg", "You have not added any Ressource type. Would you like to add one?");
				request.getRequestDispatcher("AddResourceType.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	void AddResource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USER");
		System.out.println(u.getFirstName());
		String NetId = u.getNetId();
		AuthDAO a=new AuthDAO();
		String ResourceName = request.getParameter("txtResourceName");
		String ResourceTypeId = request.getParameter("ddlResourceType");
		String Description = request.getParameter("txtDescription");
		try
		{
			boolean s = a.ResourceExist(ResourceName);
			if(s)
			{
				System.out.println("Resource already exists");
				request.setAttribute("msg", "This resource already exists.");
				request.getRequestDispatcher("AddResource.jsp").forward(request, response);
			}
			else
			{
				a.AddResource(ResourceTypeId, Description, ResourceName, NetId);
				/*ArrayList<Map> =a.getCourseByFacultyId(FacultyId);
				session.setAttribute("MyCourseInfo", courselist);
				request.getRequestDispatcher("ViewMyCourseInfo.jsp").forward(request, response);*/
				request.getRequestDispatcher("AddResource.jsp").forward(request, response);
				System.out.println("Successful");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
