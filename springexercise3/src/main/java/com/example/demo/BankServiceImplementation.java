package com.example.demo;

import java.util.Optional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BankServiceImplementation Class that extends BankService Interface
 * BankDao object is injected in this class , with help of that we can do DB Operations
 * */

@Service("userService")
@Transactional
public class BankServiceImplementation implements BankService {
	@Autowired
	private BankDAO dao;

	public void createUser(BankDTO dto) {
		dao.save(dto);
	}

	@Override
	public int checkUser(int crid, int dbid) {

		return dao.findByExists(crid, dbid);
	}

	@Override
	public BankDTO getUser(int id) {

		return dao.findById(id).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { InvalidUserException.class,InsufficientBalanceException.class })
	public String moneyTransfer(int creditId, int debitId, int amount) throws InvalidUserException, InsufficientBalanceException {
		if (checkUser(creditId, debitId) != 2) {
			throw new InvalidUserException("Invalid User");
		} else {
			doDebit(debitId, amount);
			doCredit(creditId, amount);
			return "Transfered SucessFully";
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { InsufficientBalanceException.class })
	public void doDebit(int debitId, int debitAmount) throws InsufficientBalanceException {
		Optional<BankDTO> debitUser = dao.findById(debitId);
		int amount = debitUser.get().getBalance();
		if (amount < debitAmount) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		amount = amount - debitAmount;
		debitUser.get().setBalance(amount);
		dao.updateAmount(debitId, amount);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void doCredit(int creditId, int creditAmount) {
		Optional<BankDTO> creditUser = dao.findById(creditId);
		int amount = creditUser.get().getBalance();
		amount += creditAmount;
		creditUser.get().setBalance(amount);
		dao.updateAmount(creditId, amount);
	}
}


/* 
 * InsufficientBalanceException Class 
 * */
class InsufficientBalanceException extends Exception{
	String errorMessage;

	public InsufficientBalanceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}

/* 
 * 
 * InvalidUser Exception Class 
 * */
 
class InvalidUserException extends Exception{
	String errorMessage;
	InvalidUserException(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}