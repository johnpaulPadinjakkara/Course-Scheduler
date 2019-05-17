package view;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.CourseController;

public class AdminPanelCourse extends JPanel {
	private JTabbedPane tabs = new JTabbedPane();
	AdminPanelAddCourse adminPanelAddCourse = new AdminPanelAddCourse();
	AdminPanelUpdateCourse adminPanelUpdateCourse = new AdminPanelUpdateCourse();
	AdminPanelViewCourse adminPanelViewCourse = new AdminPanelViewCourse();
	private int PosWdth;
	private int PosHgt;

	public AdminPanelCourse() {
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

		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();

				if (index == 0) {
					adminPanelAddCourse.refresh();
				} else if (index == 1) {
					adminPanelUpdateCourse.refresh();
				} else if (index == 2) {
					adminPanelViewCourse.refresh();
				}
			}
		};

		this.setLayout(null);
		tabs.addChangeListener(changeListener);
		tabs.setBounds(0, 0, PosWdth, PosHgt);
		tabs.add("Add", adminPanelAddCourse);
		tabs.add("View", adminPanelViewCourse);
		tabs.add("Update", adminPanelUpdateCourse);
		this.add(tabs, null);

		tabs.addChangeListener(new ChangeListener() { // add the Listener

			public void stateChanged(ChangeEvent e) {
				adminPanelViewCourse.displaytable_ViewCourse.setModel(CourseController.viewCourseInfo());
			}
		});
	}
}
