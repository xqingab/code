package org.forten.sample.vo;

import org.forten.sample.entity.enums.MoneyState;

public class MoneyVoForShow {
	private int id;
	private String projectName;
	private String reason;
	private int amount;
	private String bank;
	private String account;
	private MoneyState state;
	private String stateDesc;

	public MoneyVoForShow() {
		super();
	}

	public MoneyVoForShow(int id, String projectName, String reason, int amount, String bank, String account,
			MoneyState state) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.reason = reason;
		this.amount = amount;
		this.bank = bank;
		this.account = account;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public MoneyState getState() {
		return state;
	}

	public void setState(MoneyState state) {
		this.state = state;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	@Override
	public String toString() {
		return "MoneyVoForShow [id=" + id + ", projectName=" + projectName + ", reason=" + reason + ", amount=" + amount
				+ ", bank=" + bank + ", account=" + account + ", state=" + state + "]";
	}
}
