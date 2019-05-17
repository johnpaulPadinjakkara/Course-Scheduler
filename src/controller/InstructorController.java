/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.Instructor;

public class InstructorController {
	// Instructor instructor;

	/**
	 * 
	 */
	public InstructorController() {
	}

	public ArrayList<String> getInstructorsList() {

		return Instructor.getInstructorsList();
	}

	public String register(String firstName, String lastName, String email, String usrnm, String psswrd,
			String department) {

		Instructor instructor = new Instructor(firstName, lastName, email, usrnm, psswrd, department);
		return instructor.register();
	}
}
