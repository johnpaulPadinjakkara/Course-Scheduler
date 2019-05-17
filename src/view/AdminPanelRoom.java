package view;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ClassRoomController;
import controller.CourseController;

public class AdminPanelRoom extends JPanel {
	private JTabbedPane tabs = new JTabbedPane();

	private int PosWdth;
	private int PosHgt;

	public AdminPanelRoom() {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.PosWdth = screenSize.width;
			this.PosHgt = screenSize.height;
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		AdminPanelAddRoom adminPanelAddRoom = new AdminPanelAddRoom();
		final AdminPanelViewRoom adminPanelViewRoom = new AdminPanelViewRoom();

		this.setLayout(null);
		tabs.setBounds(0, 0, PosWdth, PosHgt);
		tabs.add("Add", adminPanelAddRoom);
		tabs.add("View", adminPanelViewRoom);
		this.add(tabs, null);
		tabs.addChangeListener(new ChangeListener() { // add the Listener

			public void stateChanged(ChangeEvent e) {
				adminPanelViewRoom.displaytable_ViewRoom.setModel(ClassRoomController.viewRoomInfo());
			}
		});
	}
}
