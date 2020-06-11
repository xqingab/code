package org.forten.sample.test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {

	public static void main(String[] args) {
		Random r = new Random();

		for (int i = 0; i < 5; i++) {
			int blue = r.nextInt(16) + 1;
			Set<Integer> redSet = new TreeSet<>();
			while (redSet.size() < 6) {
				int red = r.nextInt(33) + 1;
				redSet.add(red);
			}

			for (Integer redBall : redSet) {
				System.out.print(redBall + "\t");
			}
			System.out.println(blue);
		}
	}

}
