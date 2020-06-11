package org.forten.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.forten.sample.entity.enums.MoneyState;

@Entity
@Table(name = "test_money")
public class Money implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "project_id")
	private int projectId;
	@Column
	private String reason;
	@Column
	private int amount;
	@Column
	private String bank;
	@Column
	private String account;
	@Column
	@Enumerated
	private MoneyState state;// SU提交 PA审核通过 CO完成
	@Column(name = "user_id")
	private int userId;

	public Money() {
		super();
		this.state = MoneyState.SUBMIT;
	}

	public Money(int projectId, String reason, int amount, String bank, String account, int userId) {
		this();
		this.projectId = projectId;
		this.reason = reason;
		this.amount = amount;
		this.bank = bank;
		this.account = account;
		this.userId = userId;
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

	public MoneyState getState() {
		return state;
	}

	public void setState(MoneyState state) {
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [id=" + id + ", projectId=" + projectId + ", reason=" + reason + ", amount=" + amount + ", bank="
				+ bank + ", account=" + account + ", state=" + state + ", userId=" + userId + "]";
	}
}
