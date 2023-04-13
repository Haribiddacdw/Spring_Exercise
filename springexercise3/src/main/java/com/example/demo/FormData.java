package com.example.demo;

/*
 * FormData Class for Get Form inputs data for Transaction
 * */

 public class FormData {
	private int creditID;
	private int debitID;
	private int amount;
	public int getCreditID() {
		return creditID;
	}

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public int getDebitID() {
		return debitID;
	}

	public void setDebitID(int debitID) {
		this.debitID = debitID;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
