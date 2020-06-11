package org.forten.sample.vo;

public class MoneyVoForUpdate {
	private int id;
	private int projectId;
	private String reason;
	private int amount;
	private String bank;
	private String account;

	public MoneyVoForUpdate() {
		super();
	}

	public MoneyVoForUpdate(int id, int projectId, String reason, int amount, String bank, String account) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.reason = reason;
		this.amount = amount;
		this.bank = bank;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	@Override
	public String toString() {
		return "MoneyVoForUpdate [id=" + id + ", projectId=" + projectId + ", reason=" + reason + ", amount=" + amount
				+ ", bank=" + bank + ", account=" + account + "]";
	}
}
