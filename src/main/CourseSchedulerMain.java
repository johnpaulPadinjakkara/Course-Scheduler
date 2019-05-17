package main;



import database.OpenConnection;
import view.Login;

/**
 * @author Suni & Johnpaul 
 *
 */
class CourseSchedulerMain {
	public static void main(String[] args) {
		try {

			new OpenConnection();
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception mainEx) {
			mainEx.printStackTrace();
		}
	}
}
