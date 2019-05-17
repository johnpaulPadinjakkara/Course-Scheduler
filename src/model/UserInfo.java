package model;

import database.OpenConnection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserInfo {

	private String firstname;
	private String lastname;
	private String emailid;
	private String username;
	private String password;
	private String department;
	private String usertype;
	private String level;
	private UserInfo userObject;

	public UserInfo() {
		this.userObject = this;
	}

	public UserInfo(String username) {
		setUserobject(this);
		String[] nameSplit = username.split(", ");
		String fn = nameSplit[1];
		String ln = nameSplit[0];
		String query = "SELECT * FROM USRTBL WHERE FIRSTNAME='" + fn + "' and LASTNAME='" + ln + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				getUserobject().setFirstname(rs.getString("FIRSTNAME"));
				getUserobject().setLastname(rs.getString("LASTNAME"));
				getUserobject().setUsername(rs.getString("USERNAME"));
				getUserobject().setPassword(rs.getString("PASSWORD"));
				getUserobject().setEmailid(rs.getString("EMAILID"));
				getUserobject().setDepartment(rs.getString("DEPARTMENT"));
				getUserobject().setLevel(rs.getString("PROGRAMTYPE"));
				getUserobject().setUsertype(rs.getString("USERTYPE"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public UserInfo(String firstnm, String lastnm, String email, String usrnm, String psswrd, String usrtyp,
			String dprtmnt, String prgrmtyp) {
		this.firstname = firstnm;
		this.lastname = lastnm;
		this.emailid = email;
		this.username = usrnm;
		this.password = psswrd;
		this.department = dprtmnt;
		this.level = prgrmtyp;
		this.usertype = usrtyp;
		this.userObject = this;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setUserobject(UserInfo userObject) {
		this.userObject = userObject;
	}

	public UserInfo getUserobject() {
		return userObject;
	}

	public String getUsertypeForAccess(String userName) {
		String query = "SELECT USERTYPE FROM USRTBL WHERE USERNAME='" + userName + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e1) {
			e1.getErrorCode();
		}
		try {
			while (rs.next()) {
				setUsertype(rs.getString("USERTYPE"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return getUsertype();
	}

	public String login(String username, String password) {
		String query = "SELECT PASSWORD FROM USRTBL WHERE USERNAME='" + username + "'";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e1) {
			e1.getErrorCode();
		}
		String password_ = "";
		try {
			while (rs.next()) {
				password_ += rs.getString("PASSWORD");
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		if (password_.equals(""))
			return ("Username does not exist. Please Register to Login,");
		if (password_.equals(password)) {
			return ("Login Successful");
		} else
			return ("Wrong Password. Kindly try again.");
	}

	public String register() {
		String returnValue = null;
		String query = "INSERT INTO USRTBL (FIRSTNAME, LASTNAME, EMAILID, USERNAME, PASSWORD, USERTYPE, DEPARTMENT, PROGRAMTYPE) VALUES ('"
				+ getFirstname() + "','" + getLastname() + "','" + getEmailid() + "','" + getUsername() + "','"
				+ getPassword() + "','" + getUsertype() + "','" + getDepartment() + "','" + getLevel() + "')";
		try {
			OpenConnection.db.update(query);
			returnValue = "Registration Successful.\nThe password for " + getUsername() + " is : " + getPassword();
		} catch (SQLException e1) {
			e1.printStackTrace();
			returnValue = "Registration failed. Error: " + e1.getMessage() + ". Error Code: " + e1.getErrorCode();
		}
		return returnValue;
	}

	public static TableModel viewInstructorInfo() {
		ResultSet rs = null;
		String query = "SELECT FIRSTNAME, LASTNAME, EMAILID, USERNAME, DEPARTMENT FROM USRTBL WHERE USERTYPE='Instructor' ORDER BY LASTNAME";
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e1) {
			e1.getErrorCode();
		}
		Vector<String> columnNames = new Vector<String>();

		columnNames.add("First Name");
		columnNames.add("Last Name");
		columnNames.add("Email ID");
		columnNames.add("Username");
		columnNames.add("Department");

		int columnCount = columnNames.size();
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try {
			while (rs.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, columnNames);
	}

	public static String vectorToString(Vector<UserInfo> v) {
		String returnValue = "";
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) != null)
				returnValue += v.get(i).getUserobject() + "~";
			else
				returnValue += "~";
		}
		return returnValue;
	}
}
