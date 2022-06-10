package hust.soict.globalict.aims.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class MyDate {
	private String day;
	private String month;
	private int year;

	public MyDate() {
		String pattern = "MM/dd/yyyy HH:mm:ss";

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);
		 
		// Get the today date using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String todayAsString = df.format(today);
		 
		// Print it!
		System.out.println(todayAsString);
	}

	public MyDate(String day, String month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public MyDate(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = Integer.parseInt(year);
	}

	public MyDate(String myDate) {
		myDate = this.month + " " + this.day + " " + String.valueOf(this.year);
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		char[] ch = new char[2];
		day.getChars(0, 2, ch, 0);

		int intDay = Integer.parseInt(String.valueOf(ch));

		if (intDay >= 1 && intDay <= 31) {
			this.day = day;
		} else {
			System.out.println("Invalid!");
		}

	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		int intMonth = 0;
		switch (month) {
		case "January": {
			intMonth = 1;
		}
			break;
		case "February": {
			intMonth = 2;
		}
			break;
		case "March": {
			intMonth = 3;
		}
			break;
		case "April": {
			intMonth = 4;
		}
			break;
		case "May": {
			intMonth = 5;
		}
			break;
		case "June": {
			intMonth = 6;
		}
			break;
		case "July": {
			intMonth = 7;
		}
			break;
		case "August": {
			intMonth = 8;
		}
			break;
		case "September": {
			intMonth = 9;
		}
			break;
		case "October": {
			intMonth = 10;
		}
			break;
		case "November": {
			intMonth = 11;
		}
			break;
		case "December": {
			intMonth = 12;
		}
			break;
		}

		if (intMonth >= 1 && intMonth <= 12) {
			this.month = month;
		} else {
			System.out.println("Invalid!");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	// public void accept(String date) {
	// 	System.out.print("Enter a date in the form of Month-Day-Year (Ex: February 18th 2019 ): ");
	// }

	public static void print() {

		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);

		String dmy = todayAsString.substring(0, 10);

		String[] words = dmy.split(Pattern.quote("/"));

		switch (words[0]) {
			case "01":
				words[0] = "January";
				break;
			case "02":
				words[0] = "February";
				break;
			case "03":
				words[0] = "March";
				break;
			case "04":
				words[0] = "April";
				break;
			case "05":
				words[0] = "May";
				break;
			case "06":
				words[0] = "June";
				break;
			case "07":
				words[0] = "July";
				break;
			case "08":
				words[0] = "August";
				break;
			case "09":
				words[0] = "September";
				break;
			case "10":
				words[0] = "October";
				break;
			case "11":
				words[0] = "November";
				break;
			case "12":
				words[0] = "December";
				break;
		}

		int day = Integer.parseInt(words[1]);

		if (day == 01 || day == 11 || day == 21 || day == 31) {
			words[1] = words[1] + "st";
		} else if (day == 02 || day == 12 || day == 22) {
			words[1] = words[1] + "nd";
		} else if (day == 03 || day == 13 || day == 23) {
			words[1] = words[1] + "rd";
		} else {
			words[1] = words[1] + "th";
		}

		System.out.println(words[0] + " " + words[1] + " " + words[2]);
	}

	public static void main(String[] args) {
		MyDate.print();
	}
}
