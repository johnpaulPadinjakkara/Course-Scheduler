package model;

import database.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClassRoom_bckup {
	private int roomNumber;
	private int capacity;
	private ClassRoom_bckup room;
	private Vector<Slot> bookedSlots = new Vector<Slot>();
	private String bookedSlotsAsString;
	private int size;

	public ClassRoom_bckup() {
	}

	public ClassRoom_bckup(int roomNumber) {
		DBConnect db = new DBConnect();
		String query = "SELECT * FROM ROOMSTBL WHERE ROOMNUM='" + roomNumber + "'";
		ResultSet rs = null;
		try {
			rs = db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				setRoomNumber(rs.getInt(1));
				setCapacity(rs.getInt(2));
				setSize(rs.getInt(4));
				String tempStr = "";
				if (rs.getString(3) != null) {
					if (rs.getString(3).contains("null"))
						tempStr = rs.getString(3).substring(4);
					String[] bookedSlotListAsStr = tempStr.split("~");
					for (int i = 0; i < bookedSlotListAsStr.length; i++)
						setBookedSlots(new Slot(Integer.parseInt(bookedSlotListAsStr[i])));
				}
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			try {
				db.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public ClassRoom_bckup(int roomNumber, int capacity) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.room = (this);
	}

	/* Commented for future use. Mostly will not use */
	/*
	 * public ClassRoom getRoom(String roomNumber) { ClassRoom returnValue = null;
	 * for (int i=0;i<roomList.size();i++) { if
	 * (roomNumber.equalsIgnoreCase(roomList.get(i).roomNumber)) { returnValue =
	 * roomList.get(i); break; } } return returnValue; }
	 */

	public TableModel viewRoomInfo() {
		ResultSet rs = null;
		String query = "SELECT ROOMNUM,CAPACITY FROM ROOMSTBL";
		DBConnect dBConnect = new DBConnect();
		try {
			rs = dBConnect.query(query);
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
		} finally {
			try {
				dBConnect.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return new DefaultTableModel(data, columnNames);

	}

	public String addRoom() {
		DBConnect db = new DBConnect();
		String returnValue = "";
		String query = "INSERT INTO ROOMSTBL (ROOMNUM, CAPACITY) VALUES ('" + getRoomNumber() + "','" + getCapacity()
				+ "')";
		try {
			db.update(query);
			returnValue = "Room " + getRoomNumber() + " successfully added";
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				db.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		return returnValue;
	}

	public void updateRoomImplicit() {
		DBConnect db = new DBConnect();
		String query = "";
		query = "UPDATE ROOMSTBL SET " + "BOOKEDSLOTS = '" + this.getBookedSlotsAsString() + "' ,SIZE = "
				+ this.getSize() + " where ROOMNUM = " + this.getRoomNumber();

		try {
			db.update(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				db.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public String updateRoomExplicit() {
		DBConnect db = new DBConnect();
		String retValue = "";
		String query = "UPDATE ROOMSTBL SET " + "CAPACITY = " + this.getCapacity() + " where ROOMNUM = "
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

	public void setRoom(ClassRoom_bckup room) {
		this.room = room;
	}

	public ClassRoom_bckup getRoom() {
		return room;
	}

	public ClassRoom_bckup getRoom(String string) {
		/* Need to update logic */
		return null;
	}

	public ArrayList<String> getRoomNumberList() {
		DBConnect db = new DBConnect();
		ArrayList<String> roomList = new ArrayList<String>();
		/* Add Slot to method parameters and uncomment below code */
		/*
		 * String query =
		 * "select * from ROOMSTBL where (not BOOKEDSLOTS like '%"+slot.getSlotNumber()
		 * +"%') order by ROOMNUM asc";
		 */
		String query = "select * from ROOMSTBL  order by ROOMNUM asc";
		ResultSet rs = null;
		try {
			rs = db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				String roomListContents = rs.getInt(1) + " (Capacity: " + rs.getInt(2) + ")";
				roomList.add(roomListContents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomList;
	}

	public Vector<Slot> getBookedSlots() {
		return bookedSlots;
	}

	public void bookRoom(Slot slot) {
		for (int i = 0; i < bookedSlots.size(); i++)
			if (bookedSlots.get(i).getSlotNumber() == slot.getSlotNumber())
				bookedSlots.remove(i);
		this.bookedSlots.add(slot);
		// bookedSlots.removeAll(Collections.singleton(null));
		setBookedSlotsAsString(this.bookedSlots);
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setBookedSlots(Slot bookedSlots) {
		this.bookedSlots.add(bookedSlots);
	}

	private void setBookedSlotsAsString(Vector<Slot> bookedSlot) {
		bookedSlots.removeAll(Collections.singleton(null));
		for (int i = 0; i < bookedSlot.size(); i++) {
			this.bookedSlotsAsString += Integer.toString(bookedSlot.get(i).getSlotNumber()) + "~";
		}
	}

	private String getBookedSlotsAsString() {
		int count = 0;
		if (bookedSlotsAsString.contains("null")) {
			count = count + 1;
		}
		return bookedSlotsAsString;
	}
}
