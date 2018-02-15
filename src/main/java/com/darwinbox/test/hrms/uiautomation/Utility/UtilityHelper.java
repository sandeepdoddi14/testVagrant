/**
 * 
 */
package com.darwinbox.test.hrms.uiautomation.Utility;

import java.io.File;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author balaji
 * @Creation_Date:  1 Dec 2017 
 * @ClassName: UtilityHelper.java
 * @LastModified_Date:  1 Dec 2017 
 */
public class UtilityHelper {
	
	/**
	 * This method create a directory if it does not exists
	 * @param DirectoryName
	 */
	public static void CreateADirectory(String DirectoryName) {
		
		String workingDirectory = ResourceHelper.getBaseResourcePath();
		String dir = workingDirectory + File.separator + DirectoryName;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdir();
		} 
	}
	
	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}
	
	/**
	 * This file returns value from Property file
	 * @param filename
	 * @param key
	 * @return String
	 */
	public String getProperty(String filename, String key) {
		Properties prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/"+ filename +".properties"));
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * This method round a number to HalfUp
	 * @param num
	 * @return double
	 */
	public double roundHalfUp(double num) {
		NumberFormat roundUp = NumberFormat.getNumberInstance();
		roundUp.setMaximumFractionDigits(0);
		roundUp.setRoundingMode(RoundingMode.HALF_UP);

		String numRoundUpString = roundUp.format(num);
		double doubleNum = Double.parseDouble(numRoundUpString);
		return doubleNum;
	}

	/**
	 * This method rounds up a number to half down
	 * @param num
	 * @return double
	 */
	public double roundHalfDown(double num) {
		NumberFormat roundUp = NumberFormat.getNumberInstance();
		roundUp.setMaximumFractionDigits(0);
		roundUp.setRoundingMode(RoundingMode.FLOOR);

		String numRoundUpString = roundUp.format(num);
		double doubleNum = Double.parseDouble(numRoundUpString);
		return doubleNum;
	}

}