/**
 * File Name: AutoBasics.java<br>
 * Nepton, Jean-francois<br>
 * Java Boot Camp Exercise<br>
 * Instructor<br>
 * Created: Feb 4, 2017
 */
package com.sqa.jf.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

/**
 * AutoBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	public static final String DEFAULT_CONFIG_FILE_NAME = "config.properties";

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean addProperty(String key, String value) {
		return addProperty(DEFAULT_CONFIG_FILE_NAME, key, value);
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean addProperty(String fileName, String key, String value) {
		Properties prop = readProps(fileName);
		prop.setProperty(key, value);
		return writeProps(prop, fileName);
	}

	public static int getInt(String key) {
		return getInt(DEFAULT_CONFIG_FILE_NAME, key);
	}

	public static int getInt(String fileName, String key) {
		String input = getProp(fileName, key);
		int result = 0;
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("Issue converting to int value: " + input);
		}
		return result;
	}

	public static String getProp(String key) {
		return getProp(DEFAULT_CONFIG_FILE_NAME, key);
	}

	public static String getProp(String fileName, String key) {
		Properties prop = readProps(fileName);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static Properties readProps(String fileName) {
		// Create the Properties object
		Properties prop = new Properties();
		try {
			// Create an InputStream and set it to a new FileInputStream based
			// on properties file we are reading
			InputStream input = new FileInputStream("src/main/resources/" + fileName);
			// Load the properties object with data from the properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.err.println(
					"File " + fileName + " was not found in src/main/resources.");
			return null;
		} catch (IOException e) {
			System.err.println("File " + fileName + " encounters errors while reading.");
			return null;
		}
		return prop;
	}

	public static boolean takeScreenShot(WebDriver driver, String fileName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean writeProps(Properties prop, String fileName) {
		try {
			FileOutputStream output =
					new FileOutputStream("src/main/resources/" + fileName);
			prop.store(output, "Config Properties");
		} catch (FileNotFoundException e) {
			System.err.println(
					"File " + fileName + " can not be created in in src/main/resources.");
			return false;
		} catch (IOException e) {
			System.err.println("File " + fileName + " encounters errors while writing.");
			return false;
		}
		return true;
	}
}
