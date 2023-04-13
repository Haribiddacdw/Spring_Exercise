package com.example.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** 
 * BankDAO Interface that Extends JPA RESPOSITORY
 * @params BankDTO 
 * @params BankDTO DataType as Primary Key
 * */
@Repository("bank")
public interface BankDAO  extends JpaRepository<BankDTO, Integer> {
	/** 
	 * findByExists method check that users are valid or not
	 * */
	@Query("select COUNT(*) from BankDTO where id In(?1,?2)")
	public int findByExists(int creditId, int debitId);

	
	/** 
	 * updateAmount method that will update the balance of particular user
	 * */
	@Modifying
	@Query("update BankDTO u set u.balance=?2 where u.id=?1")
	public void updateAmount(int id, int amount);
}
