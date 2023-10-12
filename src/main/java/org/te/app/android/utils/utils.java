package org.te.app.android.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class utils {

    public static List<Integer> extractBounds(String bounds){
        List<Integer> coordinates = new ArrayList<Integer>();
        int startX, startY, endX, endY;
        startX = Integer.parseInt(bounds.substring(1, bounds.indexOf(',')));
        startY = Integer.parseInt(bounds.substring(bounds.indexOf(',')+1,bounds.indexOf(']')));
        int secondCommaLoc = bounds.indexOf(",", bounds.indexOf(",") + 1);
        endX = Integer.parseInt(bounds.substring(bounds.indexOf(']')+2, bounds.indexOf(",", bounds.indexOf(",") + 1) ));
        endY = Integer.parseInt(bounds.substring(secondCommaLoc+1, bounds.length()-1));
        System.out.println("Start X : "+ startX);
        System.out.println("Start Y : "+ startY);
        System.out.println("End X : "+ endX);
        System.out.println("End Y : "+ endY);
        coordinates.add(startX);
        coordinates.add(startY);
        coordinates.add(endX);
        coordinates.add(endY);
        return coordinates;
    }

    public static List<String> getPreviousYears(int previousYears){
        List<String> years = new ArrayList<>();
        Calendar prevYear = getInstance();
        //ßyears.add(String.valueOf(prevYear.get(YEAR)));
        for(int i=0;i<previousYears-1;i++) {
            prevYear.add(YEAR, -1);
            years.add(String.valueOf(prevYear.get(YEAR)));
        }
        return years;
    }

    public static String extractMonth(){
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        int currentMonth = Integer.parseInt(currentDate.substring(5,7));
        return months[currentMonth-1];
    }

    public static String extractDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        int currentDD = Integer.parseInt(currentDate.substring(8,10));
        String strDD;
        if(currentDD!=1){
            strDD = String.valueOf(currentDD-1);
        }
        else
            strDD = String.valueOf(currentDD);

        return strDD;
    }

    public static String getYearForAge(int age){
        List<String> years = getPreviousYears(100);
        return years.get(age);
    }

}
