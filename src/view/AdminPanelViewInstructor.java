package view;

import controller.UserInfoController;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPanelViewInstructor extends JPanel {
	public JTable displaytable_ViewInstructor = new JTable();

	public AdminPanelViewInstructor() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(new BorderLayout());
		displaytable_ViewInstructor.setBounds(new Rectangle(130, 160, 0, 0));

		UserInfoController instr = new UserInfoController();
		displaytable_ViewInstructor.setModel(instr.viewInstructorTable());
		JScrollPane displaytableContainer_ViewInstructor = new JScrollPane(displaytable_ViewInstructor);

		this.add(displaytableContainer_ViewInstructor, BorderLayout.CENTER);
	}
}
