/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import model.ClassRoom;

public class ClassRoomController {
	// ClassRoom classRoom;

	/**
	 * 
	 */
	public ClassRoomController() {
	}

	public static TableModel viewRoomInfo() {
		return ClassRoom.viewRoomInfo();
	}

	public String addRoom(int roomNumber, int capacity) {
		ClassRoom classRoom = new ClassRoom(roomNumber, capacity);
		return classRoom.addRoom();
	}

	public ArrayList<String> getRoomNumberList() {
		return ClassRoom.getRoomNumberList();
	}

}
