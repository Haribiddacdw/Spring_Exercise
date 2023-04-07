package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="accounts")
public class AccountsDTO {
	
	@Id

	private int acid;
	private int amount;
	public int getId() {
		return acid;
	}
	public void setId(int acid) {
		this.acid = acid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AccountsDTO [acid=" + acid + ", amount=" + amount + "]";
	}
	
}