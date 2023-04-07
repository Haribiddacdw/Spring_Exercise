package com.model;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Myservice{
	@Autowired
	private AccountsDAO dao;
	public void doServe(int acid,int amt) {
		AccountsDTO dto = dao.findByID(acid);
		dto.setAmount(amt);
		dao.updateAccounts(dto);
	}
	public AccountsDAO getDao() {
		return dao;
	}
	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
}