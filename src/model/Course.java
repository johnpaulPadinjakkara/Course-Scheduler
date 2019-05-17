package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Course {

	private String courseName;
	private int courseNumber;
	private Schedule schedule;
	private Vector<Slot> slotsInSchedule = new Vector<Slot>();
	private String slotsInScheduleAsString;
	private Vector<ClassRoom> roomsInSchedule = new Vector<ClassRoom>();
	private String roomsInScheduleAsString;
	private Section section;
	private String level;
	private UserInfo instructor_lec;
	private UserInfo instructor_tut;
	private UserInfo instructor_lab;
	private boolean isTutorial;
	private boolean isLab;
	private String durationInWeeks;
	private ClassRoom room;
	private String department;
	private Course courseObject;

	public Course() {
		this.courseObject = this;
	}

	public Course(int courseNumber) {
		setCourseObject(this);
		String query = "SELECT * FROM COURSTBL WHERE COURSENUMBER='" + courseNumber + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getCourseObject().setCourseName(rs.getString("COURSENAME"));
				getCourseObject().setCourseNumber(rs.getInt("COURSENUMBER"));
				getCourseObject().setLevel(rs.getString("LEVEL"));
				getCourseObject().setIsLab((rs.getString("LAB").equalsIgnoreCase("Y") ? true : false));
				getCourseObject().setIsTutorial((rs.getString("TUTORIAL").equalsIgnoreCase("Y") ? true : false));
				getCourseObject().setDurationInWeeks(rs.getString("DURATIONINWEEKS"));
				getCourseObject().setDepartment(rs.getString("DEPARTMENT"));
				if (rs.getInt("SCHEDULE") != 0) {
					Schedule schedule_ = new Schedule(rs.getInt("SCHEDULE"));
					getCourseObject().setSchedule(schedule_);
					getCourseObject().setSlotsInSchedule(schedule_.getSlotsInSchedule());
					getCourseObject().setRoomsInSchedule(schedule_.getRoomsInSchedule());
				}
				if (rs.getString("SECTION") != null) {
					Section section_ = new Section(rs.getString("SECTION"));
					getCourseObject().setSection(section_);
				}
				if (rs.getString("LECTUREINSTRUCTOR") != null) {
					Instructor instructor_ = new Instructor(rs.getString("LECTUREINSTRUCTOR"));
					getCourseObject().setInstructor_lec(instructor_);
				}
				if (rs.getString("TUTORIALINSTRUCTOR") != null) {
					Instructor instructor_ = new Instructor(rs.getString("TUTORIALINSTRUCTOR"));
					getCourseObject().setInstructor_lec(instructor_);
				}
				if (rs.getString("LABINSTRUCTOR") != null) {
					Instructor instructor_ = new Instructor(rs.getString("LABINSTRUCTOR"));
					getCourseObject().setInstructor_lec(instructor_);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Course(String courseName, int courseNumber, String level, boolean isTutorial, boolean isLab,
			String durationInWeeks, String department) {
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.level = level;
		this.isTutorial = isTutorial;
		this.isLab = isLab;
		this.durationInWeeks = durationInWeeks;
		this.department = department;
		this.courseObject = this;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Section getSection() {
		return section;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setInstructor_lec(UserInfo instructor_lec) {
		this.instructor_lec = instructor_lec;
	}

	public UserInfo getInstructor_lec() {
		return instructor_lec;
	}

	public void setInstructor_tut(UserInfo instructor_tut) {
		this.instructor_tut = instructor_tut;
	}

	public UserInfo getInstructor_tut() {
		return instructor_tut;
	}

	public void setInstructor_lab(UserInfo instructor_lab) {
		this.instructor_lab = instructor_lab;
	}

	public UserInfo getInstructor_lab() {
		return instructor_lab;
	}

	public void setIsTutorial(boolean isTutorial) {
		this.isTutorial = isTutorial;
	}

	public boolean isIsTutorial() {
		return isTutorial;
	}

	public void setIsLab(boolean isLab) {
		this.isLab = isLab;
	}

	public boolean isIsLab() {
		return isLab;
	}

	public void setDurationInWeeks(String durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}

	public String getDurationInWeeks() {
		return durationInWeeks;
	}

	public void setRoom(ClassRoom room) {
		this.room = room;
	}

	public ClassRoom getRoom() {
		return room;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setCourseObject(Course courseObject) {
		this.courseObject = courseObject;
	}

	public Course getCourseObject() {
		return courseObject;
	}

	public String addCourse() {
		String returnValue = "";
		String isLab_ = ((isIsLab() == true) ? "Y" : "N");
		String isTut_ = ((isIsTutorial() == true) ? "Y" : "N");
		String query = "INSERT INTO COURSTBL (COURSENAME, COURSENUMBER, LEVEL, TUTORIAL, LAB, DURATIONINWEEKS, DEPARTMENT) VALUES ('"
				+ getCourseName() + "','" + getCourseNumber() + "','" + getLevel() + "','" + isTut_ + "','" + isLab_
				+ "','" + getDurationInWeeks() + "','" + getDepartment() + "')";
		try {
			OpenConnection.db.update(query);
			returnValue = "Course successfully added";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Course entry failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public String updateCourse() {
		String section__ = this.getSection().getSectionName();
		String lect__ = this.getInstructor_lec().getLastname() + ", " + this.getInstructor_lec().getFirstname();
		String tut__ = "";
		if (this.getInstructor_tut() != null)
			tut__ = this.getInstructor_lec().getLastname() + ", " + this.getInstructor_lec().getFirstname();
		String lab__ = "";
		if (this.getInstructor_lab() != null)
			lab__ = this.getInstructor_lab().getLastname() + ", " + this.getInstructor_lab().getFirstname();
		String dept__ = this.getDepartment();
		int course__ = this.getCourseNumber();
		String query = "UPDATE COURSTBL SET " + "SECTION = '" + section__ + "',LECTUREINSTRUCTOR = '" + lect__
				+ "',TUTORIALINSTRUCTOR = '" + tut__ + "',LABINSTRUCTOR = '" + lab__ + "' where COURSENUMBER = "
				+ course__;
		String returnValue = "";
		try {
			OpenConnection.db.update(query);
			returnValue = "Course successfully updated";
		} catch (SQLException e1) {
			e1.printStackTrace();
			String query_scheduleRollback = "DELETE FROM SCHEDULETBL WHERE SCHDNUM = " + this.courseNumber;
			try {
				OpenConnection.db.update(query_scheduleRollback);
			} catch (SQLException e) {
				System.out.println("Message: Schedule entry rolled back due to course update failure.");
			}
			returnValue = "Course update failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public String deleteCourse() {
		String query = "DELETE FROM COURSTBL WHERE COURSENUMBER = " + this.courseNumber;
		String returnValue = "";

		try {
			OpenConnection.db.update(query);
			returnValue = "Course successfully deleted";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Course deletion failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public static TableModel viewCourseInfo() {
		ResultSet rs = null;
		String query = "SELECT * FROM COURSTBL ORDER BY COURSENUMBER";
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Course Name");
		columnNames.add("Course Number");
		columnNames.add("Schedule");
		columnNames.add("Section");
		columnNames.add("Level");
		columnNames.add("Instructor(Lecture)");
		columnNames.add("Instructor(Tutorial)");
		columnNames.add("Instructor(Laboratory)");
		columnNames.add("Tutorial?");
		columnNames.add("Lab?");
		columnNames.add("Duration");
		columnNames.add("Room Number");
		columnNames.add("Department");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try {
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnNames.size() - 1; columnIndex++) {
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, columnNames);
	}

	public static ArrayList<String> getCourseNameList() {
		ArrayList<String> cnList = new ArrayList<String>();
		String query = "select COURSENAME,COURSENUMBER from COURSTBL order by COURSENUMBER asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String cnListContents = rs.getInt("COURSENUMBER") + " - " + rs.getString("COURSENAME");
				cnList.add(cnListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnList;
	}

	public static String vectorToString(Vector<Course> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getCourseObject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}

	public void setSlotsInSchedule(Vector<Slot> slotsInSchedule) {
		this.slotsInSchedule = slotsInSchedule;
		setSlotsInScheduleAsString(Slot.vectorToString(this.slotsInSchedule));
	}

	public Vector<Slot> getSlotsInSchedule() {
		return slotsInSchedule;
	}

	public void setSlotsInScheduleAsString(String slotsInScheduleAsString) {
		this.slotsInScheduleAsString = slotsInScheduleAsString;
	}

	public String getSlotsInScheduleAsString() {
		return slotsInScheduleAsString;
	}

	public void setRoomsInSchedule(Vector<ClassRoom> roomsInSchedule) {
		this.roomsInSchedule = roomsInSchedule;
		setRoomsInScheduleAsString(ClassRoom.vectorToString(this.roomsInSchedule));
	}

	public Vector<ClassRoom> getRoomsInSchedule() {
		return roomsInSchedule;
	}

	public void setRoomsInScheduleAsString(String roomsInScheduleAsString) {
		this.roomsInScheduleAsString = roomsInScheduleAsString;
	}

	public String getRoomsInScheduleAsString() {
		return roomsInScheduleAsString;
	}
}
