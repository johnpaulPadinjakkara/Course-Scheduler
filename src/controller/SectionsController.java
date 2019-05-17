/**
 * 
 */
package controller;

import java.util.ArrayList;

import javax.swing.table.TableModel;

import model.Section;

public class SectionsController {
	public SectionsController() {

	}

	public String addSection(String sectionName, String sosSection) {
		Section sections = new Section(sectionName, sosSection);
		return sections.addSection();
	}

	public ArrayList<String> getSectionsList() {
		return Section.getSectionsList();
	}

	public static TableModel viewSectionsInfo() {
		return Section.viewSectionsInfo();
	}

}
