package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

public class Instructor extends UserInfo {

	private Vector<Course> instructingCourses;
	private Vector<Slot> instructingSlots;
	private String instructingCoursesAsString;
	private String instructingSlotsAsString;

	public Instructor() {
		super();
	}

	public Instructor(String firstnm, String lastnm, String email, String usrnm, String psswrd, String dprtmnt) {
		super(firstnm, lastnm, email, usrnm, psswrd, "Instructor", dprtmnt, "NA");
	}

	public Instructor(String p0) {
		super(p0);
	}

	public static ArrayList<String> getInstructorsList() {
		ArrayList<String> instructorList = new ArrayList<String>();
		String query = "select FIRSTNAME,LASTNAME,USERNAME from USRTBL WHERE USERTYPE='Instructor' order by LASTNAME asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String instructorListContents = rs.getString("LASTNAME") + ", " + rs.getString("FIRSTNAME");
				instructorList.add(instructorListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instructorList;
	}

	public void setInstructingCourses(Vector<Course> instructingCourses) {
		this.instructingCourses = instructingCourses;
	}

	public Vector<Course> getInstructingCourses() {
		return instructingCourses;
	}

	public void setInstructingSlots(Vector<Slot> instructingSlots) {
		this.instructingSlots = instructingSlots;
	}

	public Vector<Slot> getInstructingSlots() {
		return instructingSlots;
	}

	private void setInstructingCoursesAsString(Vector<Course> instructingCourses) {
		for (int i = 0; i < instructingCourses.size(); i++)
			this.instructingCoursesAsString += Integer.toString(instructingCourses.get(i).getCourseNumber()) + "~";
	}

	public String getInstructingCoursesAsString() {
		return instructingCoursesAsString;
	}

	private void setInstructingSlotsAsString(Vector<Slot> instructingSlots) {
		for (int i = 0; i < instructingSlots.size(); i++)
			this.instructingSlotsAsString += Integer.toString(instructingSlots.get(i).getSlotNumber()) + "~";
	}

	public String getInstructingSlotsAsString() {
		return instructingSlotsAsString;
	}
}
