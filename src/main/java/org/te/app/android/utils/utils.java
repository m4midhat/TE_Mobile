package org.te.app.android.utils;

import java.util.ArrayList;
import java.util.List;

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

}
