package com.hxinternet.hxtalk.utils.Date;


import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * create time: 2021/1/20
 * author: wd
 * description:
 */
public class DateUtils {

    private static DateUtils mInstance;

    public static DateUtils getInstance() {
        if (mInstance == null) {
            synchronized (DateUtils.class) {
                if (mInstance == null) {
                    mInstance = new DateUtils();
                }
            }
        }
        return mInstance;
    }

    public String[] formatLongToTimeStr(Long l) {
        Log.e("当前ll", l + "");
        String time;
        String[] timer;
        try {

            if (l < 60) {
                time = String.format("00:00:%02d", l % 60 <= 0 ? 0 : l % 60);
            } else if (l < 3600) {
                time = String.format("00:%02d:%02d", l / 60, l % 60);
            } else {
                time = String.format("%02d:%02d:%02d", l / 3600 % 24, l % 3600 / 60, l % 60);
            }
            timer = time.split(":");
//            if (Integer.parseInt(timer[0]) > 23) {
//                timer[0] = "23";
//            }
//            if (Integer.parseInt(timer[1]) == 0 && Integer.parseInt(timer[2]) == 1) {
//                timer[0] = "22";
//            }
//            timer[0] = (Integer.parseInt(timer[0]) - Integer.parseInt(timer[0])) + "";
        } catch (Exception e) {
            timer = new String[]{"00", "00", "00"};
        }

        return timer;
    }

    /***
     * 年月日
     */
    public Long Dateday(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return DateLong(formatter, time);
    }

    /***
     * 年月日  时间
     */
    public Long DateTime(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return DateLong(formatter, time);
    }

    /***
     * long 转 时间 time
     * @param time
     * @return
     */
    public String DateStrTime(Long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return DateStr(formatter, time);
    }

    //传入时间戳即可
    public String conversionTime(String timeStamp) {
        //yyyy-MM-dd HH:mm:ss 转换的时间格式  可以自定义
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转换
        String time = sdf.format(new Date(Long.parseLong(timeStamp)));
        return time;
    }

    /***
     * long 时间 转可视str
     * @param time
     * @return
     */
    public String DateStr(SimpleDateFormat format, Long time) {
        String str = "";
        try {
            Date date = new Date(time);
            str = format.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return str;
    }

    /***
     * 公共
     * 时间戳
     * @param formatter
     * @param time
     * @return
     */
    public Long DateLong(SimpleDateFormat formatter, String time) {
        Long DateTime = null;
        try {
            Date date = formatter.parse(time);
            DateTime = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return DateTime;
    }


    /***
     * 通过时间戳 获取 月份
     */
    public int getTime(Long time, int timeType) {
        String currentTimeStr = DateStrTime(System.currentTimeMillis());
        String TimeStr = DateStrTime(time);
        Calendar currentcal = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        Date date = null;
        Date currentDate = null;
        try {
            date = getDateFormat().parse(TimeStr);
            currentDate = getDateFormat().parse(currentTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        currentcal.setTime(currentDate);
        cal.setTime(date);
        Log.d("wd", "currentcal: " + currentcal.get(timeType));
        Log.d("wd", "cal: " + cal.get(timeType));
        return cal.get(timeType) - currentcal.get(timeType);
    }

    /***
     * 通过时间戳 获取 年份
     */
    public int getYear(Long time) {
        String TimeStr = DateStrTime(time);
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = getDateFormat().parse(TimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /***
     * 通过时间戳 获取 天
     */
    public int getDay(Long time) {
        String TimeStr = DateStrTime(time);
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = getDateFormat().parse(TimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /***
     * 判断 今天  明天 后天
     * @param day
     * @return
     * @throws ParseException
     */
    public String IsTodayHint(String day) {

        try {
            Calendar pre = Calendar.getInstance();
            Date predate = new Date(System.currentTimeMillis());
            pre.setTime(predate);
            Calendar cal = Calendar.getInstance();
            Date date = getDateFormat().parse(day);
            cal.setTime(date);
            if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
                int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                        - pre.get(Calendar.DAY_OF_YEAR);

                switch (diffDay) {
                    case 0:
                        return day + " 今天";
                    case 1:

                        return day + " 明天";
                    case 2:

                        return day + " 后天";
                    default:
                        return "";
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        }
        return DateLocal.get();
    }


    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();
}
