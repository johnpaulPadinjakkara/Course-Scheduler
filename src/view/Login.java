package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import controller.UserInfoController;
import database.DBConnect;
import model.UserInfo;

public class Login extends JFrame {
	private BorderLayout layoutMain = new BorderLayout();
	private JPanel panelCenter = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu();
	private JMenuItem menuFileExit = new JMenuItem();
	private JMenu menuHelp = new JMenu();
	private JMenuItem menuHelpAbout = new JMenuItem();
	private JLabel statusBar = new JLabel();
	private ImageIcon imageOpen = new ImageIcon(Login.class.getResource("openfile.gif"));
	private ImageIcon imageClose = new ImageIcon(Login.class.getResource("closefile.gif"));
	private ImageIcon imageHelp = new ImageIcon(Login.class.getResource("help.gif"));
	private JLabel usernameLogin_id = new JLabel();
	private JLabel passwordLogin_id = new JLabel();
	private JFormattedTextField usernameLogin_val = new JFormattedTextField();
	private JPasswordField passwordLogin_val = new JPasswordField();
	private JButton loginButtonLogin = new JButton();
	private BorderLayout borderLayout1 = new BorderLayout();
	private JPopupMenu jPopupMenu1 = new JPopupMenu();
	public Login() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setJMenuBar(menuBar);
		this.getContentPane().setLayout(borderLayout1);
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
		usernameLogin_id.setText("Username");
		usernameLogin_id.setBounds(new Rectangle(screenSize.width / 2 - 100, screenSize.height / 4, 75, 20));
		usernameLogin_id.setFont(new Font("Tahoma", 0, 12));
		passwordLogin_id.setText("Password");
		passwordLogin_id.setBounds(new Rectangle(screenSize.width / 2 - 100, screenSize.height / 4 + 30, 75, 20));
		passwordLogin_id.setFont(new Font("Tahoma", 0, 12));
		usernameLogin_val.setBounds(new Rectangle(screenSize.width / 2, screenSize.height / 4, 150, 22));
		passwordLogin_val.setBounds(new Rectangle(screenSize.width / 2, screenSize.height / 4 + 30, 150, 22));
		loginButtonLogin.setText("Login");
		loginButtonLogin.setBounds(new Rectangle(screenSize.width / 2 - 100, screenSize.height / 4 + 75, 90, 21));
		loginButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAction(e);
			}
		});
		jPopupMenu1.setLabel("Login");
		jPopupMenu1.setDefaultLightWeightPopupEnabled(true);
		jPopupMenu1.setVisible(false);
		menuFile.add(menuFileExit);
		menuBar.add(menuFile);
		menuHelp.add(menuHelpAbout);
		menuBar.add(menuHelp);
		this.getContentPane().add(statusBar, BorderLayout.NORTH);
		panelCenter.add(loginButtonLogin, null);
		panelCenter.add(passwordLogin_val, null);
		panelCenter.add(usernameLogin_val, null);
		panelCenter.add(passwordLogin_id, null);
		panelCenter.add(usernameLogin_id, null);
		this.getContentPane().add(panelCenter, BorderLayout.CENTER);
	}

	void fileExit_ActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	void helpAbout_ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, new Login_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
	}

	private void loginAction(ActionEvent e) {
		UserInfoController userInfo = new UserInfoController();
		String credentials = userInfo.login(usernameLogin_val.getText(), passwordLogin_val.getText());
		JOptionPane.showMessageDialog(this, credentials);
		if (credentials.equalsIgnoreCase("Login Successful")) {
                        final Home home = new Home(userInfo.getUsrtyp(usernameLogin_val.getText()));
                        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        home.setUserAccess(userInfo.getUsrtyp(usernameLogin_val.getText()));
                        home.setVisible(true);
			this.setVisible(false);
			
		}
	}
}
