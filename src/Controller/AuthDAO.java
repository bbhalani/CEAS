package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.*;

import com.mysql.jdbc.Statement;


public class AuthDAO {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ceas?autoReconnect=true&useSSL=true";
	String username = "root";
	String password = "root";
	ResultSet rs = null;
	int i;
	boolean status = false;
	public boolean checkid(String NetId) {
		// TODO Auto-generated method stub
	
		try{  
			Class.forName("com.mysql.jdbc.Driver");  	
			Connection conn = DriverManager.getConnection(url, username, password);//connection string 
			PreparedStatement ps=conn.prepareStatement("select idNetId from registration");      
			rs = ps.executeQuery();
			if(rs.getString(1).equals(NetId)){
				status = true;
			}
			          
			}catch(Exception e){System.out.println(e);}
		return status;
	}
	public ArrayList<Map> ViewAllCourses()
	{
		boolean s = false;
		ArrayList<Map> contents= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idCourseNo,CourseName from courses");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("courseno",rs.getString(1));
					m.put("coursename",rs.getString(2));
					contents.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return contents;
	}
	public ArrayList<Map> ViewMyCourseInfo(String FacultyId)
	{
		boolean s = false;
		ArrayList<Map> mycourseinfo= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idCourseNo,CourseName from courseswhere FacultyId ='"+FacultyId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("courseno",rs.getString(1));
					m.put("coursename",rs.getString(2));
					m.put("courseinfo",rs.getString(3));
					mycourseinfo.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return mycourseinfo;
	}
	public ResultSet validate(String NetId, String Password) {
		// TODO Auto-generated method stub
		
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  	
			Connection conn = DriverManager.getConnection(url, username, password);  
			PreparedStatement ps=conn.prepareStatement("select * from registration where idNetId = ? and Password = ?");      
			 ps.setString(1, NetId);
			 ps.setString(2, Password);
			 rs = ps.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
	
	
	public int RegistrationInsert(String txtNetId, String txtPassword, String rdbtnRole, String txtFirstname, String txtLastname, String txtYearJoined, String rdbtnProgram)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into registration(idNetId,Password,role,FirstName,LastName,YearJoined,Program) values(?,?,?,?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, txtNetId);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, txtPassword);
		ps.setString(3, rdbtnRole);
		ps.setString(4, txtFirstname);
		ps.setString(5, txtLastname);
		ps.setString(6, txtYearJoined);
		ps.setString(7, rdbtnProgram);
		
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		
		
		conn.close();//closing connection
		
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public boolean UserExist(String txtNetId)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select idNetId from registration where idNetId='"+txtNetId+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public boolean AlumniExist(String UniversityEmail)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select UniversityEmail from alumni where UniversityEmail='"+UniversityEmail+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public int CourseInsert(String CourseNo, String CourseName, String FacultyId, String CourseInfo)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into courses (idCourseNo,CourseName,FacultyId,CourseInfo) values(?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, CourseNo);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, CourseName);
		ps.setString(3, FacultyId);
		ps.setString(4, CourseInfo);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public int MyCourseInfoUpdate(String CourseNo, String CourseInfo)
	{
		int i=0;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			PreparedStatement ps=conn.prepareStatement("update courses set CourseInfo = ? where idCourseNo= ?");
			ps.setString(1,CourseInfo );
			ps.setString(2,CourseNo );
			i=ps.executeUpdate();//Executes the given SQL statement
			System.out.println(i);
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public boolean CourseExist(String CourseNo)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select idCourseNo from courses where idCourseNo='"+CourseNo+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public ArrayList<Map> getCourseByFacultyId(String FacultyId)
	{
			boolean s = false;
			ArrayList<Map> contents= new ArrayList<Map>();
			try{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idCourseNo,CourseName,CourseInfo from courses where FacultyId ='"+FacultyId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("courseno",rs.getString(1));
					m.put("coursename",rs.getString(2));
					m.put("courseinfo",rs.getString(3));
					contents.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
			e.printStackTrace();//print the exception
			}
			
		return contents;
	}
	public String getCourseInfobyCourseNo(String CourseNo)
	{
		boolean s = false;
		String CourseInfo = null;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idCourseNo,CourseInfo from courses where idCourseNo ='"+CourseNo+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			if(s)
			{
				CourseNo = rs.getString(1);
				CourseInfo  = rs.getString(2);
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
			return CourseInfo;
	}
	public ArrayList<Map> ViewAllPhDStudents()
	{
		boolean s = false;
		ArrayList<Map> contents= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idNetId,FirstName,Lastname,AdviserId from registration where Program='Ph.D'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("netid",rs.getString(1));
					m.put("firstname",rs.getString(2));
					m.put("lastname",rs.getString(3));
					m.put("adviserid", rs.getString(4));
					
					contents.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return contents;
	}
	public ArrayList<Map> ViewPhDStudentDetail(String StudentId,String FacultyId)
	{
			boolean s = false;
			ArrayList<Map> contents= new ArrayList<Map>();
			try{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idNetId,FirstName,LastName,NoofCurrentSem,YearJoined from registration where AdviserId ='"+FacultyId+"' and idNetId='"+StudentId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("studentid",rs.getString(1));
					m.put("firstname",rs.getString(2));
					m.put("lastname",rs.getString(3));
					m.put("noofcurrentsem",rs.getString(4));
					m.put("yearjoined",rs.getString(5));
					contents.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
			e.printStackTrace();//print the exception
			}
		return contents;
	}
	public ArrayList<Map> ViewAnnouncement(String Type)
	{
		boolean s = false;
		ArrayList<Map> contents= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idAnnouncementId,Content,Type,Link,AnnouncerId,CreationDate from announcement where Type='"+Type+"' order by CreationDate desc");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("announcementid",rs.getString(1));
					m.put("content",rs.getString(2));
					m.put("type",rs.getString(3));
					m.put("link", rs.getString(4));
					m.put("announcerid",rs.getString(5));
					m.put("creationdate", rs.getString(6));
					contents.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return contents;
	}
	public int DeleteAnnouncement(String announcementId)
	{
		int i=0;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			PreparedStatement ps=conn.prepareStatement("delete from announcement where idAnnouncementId=?");
			ps.setString(1,announcementId );
			//ps.setString(2,Link );
			i=ps.executeUpdate();//Executes the given SQL statement
			System.out.println(i);
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public int AddAnnouncement(String Content, String Type, String Link, String AnnouncerId)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into announcement (Content,Type,Link,AnnouncerId) values(?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, Content);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, Type);
		ps.setString(3, Link);
		ps.setString(4, AnnouncerId);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public int UpdateAnnouncement(String AnnouncementId,String Content,String Link)
	{
		int i=0;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			PreparedStatement ps=conn.prepareStatement("update announcement set Content= ?,Link=? where idAnnouncementId='"+AnnouncementId+"'");
			ps.setString(1,Content );
			ps.setString(2,Link );
			i=ps.executeUpdate();//Executes the given SQL statement
			System.out.println(i);
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public ArrayList<Map> getAnnouncementbyId(String AnnouncementId)
	{
		boolean s = false;
		ArrayList<Map> Announcement= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idAnnouncementId,Content,Link,Type from announcement where idAnnouncementId ='"+AnnouncementId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					m.put("announcementid", rs.getString(1));
					m.put("content",rs.getString(2));
					m.put("link", rs.getString(3));
					m.put("type", rs.getString(4));
					Announcement.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return Announcement;
	}
	public int AddAlumni(String FirstName, String LastName, String Address, String City,String State, String Country, String Zip, String UniversityEmail,String JoiningYear, String GraduationYear, String Employer, String JobTitle,String ContactNo,String Adder)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into alumni (FirstName,LastName,Address,City,State,Country,Zip,UniversityEmail,JoiningYear,GraduationYear,Employer,JobTitle,ContactNo,Adder) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, FirstName);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, LastName);
		ps.setString(3, Address);
		ps.setString(4, City);
		ps.setString(5, State);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(6, Country);
		ps.setString(7, Zip);
		ps.setString(8, UniversityEmail);
		ps.setString(9, JoiningYear);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(10, GraduationYear);
		ps.setString(11, Employer);
		ps.setString(12, JobTitle);
		ps.setString(13, ContactNo);
		ps.setString(14, Adder);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public int UpdateAlumni(String AlumniId,String FirstName, String LastName, String Address, String City,String State, String Country, String Zip, String UniversityEmail,String JoiningYear, String GraduationYear, String Employer, String JobTitle,String ContactNo,String Adder)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("update alumni set FirstName=?,LastName=?,Address=?,City=?,State=?,Country=?,Zip=?,UniversityEmail=?,JoiningYear=?,GraduationYear=?,Employer=?,JobTitle=?,ContactNo=?,Adder=? where idAlumniId='"+AlumniId +"'");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, FirstName);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, LastName);
		ps.setString(3, Address);
		ps.setString(4, City);
		ps.setString(5, State);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(6, Country);
		ps.setString(7, Zip);
		ps.setString(8, UniversityEmail);
		ps.setString(9, JoiningYear);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(10, GraduationYear);
		ps.setString(11, Employer);
		ps.setString(12, JobTitle);
		ps.setString(13, ContactNo);
		ps.setString(14, Adder);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public ArrayList<Map> ViewAlumniList()
	{
		boolean s = false;
		ArrayList<Map> Alumni= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idAlumniId,FirstName,LastName,Address,City,State,Country,Zip,UniversityEmail,JoiningYear,GraduationYear,Employer,JobTitle,ContactNo,Adder from alumni");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					m.put("idAlumniId", rs.getString(1));
					m.put("FirstName",rs.getString(2));
					m.put("LastName", rs.getString(3));
					m.put("Address", rs.getString(4));
					m.put("City", rs.getString(5));
					m.put("State",rs.getString(6));
					m.put("Country", rs.getString(7));
					m.put("Zip", rs.getString(8));
					m.put("UniversityEmail", rs.getString(9));
					m.put("JoiningYear",rs.getString(10));
					m.put("GraduationYear", rs.getString(11));
					m.put("Employer", rs.getString(12));
					m.put("JobTitle",rs.getString(13));
					m.put("ContactNo", rs.getString(14));
					m.put("Adder", rs.getString(15));
					Alumni.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return Alumni;
	}
	public ArrayList<Map> getAlumnibyId(String AlumniId)
	{
		boolean s = false;
		ArrayList<Map> Alumni= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idAlumniId,FirstName,LastName,Address,City,State,Country,Zip,UniversityEmail,JoiningYear,GraduationYear,Employer,JobTitle,ContactNo,Adder from alumni where idAlumniId ='"+AlumniId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					m.put("idAlumniId", rs.getString(1));
					m.put("FirstName",rs.getString(2));
					m.put("LastName", rs.getString(3));
					m.put("Address", rs.getString(4));
					m.put("City", rs.getString(5));
					m.put("State",rs.getString(6));
					m.put("Country", rs.getString(7));
					m.put("Zip", rs.getString(8));
					m.put("UniversityEmail", rs.getString(9));
					m.put("JoiningYear",rs.getString(10));
					m.put("GraduationYear", rs.getString(11));
					m.put("Employer", rs.getString(12));
					m.put("JobTitle",rs.getString(13));
					m.put("ContactNo", rs.getString(14));
					m.put("Adder", rs.getString(15));
					Alumni.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return Alumni;
	}
	public int AddDiscussionTopic(String Topic,String PostedBy)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into discussiontopic (Topic,PostedBy) values(?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, Topic);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, PostedBy);
		//ps.setString(3, FacultyId);
		//ps.setString(4, CourseInfo);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public boolean DiscussionTopicExists(String Topic)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select Topic from courses where Topic='"+Topic+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public ArrayList<Map> ViewDiscussion()
	{
		boolean s = false;
		ArrayList<Map> contents= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("Select r.FirstName,r.LastName, d.Topic,d.DateCreated,d.idDiscussiontopicId from discussiontopic d join registration r on d.PostedBy=r.idNetId order by d.DateCreated desc");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("FirstName",rs.getString(1));
					m.put("LastName",rs.getString(2));
					m.put("Topic",rs.getString(3));
					m.put("DateCreated",rs.getString(4));
					m.put("idDiscussiontopicId",rs.getString(5));
					contents.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return contents;
	}
	public ArrayList<Map> ViewDiscussionDetails(String DiscussionTopicId)
	{
		boolean s = false;
		ArrayList<Map> DiscussionDetails= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("select q.Question,r.FirstName,r.LastName,q.DateCreated,q.idQuestionId,rp.idQuestionId,rp.idReplyId,rp.reply,rp.DateCreated,q.idDiscussiontopicId from reply rp right join question q on rp.idQuestionId=q.idQuestionId join registration r on q.NetId = r.idNetId where q.idDiscussiontopicId="+DiscussionTopicId);// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			String id ="";
			
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					if(!id.equals(rs.getString(5)))
					{
						id = rs.getString(5);
						
					m.put("QQuestion", rs.getString(1));
					m.put("RFirstName",rs.getString(2));
					m.put("RLastName", rs.getString(3));
					m.put("QDateCreated", rs.getString(4));
					m.put("QidQuestionId", rs.getString(5));
					m.put("RPidQuestionId",rs.getString(6));
					m.put("RPidReplyId", rs.getString(7));
					m.put("RPreply", rs.getString(8));
					m.put("RPDateCreated", rs.getString(9));
					m.put("idDiscussiontopicId", rs.getString(10));
					DiscussionDetails.add(m);
					}
					else
					{
						m.put("QQuestion", "");
						m.put("RFirstName",rs.getString(2));
						m.put("RLastName", rs.getString(3));
						m.put("QDateCreated", rs.getString(4));
						m.put("QidQuestionId", rs.getString(5));
						m.put("RPidQuestionId",rs.getString(6));
						m.put("RPidReplyId", rs.getString(7));
						m.put("RPreply", rs.getString(8));
						m.put("RPDateCreated", rs.getString(9));
						m.put("idDiscussiontopicId", rs.getString(10));
						DiscussionDetails.add(m);
					}
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return DiscussionDetails;
	}
	public int AddQuestion(String Question,String PostedBy, String DiscussionTopicId)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into question (Question,NetId,idDiscussiontopicId) values(?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, Question);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, PostedBy);
		ps.setString(3, DiscussionTopicId);
		//ps.setString(4, CourseInfo);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public int AddReply(String QuestionId,String PostedBy, String Reply)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into reply (idQuestionId,ReplyBy,Reply) values(?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, QuestionId);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, PostedBy);
		ps.setString(3, Reply);
		//ps.setString(4, CourseInfo);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public ArrayList<Map> ViewQuestions(String DiscussionTopicId)
	{
		boolean s = false;
		ArrayList<Map> DiscussionDetails= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("select q.Question,r.FirstName,r.LastName,q.DateCreated,q.idQuestionId,q.idDiscussiontopicId from question q join registration r on q.NetId = r.idNetId where q.idDiscussiontopicId="+DiscussionTopicId);// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					m.put("QQuestion", rs.getString(1));
					m.put("RFirstName",rs.getString(2));
					m.put("RLastName", rs.getString(3));
					m.put("QDateCreated", rs.getString(4));
					m.put("QidQuestionId", rs.getString(5));
					/*m.put("RPidQuestionId",rs.getString(6));
					m.put("RPidReplyId", rs.getString(7));
					m.put("RPreply", rs.getString(8));
					m.put("RPDateCreated", rs.getString(9));*/
					m.put("idDiscussiontopicId", rs.getString(6));
					DiscussionDetails.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return DiscussionDetails;
	}
	public ArrayList<Map> ViewReply(String QuestionId)
	{
		boolean s = false;
		ArrayList<Map> DiscussionDetails= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("select rp.idQuestionId, rp.Reply,rp.DateDreated,rp.idReplyId,r.FirstName,r.LastName from reply rp join registration r on rp.ReplyBy = r.idNetId where rp.idQuestionId="+QuestionId);// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();
					m.put("idQuestionId", rs.getString(1));
					m.put("Reply",rs.getString(2));
					m.put("DateDreated", rs.getString(3));
					m.put("idReplyId", rs.getString(4));
					m.put("FirstName", rs.getString(5));
					m.put("LastName",rs.getString(6));
					/*m.put("RPidReplyId", rs.getString(7));
					m.put("RPreply", rs.getString(8));
					m.put("RPDateCreated", rs.getString(9));*/
					//m.put("idDiscussiontopicId", rs.getString(6));
					DiscussionDetails.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
				e.printStackTrace();//print the exception
			}
		return DiscussionDetails;
	}
	public int AddExam(String ExamName, String date, String OptionalLinks, String NetId)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into exam (NameOfExam,DateofExam,OptionalLinks,idNetId) values(?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, ExamName);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, date);
		ps.setString(3, OptionalLinks);
		ps.setString(4, NetId);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public ArrayList<Map> ViewExams()
	{
		boolean s = false;
		ArrayList<Map> exams= new ArrayList<Map>();
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idExamId,NameOfExam,DateofExam,OptionalLinks,idNetId from exam");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("idExamId",rs.getString(1));
					m.put("NameOfExam",rs.getString(2));
					m.put("DateofExam",rs.getDate(3));
					m.put("OptionalLinks",rs.getString(4));
					m.put("idNetId",rs.getString(5));
				
					exams.add(m);
				}
			}
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return exams;
	}
	public ArrayList<Map> getExambyNetId(String NetId)
	{
			boolean s = false;
			ArrayList<Map> ExamDetail= new ArrayList<Map>();
			try{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idExamId,NameOfExam,DateofExam,OptionalLinks,idNetId from exam where idNetId ='"+NetId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("idExamId",rs.getString(1));
					m.put("NameOfExam",rs.getString(2));
					m.put("DateofExam",rs.getDate(3));
					m.put("OptionalLinks",rs.getString(4));
					m.put("idNetId",rs.getString(5));
					ExamDetail.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
			e.printStackTrace();//print the exception
			}
			
		return ExamDetail;
	}
	public ArrayList<Map> getExambyExamId(String ExamId)
	{
			boolean s = false;
			ArrayList<Map> ExamDetail= new ArrayList<Map>();
			try{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idExamId,NameOfExam,DateofExam,OptionalLinks,idNetId,Result from exam where idExamId ='"+ExamId+"'");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("idExamId",rs.getString(1));
					m.put("NameOfExam",rs.getString(2));
					m.put("DateofExam",rs.getDate(3));
					m.put("OptionalLinks",rs.getString(4));
					m.put("idNetId",rs.getString(5));
					m.put("Result",rs.getString(6));
					ExamDetail.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
			e.printStackTrace();//print the exception
			}
			
		return ExamDetail;
	}
	public int UpdateResult(String ExamId, String Result)
	{
		int i=0;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			PreparedStatement ps=conn.prepareStatement("update exam set Result = ? where idExamId= ?");
			ps.setString(1,Result );
			ps.setString(2,ExamId );
			i=ps.executeUpdate();//Executes the given SQL statement
			System.out.println(i);
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public int DeleteExam(String ExamId)
	{
		int i=0;
		try
		{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			PreparedStatement ps=conn.prepareStatement("delete from exam where idExamId=?");
			ps.setString(1,ExamId );
			//ps.setString(2,Link );
			i=ps.executeUpdate();//Executes the given SQL statement
			System.out.println(i);
			conn.close();//closing connection
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public int AddResourceType(String ResourceType, String ResourceTypeDetail, String NetId)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into resourcetype (ResourceType,ResourceTypeDetail,TypeAddedBy) values(?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, ResourceType);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, ResourceTypeDetail);
		//ps.setString(3, idResourceTypeId);
		ps.setString(3, NetId);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	public boolean ResourceTypeExist(String ResourceType)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select idResourceTypeId from resourcetype where ResourceType='"+ResourceType+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public ArrayList<Map> getResourceType()
	{
			boolean s = false;
			ArrayList<Map> ResourceType= new ArrayList<Map>();
			try{
			Class.forName(driver);//loads the driver class
			Connection conn = DriverManager.getConnection(url, username, password);//connection string
			Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
			rs = st.executeQuery("SELECT idResourceTypeId,ResourceType,ResourceTypeDetail from resourcetype");// data of table representing a database result set.
			s = rs.next();//iterating each data of the table row by row
			rs.previous();
			if(s)
			{
				while(rs.next())
				{
					Map m = new HashMap();//mapping each element of each retrieved tuple into particular variable 
					m.put("idResourceTypeId",rs.getString(1));
					m.put("ResourceType",rs.getString(2));
					m.put("ResourceTypeDetail",rs.getString(3));
					ResourceType.add(m);
				}
			}
			conn.close();//closing connection
			}
			catch(Exception e)
			{
			e.printStackTrace();//print the exception
			}
			
		return ResourceType;
	}
	public boolean ResourceExist(String ResourceName)
	{	
		boolean s = false;
		try{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string to connect with the database
		Statement st = (Statement) conn.createStatement();//declaration st object which is statement type
		ResultSet rs = st.executeQuery("select idResourceId from resource where ResourceName='"+ResourceName+"'");// data of table representing a database result set.
		s=rs.next();//iterating each data of the table row by row
		conn.close();//closing connection
		}
		catch(Exception e)
		{
		e.printStackTrace();//print the exception
		}
		return s;
	}
	public int AddResource(String ResourceTypeId, String Description, String ResourceName,String NetId)
	{
		int i=0;
		//boolean s = false;
		try
		{
		Class.forName(driver);//loads the driver class
		Connection conn = DriverManager.getConnection(url, username, password);//connection string
		PreparedStatement ps=conn.prepareStatement("insert into resource (idResourceTypeId,Description,ResourceName,ResourceAddedBy) values(?,?,?,?)");// Creates a default PreparedStatement object capable of returning the auto-generated keys designated by the given array.
		ps.setString(1, ResourceTypeId);//storing the value of text in the 1st column retrieved by preparedStatement
		ps.setString(2, Description);
		ps.setString(3, ResourceName);
		ps.setString(4, NetId);
		//ps.setString(4, null);
		i=ps.executeUpdate();//Executes the given SQL statement
		System.out.println(i);
		conn.close();//closing connection
		//System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();//print the exception
		}
		return i;
	}
	
}
