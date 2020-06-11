package org.forten.sample.ro;

import java.util.List;

import org.forten.sample.vo.SalaryVo;
import org.forten.sample.vo.SumVo;

public class SalaryRoForUser {
	private List<SalaryVo> voList;
	private SumVo sumVo;

	public SalaryRoForUser() {
		super();
	}

	public SalaryRoForUser(List<SalaryVo> voList, SumVo sumVo) {
		super();
		this.voList = voList;
		this.sumVo = sumVo;
	}

	public List<SalaryVo> getVoList() {
		return voList;
	}

	public void setVoList(List<SalaryVo> voList) {
		this.voList = voList;
	}

	public SumVo getSumVo() {
		return sumVo;
	}

	public void setSumVo(SumVo sumVo) {
		this.sumVo = sumVo;
	}

	@Override
	public String toString() {
		return "SalaryRoForUser [voList=" + voList + ", sumVo=" + sumVo + "]";
	}
}
