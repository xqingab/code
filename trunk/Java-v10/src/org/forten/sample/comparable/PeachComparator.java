package org.forten.sample.comparable;

import java.util.Comparator;

// 实现了 java.util.Comparator接口的一个比较器类
public class PeachComparator implements Comparator<Peach> {

	@Override
	public int compare(Peach o1, Peach o2) {
		return o1.getWeight()-o2.getWeight();
	}

}
