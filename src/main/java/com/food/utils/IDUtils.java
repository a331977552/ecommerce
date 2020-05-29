package com.food.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * id generation strategy
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 */
public class IDUtils {

	static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmm");

	/**
	 * generate picture id
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * generate product id
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒

		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		return Long.parseLong(str);
	}

	public  synchronized static String getOrderId(long orderCode) {
		String format = dateFormat.format(new Date());
		//如果不足两位前面补0
		return format + orderCode;
	}

	public static String getUUID() {

		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/*public static void main(String[] args) {
		for(int i=0;i< 100;i++) {
			System.out.println(genItemId());
		}
	}*/
}
