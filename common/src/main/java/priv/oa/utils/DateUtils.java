package priv.oa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 日期工具类 */
public class DateUtils {

    /** 获取当前日期 */
    public static String getDate() {
        return LocalDate.now().toString();
    }

    /** 获取当前年月 */
    public static String getCurrentYearMonth() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    /** 获取当前时间 */
    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /** 获取当前秒值 */
    public static long getCurrentSecond() {
        return Clock.systemDefaultZone().millis() / 1000;
    }

    /** 获取当前毫秒值 */
    public static long getCurrentMilliSecond() {
        return Clock.systemDefaultZone().millis();
    }

    /** 获取年份 */
    public static int getYear() {
        return LocalDateTime.now().getYear();
    }

    /** 获取月份 */
    public static int getMonth() {
        return LocalDateTime.now().getMonthValue();
    }

    /** 获取日/月 (本月的第几天)*/
    public static int getDayOfMonth() {
        return LocalDateTime.now().getDayOfMonth();
    }

    /** 获取日/周 (本周的第几天)*/
    public static int getDayOfWeek() {
        return LocalDateTime.now().getDayOfWeek().getValue();
    }

    /** 获取日/年 (本年的第几天)*/
    public static int getDayOfYear() {
        return LocalDateTime.now().getDayOfYear();
    }

    /** 判断今年是否是闰年 */
    public static boolean thisYearIsLeapYear() {
        return LocalDate.now().isLeapYear();
    }

    /**
     * 获取本月中的所有天数的日期
     * @return
     */
    public static List<String> getCurrenMonthDays() {
        // 当前的日期
        String currentYearMonth = getDate();
        // 判断当月多少天
        String[] split = currentYearMonth.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        LocalDate localDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        int dayOfMonth = lastDay.getDayOfMonth();
        List<String> days = new ArrayList<>(dayOfMonth);
        for (int i = 0; i < dayOfMonth; i++) {
            if (i < 9) {
                days.add(month + "-0" + (i + 1));
            } else {
                days.add(month + "-" + (i + 1));
            }
        }
        return days;
    }

    /** 秒转为时间 */
    public static String secondToDateTime(Long second) {
        if (null == second) {
            return "";
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /** 秒转为日期 */
    public static String secondToDate(Long second) {
        if (null == second) {
            return "";
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 日期格式字符串转为时间戳，秒数
     * @param date  yyyy-MM-dd  格式日期字符串
     * @return  时间戳
     */
    public static Long dateToSecond(String date) {
        if (StringUtils.notEmpty(date)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parse = format.parse(date);
                return parse.getTime() / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 把时间字符串转成时间戳 秒数
     * @param dateTime  yyyy-MM-dd HH:mm:ss 格式字符串
     * @return
     */
    public static Long dateTimeToSecond(String dateTime) {
        if (StringUtils.notEmpty(dateTime)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parse = format.parse(dateTime);
                return parse.getTime() / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public static void main(String[] args) {
//        System.out.println(dateToSecond(LocalDate.now().withDayOfMonth(1).toString()));
        System.out.println(getTodayStartTime());
    }

    /**
     * 获取上个月的开始时间戳
     * @return
     */
    public static Long getLastMonthStartTime() {
        return dateToSecond(LocalDate.now().minusMonths(1).withDayOfMonth(1).toString());
    }

    /**
     * 获取本月开始时间戳
     * @return
     */
    public static Long getCurrentMonthStartTime() {
        return dateToSecond(LocalDate.now().withDayOfMonth(1).toString());
    }

    /**
     * 获取今天的开始时间戳
     * @return
     */
    public static Long getTodayStartTime() {
        return dateToSecond(LocalDate.now().toString());
    }
}
