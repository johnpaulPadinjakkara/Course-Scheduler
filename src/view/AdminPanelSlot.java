package view;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.SectionsController;
import controller.SlotController;

public class AdminPanelSlot extends JPanel {
	private JTabbedPane tabs = new JTabbedPane();

	private int PosWdth;
	private int PosHgt;

	public AdminPanelSlot() {
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

		AdminPanelAddSlot adminPanelAddSlot = new AdminPanelAddSlot();
		AdminPanelUpdateSlot adminPanelUpdateSlot = new AdminPanelUpdateSlot();
		final AdminPanelViewSlot adminPanelViewSlot = new AdminPanelViewSlot();

		this.setLayout(null);
		tabs.setBounds(0, 0, PosWdth, PosHgt);
		tabs.add("Add", adminPanelAddSlot);
		tabs.add("View", adminPanelViewSlot);
		tabs.add("Update", adminPanelUpdateSlot);
		this.add(tabs, null);

		tabs.addChangeListener(new ChangeListener() { // add the Listener

			public void stateChanged(ChangeEvent e) {
				adminPanelViewSlot.displaytable_ViewSlots.setModel(SlotController.viewSlotInfo());
			}
		});
	}
}
