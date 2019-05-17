package view;

import controller.ClassRoomController;

import controller.ScheduleController;
import controller.SlotController;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

import model.ClassRoom;
import model.Schedule;
import model.Slot;

public class AdminPanelAddSchedule extends JDialog {
	private JLabel lectSlot1_id_AddSchedule = new JLabel();
	private JLabel lectSlot2_id_AddSchedule = new JLabel();
	private JLabel lectSlot3_id_AddSchedule = new JLabel();
	private JLabel lectSlot4_id_AddSchedule = new JLabel();
	private JLabel tutSlot_id_AddSchedule = new JLabel();
	private JLabel labSlot_id_AddSchedule = new JLabel();
	private JComboBox lectSlot1_val_AddSchedule = new JComboBox();
	private JComboBox lectSlot2_val_AddSchedule = new JComboBox();
	private JComboBox lectSlot3_val_AddSchedule = new JComboBox();
	private JComboBox lectSlot4_val_AddSchedule = new JComboBox();
	private JComboBox labSlot_val_AddSchedule = new JComboBox();
	private JComboBox tutSlot_val_AddSchedule = new JComboBox();
	private JButton addSlot2Button_AddSchedule = new JButton();
	private JButton addSlot3Button_AddSchedule = new JButton();
	private JButton addSlot4Button_AddSchedule = new JButton();
	private JButton removeSlot2Button_AddSchedule = new JButton();
	private JButton removeSlot3Button_AddSchedule = new JButton();
	private JButton removeSlot4Button_AddSchedule = new JButton();
	private JButton submitButton_AddSchedule = new JButton();
	private JLabel room1_id_AddSchedule = new JLabel();
	private JLabel room2_id_AddSchedule = new JLabel();
	private JLabel room3_id_AddSchedule = new JLabel();
	private JLabel room4_id_AddSchedule = new JLabel();
	private JLabel roomTutorial_id_AddSchedule = new JLabel();
	private JLabel roomLab_id_AddSchedule = new JLabel();
	private JComboBox room1_val_AddSchedule = new JComboBox();
	private JComboBox room2_val_AddSchedule = new JComboBox();
	private JComboBox room3_val_AddSchedule = new JComboBox();
	private JComboBox room4_val_AddSchedule = new JComboBox();
	private JComboBox room5_val_AddSchedule = new JComboBox();
	private JComboBox room6_val_AddSchedule = new JComboBox();

	private int scheduleNumber;
	private boolean isLabCheck;
	private boolean isTutCheck;

	public AdminPanelAddSchedule() {
		this(null, "", false);
	}

	public AdminPanelAddSchedule(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

	}

	public void setScheduleNumber(int scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public int getScheduleNumber() {
		return scheduleNumber;
	}

	public void setIsLabCheck(boolean isLabCheck_) {
		this.isLabCheck = isLabCheck_;
	}

	public boolean isIsLabCheck() {
		return isLabCheck;
	}

	public void setIsTutCheck(boolean isTutCheck_) {
		this.isTutCheck = isTutCheck_;
	}

	public boolean isIsTutCheck() {
		return isTutCheck;
	}

	public void executeJBInit() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setSize(new Dimension(825, 350));
		this.getContentPane().setLayout(null);
		lectSlot1_id_AddSchedule.setText("Lecture Slot 1");
		lectSlot1_id_AddSchedule.setBounds(new Rectangle(35, 50, 100, 25));
		lectSlot2_id_AddSchedule.setText("Lecture Slot 2");
		lectSlot2_id_AddSchedule.setBounds(new Rectangle(35, 80, 100, 25));
		lectSlot2_id_AddSchedule.setEnabled(false);
		lectSlot3_id_AddSchedule.setText("Lecture Slot 3");
		lectSlot3_id_AddSchedule.setBounds(new Rectangle(35, 110, 100, 25));
		lectSlot3_id_AddSchedule.setEnabled(false);
		lectSlot4_id_AddSchedule.setText("Lecture Slot 4");
		lectSlot4_id_AddSchedule.setBounds(new Rectangle(35, 140, 100, 25));
		lectSlot4_id_AddSchedule.setEnabled(false);
		tutSlot_id_AddSchedule.setText("Tutorial Slot");
		tutSlot_id_AddSchedule.setBounds(new Rectangle(35, 170, 100, 25));
		labSlot_id_AddSchedule.setText("Laboratory Slot");
		labSlot_id_AddSchedule.setBounds(new Rectangle(35, 200, 100, 25));

		lectSlot1_val_AddSchedule.setBounds(new Rectangle(150, 50, 200, 25));
		lectSlot1_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		lectSlot1_val_AddSchedule.setSelectedIndex(-1);
		lectSlot2_val_AddSchedule.setBounds(new Rectangle(150, 80, 200, 25));
		lectSlot2_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		lectSlot2_val_AddSchedule.setSelectedIndex(-1);
		lectSlot2_val_AddSchedule.setEnabled(false);
		lectSlot3_val_AddSchedule.setBounds(new Rectangle(150, 110, 200, 25));
		lectSlot3_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		lectSlot3_val_AddSchedule.setSelectedIndex(-1);
		lectSlot3_val_AddSchedule.setEnabled(false);
		lectSlot4_val_AddSchedule.setBounds(new Rectangle(150, 140, 200, 25));
		lectSlot4_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		lectSlot4_val_AddSchedule.setSelectedIndex(-1);
		lectSlot4_val_AddSchedule.setEnabled(false);
		tutSlot_val_AddSchedule.setBounds(new Rectangle(150, 170, 200, 25));
		tutSlot_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		tutSlot_val_AddSchedule.setSelectedIndex(-1);
		labSlot_val_AddSchedule.setBounds(new Rectangle(150, 200, 200, 25));
		labSlot_val_AddSchedule.setModel(new DefaultComboBoxModel(populateSlotNumberComboBox().toArray()));
		labSlot_val_AddSchedule.setSelectedIndex(-1);

		addSlot2Button_AddSchedule.setText("Add");
		addSlot2Button_AddSchedule.setBounds(new Rectangle(600, 50, 90, 25));
		addSlot2Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSlot2Button_AddSchedule_actionPerformed(e);
			}
		});
		addSlot3Button_AddSchedule.setText("Add");
		addSlot3Button_AddSchedule.setBounds(new Rectangle(600, 80, 90, 25));
		addSlot3Button_AddSchedule.setEnabled(false);
		addSlot3Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSlot3Button_AddSchedule_actionPerformed(e);
			}
		});
		addSlot4Button_AddSchedule.setText("Add");
		addSlot4Button_AddSchedule.setBounds(new Rectangle(600, 110, 90, 25));
		addSlot4Button_AddSchedule.setEnabled(false);
		addSlot4Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSlot4Button_AddSchedule_actionPerformed(e);
			}
		});
		removeSlot2Button_AddSchedule.setText("Remove");
		removeSlot2Button_AddSchedule.setBounds(new Rectangle(700, 50, 90, 25));
		removeSlot2Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSlot2Button_AddSchedule_actionPerformed(e);
			}
		});
		removeSlot3Button_AddSchedule.setText("Remove");
		removeSlot3Button_AddSchedule.setBounds(new Rectangle(700, 80, 90, 25));
		removeSlot3Button_AddSchedule.setEnabled(false);
		removeSlot3Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSlot3Button_AddSchedule_actionPerformed(e);
			}
		});
		removeSlot4Button_AddSchedule.setText("Remove");
		removeSlot4Button_AddSchedule.setBounds(new Rectangle(700, 110, 90, 25));
		removeSlot4Button_AddSchedule.setEnabled(false);
		removeSlot4Button_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSlot4Button_AddSchedule_actionPerformed(e);
			}
		});
		submitButton_AddSchedule.setText("Submit");
		submitButton_AddSchedule.setBounds(new Rectangle(350, 250, 125, 25));
		submitButton_AddSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitButton_AddSchedule(e);
			}
		});
		room1_id_AddSchedule.setText("Room");
		room1_id_AddSchedule.setBounds(new Rectangle(400, 50, 75, 25));

		room2_id_AddSchedule.setText("Room");
		room2_id_AddSchedule.setBounds(new Rectangle(400, 80, 75, 25));
		room2_id_AddSchedule.setEnabled(false);
		room3_id_AddSchedule.setText("Room");
		room3_id_AddSchedule.setBounds(new Rectangle(400, 110, 75, 25));
		room3_id_AddSchedule.setEnabled(false);
		room4_id_AddSchedule.setText("Room");
		room4_id_AddSchedule.setBounds(new Rectangle(400, 140, 75, 25));
		room4_id_AddSchedule.setEnabled(false);
		roomTutorial_id_AddSchedule.setText("Room");
		roomTutorial_id_AddSchedule.setBounds(new Rectangle(400, 170, 75, 25));
		roomLab_id_AddSchedule.setText("Room");
		roomLab_id_AddSchedule.setBounds(new Rectangle(400, 200, 75, 25));

		room1_val_AddSchedule.setBounds(new Rectangle(500, 50, 75, 25));
		room1_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room1_val_AddSchedule.setSelectedIndex(-1);
		room2_val_AddSchedule.setBounds(new Rectangle(500, 80, 75, 25));
		room2_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room2_val_AddSchedule.setSelectedIndex(-1);
		room2_val_AddSchedule.setEnabled(false);
		room3_val_AddSchedule.setBounds(new Rectangle(500, 110, 75, 25));
		room3_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room3_val_AddSchedule.setSelectedIndex(-1);
		room3_val_AddSchedule.setEnabled(false);
		room4_val_AddSchedule.setBounds(new Rectangle(500, 140, 75, 25));
		room4_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room4_val_AddSchedule.setSelectedIndex(-1);
		room4_val_AddSchedule.setEnabled(false);
		room5_val_AddSchedule.setBounds(new Rectangle(500, 170, 75, 25));
		room5_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room5_val_AddSchedule.setSelectedIndex(-1);
		room6_val_AddSchedule.setBounds(new Rectangle(500, 200, 75, 25));
		room6_val_AddSchedule.setModel(new DefaultComboBoxModel(populateRoomNumberComboBox().toArray()));
		room6_val_AddSchedule.setSelectedIndex(-1);
		if (!isIsTutCheck()) {
			tutSlot_id_AddSchedule.setEnabled(false);
			tutSlot_val_AddSchedule.setEnabled(false);
			roomTutorial_id_AddSchedule.setEnabled(false);
			room5_val_AddSchedule.setEnabled(false);
		} else {
			tutSlot_id_AddSchedule.setEnabled(true);
			tutSlot_val_AddSchedule.setEnabled(true);
			roomTutorial_id_AddSchedule.setEnabled(true);
			room5_val_AddSchedule.setEnabled(true);
		}
		if (!isIsLabCheck()) {
			labSlot_id_AddSchedule.setEnabled(false);
			labSlot_val_AddSchedule.setEnabled(false);
			roomLab_id_AddSchedule.setEnabled(false);
			room6_val_AddSchedule.setEnabled(false);
		} else {
			labSlot_id_AddSchedule.setEnabled(true);
			labSlot_val_AddSchedule.setEnabled(true);
			roomLab_id_AddSchedule.setEnabled(true);
			room6_val_AddSchedule.setEnabled(true);
		}

		this.getContentPane().add(room6_val_AddSchedule, null);
		this.getContentPane().add(room5_val_AddSchedule, null);
		this.getContentPane().add(room4_val_AddSchedule, null);
		this.getContentPane().add(room3_val_AddSchedule, null);
		this.getContentPane().add(room2_val_AddSchedule, null);
		this.getContentPane().add(room1_val_AddSchedule, null);
		this.getContentPane().add(roomLab_id_AddSchedule, null);
		this.getContentPane().add(roomTutorial_id_AddSchedule, null);
		this.getContentPane().add(room4_id_AddSchedule, null);
		this.getContentPane().add(room3_id_AddSchedule, null);
		this.getContentPane().add(room2_id_AddSchedule, null);
		this.getContentPane().add(room1_id_AddSchedule, null);
		this.getContentPane().add(submitButton_AddSchedule, null);
		this.getContentPane().add(labSlot_val_AddSchedule, null);
		this.getContentPane().add(labSlot_id_AddSchedule, null);
		this.getContentPane().add(removeSlot4Button_AddSchedule, null);
		this.getContentPane().add(removeSlot3Button_AddSchedule, null);
		this.getContentPane().add(removeSlot2Button_AddSchedule, null);
		this.getContentPane().add(addSlot4Button_AddSchedule, null);
		this.getContentPane().add(addSlot3Button_AddSchedule, null);
		this.getContentPane().add(addSlot2Button_AddSchedule, null);
		this.getContentPane().add(tutSlot_val_AddSchedule, null);
		this.getContentPane().add(lectSlot4_val_AddSchedule, null);
		this.getContentPane().add(lectSlot3_val_AddSchedule, null);
		this.getContentPane().add(lectSlot2_val_AddSchedule, null);
		this.getContentPane().add(lectSlot1_val_AddSchedule, null);
		this.getContentPane().add(tutSlot_id_AddSchedule, null);
		this.getContentPane().add(lectSlot4_id_AddSchedule, null);
		this.getContentPane().add(lectSlot3_id_AddSchedule, null);
		this.getContentPane().add(lectSlot2_id_AddSchedule, null);
		this.getContentPane().add(lectSlot1_id_AddSchedule, null);
	}

	private void addSlot2Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot2_id_AddSchedule.setEnabled(true);
		lectSlot2_val_AddSchedule.setEnabled(true);
		room2_id_AddSchedule.setEnabled(true);
		room2_val_AddSchedule.setEnabled(true);
		addSlot3Button_AddSchedule.setEnabled(true);
		removeSlot3Button_AddSchedule.setEnabled(true);
	}

	private void removeSlot2Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot2_id_AddSchedule.setEnabled(false);
		lectSlot2_val_AddSchedule.setSelectedIndex(-1);
		lectSlot2_val_AddSchedule.setEnabled(false);
		room2_id_AddSchedule.setEnabled(false);
		room2_val_AddSchedule.setSelectedIndex(-1);
		room2_val_AddSchedule.setEnabled(false);
		addSlot3Button_AddSchedule.setEnabled(false);
		removeSlot3Button_AddSchedule.setEnabled(false);
	}

	private void addSlot3Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot3_id_AddSchedule.setEnabled(true);
		lectSlot3_val_AddSchedule.setEnabled(true);
		room3_id_AddSchedule.setEnabled(true);
		room3_val_AddSchedule.setEnabled(true);
		addSlot4Button_AddSchedule.setEnabled(true);
		removeSlot4Button_AddSchedule.setEnabled(true);
	}

	private void removeSlot3Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot3_id_AddSchedule.setEnabled(false);
		lectSlot3_val_AddSchedule.setSelectedIndex(-1);
		lectSlot3_val_AddSchedule.setEnabled(false);
		room3_id_AddSchedule.setEnabled(false);
		room3_val_AddSchedule.setSelectedIndex(-1);
		room3_val_AddSchedule.setEnabled(false);
		addSlot4Button_AddSchedule.setEnabled(false);
		removeSlot4Button_AddSchedule.setEnabled(false);
	}

	private void addSlot4Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot4_id_AddSchedule.setEnabled(true);
		lectSlot4_val_AddSchedule.setEnabled(true);
		room4_id_AddSchedule.setEnabled(true);
		room4_val_AddSchedule.setEnabled(true);
	}

	private void removeSlot4Button_AddSchedule_actionPerformed(ActionEvent e) {
		lectSlot4_id_AddSchedule.setEnabled(false);
		lectSlot4_val_AddSchedule.setSelectedIndex(-1);
		lectSlot4_val_AddSchedule.setEnabled(false);
		room4_id_AddSchedule.setEnabled(false);
		room4_val_AddSchedule.setSelectedIndex(-1);
		room4_val_AddSchedule.setEnabled(false);
	}

	private void submitButton_AddSchedule(ActionEvent e) {

		Vector<Integer> slotsInt = new Vector<Integer>();
		int lectSlot1 = Integer.parseInt(lectSlot1_val_AddSchedule.getSelectedItem().toString().substring(13, 15));
		int lectSlot2 = -1, lectSlot3 = -1, lectSlot4 = -1, totSlot = -1, labSlot = -1;
		if (lectSlot2_val_AddSchedule.getSelectedIndex() != -1)
			lectSlot2 = Integer.parseInt(lectSlot2_val_AddSchedule.getSelectedItem().toString().substring(13, 15));
		if (lectSlot3_val_AddSchedule.getSelectedIndex() != -1)
			lectSlot3 = Integer.parseInt(lectSlot3_val_AddSchedule.getSelectedItem().toString().substring(13, 15));
		if (lectSlot4_val_AddSchedule.getSelectedIndex() != -1)
			lectSlot4 = Integer.parseInt(lectSlot4_val_AddSchedule.getSelectedItem().toString().substring(13, 15));
		if (tutSlot_val_AddSchedule.getSelectedIndex() != -1)
			totSlot = Integer.parseInt(tutSlot_val_AddSchedule.getSelectedItem().toString().substring(13, 15));
		if (labSlot_val_AddSchedule.getSelectedIndex() != -1)
			labSlot = Integer.parseInt(labSlot_val_AddSchedule.getSelectedItem().toString().substring(13, 15));

		slotsInt.add(lectSlot1);
		slotsInt.add(lectSlot2);
		slotsInt.add(lectSlot3);
		slotsInt.add(lectSlot4);
		slotsInt.add(totSlot);
		slotsInt.add(labSlot);

		Vector<Integer> roomsInt = new Vector<Integer>();
		int room2 = -1, room3 = -1, room4 = -1, tutRoom = -1, labRoom = -1;
		int room1 = Integer.parseInt(room1_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		if (room2_val_AddSchedule.getSelectedIndex() != -1)
			room2 = Integer.parseInt(room2_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		if (room3_val_AddSchedule.getSelectedIndex() != -1)
			room3 = Integer.parseInt(room3_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		if (room4_val_AddSchedule.getSelectedIndex() != -1)
			room4 = Integer.parseInt(room4_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		if (room5_val_AddSchedule.getSelectedIndex() != -1)
			tutRoom = Integer.parseInt(room5_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		if (room6_val_AddSchedule.getSelectedIndex() != -1)
			labRoom = Integer.parseInt(room6_val_AddSchedule.getSelectedItem().toString().substring(0, 4));
		roomsInt.add(room1);
		roomsInt.add(room2);
		roomsInt.add(room3);
		roomsInt.add(room4);
		roomsInt.add(tutRoom);
		roomsInt.add(labRoom);

		ScheduleController scheduleController = new ScheduleController(slotsInt, roomsInt);
		String output = scheduleController.addSchedule(getScheduleNumber());
		int refresh = JOptionPane.showOptionDialog(this, output, "Message", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (refresh == 0)
			dispose();

	}

	public ArrayList<String> populateRoomNumberComboBox() {
		ClassRoomController roomLOV = new ClassRoomController();
		return roomLOV.getRoomNumberList();
	}

	public ArrayList populateSlotNumberComboBox() {
		SlotController slotLOV = new SlotController();
		return slotLOV.getSlotList();
	}
}
