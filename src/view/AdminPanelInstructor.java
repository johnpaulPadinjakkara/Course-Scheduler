package view;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ClassRoomController;
import controller.InstructorController;
import controller.UserInfoController;

public class AdminPanelInstructor extends JPanel {
	private JTabbedPane tabs = new JTabbedPane();

	private int PosWdth;
	private int PosHgt;

	public AdminPanelInstructor() {
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

		AdminPanelAddInstructor adminPanelAddInstructor = new AdminPanelAddInstructor();
		final AdminPanelViewInstructor adminPanelViewInstructor = new AdminPanelViewInstructor();

		this.setLayout(null);
		tabs.setBounds(0, 0, PosWdth, PosHgt);
		tabs.add("Add", adminPanelAddInstructor);
		tabs.add("View", adminPanelViewInstructor);
		this.add(tabs, null);
		tabs.addChangeListener(new ChangeListener() { // add the Listener

			public void stateChanged(ChangeEvent e) {
				adminPanelViewInstructor.displaytable_ViewInstructor.setModel(UserInfoController.viewInstructorTable());
			}
		});
	}
}
