package org.forten.sample.ro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.forten.sample.vo.SalaryVo;

public class SalaryRo {
	private String[] months = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
	private List<SalaryVo> salaryVoList = new ArrayList<>();

	public SalaryRo() {
		super();
		for (String m : months) {
			salaryVoList.add(new SalaryVo(m));
		}
	}

	public String[] getMonths() {
		return months;
	}

	public List<SalaryVo> getSalaryVoList() {
		return salaryVoList;
	}

	public List<Integer> getSalaryList() {
		List<Integer> salaryList = new ArrayList<>();
		for (SalaryVo vo : salaryVoList) {
			salaryList.add(vo.getSalary());
		}
		return salaryList;
	}

	@Override
	public String toString() {
		return "SalaryRo [months=" + Arrays.toString(months) + ", salaryList=" + salaryVoList + "]";
	}
}
