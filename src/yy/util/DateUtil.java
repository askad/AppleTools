package yy.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import yy.excelutil.common.Constants;

public class DateUtil {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(Constants.CONFIG_PATH);
    private static String AC_FORMAT = resourceBundle.getString(Constants.ACCEPT_DATE);
    private static SimpleDateFormat AC_FORMATER = new SimpleDateFormat(AC_FORMAT);
    private static String MD_FORMAT = "MM月dd日";
    private static SimpleDateFormat MD_FORMATER = new SimpleDateFormat(MD_FORMAT);

    public static String getACDate(String yyyymmddhhmmss) throws Exception {
        Date date = AC_FORMATER.parse(yyyymmddhhmmss);
        return MD_FORMATER.format(date);
    }
}
