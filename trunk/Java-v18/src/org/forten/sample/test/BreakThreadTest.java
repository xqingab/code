package org.forten.sample.test;

import org.forten.sample.thread.Thread03;

public class BreakThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Thread03 tt = new Thread03();
		Thread t = new Thread(tt);

		t.start();
		Thread.sleep(3000);
		tt.stop();
	}

}
