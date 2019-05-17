package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

public class SetOfStudents {

	private String sosName;
	private Vector<Section> consistsOfList = new Vector<Section>();
	private int sosCapacity;
	private SetOfStudents sosObject;

	public SetOfStudents() {
		this.sosObject = this;
	}

	public SetOfStudents(String sosName) {
		setSosObject(this);
		String query = "SELECT * FROM SOSTBL WHERE SOSNAME='" + sosName + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getSosObject().setSosName(rs.getString("SOSNAME"));
				getSosObject().setSosCapacity(rs.getInt("SOSCAPACITY"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	public void setSosName(String sosName) {
		this.sosName = sosName;
	}

	public String getSosName() {
		return sosName;
	}

	public void setConsistsOfList(Vector<Section> consistsOfList) {
		this.consistsOfList = consistsOfList;
	}

	public Vector<Section> getConsistsOfList() {
		return consistsOfList;
	}

	public void setSosCapacity(int sosCapacity) {
		this.sosCapacity = sosCapacity;
	}

	public int getSosCapacity() {
		return sosCapacity;
	}

	public void setSosObject(SetOfStudents sosObject) {
		this.sosObject = sosObject;
	}

	public SetOfStudents getSosObject() {
		return sosObject;
	}

	public static ArrayList<String> getSOSList() {
		ArrayList<String> sosList = new ArrayList<String>();
		String query = "select SOSNAME from SOSTBL order by SOSNAME asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String sosListContents = rs.getString(1);
				sosList.add(sosListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sosList;
	}

	public static String vectorToString(Vector<SetOfStudents> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getSosObject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}
}
