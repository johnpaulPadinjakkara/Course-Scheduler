package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import database.OpenConnection;

public class Home extends JFrame {
	private BorderLayout layoutMain = new BorderLayout();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu();
	private JMenuItem menuFileExit = new JMenuItem();
	private JMenu menuHelp = new JMenu();
	private JMenuItem menuHelpAbout = new JMenuItem();
	private JLabel statusBar = new JLabel();
	private JTabbedPane tabs = new JTabbedPane();
	private String userAccess;
	private JPanel adminPanelView = new JPanel();
	private JPanel adminSubPanelView = new JPanel();
	private JPanel adminSubPanelView_viewStudents = new JPanel();
	private JPanel instructorPanel = new JPanel();
	private JPanel studentPanelRegister = new JPanel();
	private JPanel studentPanelUpdate = new JPanel();
	private JPanel adminPanelRooms = new JPanel();
	private JPanel adminPanelSlots = new JPanel();
	private JPanel adminSubPanelRooms = new JPanel();
	private JPanel adminSubPanelRooms_viewRooms = new JPanel();
	private JPanel adminSubPanelRooms_addRoom = new JPanel();
	private JLabel timeSlot_id = new JLabel();
	private JLabel roomNumber_id = new JLabel();
	private JLabel instructor_lect_id = new JLabel();
	private JLabel instructor_tut_id = new JLabel();
	private JLabel instructor_lab_id = new JLabel();
	private JComboBox timeSlot_val = new JComboBox();
	private JComboBox instructor_lect_val = new JComboBox();
	private JComboBox instructor_tut_val = new JComboBox();
	private JComboBox instructor_lab_val = new JComboBox();
	private JComboBox roomNumber_val = new JComboBox();
	private JComboBox courseDetails = new JComboBox();
	private JLabel timeSlot_id1 = new JLabel();
	private JLabel timeSlot_id2 = new JLabel();
	private JComboBox timeSlot_val1 = new JComboBox();
	private JComboBox timeSlot_val2 = new JComboBox();
	private JButton submitButtonUpdateCourse = new JButton();
	private int halfPosWdth;
	private int qrtrPosHgt;
	private JButton updateCourseButton = new JButton();
	private JTable studentInfoViewTable;
	private JTable roomsInfoViewTable;
	private JButton adminViewButton = new JButton();
	private JButton viewRoomsButton = new JButton();
	private JButton addRoomsButton = new JButton();
	private BorderLayout borderLayout1 = new BorderLayout();
	private JLabel roomNum_id = new JLabel();
	private JLabel roomCap_id = new JLabel();
	private JFormattedTextField roomNum_val = new JFormattedTextField();
	private JFormattedTextField roomCap_val = new JFormattedTextField();
	private JButton addRoomSubmitButton = new JButton();
	private BorderLayout borderLayout2 = new BorderLayout();

	public Home(String userAccess) {
		try {
			setUserAccess(userAccess);
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getUserAccess() {
		return userAccess;
	}

	private void jbInit() throws Exception {
		this.setJMenuBar(menuBar);
		this.getContentPane().setLayout(layoutMain);
		this.setTitle("Course Scheduler");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		menuFile.setText("File");
		menuFileExit.setText("Exit");
		menuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fileExit_ActionPerformed(ae);
			}
		});
		menuHelp.setText("Help");
		menuHelpAbout.setText("About");
		menuHelpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				helpAbout_ActionPerformed(ae);
			}
		});
		statusBar.setText("");

		this.halfPosWdth = screenSize.width / 2;
		this.qrtrPosHgt = screenSize.height / 4;

		menuFile.add(menuFileExit);
		menuBar.add(menuFile);
		menuHelp.add(menuHelpAbout);
		menuBar.add(menuHelp);
		this.getContentPane().add(statusBar, BorderLayout.SOUTH);

		AdminPanelCourse adminPanelCourse = new AdminPanelCourse();
		AdminPanelInstructor adminPanelInstructor = new AdminPanelInstructor();
		AdminPanelRoom adminPanelRoom = new AdminPanelRoom();
		AdminPanelSection adminPanelSection = new AdminPanelSection();
		AdminPanelSlot adminPanelSlot = new AdminPanelSlot();

		if (userAccess.equalsIgnoreCase("Administrator")) {
			tabs.addTab("Course", adminPanelCourse);
			tabs.addTab("Instructor", adminPanelInstructor);
			tabs.addTab("Room", adminPanelRoom);
			tabs.addTab("Section", adminPanelSection);
			tabs.addTab("Slot", adminPanelSlot);

			tabs.addChangeListener(new ChangeListener() { // add the Listener

				public void stateChanged(ChangeEvent e) {

				}
			});
			//
			// } else if (userAccess.equalsIgnoreCase("student")) {
			// tabs.addTab("Register", studentPanelRegister);
			// } else {
			// tabs.addTab("View Courses", instructorPanel);
		}

		this.getContentPane().add(tabs, BorderLayout.CENTER);

	}

	void fileExit_ActionPerformed(ActionEvent e) {
		try {
			OpenConnection.db.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.exit(0);

	}

	void helpAbout_ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, new Home_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	 * private void updateCourse(ActionEvent e) { Course c = new Course(); ClassRoom
	 * room = new ClassRoom(); Slot timeSlot = new Slot(); String cNum =
	 * (String)courseDetails.getSelectedItem().toString().subSequence(5, 8); Course
	 * course = c.getCourse(Integer.parseInt(cNum));
	 * course.setRoom(room.getRoom((String)roomNumber_val.getSelectedItem()));
	 * course.setTimeSlot(timeSlot.getSlot(((Integer)(timeSlot_val.getSelectedItem()
	 * ))));
	 * course.setInstructor_lec((String)instructor_lect_val.getSelectedItem());
	 * course.setInstructor_tut((String)instructor_tut_val.getSelectedItem());
	 * course.setInstructor_lab((String)instructor_lab_val.getSelectedItem());
	 * String output = course.updateCourse(Integer.parseInt(cNum));
	 * JOptionPane.showMessageDialog(this, output); }
	 */

	private void updateCourseButton(ActionEvent e) {
		updateCourseButton.setVisible(false);
		submitButtonUpdateCourse.setVisible(true);
		timeSlot_val2.setVisible(true);
		timeSlot_val1.setVisible(true);
		timeSlot_id2.setVisible(true);
		timeSlot_id1.setVisible(true);
		courseDetails.setVisible(true);
		roomNumber_val.setVisible(true);
		instructor_lab_val.setVisible(true);
		instructor_tut_val.setVisible(true);
		timeSlot_val.setVisible(true);
		instructor_lect_val.setVisible(true);
		instructor_lab_id.setVisible(true);
		instructor_tut_id.setVisible(true);
		instructor_lect_id.setVisible(true);
		roomNumber_id.setVisible(true);
		timeSlot_id.setVisible(true);
	}

}
