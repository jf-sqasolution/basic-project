/**
 * File Name: AppBasics.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor<br>
 * Created: Jan 14, 2017
 */
package com.sqa.jf.helpers;

import java.util.*;

import com.sqa.jf.helpers.exceptions.*;

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

	public static int requestIntFromUser(String question) {
		return requestIntFromUser(question, 0, 0);
	}

	public static int requestIntFromUser(String question, int min, int max) {
		String input;
		int result = 0;
		boolean isNotValid = true;
		while (isNotValid) {
			try {
				System.out.print(question + " ");
				input = scanner.nextLine();
				result = Integer.parseInt(input);
				if (min != 0 && max != 0) {
					if (result <= max && result >= min) {
						isNotValid = false;
					} else {
						throw new NumberNotInRangeException();
					}
				}
				isNotValid = false;
			} catch (NumberFormatException e) {
				System.out.println("You have not entered a correct number value.");
			} catch (NumberNotInRangeException e) {
				System.out.println("You have not entered a number within the range of " + min + " and " + max + ".");
			}
		}
		return result;
	}
}
