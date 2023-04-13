package com.example.demo;

import com.example.exception.InsufficientBalanceException;
import com.example.exception.InvalidUserException;
import com.example.model.BankDTO;

public interface BankService {
	public int checkUser(int creditId, int debitId);

	public BankDTO getUser(int id);

	public String moneyTransfer(int creditId, int debitId, int amount) throws InvalidUserException, InsufficientBalanceException;

	public void doCredit(int creditId, int creditAmount);

	public void doDebit(int debitId, int debitAmount) throws InsufficientBalanceException, InsufficientBalanceException;
}