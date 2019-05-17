package view;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ClassRoomController;
import controller.SectionsController;

public class AdminPanelSection extends JPanel {
	private JTabbedPane tabs = new JTabbedPane();

	private int PosWdth;
	private int PosHgt;

	public AdminPanelSection() {
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

		AdminPanelAddSection adminPanelAddSection = new AdminPanelAddSection();
		AdminPanelUpdateSection adminPanelUpdateSection = new AdminPanelUpdateSection();
		final AdminPanelViewSection adminPanelViewSection = new AdminPanelViewSection();

		this.setLayout(null);
		tabs.setBounds(0, 0, PosWdth, PosHgt);
		tabs.add("Add", adminPanelAddSection);
		tabs.add("View", adminPanelViewSection);
		tabs.add("Update", adminPanelUpdateSection);
		this.add(tabs, null);

		tabs.addChangeListener(new ChangeListener() { // add the Listener

			public void stateChanged(ChangeEvent e) {
				adminPanelViewSection.displaytable_ViewSctions.setModel(SectionsController.viewSectionsInfo());
			}
		});
	}
}
