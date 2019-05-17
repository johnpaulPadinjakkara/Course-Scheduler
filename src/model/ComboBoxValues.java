package model;

import database.OpenConnection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

public class ComboBoxValues {

	public ArrayList<String> valueList = new ArrayList<String>();

	public ArrayList<String> getValueList(String className, String fieldName) {
		String query = "select field_value from comboboxtbl where class_name = '" + className + "' and field_name = '"
				+ fieldName + "' order by field_value asc";
		ResultSet rs = null;
		try {
			rs = OpenConnection.db.query(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				this.valueList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.valueList;
	}
}
