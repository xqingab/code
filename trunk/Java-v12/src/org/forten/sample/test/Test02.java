package org.forten.sample.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> scoreList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int s = r.nextInt(10) + 1;
			scoreList.add(s);
		}

		Collections.sort(scoreList);
		double sum = 0.0;
		for (int i = 1; i < scoreList.size() - 1; i++) {
			sum = sum + scoreList.get(i);
		}
		System.out.println(sum / 8.0);
	}

}
