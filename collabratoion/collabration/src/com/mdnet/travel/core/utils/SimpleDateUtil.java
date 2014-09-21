package com.mdnet.travel.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ldy
 * 
 */
public class SimpleDateUtil {

	// 短日期格式
	public final static String DATE_FORMAT = "yyyy-MM-dd";

	// 长日期格式
	public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将日期格式的字符串转换为长整型
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static long convert2long(String date, String format) {
		try {
			if (StringUtils.isNotBlank(date)) {
				if (StringUtils.isBlank(format))
					format = SimpleDateUtil.TIME_FORMAT;
				SimpleDateFormat sf = new SimpleDateFormat(format);
				return sf.parse(date).getTime();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0l;
	}

	// 得到所输入日期的第二天
	public static String getUserDefinedDateTomorrow(Date date, int dayNum) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		String dateString = "";
		calendar.add(calendar.DATE, dayNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		dateString = getTimeFormat("yyyy-MM-dd", date);

		return dateString;
	}
	
	// 将日期格式化成自定义的类型
	public static String getTimeFormat(String format, Date date) {

		SimpleDateFormat formatDate = new SimpleDateFormat(format);

		return formatDate.format(date);

	}

	/**
	 * 将长整型数字转换为日期格式的字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String convert2String(long time, String format) {
		if (time > 0l) {
			if (StringUtils.isBlank(format))
				format = SimpleDateUtil.TIME_FORMAT;
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date date = new Date(time);
			return sf.format(date);
		}
		return "";
	}

	/**
	 * 获取当前系统的日期
	 * 
	 * @return
	 */
	public static long curTimeMillis() {
		return System.currentTimeMillis();
	}

	// 生成一个唯一的序列号
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String msgSerial = MD5.getMD5((uuid + String.valueOf(new Date()))
				.getBytes());
		return msgSerial;
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 *            "2013-10-12"
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的后一天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

	/**
	 * 
	 * @param datestr
	 *            日期字符串
	 * @param day
	 *            相对天数，为正数表示之后，为负数表示之前
	 * @return 指定日期字符串n天之前或者之后的日期
	 */
	public static String getBeforeAfterDate(String datestr, int day) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date olddate = null;
		try {
			df.setLenient(false);
			olddate = new Date(df.parse(datestr).getTime());
		} catch (ParseException e) {
			throw new RuntimeException("日期转换错误");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(olddate);

		int Year = cal.get(Calendar.YEAR);
		int Month = cal.get(Calendar.MONTH);
		int Day = cal.get(Calendar.DAY_OF_MONTH);

		int NewDay = Day + day;

		cal.set(Calendar.YEAR, Year);
		cal.set(Calendar.MONTH, Month);
		cal.set(Calendar.DAY_OF_MONTH, NewDay);

		return df.format(cal.getTimeInMillis());
	}

	/**
	 * long difference=c2.getTimeInMillis()-c1.getTimeInMillis(); 相差天数：long
	 * day=difference/(3600*24*1000) 相差小时：long hour=difference/(3600*1000)
	 * 相差分钟：long minute=difference/(60*1000) 相差秒： long second=difference/1000
	 */
	public static Long getMinuteDifference(Long cF, Long cL) {
		long difference = cL - cF;
		return difference / (60 * 1000);
	}
}
