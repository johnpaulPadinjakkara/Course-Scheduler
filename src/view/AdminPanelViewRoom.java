package view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ClassRoomController;

public class AdminPanelViewRoom extends JPanel {
	public JTable displaytable_ViewRoom = new JTable();

	public AdminPanelViewRoom() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(new BorderLayout());
		displaytable_ViewRoom.setBounds(new Rectangle(130, 160, 0, 0));
		// ClassRoomController room = new ClassRoomController();
		displaytable_ViewRoom.setModel(ClassRoomController.viewRoomInfo());
		JScrollPane displaytableContainer_ViewRoom = new JScrollPane(displaytable_ViewRoom);
		this.add(displaytableContainer_ViewRoom, BorderLayout.CENTER);
	}
}
