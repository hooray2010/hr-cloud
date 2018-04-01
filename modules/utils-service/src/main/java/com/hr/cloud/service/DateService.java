package com.hr.cloud.service;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liujianqiang on 2017/3/3.
 */
@UtilityClass
@Slf4j
public class DateService {
  
  /**
   * 存放不同的日期模板格式的sdf的Map
   */
  private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap = ThreadLocal.withInitial(() -> {
    log.info(Thread.currentThread().getName() + " init pattern: " + Thread.currentThread());
    return new HashMap<>();
  });
  
  /**
   * 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf
   *
   * @param pattern
   * @return
   */
  private static SimpleDateFormat getSdf(final String pattern) {
    Map<String, SimpleDateFormat> tl = sdfMap.get();
    SimpleDateFormat sdf = tl.get(pattern);
    if (sdf == null) {
      log.info(Thread.currentThread().getName() + " put new sdf of pattern " + pattern + " to map");
      sdf = new SimpleDateFormat(pattern);
      tl.put(pattern, sdf);
    }
    return sdf;
  }
  
  /**
   * date > string
   *
   * @param date
   * @param pattern
   * @return
   */
  public static String format(Date date, String pattern) {
    return getSdf(pattern).format(date);
  }
  
  /**
   * string > date
   *
   * @param dateStr
   * @param pattern
   * @return
   * @throws ParseException
   */
  public static Date parse(String dateStr, String pattern) throws ParseException {
    return getSdf(pattern).parse(dateStr);
  }
  
  /************************************************************/
  
  public static final String FORMAT_DATE_STYLE_1 = "yyyy/MM/dd";
  public static final String FORMAT_DATE_STYLE_2 = "yyyy-MM-dd";
  public static final String FORMAT_DATE_STYLE_3 = "yyyyMMdd";
  public static final String FORMAT_DATE_STYLE_4 = "YYYY/M/d";
  public static final String FORMAT_DATE_TIME_STYLE_1 = "yyyy-MM-dd HH:mm:ss";
  public static final String FORMAT_DATE_TIME_STYLE_2 = "yyyyMMddHHmmss";
  public static final String FORMAT_DATE_TIME_STYLE_3 = "yyyyMMddHHmm";
  
  private static final long DAY_TIME = 1000L * 60 * 60 * 24;
  
  //当天的开始
  public static Date TodayBegin() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //当天的结束
  public static Date TodayEnd() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //昨天的开始
  public static Date YesterdayBegin() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.add(Calendar.DAY_OF_MONTH, - 1);
    return calendar.getTime();
  }
  
  //昨天的结束
  public static Date YesterdayEnd() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.add(Calendar.DAY_OF_MONTH, - 1);
    return calendar.getTime();
  }
  
  //明天的开始
  public static Date TomorrowBegin() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.add(Calendar.DAY_OF_MONTH, + 1);
    return calendar.getTime();
  }
  
  //明天的结束
  public static Date TomorrowEnd() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.add(Calendar.DAY_OF_MONTH, + 1);
    return calendar.getTime();
  }
  
  //一天的开始
  public static Date StartTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //一天的结束
  public static Date EndTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //当月的第一天
  public static Date MonthBegin() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //当月的最后一天
  public static Date MonthEnd() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    return calendar.getTime();
  }
  
  //指定月的第一天
  public static Date TheMonthBegin(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }
  
  //指定月的最后一天
  public static Date TheMonthEnd(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    return calendar.getTime();
  }
  
  /*
  几天前
   */
  public static Date theDayBefore(Date date, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MINUTE, - minute);
    return calendar.getTime();
  }
  
  /**
   * 格式化日期时间精确到秒
   *
   * @param date
   * @return 时间格式的字符串
   */
  public static String formatDateTime(Date date) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_STYLE_1);
    return dateFormat.format(date);
  }
  
  /**
   * 格式化日期时间精确到秒
   *
   * @param date
   * @return 时间格式的字符串
   */
  public static String formatDateTimeStr(Date date) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_STYLE_2);
    return dateFormat.format(date);
  }
  
  /**
   * 格式化日期，仅日期
   *
   * @param date
   * @return 日期格式的字符串
   */
  public static String formatDate(Date date) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_STYLE_2);
    return dateFormat.format(date);
  }
  
  /**
   * 日期格式化
   *
   * @param date
   * @param style
   * @return
   */
  public static String formatDate(Date date, String style) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(style);
    return dateFormat.format(date);
  }
  
  /**
   * 日期文本转日期格式
   *
   * @param dateText
   * @return 日期
   */
  public static Date stringToDate(String dateText) {
    try {
      if (dateText == null) {
        return null;
      }
      SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_STYLE_2);
      return dateFormat.parse(dateText);
    } catch (Exception e) {
      return null;
    }
  }
  
  /**
   * 日期文本转日期格式
   *
   * @param dateText
   * @param dateFormatPattern
   * @return 日期
   */
  public static Date stringToDate(String dateText, String dateFormatPattern) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
      return dateFormat.parse(dateText);
    } catch (Exception e) {
      return null;
    }
  }
  
  /**
   * 日期文本转日期时间格式
   *
   * @param dateText
   * @return 日期时间
   */
  public static Date stringToDateTime(String dateText) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_STYLE_1);
      return dateFormat.parse(dateText);
    } catch (Exception e) {
      return null;
    }
  }
  
  /**
   * 将传入时间format成半点时间
   *
   * @param date
   * @return date
   */
  public static Date formatToHalfHour(Date date) {
    int minute = date.getMinutes();
    
    if (minute >= 0 && minute <= 29) {
      date.setMinutes(0);
    } else {
      date.setMinutes(30);
    }
    
    date.setSeconds(0);
    return date;
  }
  
  
  /**
   * 将传入时间format成半点时间(+ 30)
   *
   * @param date
   * @return date
   */
  public static Date formatToAfterHalfHour(Date date) {
    int minute = date.getMinutes();
    
    if (minute >= 0 && minute <= 29) {
      date.setMinutes(30);
    } else {
      date.setMinutes(0);
      long time = date.getTime();
      //+ 1 h
      date = new Date(time + 60L * 60L * 1000L);
    }
    
    date.setSeconds(0);
    return date;
  }
  
  /**
   * 检查传入时间是否为今天
   *
   * @param date 传入时间
   * @return date
   */
  public static Boolean checkIsToday(Date date) {
    return StartTime(date).getTime() == StartTime(new Date()).getTime();
  }
  
  /**
   * 检查传入时间是否为昨天
   *
   * @param date 传入时间
   * @return date
   */
  public static Boolean checkIsYesterday(Date date) {
    return StartTime(date).getTime() == StartTime(new Date()).getTime() - DAY_TIME;
  }
  
  /**
   * 转为 cron 表达式
   *
   * @param date
   * @return
   */
  public static String getCron(Date date) {
    String dateFormat = "ss mm HH dd MM ? yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    return simpleDateFormat.format(date);
  }
  
  /**
   * 计算天数
   *
   * @param startDate 初始时间
   * @param endDate   结束时间
   * @return
   */
  public static long countDays(Date startDate, Date endDate) {
    float count = (endDate.getTime() / DAY_TIME) - (startDate.getTime()) / DAY_TIME;
    if (count <= 0) {
      return 0;
    }
    return Math.round(count);
  }
}
