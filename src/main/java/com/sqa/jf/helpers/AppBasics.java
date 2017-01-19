/**
 * File Name: AppBasics.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor<br>
 * Created: Jan 14, 2017
 */
package com.sqa.jf.helpers;

import java.util.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static void farewellUser(String userName, String appName) {
		System.out.println("Thank you for using the " + appName + " application.");
		System.out.println("Good Bye " + userName + " and have a great day!");
	}

	public static String greetUserAndGetName(String nameOfApp) {
		System.out.println("Hello, Welcome to the " + nameOfApp + " App.");
		System.out.print("Could I please get your name? ");
		return scanner.nextLine();
	}

	public static String requestInfoFromUser(String question) {
		String response;
		System.out.print(question + " ");
		response = scanner.nextLine();
		return response;
	}
}
