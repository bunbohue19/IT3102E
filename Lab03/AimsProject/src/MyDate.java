public class MyDate {
	private String day;
	private String month;
	private int year;

	public MyDate() {
		this.day = "19th";
		this.month = "April";
		this.year = 2022;
	}

	public MyDate(String day, String month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
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
	
	public void accept(String date) {
		System.out.print("Enter a date in the form of Month-Day-Year (Ex: February 18th 2019”): ");
	}
}
