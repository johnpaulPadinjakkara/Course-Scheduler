package view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ClassRoomController;
import controller.SlotController;

public class AdminPanelViewSlot extends JPanel {
	public JTable displaytable_ViewSlots = new JTable();

	public AdminPanelViewSlot() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(new BorderLayout());
		displaytable_ViewSlots.setBounds(new Rectangle(130, 160, 0, 0));
		SlotController slot = new SlotController();
		displaytable_ViewSlots.setModel(slot.viewSlotInfo());
		JScrollPane displaytableContainer_ViewRoom = new JScrollPane(displaytable_ViewSlots);
		this.add(displaytableContainer_ViewRoom, BorderLayout.CENTER);
	}
}
