package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ClassRoomController;
import model.ClassRoom;

public class AdminPanelAddRoom extends JPanel {
	private JButton addRoomButton_AddRoom = new JButton();
	private JLabel roomNumber_id_AddRoom = new JLabel();
	private JLabel capacity_id_AddRoom = new JLabel();
	private JFormattedTextField roomNumber_val_AddRoom = new JFormattedTextField();
	private JFormattedTextField capacity_val_AddRoom = new JFormattedTextField();
	private JButton submitButton_AddRoom = new JButton();

	private int halfPosWdth;
	private int qrtrPosHgt;

	public AdminPanelAddRoom() {
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
		addRoomButton_AddRoom.setText("Add Room");
		addRoomButton_AddRoom.setBounds(new Rectangle(halfPosWdth - 50, 80, 150, 25));
		roomNumber_id_AddRoom.setText("Room Number");
		roomNumber_id_AddRoom.setBounds(new Rectangle(halfPosWdth - 150, 150, 100, 20));
		capacity_id_AddRoom.setText("Capacity");
		capacity_id_AddRoom.setBounds(new Rectangle(halfPosWdth - 150, 180, 100, 20));
		roomNumber_val_AddRoom.setBounds(new Rectangle(halfPosWdth, 148, 100, 25));
		capacity_val_AddRoom.setBounds(new Rectangle(halfPosWdth, 178, 100, 25));
		submitButton_AddRoom.setText("Submit");
		submitButton_AddRoom.setBounds(new Rectangle(halfPosWdth - 50, 260, 150, 25));

		addRoomButton_AddRoom.setVisible(true);
		addRoomButton_AddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRoomInit(e);
			}
		});
		roomNumber_id_AddRoom.setVisible(false);
		capacity_id_AddRoom.setVisible(false);
		roomNumber_val_AddRoom.setVisible(false);
		capacity_val_AddRoom.setVisible(false);
		submitButton_AddRoom.setVisible(false);

		submitButton_AddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRoomConstCall(e);
			}
		});
		this.add(submitButton_AddRoom, null);
		this.add(capacity_val_AddRoom, null);
		this.add(roomNumber_val_AddRoom, null);
		this.add(capacity_id_AddRoom, null);
		this.add(roomNumber_id_AddRoom, null);
		this.add(addRoomButton_AddRoom, null);
	}

	private void addRoomInit(ActionEvent e) {
		addRoomButton_AddRoom.setVisible(false);
		roomNumber_id_AddRoom.setVisible(true);
		capacity_id_AddRoom.setVisible(true);
		roomNumber_val_AddRoom.setVisible(true);
		capacity_val_AddRoom.setVisible(true);
		submitButton_AddRoom.setVisible(true);
	}

	private void addRoomConstCall(ActionEvent e) {
		ClassRoomController room = new ClassRoomController();
		JOptionPane.showMessageDialog(this, room.addRoom(Integer.parseInt(roomNumber_val_AddRoom.getText()),
				Integer.parseInt(capacity_val_AddRoom.getText())));
	}
}
