package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Slot {
	private int slotNumber;
	private String startTime;
	private String endTime;
	private String day;
	private Course course;
	private Slot slotObject;

	public Slot() {
		this.slotObject = this;
	}

	public Slot(int slotNumber) {
		setSlot(this);
		String query = "SELECT * FROM SLOTTBL WHERE SLOT='" + slotNumber + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getSlot().setSlotNumber(rs.getInt("SLOT"));
				getSlot().setStartTime(rs.getString("STARTTIME"));
				getSlot().setEndTime(rs.getString("ENDTIME"));
				getSlot().setDay(rs.getString("DAYOFWEEK"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public Slot(int slotNumber, String day, String startTime, String endTime) {
		this.slotNumber = slotNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
		this.slotObject = this;
	}

	/* Commented for future use. Mostly will not use */
	/*
	 * public Slot getSlot(int slotNumber) { Slot returnValue = null; for (int
	 * i=0;i<slotList.size();i++) { if (slotNumber == (slotList.get(i).slotNumber))
	 * { returnValue = slotList.get(i); break; } } return returnValue; }
	 */

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	public void setSlot(Slot slot) {
		this.slotObject = slot;
	}

	public Slot getSlot() {
		return slotObject;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	// public Slot getSlot(Integer integer) {
	// /* Need to update logic */
	// return null;
	// }

	public String addSlot() {
		String returnValue = "";
		String query = "INSERT INTO SLOTTBL (SLOT, STARTTIME, ENDTIME, DAYOFWEEK) VALUES ('" + getSlotNumber() + "','"
				+ getStartTime() + "','" + getEndTime() + "','" + getDay() + "')";
		try {
			OpenConnection.db.update(query);
			returnValue = "Slot " + getSlotNumber() + " successfully added";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Slot entry failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;

	}

	public static ArrayList<String> getSlotList() {

		ArrayList<String> slotList = new ArrayList<String>();
		String query = "select SLOT,STARTTIME,ENDTIME,DAYOFWEEK from SLOTTBL order by SLOT asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String num = ((rs.getString("SLOT").length() == 1) ? ("0" + rs.getString("SLOT"))
						: (rs.getString("SLOT")));
				String slotListContents = "Slot Number: " + num + "(" + rs.getString("STARTTIME") + " - "
						+ rs.getString("ENDTIME") + " " + rs.getString("DAYOFWEEK").substring(
								rs.getString("DAYOFWEEK").length() - 3, rs.getString("DAYOFWEEK").length() - 1)
						+ ")";
				slotList.add(slotListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slotList;
	}

	public static String vectorToString(Vector<Slot> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getSlot() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}

	public static TableModel viewSlotInfo() {

		ResultSet rs = null;
		String query = "SELECT * FROM SLOTTBL ORDER BY SLOT";
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Slot Numer");
		columnNames.add("Start Time");
		columnNames.add("End Time");

		columnNames.add("Day of Week");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try {
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnNames.size(); columnIndex++) {
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
