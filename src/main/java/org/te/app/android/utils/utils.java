package org.te.app.android.utils;


import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;

public class utils {


    private static final Logger logger = Logger.getLogger(utils.class);
    public static Properties initProperties(String fileName) throws IOException, FileNotFoundException {
        Properties properties;
        FileInputStream inputStream = null;
        String completeFilePath = "./src/main/resources/"+fileName+".properties";
        inputStream = new FileInputStream(completeFilePath);
        properties = new Properties();
        properties.load(inputStream);

        return properties;
    }

    public static int generateRandomNumber(int min, int max){
        return (int) (Math.random()*(max-min+1)+min);
    }


    public static List<Integer> extractBounds(String bounds){
        List<Integer> coordinates = new ArrayList<Integer>();
        int startX, startY, endX, endY;
        startX = Integer.parseInt(bounds.substring(1, bounds.indexOf(',')));
        startY = Integer.parseInt(bounds.substring(bounds.indexOf(',')+1,bounds.indexOf(']')));
        int secondCommaLoc = bounds.indexOf(",", bounds.indexOf(",") + 1);
        endX = Integer.parseInt(bounds.substring(bounds.indexOf(']')+2, bounds.indexOf(",", bounds.indexOf(",") + 1) ));
        endY = Integer.parseInt(bounds.substring(secondCommaLoc+1, bounds.length()-1));
        logger.info("Start X : "+ startX);
        logger.info("Start Y : "+ startY);
        logger.info("End X : "+ endX);
        logger.info("End Y : "+ endY);
        coordinates.add(startX);
        coordinates.add(startY);
        coordinates.add(endX);
        coordinates.add(endY);
        return coordinates;
    }

    public static List<String> getPreviousYears(int previousYears){
        List<String> years = new ArrayList<>();
        Calendar prevYear = getInstance();
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

    public static String decodeString(String str)
    {
        byte[] decodeString= Base64.getDecoder().decode(str);
        return (new String(decodeString));
    }

    public static String encodeString(String str){
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
    public static List<String> removeDuplicatesFromList(List<String> list){
        List<String> finalList = new ArrayList<>();
        for(String str:list){
            if(!finalList.contains(str)){
                finalList.add(str);
            }
        }
        return finalList;
    }

    public static List<String> combineLists(List<String> str1, List<String> str2){
        List<String> finalList = new ArrayList<>(str1);
        finalList.addAll(str2);
        return finalList;
    }


    public static Properties initTestRailProperties() throws IOException {
        Properties properties=new Properties();
        FileInputStream inputStream = null;
        inputStream = new FileInputStream("./src/main/resources/testRail.properties");
        properties.load(inputStream);
        return properties;
    }

    public static int returnSavings(String saving){
        return Integer.parseInt(saving.substring(0, saving.indexOf(" ")));
    }

    public static String returnCurrency(String saving){
        return saving.substring(saving.indexOf(" "));
    }

}
