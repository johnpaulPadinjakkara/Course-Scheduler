package view;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.CourseController;
import controller.SectionsController;

public class AdminPanelViewSection extends JPanel {

	public JTable displaytable_ViewSctions = new JTable();

	public AdminPanelViewSection() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(new BorderLayout());
		displaytable_ViewSctions.setBounds(new Rectangle(130, 160, 0, 0));
		SectionsController sections = new SectionsController();
		displaytable_ViewSctions.setModel(sections.viewSectionsInfo());
		JScrollPane displaytableContainer_ViewCourse = new JScrollPane(displaytable_ViewSctions);
		this.add(displaytableContainer_ViewCourse, BorderLayout.CENTER);
	}
}
