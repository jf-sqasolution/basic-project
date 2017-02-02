/**
 * File Name: DataHelper.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor<br>
 * Created: Jan 30, 2017
 */
package com.sqa.jf.helpers;

/**
 * DataHelper //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class DataHelper {

	// Static Method
	public static String displayData(Object[][] data) {
		StringBuilder sb = new StringBuilder();
		// TODO Create two loops, one within another to add all items to sb.
		// sb.append(data[i][0]);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private String dataString;

	// Constructor
	public DataHelper(Object[][] data) {
		this.dataString = displayData(data);
	}

	// Instance Method (Will need a constructor that takes the Object[][])
	public String displayData() {
		return this.dataString;
	}
}
