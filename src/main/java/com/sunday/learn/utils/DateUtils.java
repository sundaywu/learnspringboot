/*
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

package com.sunday.learn.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author : Sunday
 * @Description : 时间转换工具
 * @Date : 14:11 2017/8/21
 * @Modified By :
 */
@Slf4j
public class DateUtils {

    // 2015
    private static final SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");
    // 2015-09
    private static final SimpleDateFormat YEAR_MONTH = new SimpleDateFormat("yyyy-MM");
    // 2015-09-01
    private static final SimpleDateFormat YEAR_MONTH_DAY = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat YEAR_MONTH_DAY_POINT = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat YEAR_MONTH_DAY_NONE = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat YEAR_MONTH_DAY_SLASH = new SimpleDateFormat("yyyy/MM/dd");
    // 2015-09-01 10:00
    private static final SimpleDateFormat YEAR_MONTH_DAY_HM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // 2015-09-01 10:11:11
    private static final SimpleDateFormat YEAR_MONTH_DAY_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 2015-8-1
    private static final SimpleDateFormat YEAR_MONTH_DAY_SIMPLE = new SimpleDateFormat("yyyy-M-d");
    // 16/05/2007
    private static final SimpleDateFormat DAY_MONTH_YEAR = new SimpleDateFormat("dd/MM/yyyy");
    // 10:00
    private static final SimpleDateFormat HM = new SimpleDateFormat("HH:mm");
    // 星期
    private static final SimpleDateFormat WEEKDAY = new SimpleDateFormat("EEEE", Locale.CHINESE);

    /**
     * java.util.Date类型转String，格式为 yyyy
     *
     * @param date
     * @return
     */
    public static String formatYDate(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy"), date, forNullVal);
    }

    /**
     * java.util.Date类型转String，格式为 yyyy-MM
     *
     * @param date
     * @return
     */
    public static String formatYmDate(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy-MM"), date, forNullVal);
    }

    /**
     * java.util.Date类型转String，格式为 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formatYmdDate(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy-MM-dd"), date, forNullVal);
    }

    /**
     * java.util.Date类型转String，格式为 yyyy.MM.dd
     *
     * @param date
     * @return
     */
    public static String formatYmdPointDate(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy.MM.dd"), date, forNullVal);
    }

    /**
     * java.util.Date类型转String，格式为 yyyy-MM-dd HH:mm
     *
     * @param date
     * @param forNullVal
     * @return
     */
    public static String formatHmTime(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm"), date, forNullVal);
    }

    /**
     * java.util.Date类型转String，格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatHmsTime(Date date, String forNullVal) {
        return formatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), date, forNullVal);
    }

    /**
     * java.util.Date类型转Srting，格式为 yyyy-M-d
     *
     * @param date
     * @return
     */
    public static String formatSimpleYmdDate(Date date) {
        return formatDate(new SimpleDateFormat("yyyy-M-d"), date, "");
    }

    /**
     * java.util.Date类型转Srting，格式为 dd/MM/yyyy
     *
     * @param date
     * @return
     */
    public static String formatDmyDate(Date date) {
        return formatDate(new SimpleDateFormat("dd/MM/yyyy"), date, "");
    }

    /**
     * java.util.Date类型转Srting，格式为 HH:MM
     *
     * @param date
     * @return
     */
    public static String formatHMDate(Date date) {
        return formatDate(new SimpleDateFormat("HH:mm"), date, "");
    }

    /**
     * java.util.Date类型转Srting，格式为 HH:MM
     *
     * @param date
     * @return
     */
    public static String formatWeekdayDate(Date date) {
        return formatDate(new SimpleDateFormat("EEEE", Locale.CHINESE), date, "");
    }

    /**
     * 格式为 yyyy-MM的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseYmDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy-MM"), date);
    }

    /**
     * 格式为 HH:MM的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseHMDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("HH:mm"), date);
    }

    /**
     * @param sdf
     * @param date
     * @param forNullVal
     * @return
     */
    private static String formatDate(SimpleDateFormat sdf, Date date, String forNullVal) {
        if (date == null)
            return forNullVal;
        return sdf.format(date);
    }

    /**
     * 格式为 yyyy-MM-dd的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseYmdDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy-MM-dd"), date);
    }

    /**
     * 格式为 yyyy.MM.dd的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseYmdPointDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy.MM.dd"), date);
    }

    /**
     * 格式为 yyyyMMdd的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseYmdNONEDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyyMMdd"), date);
    }

    /**
     * 格式为 yyyy/MM/dd的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseYmdSLASHDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy/MM/dd"), date);
    }

    /**
     * 格式为 yyyy-MM-dd HH:mm 的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseHmTime(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy-MM-dd HH:mm"), date);
    }

    /**
     * 格式为 yyyy-MM-dd HH:mm:ss的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseHmsTime(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), date);
    }

    /**
     * 对应字符串转日期
     *
     * @param sdf
     * @param date
     * @return
     */
    private static Date parseDate(SimpleDateFormat sdf, String date) {
        try {
            Date d = sdf.parse(date);
            return d;
        } catch (ParseException e) {
            log.error("日期转换错误：" + date, e);
        }
        return null;
    }

    /**
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式
     * @param date2 被比较的时间  为空(null)则为当前时间
     * @param stype 返回值类型   0为多少天，1为多少个月，2为多少年
     * @return
     */
    public static int compareDate(String date1, String date2, int stype) {
        int n = 0;
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";
        date2 = date2 == null ? getCurrentDate() : date2;
        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (Exception e3) {
            log.error("日期转换错误", e3);
        }
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1); // 比较天数，日期+1
            }
        }
        n = n - 1;
        if (stype == 2) {
            n = (int) n / 365;
        }
        return n;
    }

    /**
     * 得到当前日期
     * @return
     */
    public static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(date);
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getSystemTime() {
        return sdf.format(new Date());
    }

    /**
     * 返回俩日期中所有日期
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    public static List<Date> dateSplit(Date start, Date end) {
        if (start.getTime() - end.getTime() > 0) {
            return null;
        }
        Long spi = end.getTime() - start.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

        List<Date> dateList = new ArrayList<Date>();
        dateList.add(end);
        for (int i = 1; i <= step; i++) {
            dateList.add(new Date(dateList.get(i - 1).getTime() - (24 * 60 * 60 * 1000)));// 比上一天减一
        }
        return dateList;
    }

    /**
     * 查询俩日期之间年数
     * @param first
     * @param last
     * @return
     */
    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
                || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.CHINESE);
        if (date != null) {
            cal.setTime(date);
        }
        return cal;
    }

    /**
     * 获取当前年
     * @return
     */
    public static String getCurrentYear() {
        Calendar cal = getCalendar(null);
        cal.setTimeInMillis(System.currentTimeMillis());
        return String.valueOf(cal.get(Calendar.YEAR));
    }

    /**
     * 将日期组合成 yyyy-MM-dd HH:mm:ss
     * @param day yyyy-MM-dd
     * @param time HH:mm:ss
     * @throws DataAccessException
     */
    public static Date buildDate(Date day, Date time) throws DataAccessException {
        Calendar calDay = DateUtils.getCalendar(null);
        Calendar calTime = DateUtils.getCalendar(null);
        calDay.setTime(day);
        calTime.setTime(time);
        calTime.set(calDay.get(Calendar.YEAR), calDay.get(Calendar.MONTH), calDay.get(Calendar.DATE));
        day = calTime.getTime();
        return day;
    }

    /**
     * 判断两个时间段是否重叠冲突
     * 临界值不算冲突
     * @param startDate
     * @param endDate
     * @param startDateTarget
     * @param endDateTarget
     * @return
     */
    public static boolean isConflict(Date startDate, Date endDate, Date startDateTarget, Date endDateTarget) {
        boolean flag = true;
        if (endDateTarget.getTime() < startDate.getTime() || startDateTarget.getTime() > endDate.getTime()) {
            flag = false;
        }
        return flag;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取指定日期前/后几天对应的日期
     * 往前 -num , 往后 num
     *
     * @param date
     * @param num
     * @return
     */
    public static Date getDateFromSpeciDayByNum(Date date, Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return calendar.getTime();
    }

    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static String getCurrentMonthFirstDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(c.getTime());
    }

    /**
     * 获取当前月最后一天
     *
     * @return
     */
    public static String getCurrentMonthLastDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        return simple.format(c.getTime());
    }

    /**
     * 得到当前时间
     *
     * @return
     */
    public static String getCurrentHms() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
        return simple.format(date);
    }

    /**
     * 格式为 yyyy-MM-dd HH:mm:ss的String转java.util.Date。错误返回null
     *
     * @param date
     * @return
     */
    public static Date parseHmsDate(String date) {
        if (date == null)
            return null;
        return parseDate(new SimpleDateFormat("HH:mm:ss"), date);
    }

}
