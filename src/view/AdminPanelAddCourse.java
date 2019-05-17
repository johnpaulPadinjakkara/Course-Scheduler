package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ComboBoxValuesController;
import controller.CourseController;

import model.ComboBoxValues;

public class AdminPanelAddCourse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addCourseButton_AddCourse = new JButton();
	private JLabel courseName_id_AddCourse = new JLabel();
	private JLabel courseNumber_id_AddCourse = new JLabel();
	private JLabel level_id_AddCourse = new JLabel();
	private JLabel isTutorial_id_AddCourse = new JLabel();
	private JLabel isLab_id_AddCourse = new JLabel();
	private JLabel duration_id_AddCourse = new JLabel();
	private JLabel department_id_AddCourse = new JLabel();
	private JFormattedTextField courseName_val_AddCourse = new JFormattedTextField();
	private JFormattedTextField courseNumber_val_AddCourse = new JFormattedTextField();
	private JComboBox<String> level_val_AddCourse = new JComboBox<String>();
	private JComboBox duration_val_AddCourse = new JComboBox();
	private JCheckBox isTutorial_val_AddCourse = new JCheckBox();
	private JCheckBox isLab_val_AddCourse = new JCheckBox();
	private JButton submitButton_AddCourse = new JButton();
	private JComboBox department_val_AddCourse = new JComboBox();

	private int halfPosWdth;
	private int qrtrPosHgt;

	public AdminPanelAddCourse() {
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
		addCourseButton_AddCourse.setText("Add Course");
		addCourseButton_AddCourse.setBounds(new Rectangle(halfPosWdth - 50, 80, 150, 25));
		addCourseButton_AddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseInit(e);
			}

		});
		courseName_id_AddCourse.setText("Course Name");
		courseName_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 150, 100, 20));
		courseNumber_id_AddCourse.setText("Course Number");
		courseNumber_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 180, 100, 20));
		level_id_AddCourse.setText("Level");
		level_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 210, 100, 20));
		isTutorial_id_AddCourse.setText("Tutorial");
		isTutorial_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 240, 100, 20));
		isLab_id_AddCourse.setText("Laboratory");
		isLab_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 270, 100, 20));
		duration_id_AddCourse.setText("Duration");
		duration_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 300, 100, 20));
		department_id_AddCourse.setText("Faculty");
		department_id_AddCourse.setBounds(new Rectangle(halfPosWdth - 150, 330, 100, 20));
		courseName_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 148, 200, 25));
		courseNumber_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 178, 200, 25));
		level_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 208, 200, 25));
		level_val_AddCourse.setModel(new DefaultComboBoxModel(populateLevelComboBox().toArray()));
		level_val_AddCourse.setSelectedIndex(-1);
		duration_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 298, 200, 25));
		duration_val_AddCourse.setModel(new DefaultComboBoxModel(populateDurationComboBox().toArray()));
		duration_val_AddCourse.setSelectedIndex(-1);
		isTutorial_val_AddCourse.setText("Available");
		isTutorial_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 238, 200, 25));
		isLab_val_AddCourse.setText("Available");
		isLab_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 268, 200, 25));
		department_val_AddCourse.setBounds(new Rectangle(halfPosWdth, 328, 200, 25));
		department_val_AddCourse.setModel(new DefaultComboBoxModel(populateDepartmentComboBox().toArray()));
		submitButton_AddCourse.setText("Submit");
		submitButton_AddCourse.setBounds(new Rectangle(halfPosWdth - 50, 400, 100, 25));

		courseName_id_AddCourse.setVisible(false);
		courseNumber_id_AddCourse.setVisible(false);
		level_id_AddCourse.setVisible(false);
		isTutorial_id_AddCourse.setVisible(false);
		isLab_id_AddCourse.setVisible(false);
		duration_id_AddCourse.setVisible(false);
		department_id_AddCourse.setVisible(false);
		courseName_val_AddCourse.setVisible(false);
		courseNumber_val_AddCourse.setVisible(false);
		level_val_AddCourse.setVisible(false);
		duration_val_AddCourse.setVisible(false);
		isTutorial_val_AddCourse.setVisible(false);
		isLab_val_AddCourse.setVisible(false);
		department_val_AddCourse.setVisible(false);
		submitButton_AddCourse.setVisible(false);
		submitButton_AddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseConstCall(e);
			}
		});

		this.add(department_val_AddCourse, null);
		this.add(department_id_AddCourse, null);
		this.add(submitButton_AddCourse, null);
		this.add(isLab_val_AddCourse, null);
		this.add(isTutorial_val_AddCourse, null);
		this.add(duration_val_AddCourse, null);
		this.add(level_val_AddCourse, null);
		this.add(courseNumber_val_AddCourse, null);
		this.add(courseName_val_AddCourse, null);
		this.add(duration_id_AddCourse, null);
		this.add(isLab_id_AddCourse, null);
		this.add(isTutorial_id_AddCourse, null);
		this.add(level_id_AddCourse, null);
		this.add(courseNumber_id_AddCourse, null);
		this.add(addCourseButton_AddCourse, null);
		this.add(courseName_id_AddCourse, null);
	}

	private void addCourseConstCall(ActionEvent e) {

		String output = "";
		CourseController courseController = new CourseController();
		output = courseController.addCourse(courseName_val_AddCourse.getText(),
				Integer.parseInt(courseNumber_val_AddCourse.getText()),
				level_val_AddCourse.getSelectedItem().toString(), isTutorial_val_AddCourse.isSelected(),
				isLab_val_AddCourse.isSelected(), duration_val_AddCourse.getSelectedItem().toString(),
				department_val_AddCourse.getSelectedItem().toString());
		int refresh = JOptionPane.showOptionDialog(this, output, "Add Course", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (refresh == 0) {
			refresh();
		}
	}

	private void addCourseInit(ActionEvent e) {
		addCourseButton_AddCourse.setVisible(false);
		courseName_id_AddCourse.setVisible(true);
		courseNumber_id_AddCourse.setVisible(true);
		level_id_AddCourse.setVisible(true);
		isTutorial_id_AddCourse.setVisible(true);
		isLab_id_AddCourse.setVisible(true);
		duration_id_AddCourse.setVisible(true);
		department_id_AddCourse.setVisible(true);
		courseName_val_AddCourse.setVisible(true);
		courseNumber_val_AddCourse.setVisible(true);
		level_val_AddCourse.setVisible(true);
		duration_val_AddCourse.setVisible(true);
		isTutorial_val_AddCourse.setVisible(true);
		isLab_val_AddCourse.setVisible(true);
		department_val_AddCourse.setVisible(true);
		submitButton_AddCourse.setVisible(true);
	}

	public void refresh() {
		courseName_val_AddCourse.setText("");
		courseNumber_val_AddCourse.setText("");
		level_val_AddCourse.setSelectedIndex(-1);
		isTutorial_val_AddCourse.setSelected(false);
		isLab_val_AddCourse.setSelected(false);
		duration_val_AddCourse.setSelectedIndex(-1);
		department_val_AddCourse.setSelectedIndex(-1);

		courseName_id_AddCourse.setVisible(false);
		courseNumber_id_AddCourse.setVisible(false);
		level_id_AddCourse.setVisible(false);
		isTutorial_id_AddCourse.setVisible(false);
		isLab_id_AddCourse.setVisible(false);
		duration_id_AddCourse.setVisible(false);
		department_id_AddCourse.setVisible(false);
		courseName_val_AddCourse.setVisible(false);
		courseNumber_val_AddCourse.setVisible(false);
		level_val_AddCourse.setVisible(false);
		duration_val_AddCourse.setVisible(false);
		isTutorial_val_AddCourse.setVisible(false);
		isLab_val_AddCourse.setVisible(false);
		department_val_AddCourse.setVisible(false);
		submitButton_AddCourse.setVisible(false);

		addCourseButton_AddCourse.setVisible(true);
	}

	public ArrayList<String> populateLevelComboBox() {
		ComboBoxValuesController levelLOV = new ComboBoxValuesController(new ComboBoxValues());
		return levelLOV.getValueList(this.getClass().getSimpleName(), "level_val_AddCourse");
	}

	public ArrayList<String> populateDurationComboBox() {
		ComboBoxValuesController durationLOV = new ComboBoxValuesController(new ComboBoxValues());
		return durationLOV.getValueList(this.getClass().getSimpleName(), "duration_val_AddCourse");
	}

	public ArrayList<String> populateDepartmentComboBox() {
		ComboBoxValuesController departmentLOV = new ComboBoxValuesController(new ComboBoxValues());
		return departmentLOV.getValueList(this.getClass().getSimpleName(), "department_val_AddCourse");
	}

}
