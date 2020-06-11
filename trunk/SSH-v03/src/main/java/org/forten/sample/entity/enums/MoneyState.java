package org.forten.sample.entity.enums;

public enum MoneyState {
	SUBMIT("提交"),PASS("审核通过"),FINISH("报销完成");
	
	private String desc;

	private MoneyState(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	public int getIndex(){
		return ordinal();
	}
}
