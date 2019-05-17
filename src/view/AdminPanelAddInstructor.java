package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ComboBoxValuesController;
import controller.InstructorController;
import model.ComboBoxValues;
import model.Instructor;

public class AdminPanelAddInstructor extends JPanel {

	private JButton addInstructorButton_AddInstructor = new JButton();
	private JLabel firstName_id_AddInstructor = new JLabel();
	private JLabel lastName_id_AddInstructor = new JLabel();
	private JLabel username_id_AddInstructor = new JLabel();
	private JLabel email_id_AddInstructor = new JLabel();
	private JLabel department_id_AddInstructor = new JLabel();
	private JFormattedTextField firstName_val_AddInstructor = new JFormattedTextField();
	private JFormattedTextField lastName_val_AddInstructor = new JFormattedTextField();
	private JFormattedTextField username_val_AddInstructor = new JFormattedTextField();
	private JFormattedTextField email_val_AddInstructor = new JFormattedTextField();
	private JComboBox department_val_AddInstructor = new JComboBox();
	private JButton submitButton_AddInstructor = new JButton();

	private int halfPosWdth;
	private int qrtrPosHgt;

	public AdminPanelAddInstructor() {
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
		addInstructorButton_AddInstructor.setText("Add Instructor");
		addInstructorButton_AddInstructor.setBounds(new Rectangle(halfPosWdth - 50, 80, 150, 25));
		addInstructorButton_AddInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInstructorInit(e);
			}
		});
		firstName_id_AddInstructor.setText("First Name");
		firstName_id_AddInstructor.setBounds(new Rectangle(halfPosWdth - 150, 150, 100, 20));
		lastName_id_AddInstructor.setText("Last Name");
		lastName_id_AddInstructor.setBounds(new Rectangle(halfPosWdth - 150, 180, 100, 20));
		username_id_AddInstructor.setText("Username");
		username_id_AddInstructor.setBounds(new Rectangle(halfPosWdth - 150, 210, 100, 20));
		email_id_AddInstructor.setText("Email ID");
		email_id_AddInstructor.setBounds(new Rectangle(halfPosWdth - 150, 240, 100, 20));
		department_id_AddInstructor.setText("Department");
		department_id_AddInstructor.setBounds(new Rectangle(halfPosWdth - 150, 270, 100, 20));
		firstName_val_AddInstructor.setBounds(new Rectangle(halfPosWdth, 148, 200, 25));
		lastName_val_AddInstructor.setBounds(new Rectangle(halfPosWdth, 178, 200, 25));
		username_val_AddInstructor.setBounds(new Rectangle(halfPosWdth, 208, 200, 25));
		email_val_AddInstructor.setBounds(new Rectangle(halfPosWdth, 238, 200, 25));
		department_val_AddInstructor.setBounds(new Rectangle(halfPosWdth, 268, 200, 25));
		department_val_AddInstructor.setModel(new DefaultComboBoxModel(populateDepartmentComboBox().toArray()));
		submitButton_AddInstructor.setText("Submit");
		submitButton_AddInstructor.setBounds(new Rectangle(halfPosWdth - 50, 350, 150, 25));
		submitButton_AddInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInstructorConstCall(e);
			}
		});

		addInstructorButton_AddInstructor.setVisible(true);
		firstName_id_AddInstructor.setVisible(false);
		lastName_id_AddInstructor.setVisible(false);
		username_id_AddInstructor.setVisible(false);
		email_id_AddInstructor.setVisible(false);
		department_id_AddInstructor.setVisible(false);
		firstName_val_AddInstructor.setVisible(false);
		lastName_val_AddInstructor.setVisible(false);
		username_val_AddInstructor.setVisible(false);
		email_val_AddInstructor.setVisible(false);
		department_val_AddInstructor.setVisible(false);
		submitButton_AddInstructor.setVisible(false);

		this.add(submitButton_AddInstructor, null);
		this.add(department_val_AddInstructor, null);
		this.add(email_val_AddInstructor, null);
		this.add(username_val_AddInstructor, null);
		this.add(lastName_val_AddInstructor, null);
		this.add(firstName_val_AddInstructor, null);
		this.add(department_id_AddInstructor, null);
		this.add(email_id_AddInstructor, null);
		this.add(username_id_AddInstructor, null);
		this.add(lastName_id_AddInstructor, null);
		this.add(firstName_id_AddInstructor, null);
		this.add(addInstructorButton_AddInstructor, null);
	}

	private void addInstructorInit(ActionEvent e) {
		addInstructorButton_AddInstructor.setVisible(false);
		firstName_id_AddInstructor.setVisible(true);
		lastName_id_AddInstructor.setVisible(true);
		username_id_AddInstructor.setVisible(true);
		email_id_AddInstructor.setVisible(true);
		department_id_AddInstructor.setVisible(true);
		firstName_val_AddInstructor.setVisible(true);
		lastName_val_AddInstructor.setVisible(true);
		username_val_AddInstructor.setVisible(true);
		email_val_AddInstructor.setVisible(true);
		department_val_AddInstructor.setVisible(true);
		submitButton_AddInstructor.setVisible(true);
	}

	private void addInstructorConstCall(ActionEvent e) {
		InstructorController instructorController = new InstructorController();
		JOptionPane.showMessageDialog(this,
				instructorController.register(firstName_val_AddInstructor.getText(),
						lastName_val_AddInstructor.getText(), email_val_AddInstructor.getText(),
						username_val_AddInstructor.getText(), passwordGenerator(),
						(String) department_val_AddInstructor.getSelectedItem()));
	}

	public ArrayList<String> populateDepartmentComboBox() {
		ComboBoxValuesController departmentLOV = new ComboBoxValuesController(new ComboBoxValues());
		return departmentLOV.getValueList(this.getClass().getSimpleName(), "department_val_AddCourse");
	}

	public String passwordGenerator() {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}
}
