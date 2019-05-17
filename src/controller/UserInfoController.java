package controller;

import javax.swing.table.TableModel;

import model.UserInfo;

public class UserInfoController {
	// UserInfo userInfo;

	public UserInfoController() {
	}

	public String login(String username, String password) {
		UserInfo userInfo = new UserInfo();
		String temp = userInfo.login(username, password);
		return temp;
	}

	public String getUsrtyp(String userName) {
		UserInfo userInfo = new UserInfo();
		return userInfo.getUsertypeForAccess(userName);
	}

	public String register() {
		UserInfo userInfo = new UserInfo();
		return userInfo.register();
	}

	public static TableModel viewInstructorTable() {
		return UserInfo.viewInstructorInfo();
	}
}
