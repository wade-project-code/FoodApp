package com.wade.foodapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wade on 2020/2/19.
 */
public class ToolFactory {

    public static String getDateTime(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}
