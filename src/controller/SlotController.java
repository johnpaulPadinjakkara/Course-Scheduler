package controller;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import model.Slot;

public class SlotController {
	public SlotController() {
	}

	public String addSlot(int slotNumber, String day, String startTime, String endTime) {
		Slot slot = new Slot(slotNumber, day, startTime, endTime);
		return slot.addSlot();
	}

	public ArrayList<String> getSlotList() {
		return Slot.getSlotList();
	}

	public static TableModel viewSlotInfo() {
		return Slot.viewSlotInfo();
	}
}
