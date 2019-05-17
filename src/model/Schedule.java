package model;

import database.OpenConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

public class Schedule {

	private int scheduleNumber;
	private Course course;
	private Vector<Slot> slotsInSchedule = new Vector<Slot>();
	private Vector<ClassRoom> roomsInSchedule = new Vector<ClassRoom>();
	private Schedule scheduleObject;

	public Schedule() {
		this.scheduleObject = this;
	}

	public Schedule(Vector<Slot> slots, Vector<ClassRoom> rooms) {

		this.slotsInSchedule = slots;
		this.roomsInSchedule = rooms;
	}

	public Schedule(int scheduleNumber) {
		setScheduleObject(this);
		String query = "SELECT * FROM SCHEDULETBL WHERE SCHDNUM='" + scheduleNumber + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getScheduleObject().setScheduleNumber(rs.getInt("SCHDNUM"));

				getScheduleObject().getSlotsInSchedule().add(0, new Slot(rs.getInt("SLOT1")));
				getScheduleObject().getSlotsInSchedule().add(1, new Slot(rs.getInt("SLOT2")));
				getScheduleObject().getSlotsInSchedule().add(2, new Slot(rs.getInt("SLOT3")));
				getScheduleObject().getSlotsInSchedule().add(3, new Slot(rs.getInt("SLOT4")));

				getScheduleObject().getRoomsInSchedule().add(0, new ClassRoom(rs.getInt("ROOM1")));
				getScheduleObject().getRoomsInSchedule().add(1, new ClassRoom(rs.getInt("ROOM2")));
				getScheduleObject().getRoomsInSchedule().add(2, new ClassRoom(rs.getInt("ROOM3")));
				getScheduleObject().getRoomsInSchedule().add(3, new ClassRoom(rs.getInt("ROOM4")));

				getScheduleObject().getSlotsInSchedule().add(4, new Slot(rs.getInt("TUTSLOT")));
				getScheduleObject().getSlotsInSchedule().add(5, new Slot(rs.getInt("LABSLOT")));
				getScheduleObject().getRoomsInSchedule().add(4, new ClassRoom(rs.getInt("ROOM5")));
				getScheduleObject().getRoomsInSchedule().add(5, new ClassRoom(rs.getInt("ROOM6")));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	public void setScheduleNumber(int scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public int getScheduleNumber() {
		return scheduleNumber;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setScheduleObject(Schedule scheduleObject) {
		this.scheduleObject = scheduleObject;
	}

	public Schedule getScheduleObject() {
		return scheduleObject;
	}

	public String addSchedule(int schdlNum) {
		String returnValue = "";
		int slot2num = (getSlotsInSchedule().get(1) == null ? 0
				: getSlotsInSchedule().get(1).getSlot().getSlotNumber());
		int slot3num = (getSlotsInSchedule().get(2) == null ? 0
				: getSlotsInSchedule().get(2).getSlot().getSlotNumber());
		int slot4num = (getSlotsInSchedule().get(3) == null ? 0
				: getSlotsInSchedule().get(3).getSlot().getSlotNumber());
		int tutSlotNum = (getSlotsInSchedule().get(4) == null ? 0
				: getSlotsInSchedule().get(4).getSlot().getSlotNumber());
		int labSlotNum = (getSlotsInSchedule().get(5) == null ? 0
				: getSlotsInSchedule().get(5).getSlot().getSlotNumber());
		int room2num = (getRoomsInSchedule().get(1) == null ? 0
				: getRoomsInSchedule().get(1).getRoomObject().getRoomNumber());
		int room3num = (getRoomsInSchedule().get(2) == null ? 0
				: getRoomsInSchedule().get(2).getRoomObject().getRoomNumber());
		int room4num = (getRoomsInSchedule().get(3) == null ? 0
				: getRoomsInSchedule().get(3).getRoomObject().getRoomNumber());
		int tutRoomNum = (getRoomsInSchedule().get(4) == null ? 0
				: getRoomsInSchedule().get(4).getRoomObject().getRoomNumber());
		int labRoomNum = (getRoomsInSchedule().get(5) == null ? 0
				: getRoomsInSchedule().get(5).getRoomObject().getRoomNumber());
		String query = "INSERT INTO SCHEDULETBL (SCHDNUM, SLOT1, SLOT2, SLOT3, SLOT4, TUTSLOT, LABSLOT, ROOM1, ROOM2, ROOM3, ROOM4, ROOM5, ROOM6) VALUES ("
				+ schdlNum + ", " + getSlotsInSchedule().get(0).getSlot().getSlotNumber() + ", " + slot2num + ", "
				+ slot3num + ", " + slot4num + ", " + tutSlotNum + ", " + labSlotNum + ", "
				+ getRoomsInSchedule().get(0).getRoomObject().getRoomNumber() + ", " + room2num + ", " + room3num + ", "
				+ room4num + ", " + tutRoomNum + ", " + labRoomNum + ")";
		try {
			OpenConnection.db.update(query);
			returnValue = addScheduleToCourse(schdlNum);
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Schedule entry failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public String addScheduleToCourse(int schdlNum) {
		Course courseAssociated = new Course(schdlNum);
		courseAssociated.setSchedule(this);
		courseAssociated.setSlotsInSchedule(this.getSlotsInSchedule());
		courseAssociated.setRoomsInSchedule(this.getRoomsInSchedule());
		String returnValue = "";
		String query = "UPDATE COURSTBL SET " + "SCHEDULE = " + schdlNum + " where COURSENUMBER = " + schdlNum;
		try {
			OpenConnection.db.update(query);
			returnValue = "Schedule successfully updated in course";
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Schedule entry to course failed. Error: " + e1.getMessage() + ". Error Code: "
					+ e1.getErrorCode();
		}
		return returnValue;
	}

	public static String vectorToString(Vector<Schedule> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getScheduleObject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;

	}

	public void setSlotsInSchedule(Vector<Slot> slotsInSchedule) {
		this.slotsInSchedule = slotsInSchedule;
	}

	public Vector<Slot> getSlotsInSchedule() {
		return slotsInSchedule;
	}

	public void setRoomsInSchedule(Vector<ClassRoom> roomsInSchedule) {
		this.roomsInSchedule = roomsInSchedule;
	}

	public Vector<ClassRoom> getRoomsInSchedule() {
		return roomsInSchedule;
	}
}
