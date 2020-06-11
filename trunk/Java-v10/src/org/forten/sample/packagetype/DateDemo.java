package org.forten.sample.packagetype;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// Java语言设置的日期开始的时间点
		// 日期对象的开始时间是格林尼制时间的1970年1月1号的0:0:0
		Date javaStartTime = new Date(0);
		// 得到当前时间
		// 当前时间的表示：从格林尼制时间的1970年1月1号的0:0:0到当前时间所经过的毫秒数
		Date currentDate = new Date();
		
		System.out.println(currentDate);
		System.out.println(javaStartTime);
		
		// getTime()方法返回的是一个long型的数字
		// 它是从1970年1月1日00:00:00到当前时间经过的毫秒数
		System.out.println(javaStartTime.getTime());
		System.out.println(currentDate.getTime());
		// 通过System.currentTimeMillis()也可以得到从1970年1月1日00:00:00到当前时间经过的毫秒数
		System.out.println(System.currentTimeMillis());
		
		// 通过System.currentTimeMillis()计算程序的执行时间
		long begin = System.currentTimeMillis();
		for(int i = 0;i<=1000000000;i++){
			
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		
		// 关于日期格式：
		// yyyy：4位年份
		// yy：2位年份
		// MM：月份
		// dd：月份中的日期
		// HH：24小时制的小时
		// hh：12小时制的小时
		// mm：分钟
		// ss：秒
		// SSS：毫秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(currentDate));
		
		sdf = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println(sdf.format(currentDate));
		sdf = new SimpleDateFormat("yy年MM月dd日 hh:mm:ss,SSS");
		System.out.println(sdf.format(currentDate));
		
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		cal1.set(2000, 0, 1);
		System.out.println(cal1);
		cal1.set(Calendar.YEAR, 2001);
		System.out.println(cal1);
	}

}
