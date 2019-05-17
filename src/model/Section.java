package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Section {

	private String sectionName;
	private int sectionCapacity;
	private Vector<SetOfStudents> sosList = new Vector<SetOfStudents>();
	private String sosListAsString;
	private Section sectionObject;

	public Section() {
		this.sectionObject = this;
	}

	public Section(String sectionName) {
		setSectionObject(this);
		String query = "SELECT * FROM SECTTBL WHERE SECTIONNAME='" + sectionName + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getSectionObject().setSectionName(rs.getString("SECTIONNAME"));
				getSectionObject().setSosListAsString(rs.getString("SOSLIST"));
				getSectionObject().setSectionCapacity(rs.getInt("CAPACITY"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public Section(String sectionName, String sosListAsString) {
		setSectionName(sectionName);
		setSosListAsString(sosListAsString);
		for (String retval : getSosListAsString().split("~")) {
			getSosList().add(new SetOfStudents(retval));
		}
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionCapacity(int sectionCapacity) {
		this.sectionCapacity = sectionCapacity;
	}

	public int getSectionCapacity() {
		return sectionCapacity;
	}

	public void setSosList(Vector<SetOfStudents> sosList) {
		this.sosList = sosList;
	}

	public Vector<SetOfStudents> getSosList() {
		return sosList;
	}

	public void setSosListAsString(String sosListAsString) {
		this.sosListAsString = sosListAsString;
	}

	public String getSosListAsString() {
		return sosListAsString;
	}

	public void setSectionObject(Section sectionObject) {
		this.sectionObject = sectionObject;
	}

	public Section getSectionObject() {
		return sectionObject;
	}

	public String addSection() {
		String returnValue = "";
		String query = "INSERT INTO SECTTBL (SECTIONNAME, SOSLIST, CAPACITY) VALUES ('" + getSectionName() + "', '"
				+ getSosListAsString() + "', " + getSectionCapacity() + ")";
		try {
			OpenConnection.db.update(query);
			returnValue = "Section successfully added";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Section entry failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public static ArrayList<String> getSectionsList() {
		ArrayList<String> sectList = new ArrayList<String>();
		String query = "select SECTIONNAME from SECTTBL order by SECTIONNAME asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				sectList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sectList;
	}

	public static String vectorToString(Vector<Section> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getSectionObject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}

	public static TableModel viewSectionsInfo() {
		System.out.println("View room table ");

		ResultSet rs = null;
		String query = "SELECT * FROM SECTTBL ORDER BY SECTIONNAME";
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Section Name");
		columnNames.add("Set of Students");
		columnNames.add("Capacity");

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

}
