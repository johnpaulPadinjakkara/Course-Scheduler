/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import model.Course;
import model.Instructor;
import model.Section;

public class CourseController {

	public CourseController() {
	}

	public Course getCourse(int courseNumber) {
		Course c = new Course(courseNumber);
		return c.getCourseObject();
	}

	public String addCourse(String courseName, int courseNumber, String level, boolean isTutorial, boolean isLab,
			String durationInWeeks, String department) {
		Course course = new Course(courseName, courseNumber, level, isTutorial, isLab, durationInWeeks, department);
		return course.addCourse();
	}

	public String updateCourse(int courseNumber, String lectinstructor, String tutInstructor, String labInstructor,
			String sectionsValue) {
		Course c = new Course(courseNumber);
		Course course = c.getCourseObject();
		Section updateCourse_section = new Section(sectionsValue);
		Instructor instructor_lect = new Instructor(lectinstructor);
		Instructor instructor_tut = null;
		if (tutInstructor != "")
			instructor_tut = new Instructor(tutInstructor);

		Instructor instructor_lab = null;
		if (labInstructor != "")
			instructor_lab = new Instructor(labInstructor);

		course.setSection(updateCourse_section);
		course.setInstructor_lec(instructor_lect);
		if (instructor_tut != null) {
			course.setInstructor_tut(instructor_tut);
		}
		if (instructor_lab != null) {
			course.setInstructor_lab(instructor_lab);
		}
		return course.updateCourse();
	}

	public String deleteCourse(int courseNumber)

	{
		Course course = new Course(courseNumber);
		return course.getCourseObject().deleteCourse();
	}

	public static TableModel viewCourseInfo() {
		return Course.viewCourseInfo();
	}

	public ArrayList<String> getCourseNameList() {
		return Course.getCourseNameList();
	}

	public boolean isIsTutorial(int courseNumber) {
		Course course = new Course(courseNumber);
		return course.getCourseObject().isIsTutorial();
	}

	public boolean isIsLab(int courseNumber) {
		Course course = new Course(courseNumber);
		return course.getCourseObject().isIsLab();
	}

}
