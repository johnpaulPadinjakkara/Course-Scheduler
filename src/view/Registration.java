package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.ImageIcon;
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
import javax.swing.JPasswordField;
import javax.swing.JToolBar;

import controller.UserInfoController;
import model.ComboBoxValues;
import model.UserInfo;

public class Registration extends JFrame {
	private BorderLayout layoutMain = new BorderLayout();
	private JPanel panelCenter = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu();
	private JMenuItem menuFileExit = new JMenuItem();
	private JMenu menuHelp = new JMenu();
	private JMenuItem menuHelpAbout = new JMenuItem();
	private JLabel statusBar = new JLabel();
	private ImageIcon imageOpen = new ImageIcon(Registration.class.getResource("openfile.gif"));
	private ImageIcon imageClose = new ImageIcon(Registration.class.getResource("closefile.gif"));
	private ImageIcon imageHelp = new ImageIcon(Registration.class.getResource("help.gif"));
	private JLabel firstNameReg_id = new JLabel();
	private JLabel lastNameReg_id = new JLabel();
	private JLabel emailReg_id = new JLabel();
	private JLabel usernameReg_id = new JLabel();
	private JLabel passwordReg_id = new JLabel();
	private JLabel departmentReg_id = new JLabel();
	private JLabel levelReg_id = new JLabel();
	private JLabel userTypeReg_id = new JLabel();
	private JFormattedTextField firstNameReg_val = new JFormattedTextField();
	private JFormattedTextField lastNameReg_val = new JFormattedTextField();
	private JFormattedTextField emailReg_val = new JFormattedTextField();
	private JFormattedTextField usernameReg_val = new JFormattedTextField();
	private JPasswordField passwordReg_val = new JPasswordField();
	private JComboBox departmentReg_val = new JComboBox();
	private JComboBox levelReg_val = new JComboBox();
	private JComboBox userTypeReg_val = new JComboBox();
	private JButton submitButtonReg = new JButton();
	private JButton exitButtonReg = new JButton();

	public Registration() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setJMenuBar(menuBar);
		this.getContentPane().setLayout(layoutMain);
		panelCenter.setLayout(null);
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
		firstNameReg_id.setText("First Name");
		firstNameReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 100, 100, 20));
		lastNameReg_id.setText("Last Name");
		lastNameReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 130, 100, 20));
		emailReg_id.setText("Email ID");
		emailReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 160, 100, 20));
		usernameReg_id.setText("Username");
		usernameReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 190, 100, 20));
		passwordReg_id.setText("Password");
		passwordReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 220, 100, 20));
		departmentReg_id.setText("Department");
		departmentReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 250, 100, 20));
		levelReg_id.setText("Level");
		levelReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 280, 100, 20));
		userTypeReg_id.setText("User Type");
		userTypeReg_id.setBounds(new Rectangle((screenSize.width / 2) - 200, 310, 100, 20));
		firstNameReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 98, 200, 25));
		lastNameReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 128, 200, 25));
		emailReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 158, 200, 25));
		usernameReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 188, 200, 25));
		passwordReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 218, 200, 25));
		departmentReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 248, 200, 25));
		departmentReg_val.addItem("Civil");
		departmentReg_val.addItem("Computer");
		departmentReg_val.addItem("Electrical");
		departmentReg_val.addItem("Mechanical");
		departmentReg_val.addItem("Process");
		departmentReg_val.addItem("Oil & Gas");
		departmentReg_val.addItem("Ocean & Naval");
		/*
		 * ComboBoxValues cvals = new ComboBoxValues(); Vector cvect =
		 * cvals.getValueList("usrtbl", "dprtmnt"); for (int i=0;i<cvect.size();i++) {
		 * jComboBox1.addItem(cvect.get(i)); }
		 */
		levelReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 278, 200, 25));
		levelReg_val.addItem("Undergraduate");
		levelReg_val.addItem("Graduate");
		/*
		 * cvect = cvals.getValueList("usrtbl", "prgrmtyp"); for (int
		 * i=0;i<cvect.size();i++) { jComboBox2.addItem(cvect.get(i)); }
		 */
		userTypeReg_val.setBounds(new Rectangle((screenSize.width / 2) - 50, 308, 200, 25));
		userTypeReg_val.addItem("Administrator");
		userTypeReg_val.addItem("Instructor");
		userTypeReg_val.addItem("Student");
		/*
		 * cvect = cvals.getValueList("usrtbl", "usrtyp"); for (int
		 * i=0;i<cvect.size();i++) { jComboBox3.addItem(cvect.get(i)); }
		 */
		submitButtonReg.setText("Submit");
		submitButtonReg.setBounds(new Rectangle((screenSize.width / 2) - 150, 350, 100, 25));
		submitButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register(e);
			}
		});
		exitButtonReg.setText("Exit");
		exitButtonReg.setBounds(new Rectangle((screenSize.width / 2), 350, 100, 25));
		exitButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitRegistration(e);
			}
		});
		menuFile.add(menuFileExit);
		menuBar.add(menuFile);
		menuHelp.add(menuHelpAbout);
		menuBar.add(menuHelp);
		this.getContentPane().add(statusBar, BorderLayout.SOUTH);
		panelCenter.add(exitButtonReg, null);
		panelCenter.add(submitButtonReg, null);
		panelCenter.add(userTypeReg_val, null);
		panelCenter.add(levelReg_val, null);
		panelCenter.add(departmentReg_val, null);
		panelCenter.add(passwordReg_val, null);
		panelCenter.add(usernameReg_val, null);
		panelCenter.add(emailReg_val, null);
		panelCenter.add(lastNameReg_val, null);
		panelCenter.add(firstNameReg_val, null);
		panelCenter.add(userTypeReg_id, null);
		panelCenter.add(levelReg_id, null);
		panelCenter.add(departmentReg_id, null);
		panelCenter.add(passwordReg_id, null);
		panelCenter.add(usernameReg_id, null);
		panelCenter.add(emailReg_id, null);
		panelCenter.add(lastNameReg_id, null);
		panelCenter.add(firstNameReg_id, null);
		this.getContentPane().add(panelCenter, BorderLayout.CENTER);
	}

	void fileExit_ActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	void helpAbout_ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, new Registration_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
	}

	private void register(ActionEvent e) {
		UserInfoController userInfo = new UserInfoController();
		String credentials = userInfo.register();
		JOptionPane.showMessageDialog(this, credentials);
	}

	private void exitRegistration(ActionEvent e) {
		dispose();
	}
}
