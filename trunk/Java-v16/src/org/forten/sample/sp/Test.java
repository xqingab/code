package org.forten.sample.sp;

public class Test {

	public static void main(String[] args) {
		// Runner r = new Runner("张飞");
		// r.run();
		
		CanRun runner = new RunnerProxy(new Runner("张飞"));
		runner.run();
	}

}
