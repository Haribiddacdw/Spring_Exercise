package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/** 
 * BankController Class 
 * It Responsible for Handling HTML request and response
 * */
@RestController
@RequestMapping("/bank")
public class BankController  {
	@Autowired
	private BankServiceImplementation bankService;

	/** 
	 * menuPage Method Responsible for Display Menu Page 
	 * @param ModelandView Object
	 * @return modelandView
	 * */
	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public ModelAndView menuPage(ModelAndView modelAndView) {
		modelAndView.setViewName("menu");
		return modelAndView;
	}
	
	/** 
	 * userCreationPage Method Responsible for Displaying User Creating Form and Storing form details
	 * add bank object data to model and display userAddtion page  
	 * @param ModelandView Object
	 * @return modelandView
	 * */
	@RequestMapping(value = "createForm", method = RequestMethod.GET)
	public ModelAndView userCreationPage(ModelAndView modelAndView) {
		BankDTO userdto = new BankDTO();
		modelAndView.addObject("user", userdto);
		modelAndView.setViewName("userAddition");
		return modelAndView;
	}

	/** 
	 * userCreate Method Responsible for Storing new user to database
	 * add bank object data to model and display userAddtion page  
	 * @param user object that holds form data regards user details
	 * @return modelandView
	 * */
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public ModelAndView createUser(BankDTO user) {
		bankService.createUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserSuccessPage");
		return modelAndView;
	}
	/** 
	 * userSuccessPage Method Responsible for Displaying User Created Message
	 * @param ModelandView Object
	 * @return modelandView
	 * */
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public ModelAndView userSuccessPage(ModelAndView modelAndView) {
		modelAndView.setViewName("UserSuccessPage");
		return modelAndView;
	}
	
	/** 
	 * getUserForCheckBalance Method Responsible for get User Id to check balance of given user id
	 * @param ModelandView Object 
	 * @param FormData formData - set empty object initially to fetch form input 
	 * @return modelandView
	 * */
	@RequestMapping(value = "checkbalance", method = RequestMethod.GET)
	public ModelAndView getUserForCheckBalance(FormData formData,ModelAndView modelAndView) {
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("checkBalance");
		return modelAndView;
	}
	
	/** 
	 * displayBalance Method Responsible for Displaying Balance Detail of Particular User
	 * @param ModelandView Object 
	 * @param FormData formData - formData object contain user id and with help of that we can fetch that particular user from DB
	 * @return modelandView
	 * */
	@RequestMapping(value = "displayBalance", method = RequestMethod.POST)
	public ModelAndView displayBalance(FormData formData,ModelAndView modelAndView) {
		BankDTO userDTO = bankService.getUser(formData.getCreditID());
		modelAndView.addObject("balance", userDTO.getBalance());
		modelAndView.addObject("id", userDTO.getId());
		modelAndView.addObject("username", userDTO.getName());
		modelAndView.setViewName("displayBalance");
		return modelAndView;
	}

	/** 
	 * moneyTransferForm Method Responsible for get Money Transfer Details 
	 * @param ModelandView Object 
	 * @param FormData formData - set empty object initially to fetch form input 
	 * @return modelandView
	 * */
	@RequestMapping(value = "moneytransfer", method = RequestMethod.GET)
	public ModelAndView moneyTransferForm(FormData formData,ModelAndView modelAndView) {
		modelAndView.addObject("data", formData);
		modelAndView.setViewName("moneytransfer");
		return modelAndView;
	}
	
	/** 
	 * moneyTransfer Method Responsible for Updated balances of each user and it will acknowledge 
	 * @param ModelandView Object 
	 * @param FormData formData - formData object contain credit id , debit id  and  amount with help of that we can Transfer the money to particular user
	 * @return modelandView
	 * */
	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public ModelAndView moneyTransfer(FormData data) {
		try {
			bankService.moneyTransfer(data.getCreditID(), data.getDebitID(), data.getAmount());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("successtransfer");
			return modelAndView;
		} catch (InvalidUserException | InsufficientBalanceException e) {

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("UserErrorPage");
			return modelAndView;
		}
	}
	
}




/*
 * FormData Class for Get Form inputs data for Transaction
 * */

 class FormData {
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