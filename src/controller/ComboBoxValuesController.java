/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.ComboBoxValues;

public class ComboBoxValuesController {

	ComboBoxValues comboBoxValues;

	/**
	 * 
	 */
	public ComboBoxValuesController(ComboBoxValues comboBoxValues) {
		this.comboBoxValues = comboBoxValues;

	}

	public ArrayList<String> getValueList(String className, String fieldName) {

		return this.comboBoxValues.getValueList(className, fieldName);
	}

}
