package com.example.demo;


public interface BankService {
	public int checkUser(int crid, int dbid);

	public BankDTO getUser(int id);

	public String moneyTransfer(int crid, int dbid, int amount) throws InvalidUserException, InsufficientBalanceException;

	public void doCredit(int crid, int cramt);

	public void doDebit(int dbid, int dramt) throws InsufficientBalanceException;
}