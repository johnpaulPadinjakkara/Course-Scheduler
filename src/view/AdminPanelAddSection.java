package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.SectionsController;
import controller.SetOfStudentsController;
import model.Section;
import model.SetOfStudents;

public class AdminPanelAddSection extends JPanel implements ListSelectionListener {
	private JButton addSectionButton_AddSection = new JButton();
	private JFormattedTextField sectionName_val_AddSection = new JFormattedTextField();
	private JScrollPane sosListscroll_AddSection;
	private JList sosList_val_AddSection = new JList();
	private JLabel sectionName_id_AddSection = new JLabel();
	private JLabel sosList_id_AddSection = new JLabel();
	private JButton submitButton_AddSection = new JButton();

	private int halfPosWdth;
	private int qrtrPosHgt;
	private String sosListSelection;

	public AdminPanelAddSection() {
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
		addSectionButton_AddSection.setText("Click Here to Add a Section");
		addSectionButton_AddSection.setBounds(new Rectangle(halfPosWdth - 200, 80, 400, 25));
		sectionName_val_AddSection.setBounds(new Rectangle(halfPosWdth, 150, 250, 25));
		sosList_val_AddSection.setBounds(new Rectangle(halfPosWdth, 180, 250, 200));
		sosList_val_AddSection.setListData(populateSOSList().toArray());
		sectionName_id_AddSection.setText("Section Name");
		sectionName_id_AddSection.setBounds(new Rectangle(halfPosWdth - 150, 150, 100, 20));
		sosList_id_AddSection.setText("Contains");
		sosList_id_AddSection.setBounds(new Rectangle(halfPosWdth - 150, 180, 100, 20));
		submitButton_AddSection.setText("Submit");
		submitButton_AddSection.setBounds(new Rectangle(halfPosWdth - 50, 400, 100, 25));
		sosListscroll_AddSection = new JScrollPane(sosList_val_AddSection);
		sosListscroll_AddSection.setBounds(new Rectangle(halfPosWdth, 180, 250, 200));

		sosList_val_AddSection.addListSelectionListener(this);
		sosList_val_AddSection.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		submitButton_AddSection.setVisible(false);
		submitButton_AddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSectionConstCall(e);
			}
		});
		sosList_id_AddSection.setVisible(false);
		sectionName_id_AddSection.setVisible(false);
		sosListscroll_AddSection.setVisible(false);
		sectionName_val_AddSection.setVisible(false);
		addSectionButton_AddSection.setVisible(true);

		addSectionButton_AddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSectionInit(e);
			}
		});

		this.add(submitButton_AddSection, null);
		this.add(sosList_id_AddSection, null);
		this.add(sectionName_id_AddSection, null);
		this.add(sosListscroll_AddSection, null);
		this.add(sectionName_val_AddSection, null);
		this.add(addSectionButton_AddSection, null);

	}

	private void addSectionInit(ActionEvent e) {

		addSectionButton_AddSection.setVisible(false);
		submitButton_AddSection.setVisible(true);
		sosList_id_AddSection.setVisible(true);
		sectionName_id_AddSection.setVisible(true);
		sosListscroll_AddSection.setVisible(true);
		sectionName_val_AddSection.setVisible(true);
	}

	private void addSectionConstCall(ActionEvent e) {
		SectionsController sect = new SectionsController();
		JOptionPane.showMessageDialog(this, sect.addSection(sectionName_val_AddSection.getText(), sosListSelection));
	}

	public void valueChanged(ListSelectionEvent e) {
		String tempVar = "";
		Object obj[] = sosList_val_AddSection.getSelectedValues();
		for (int i = 0; i < obj.length; i++) {
			tempVar += ((String) obj[i] + "~");
		}
		this.sosListSelection = tempVar;
	}

	public ArrayList<String> populateSOSList() {
		SetOfStudentsController sosLOV = new SetOfStudentsController();
		return sosLOV.getSOSList();
	}
}
