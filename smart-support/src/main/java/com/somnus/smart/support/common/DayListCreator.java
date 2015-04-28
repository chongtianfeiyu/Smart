package com.somnus.smart.support.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 2015年日历生成
 * 
 * @author 武少通
 * @version $Id: DayListCreator.java, v 0.1 2014-12-30 下午05:49:27 李太平 Exp $
 */
public class DayListCreator {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String curDate = "2015-01-01";
        String endDate = "2016-01-01";
        Date d = null;

        int year;
        int month;
        int date;
        boolean isHoliday;
        boolean isWeekend;
        boolean isTenDay;
        boolean isMonthEnd;
        boolean isQuarteEnd;
        boolean isYearEnd;

        String sqlHead = "insert into TCOR_DAY_DAYLIST (DATE_CODE, YEAR_CODE, MONTH_CODE, DAY_CODE, IS_HOLIDAY, IS_WEEKEND, IS_TENDAY, IS_MONTHEND, IS_QUARTEREND, IS_YEAREND, CREATE_TIME, CREATE_BY, MODIFY_TIME, MODIFY_BY)\n";
        StringBuffer curSql;

        System.out.println("-- 2015 Day List insert Sql\n");

        while (!curDate.equals(endDate)) {
            d = sdf.parse(curDate);
            c.setTime(d);
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH) + 1;
            date = c.get(Calendar.DAY_OF_MONTH);

            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;

            isHoliday = isHoliday(c);
            isWeekend = isWeekend(c);
            isTenDay = isTenDay(c);
            isMonthEnd = isMonthEnd(c);
            isQuarteEnd = isQuarteEnd(c);
            isYearEnd = isYearEnd(c);

            curSql = new StringBuffer(sqlHead);
            curSql.append("values (");
            curSql.append("'" + curDate + "', ");
            curSql.append("'" + year + "', ");
            curSql.append("'" + String.format("%02d", month) + "', ");
            curSql.append("'" + String.format("%02d", date) + "', ");
            curSql.append("'" + (isHoliday ? 1 : 0) + "', ");
            curSql.append("'" + (isWeekend ? 1 : 0) + "', ");
            curSql.append("'" + (isTenDay ? 1 : 0) + "', ");
            curSql.append("'" + (isMonthEnd ? 1 : 0) + "', ");
            curSql.append("'" + (isQuarteEnd ? 1 : 0) + "', ");
            curSql.append("'" + (isYearEnd ? 1 : 0) + "', ");
            //curSql.append("to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), ");
            curSql.append("'2014-12-31 23:59:59', ");
            curSql.append("'system', ");
            //curSql.append("to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'), ");
            curSql.append("'2014-12-31 23:59:59', ");
            curSql.append("'system');\n");

            System.out.print(curSql.toString());
            System.out.println("commit;");
            /*
             * System.out.print(curDate+"\t"); System.out.print(year+"\t"); System.out.print(month+"\t");
             * System.out.print(date+"\t"); //System.out.print(dayOfWeek+"\t"); System.out.print(isHoliday+"\t");
             * System.out.print(isWeekend+"\t"); System.out.print(isTenDay+"\t"); System.out.print(isMonthEnd+"\t");
             * System.out.print(isQuarteEnd+"\t"); System.out.print(isYearEnd+"\t"); System.out.println();
             */

            c.add(Calendar.DAY_OF_MONTH, 1); //加一天
            d = c.getTime();
            curDate = sdf.format(d);
        }
    }

    private static boolean isHoliday(Calendar c) {
        //假日
        String[] holidayArr = new String[] { "2015-01-01", "2015-01-02", "2015-01-03", "2015-02-18", "2015-02-19", "2015-02-20", "2015-02-21",
                "2015-02-22", "2015-02-23", "2015-02-24", "2015-04-04", "2015-04-05", "2015-04-06", "2015-05-01", "2015-05-02", "2015-05-03",
                "2015-06-20", "2015-06-21", "2015-06-22", "2015-09-26", "2015-09-27", "2015-10-01", "2015-10-02", "2015-10-03", "2015-10-04",
                "2015-10-05", "2015-10-06", "2015-10-07" };

        //周末上班
        String[] workArr = new String[] { "2015-01-04", "2015-02-15", "2015-02-28", "2015-10-10" };

        Date d = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(d);
        for (String s : holidayArr) {
            if (s.equals(dateStr)) {
                return true;
            }
        }
        for (String s : workArr) {
            if (s.equals(dateStr)) {
                return false;
            }
        }

        int day = c.get(Calendar.DAY_OF_WEEK); //星期 1:周日，7：周六
        if (day == 1 || day == 7) {
            return true;
        }
        return false;
    }

    private static boolean isWeekend(Calendar c) {
        int day = c.get(Calendar.DAY_OF_WEEK);
        if (day == 1) { //1:周日
            return true;
        }
        return false;
    }

    private static boolean isMonthEnd(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        boolean isRun = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            isRun = true;
        }
        int monthEnd = 30;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            monthEnd = 31;
        }
        if (month == 2 && isRun) {
            monthEnd = 29;
        }
        if (month == 2 && !isRun) {
            monthEnd = 28;
        }
        if (day == monthEnd) {
            return true;
        }
        return false;
    }

    private static boolean isTenDay(Calendar c) {
        int day = c.get(Calendar.DAY_OF_MONTH);

        if (isMonthEnd(c)) {
            return true;
        }

        if (day % 10 == 0 && day != 30) {
            return true;
        }
        return false;
    }

    private static boolean isQuarteEnd(Calendar c) {
        int month = c.get(Calendar.MONTH) + 1;
        if (month % 3 == 0 && isMonthEnd(c)) {
            return true;
        }
        return false;
    }

    private static boolean isYearEnd(Calendar c) {
        int month = c.get(Calendar.MONTH) + 1;
        if (month == 12 && isMonthEnd(c)) {
            return true;
        }
        return false;
    }

}
