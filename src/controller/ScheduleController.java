package controller;

import java.util.Vector;

import model.ClassRoom;
import model.Slot;
import model.Schedule;

public class ScheduleController {
	Schedule scheduleObj;

	public ScheduleController(Vector<Integer> slotsInt, Vector<Integer> roomsInt) {
		Vector<Slot> slots = new Vector<Slot>();
		Vector<ClassRoom> rooms = new Vector<ClassRoom>();
		for (int i = 0; i < slotsInt.size(); i++) {
			if (slotsInt.get(i) > 0) {
				slots.add(new Slot(slotsInt.get(i)));
				rooms.add(new ClassRoom(roomsInt.get(i)));
			} else {
				slots.add(null);
				rooms.add(null);
			}
		}
		this.scheduleObj = new Schedule(slots, rooms);
	}

	public String addSchedule(int scheduleNumber) {
		return scheduleObj.addSchedule(scheduleNumber);
	}
}
