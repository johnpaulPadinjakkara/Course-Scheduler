package view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.CourseController;
import controller.UserInfoController;

public class AdminPanelViewCourse extends JPanel {
	public JTable displaytable_ViewCourse = new JTable();

	public AdminPanelViewCourse() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jbInit() throws Exception {
		this.setLayout(new BorderLayout());
		displaytable_ViewCourse.setBounds(new Rectangle(130, 160, 0, 0));
		displaytable_ViewCourse.setModel(CourseController.viewCourseInfo());
		JScrollPane displaytableContainer_ViewCourse = new JScrollPane(displaytable_ViewCourse);
		this.add(displaytableContainer_ViewCourse, BorderLayout.CENTER);
	}

	public void refresh() {

	}
}
