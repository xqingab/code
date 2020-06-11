package org.forten.sample;

public class NumFunTest01 {

	public static void main(String[] args) {
		NumFun n = new NumFun() {
			@Override
			public double test() {
				return Math.random()*100;
			}
		};
		
		System.out.println(n.test());
	}

}
