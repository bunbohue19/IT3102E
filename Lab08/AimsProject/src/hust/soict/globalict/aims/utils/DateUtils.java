package hust.soict.globalict.aims.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateUtils {
    static class DateItem {
        String datetime;

        DateItem(String date) {
            this.datetime = date;
        }
    }

    static class SortByDate implements Comparator<DateItem> {
        @Override
        public int compare(DateItem a, DateItem b) {
            return a.datetime.compareTo(b.datetime);
        }
    }

    public static void sortTheNumberOfDates(List<DateItem> dateList) {
        Collections.sort(dateList, new SortByDate());
        dateList.forEach(date -> {
            System.out.println(date.datetime);
        });
    }

    public static void compareTwoDate(Date date1, Date date2) {
        if(date1.compareTo(date2) > 0) {
            System.out.println("Date 1 occurs after Date 2");
         } else if(date1.compareTo(date2) < 0) {
            System.out.println("Date 1 occurs before Date 2");
         } else if(date1.compareTo(date2) == 0) {
            System.out.println("Both dates are equal");
         }
    }

    public static void main(String args[]) throws ParseException {

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2019-04-15");
        Date d2 = sdformat.parse("2019-08-10");
        compareTwoDate(d1, d2);

        List<DateItem> dateList = new ArrayList<>();
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2019-01-27"));
        dateList.add(new DateItem("2020-03-26"));
        dateList.add(new DateItem("2020-02-26"));
        sortTheNumberOfDates(dateList);
        
    }
}