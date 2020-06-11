package org.forten.sample.packagetype;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberDemo {

	public static void main(String[] args) {
		// BigInteger表示很大的整数
		BigInteger bi1 = new BigInteger("90248098234098209834092384902834298350982346832059823049");
		BigInteger bi2 = new BigInteger("9403904903904932394809593844590345");
		// bi1+bi2
		System.out.println(bi1.add(bi2));
		// bi1-bi2
		System.out.println(bi1.subtract(bi2));
		// bi1*bi2
		System.out.println(bi1.multiply(bi2));
		// bi1/bi2
		System.out.println(bi1.divide(bi2));
		// bi1%bi2
		System.out.println(bi1.mod(bi2));
		
		// BigDecimal表示很大的浮点数
		BigDecimal bd1 = new BigDecimal("2848958234234898394893.2849589483958");
		BigDecimal bd2 = new BigDecimal("1398294284.0392094589438590342849589483958");
		// bd1+bd2
		System.out.println(bd1.add(bd2));
		// bd1-bd2
		System.out.println(bd1.subtract(bd2));
		// bd1*bd2
		System.out.println(bd1.multiply(bd2));
	}

}
