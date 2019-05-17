package model;

import database.DBConnect;
import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClassRoom {
	private int roomNumber;
	private int capacity;
	private Vector<Slot> bookedSlots = new Vector<Slot>();
	private String bookedSlotsAsString;
	private int size;
	private ClassRoom roomObject;

	public ClassRoom() {
		this.roomObject = (this);
	}

	public ClassRoom(int roomNumber) {
		setRoomObject(this);
		String query = "SELECT * FROM ROOMSTBL WHERE ROOMNUMBER='" + roomNumber + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getRoomObject().setRoomNumber(rs.getInt("ROOMNUMBER"));
				getRoomObject().setCapacity(rs.getInt("CAPACITY"));
				getRoomObject().setBookedSlotsAsString(rs.getString("BOOKEDSLOTS"));
				getRoomObject().setSize(rs.getInt("SIZE"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ClassRoom(int roomNumber, int capacity) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.roomObject = (this);
	}

	public Vector<Slot> getBookedSlots() {
		return bookedSlots;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setBookedSlots(Vector<Slot> bookedSlots) {
		this.bookedSlots = bookedSlots;
	}

	public void setBookedSlotsAsString(String bookedSlotsAsString) {
		this.bookedSlotsAsString = bookedSlotsAsString;
	}

	public String getBookedSlotsAsString() {
		return bookedSlotsAsString;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setRoomObject(ClassRoom roomObject) {
		this.roomObject = roomObject;
	}

	public ClassRoom getRoomObject() {
		return roomObject;
	}

	public String addRoom() {
		String returnValue = "";
		String query = "INSERT INTO ROOMSTBL (ROOMNUMBER, CAPACITY) VALUES ('" + getRoomNumber() + "'," + getCapacity()
				+ ")";
		try {
			OpenConnection.db.update(query);
			returnValue = "Room " + getRoomNumber() + " successfully added";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Room entry failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;

	}

	public void updateRoomImplicit() {
		String query = "";
		query = "UPDATE ROOMSTBL SET " + "BOOKEDSLOTS = '" + this.getBookedSlotsAsString() + "' ,SIZE = "
				+ this.getSize() + " where ROOMNUMBER = " + this.getRoomNumber();
		try {
			OpenConnection.db.update(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public String updateRoomExplicit() {
		DBConnect db = new DBConnect();
		String retValue = "";
		String query = "UPDATE ROOMSTBL SET " + "CAPACITY = " + this.getCapacity() + " where ROOMNUMBER = "
				+ this.getRoomNumber();
		try {
			db.update(query);
			retValue = "Room " + getRoomNumber() + " updated successfully.";
		} catch (SQLException e1) {
			e1.printStackTrace();
			retValue = "Room update failed. \nError Code: " + e1.getErrorCode() + " \nError Message: "
					+ e1.getMessage();
		} finally {
			try {
				db.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return retValue;
	}

	public static ArrayList<String> getRoomNumberList() {
		ArrayList<String> roomList = new ArrayList<String>();
		/* Add Slot to method parameters and uncomment below code */
		/*
		 * String query =
		 * "select * from ROOMSTBL where (not BOOKEDSLOTS like '%"+slot.getSlotNumber()
		 * +"%') order by ROOMNUM asc";
		 */
		String query = "select ROOMNUMBER, CAPACITY from ROOMSTBL  order by ROOMNUMBER asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String roomListContents = rs.getInt("ROOMNUMBER") + " (Capacity: " + rs.getInt("CAPACITY") + ")";
				roomList.add(roomListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomList;
	}

	public static TableModel viewRoomInfo() {
		ResultSet rs = null;
		String query = "SELECT ROOMNUMBER,CAPACITY FROM ROOMSTBL";
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e1) {
			e1.getErrorCode();
		}
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Room Number");
		columnNames.add("Capacity");
		int columnCount = columnNames.size();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		try {
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, columnNames);
	}
	/*
	 * public void bookRoom(Slot slot) { for (int i = 0; i < bookedSlots.size();
	 * i++) if (bookedSlots.get(i).getSlotNumber() == slot.getSlotNumber())
	 * bookedSlots.remove(i); this.bookedSlots.add(slot); //
	 * bookedSlots.removeAll(Collections.singleton(null));
	 * setBookedSlotsAsString(this.bookedSlots); }
	 */

	public static String vectorToString(Vector<ClassRoom> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getRoomObject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}
}
