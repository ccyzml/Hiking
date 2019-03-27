package com.nju.meanlay.hiking.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static int getRestDays(String startDay,String endDay) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(startDay);
            date2 = format.parse(endDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return result;
    }
}
