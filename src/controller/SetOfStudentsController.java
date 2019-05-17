package controller;

import java.util.ArrayList;

import model.SetOfStudents;

public class SetOfStudentsController {

	public SetOfStudentsController() {

	}

	public ArrayList<String> getSOSList() {
		return SetOfStudents.getSOSList();
	}
}
