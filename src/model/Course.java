package model;

public class Course {

		String courseno;
		String coursename;
		String facultyid;
		String courseinfo;
		public Course(){
			super();
		}
		
		public Course(String CourseNo, String CourseName, String FacultyId, String CourseInfo) {
			super();
			courseno = CourseNo;
			this.coursename = CourseName;
			this.facultyid = FacultyId;
			this.courseinfo = CourseInfo;
		}

		public String getCourseNo() {
			return courseno;
		}

		public void setCourseNo(String CourseNo) {
			courseno = CourseNo;
		}

		public String getCourseName() {
			return coursename;
		}

		public void setCourseName(String CourseName) {
			this.coursename = CourseName;
		}

		public String getFacultyId(String FacultyId) {
			return facultyid;
		}

		public void setFacultyId(String FacultyId) {
			this.facultyid = FacultyId;
		}
		public String getCourseInfo() {
			return coursename;
		}

		public void setCourseInfo(String CourseInfo) {
			this.coursename = CourseInfo;
		}
}

