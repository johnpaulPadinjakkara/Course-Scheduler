package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ComboBoxValuesController;
import controller.SlotController;

import javax.swing.JOptionPane;

import model.ComboBoxValues;
import model.Slot;

public class AdminPanelAddSlot extends JPanel {
	private JButton addSlotButton_AddSlot = new JButton();
	private JLabel slotNumber_id_AddSlot = new JLabel();
	private JLabel startTime_id_AddSlot = new JLabel();
	private JLabel endTime_id_AddSlot = new JLabel();
	private JComboBox startTimeHrs_val_AddSlot = new JComboBox();
	private JComboBox startTimeMin_val_AddSlot = new JComboBox();
	private JComboBox startTimeAMPM_val_AddSlot = new JComboBox();
	private JComboBox endTimeHrs_val_AddSlot = new JComboBox();
	private JComboBox endTimeMin_val_AddSlot = new JComboBox();
	private JComboBox endTimeAMPM_val_AddSlot = new JComboBox();
	private JComboBox day_val_AddSlot = new JComboBox();
	private JLabel day_id_AddSlot = new JLabel();
	private JButton submitButton_AddSlot = new JButton();

	private int halfPosWdth;
	private int qrtrPosHgt;
	private JFormattedTextField slotNumber_val_AddSlot = new JFormattedTextField();

	public AdminPanelAddSlot() {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.halfPosWdth = screenSize.width / 2;
			this.qrtrPosHgt = screenSize.height / 4;
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(null);
		this.setSize(new Dimension(731, 484));
		addSlotButton_AddSlot.setText("Click Here to Add Slot");
		addSlotButton_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 200, 80, 400, 25));
		addSlotButton_AddSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSlotInit(e);
			}
		});
		slotNumber_id_AddSlot.setText("Slot Number");
		slotNumber_id_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 150, 150, 100, 20));
		startTime_id_AddSlot.setText("Start Time");
		startTime_id_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 150, 180, 100, 20));
		endTime_id_AddSlot.setText("End Time");
		endTime_id_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 150, 210, 100, 20));
		slotNumber_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth, 148, 200, 25));
		startTimeHrs_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth, 178, 60, 25));
		startTimeHrs_val_AddSlot.setModel(new DefaultComboBoxModel(populateHrsComboBox().toArray()));
		startTimeMin_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth + 70, 178, 60, 25));
		startTimeMin_val_AddSlot.setModel(new DefaultComboBoxModel(populateMinsComboBox().toArray()));
		startTimeAMPM_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth + 140, 178, 60, 25));
		startTimeAMPM_val_AddSlot.addItem("AM");
		startTimeAMPM_val_AddSlot.addItem("PM");
		endTimeHrs_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth, 208, 60, 25));
		endTimeHrs_val_AddSlot.setModel(new DefaultComboBoxModel(populateHrsComboBox().toArray()));
		endTimeMin_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth + 70, 208, 60, 25));
		endTimeMin_val_AddSlot.setModel(new DefaultComboBoxModel(populateMinsComboBox().toArray()));
		endTimeAMPM_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth + 140, 208, 60, 25));
		endTimeAMPM_val_AddSlot.addItem("AM");
		endTimeAMPM_val_AddSlot.addItem("PM");
		day_val_AddSlot.setBounds(new Rectangle(this.halfPosWdth, 238, 200, 25));
		day_id_AddSlot.setText("Day");
		day_id_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 150, 240, 100, 25));
		day_val_AddSlot.addItem("Monday (M)");
		day_val_AddSlot.addItem("Tuesday (T)");
		day_val_AddSlot.addItem("Wednesday (W)");
		day_val_AddSlot.addItem("Thursday (R)");
		day_val_AddSlot.addItem("Friday (F)");
		submitButton_AddSlot.setText("Submit");
		submitButton_AddSlot.setBounds(new Rectangle(this.halfPosWdth - 50, 320, 100, 25));

		submitButton_AddSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSlotConstCall(e);
			}
		});

		slotNumber_val_AddSlot.setVisible(false);
		submitButton_AddSlot.setVisible(false);
		day_id_AddSlot.setVisible(false);
		day_val_AddSlot.setVisible(false);
		endTimeAMPM_val_AddSlot.setVisible(false);
		endTimeMin_val_AddSlot.setVisible(false);
		endTimeHrs_val_AddSlot.setVisible(false);
		startTimeAMPM_val_AddSlot.setVisible(false);
		startTimeMin_val_AddSlot.setVisible(false);
		startTimeHrs_val_AddSlot.setVisible(false);
		endTime_id_AddSlot.setVisible(false);
		startTime_id_AddSlot.setVisible(false);
		slotNumber_id_AddSlot.setVisible(false);
		addSlotButton_AddSlot.setVisible(true);

		this.add(slotNumber_val_AddSlot, null);
		this.add(submitButton_AddSlot, null);
		this.add(day_id_AddSlot, null);
		this.add(day_val_AddSlot, null);
		this.add(endTimeAMPM_val_AddSlot, null);
		this.add(endTimeMin_val_AddSlot, null);
		this.add(endTimeHrs_val_AddSlot, null);
		this.add(startTimeAMPM_val_AddSlot, null);
		this.add(startTimeMin_val_AddSlot, null);
		this.add(startTimeHrs_val_AddSlot, null);
		this.add(endTime_id_AddSlot, null);
		this.add(startTime_id_AddSlot, null);
		this.add(slotNumber_id_AddSlot, null);
		this.add(addSlotButton_AddSlot, null);
	}

	private void addSlotInit(ActionEvent e) {
		slotNumber_val_AddSlot.setVisible(true);
		submitButton_AddSlot.setVisible(true);
		day_id_AddSlot.setVisible(true);
		day_val_AddSlot.setVisible(true);
		endTimeAMPM_val_AddSlot.setVisible(true);
		endTimeMin_val_AddSlot.setVisible(true);
		endTimeHrs_val_AddSlot.setVisible(true);
		startTimeAMPM_val_AddSlot.setVisible(true);
		startTimeMin_val_AddSlot.setVisible(true);
		startTimeHrs_val_AddSlot.setVisible(true);
		endTime_id_AddSlot.setVisible(true);
		startTime_id_AddSlot.setVisible(true);
		slotNumber_id_AddSlot.setVisible(true);
		addSlotButton_AddSlot.setVisible(false);
	}

	private void addSlotConstCall(ActionEvent e) {
		String startTime_ = (String) startTimeHrs_val_AddSlot.getSelectedItem() + ":"
				+ (String) startTimeMin_val_AddSlot.getSelectedItem() + " "
				+ (String) startTimeAMPM_val_AddSlot.getSelectedItem();
		String endTime_ = (String) endTimeHrs_val_AddSlot.getSelectedItem() + ":"
				+ (String) endTimeMin_val_AddSlot.getSelectedItem() + " "
				+ (String) endTimeAMPM_val_AddSlot.getSelectedItem();
		SlotController slot = new SlotController();
		String output = slot.addSlot(Integer.parseInt(slotNumber_val_AddSlot.getText()),
				day_val_AddSlot.getSelectedItem().toString(), startTime_, endTime_);
		int refresh = JOptionPane.showOptionDialog(this, output, "Add Slot", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}

	public ArrayList<String> populateHrsComboBox() {
		ComboBoxValuesController slotLOV = new ComboBoxValuesController(new ComboBoxValues());
		return slotLOV.getValueList(this.getClass().getSimpleName(), "TimeHrs_val_AddSlot");
	}

	public ArrayList<String> populateMinsComboBox() {
		ComboBoxValuesController slotLOV = new ComboBoxValuesController(new ComboBoxValues());
		return slotLOV.getValueList(this.getClass().getSimpleName(), "TimeMin_val_AddSlot");
	}
}
