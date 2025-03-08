package cn.ylcto.book.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class DateFormater {
    public static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Timestamp timestamp) {
        return dateFormater.format(timestamp);
    }

    public static Timestamp parse(String str) {
        Timestamp timestamp = null;
        try {
            timestamp =  new Timestamp(dateFormater.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

}
