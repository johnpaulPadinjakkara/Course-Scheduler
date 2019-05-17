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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ClassRoomController;
import controller.CourseController;
import controller.InstructorController;
import controller.SectionsController;
import controller.SlotController;

public class AdminPanelUpdateCourse extends JPanel {
	private JButton deleteCourseButton_UpdateCourse = new JButton();
	private JButton updateCourseButton_UpdateCourse = new JButton();
	private JLabel sos_id_UpdateCourse = new JLabel();
	private JLabel lectInstructor_id_UpdateCourse = new JLabel();
	private JLabel tutInstructor_id_UpdateCourse = new JLabel();
	private JLabel labInstructor_id_UpdateCourse = new JLabel();
	private JComboBox sos_val_UpdateCourse = new JComboBox();
	private JComboBox lectInstructor_val_UpdateCourse = new JComboBox();
	private JComboBox tutInstructor_val_UpdateCourse = new JComboBox();
	private JComboBox labInstructor_val_UpdateCourse = new JComboBox();
	private JButton submitButton_UpdateCourse = new JButton();
	private JComboBox courseNameSelection = new JComboBox();

	private int halfPosWdth;
	private int qrtrPosHgt;

	private JButton scheduleSelectionButton_UpdateCourse = new JButton();

	public AdminPanelUpdateCourse() {
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

		courseNameSelection.setBounds(new Rectangle(halfPosWdth - 200, 100, 400, 21));
		courseNameSelection.setModel(new DefaultComboBoxModel(populateCourseNameComboBox().toArray()));
		courseNameSelection.setSelectedIndex(-1);

		scheduleSelectionButton_UpdateCourse.setText("Click here to add slots for this course");
		scheduleSelectionButton_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 150, 500, 25));
		scheduleSelectionButton_UpdateCourse.setVisible(false);
		scheduleSelectionButton_UpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scheduleSelectionButton_UpdateCourse(e);
			}
		});
		deleteCourseButton_UpdateCourse.setText("Click here to delete the selected course");
		deleteCourseButton_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 150, 400, 25));
		updateCourseButton_UpdateCourse.setText("Click here to update the selected course");
		updateCourseButton_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 200, 400, 25));
		sos_id_UpdateCourse.setText("Set of Students");
		sos_id_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 180, 150, 25));
		lectInstructor_id_UpdateCourse.setText("Lecture Instructor");
		lectInstructor_id_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 210, 150, 25));
		tutInstructor_id_UpdateCourse.setText("Tutorial Instructor");
		tutInstructor_id_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 240, 150, 25));
		labInstructor_id_UpdateCourse.setText("Laboratory Instructor");
		labInstructor_id_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 200, 270, 150, 25));
		sos_val_UpdateCourse.setBounds(new Rectangle(halfPosWdth, 180, 300, 25));
		sos_val_UpdateCourse.setModel(new DefaultComboBoxModel(populateSectionsComboBox().toArray()));
		lectInstructor_val_UpdateCourse.setBounds(new Rectangle(halfPosWdth, 210, 300, 25));
		lectInstructor_val_UpdateCourse.setModel(new DefaultComboBoxModel(populateInstructorComboBox().toArray()));
		tutInstructor_val_UpdateCourse.setBounds(new Rectangle(halfPosWdth, 240, 300, 25));
		tutInstructor_val_UpdateCourse.setModel(new DefaultComboBoxModel(populateInstructorComboBox().toArray()));
		labInstructor_val_UpdateCourse.setBounds(new Rectangle(halfPosWdth, 270, 300, 25));
		labInstructor_val_UpdateCourse.setModel(new DefaultComboBoxModel(populateInstructorComboBox().toArray()));
		submitButton_UpdateCourse.setText("Submit");
		submitButton_UpdateCourse.setBounds(new Rectangle(halfPosWdth - 50, 380, 100, 25));

		updateCourseButton_UpdateCourse.setVisible(true);
		updateCourseButton_UpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCourseInit(e);
			}
		});
		deleteCourseButton_UpdateCourse.setVisible(true);

		deleteCourseButton_UpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCourseInit(e);
			}
		});
		submitButton_UpdateCourse.setVisible(false);
		submitButton_UpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCourseConstructor(e);
			}
		});

		labInstructor_val_UpdateCourse.setVisible(false);
		tutInstructor_val_UpdateCourse.setVisible(false);
		lectInstructor_val_UpdateCourse.setVisible(false);
		sos_val_UpdateCourse.setVisible(false);
		// slotNumber_val_UpdateCourse.setVisible(false);
		labInstructor_id_UpdateCourse.setVisible(false);
		tutInstructor_id_UpdateCourse.setVisible(false);
		lectInstructor_id_UpdateCourse.setVisible(false);
		sos_id_UpdateCourse.setVisible(false);
		// slotNumber_id_UpdateCourse.setVisible(false);

		this.add(scheduleSelectionButton_UpdateCourse, null);
		this.add(courseNameSelection, null);
		this.add(submitButton_UpdateCourse, null);
		this.add(labInstructor_val_UpdateCourse, null);
		this.add(tutInstructor_val_UpdateCourse, null);
		this.add(lectInstructor_val_UpdateCourse, null);
		this.add(sos_val_UpdateCourse, null);
		// this.add(slotNumber_val_UpdateCourse, null);
		this.add(labInstructor_id_UpdateCourse, null);
		this.add(tutInstructor_id_UpdateCourse, null);
		this.add(lectInstructor_id_UpdateCourse, null);
		this.add(sos_id_UpdateCourse, null);
		// this.add(slotNumber_id_UpdateCourse, null);
		this.add(updateCourseButton_UpdateCourse, null);
		this.add(deleteCourseButton_UpdateCourse, null);
	}

	private void deleteCourseInit(ActionEvent e) {
		String courseNumber = courseNameSelection.getSelectedItem().toString().substring(0, 4);
		CourseController course = new CourseController();

		String deleted = course.deleteCourse(Integer.parseInt(courseNumber));
		int refresh = JOptionPane.showOptionDialog(this, deleted, "test", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (refresh == 0) {
			courseNameSelection.setModel(new DefaultComboBoxModel(populateCourseNameComboBox().toArray()));
			courseNameSelection.setModel(new DefaultComboBoxModel(populateCourseNameComboBox().toArray()));
			courseNameSelection.setSelectedIndex(-1);

		}
	}

	private void updateCourseInit(ActionEvent e) {

		String courseNumber = (String) courseNameSelection.getSelectedItem();
		CourseController updC = new CourseController();

		updateCourseButton_UpdateCourse.setVisible(false);
		deleteCourseButton_UpdateCourse.setVisible(false);
		tutInstructor_val_UpdateCourse.setVisible(true);
		tutInstructor_id_UpdateCourse.setVisible(true);
		labInstructor_val_UpdateCourse.setVisible(true);
		labInstructor_id_UpdateCourse.setVisible(true);
		if (!updC.isIsLab(Integer.parseInt(courseNumber.substring(0, 4)))) {
			labInstructor_val_UpdateCourse.setEnabled(false);
			labInstructor_id_UpdateCourse.setEnabled(false);
		} else {
			labInstructor_val_UpdateCourse.setEnabled(true);
			labInstructor_id_UpdateCourse.setEnabled(true);
		}
		if (!updC.isIsTutorial(Integer.parseInt(courseNumber.substring(0, 4)))) {
			tutInstructor_id_UpdateCourse.setEnabled(false);
			tutInstructor_val_UpdateCourse.setEnabled(false);
		} else {
			tutInstructor_val_UpdateCourse.setEnabled(true);
			tutInstructor_id_UpdateCourse.setEnabled(true);

		}
		lectInstructor_val_UpdateCourse.setVisible(true);
		sos_val_UpdateCourse.setVisible(true);
		scheduleSelectionButton_UpdateCourse.setVisible(true);

		lectInstructor_id_UpdateCourse.setVisible(true);
		sos_id_UpdateCourse.setVisible(true);
		submitButton_UpdateCourse.setVisible(true);
		labInstructor_val_UpdateCourse.setSelectedIndex(-1);
		tutInstructor_val_UpdateCourse.setSelectedIndex(-1);
		lectInstructor_val_UpdateCourse.setSelectedIndex(-1);
		sos_val_UpdateCourse.setSelectedIndex(-1);
	}

	private void updateCourseConstructor(ActionEvent e) {
		String updC_str = (String) courseNameSelection.getSelectedItem();
		CourseController courseController = new CourseController();
		String output = "";
		int courseNumber_ = Integer.parseInt(updC_str.substring(0, 4));
		String lectIns_ = lectInstructor_val_UpdateCourse.getSelectedItem().toString();
		String tutIns_, labIns_;
		try {
			tutIns_ = tutInstructor_val_UpdateCourse.getSelectedItem().toString();
		} catch (NullPointerException e1) {
			tutIns_ = "";
		}
		try {
			labIns_ = labInstructor_val_UpdateCourse.getSelectedItem().toString();
		} catch (NullPointerException e1) {
			labIns_ = "";
		}
		String section_ = sos_val_UpdateCourse.getSelectedItem().toString();
		output = courseController.updateCourse(courseNumber_, lectIns_, tutIns_, labIns_, section_);

		int refresh = JOptionPane.showOptionDialog(this, output, "Message", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (refresh == 0) {
			refresh();
		}

	}

	public ArrayList<String> populateCourseNameComboBox() {

		CourseController courseController = new CourseController();
		return courseController.getCourseNameList();
	}

	public ArrayList<String> populateRoomNumberComboBox() {
		ClassRoomController roomLOV = new ClassRoomController();
		return roomLOV.getRoomNumberList();
	}

	public ArrayList<String> populateInstructorComboBox() {
		InstructorController instructorLOV = new InstructorController();
		return instructorLOV.getInstructorsList();
	}

	public ArrayList<String> populateSectionsComboBox() {
		SectionsController sectionsLOV = new SectionsController();
		return sectionsLOV.getSectionsList();
	}

	public ArrayList populateSlotNumberComboBox() {
		SlotController slotLOV = new SlotController();
		return slotLOV.getSlotList();
	}

	private void scheduleSelectionButton_UpdateCourse(ActionEvent e) {
		AdminPanelAddSchedule adminPanelAddSchedule = new AdminPanelAddSchedule();
		CourseController courseAssociated = new CourseController();
		int courseNum = Integer.parseInt(courseNameSelection.getSelectedItem().toString().substring(0, 4));
		adminPanelAddSchedule.setScheduleNumber(courseNum);
		adminPanelAddSchedule.setIsTutCheck(courseAssociated.isIsTutorial(courseNum));
		adminPanelAddSchedule.setIsLabCheck(courseAssociated.isIsLab(courseNum));
		adminPanelAddSchedule.setVisible(true);
		adminPanelAddSchedule.setBounds(10, 10, 825, 350);
		adminPanelAddSchedule.executeJBInit();
	}

	public void refresh() {
		labInstructor_val_UpdateCourse.setVisible(false);
		tutInstructor_val_UpdateCourse.setVisible(false);
		lectInstructor_val_UpdateCourse.setVisible(false);
		sos_val_UpdateCourse.setVisible(false);
		labInstructor_id_UpdateCourse.setVisible(false);
		tutInstructor_id_UpdateCourse.setVisible(false);
		lectInstructor_id_UpdateCourse.setVisible(false);
		sos_id_UpdateCourse.setVisible(false);
		submitButton_UpdateCourse.setVisible(false);
		scheduleSelectionButton_UpdateCourse.setVisible(false);
		updateCourseButton_UpdateCourse.setVisible(true);
		deleteCourseButton_UpdateCourse.setVisible(true);
		courseNameSelection.setModel(new DefaultComboBoxModel(populateCourseNameComboBox().toArray()));
		courseNameSelection.setSelectedIndex(-1);
	}
}
