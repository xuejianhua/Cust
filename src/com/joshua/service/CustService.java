package com.joshua.service;

import java.sql.SQLException;
import java.util.List;

import com.joshua.domain.Cust;

public interface CustService {
	/**
	 * to add a customer
	 * @param cust
	 */
	void add(Cust cust);
	
	/**
	 * to get all the cumtomers 
	 * @return
	 */
	List<Cust> getAllCust();
	
	/**
	 * get customer information by id
	 * @param id
	 * @return
	 */
	Cust findById(String id);
	
	/**
	 * adjust information of the chosen customer
	 * @param cust
	 */
	void adjustInfo(Cust cust);

	/**
	 * delete this cust
	 * @param id
	 */
	void deleteInfo(String id);

	/**
	 * delete batch,will use transaction management to do this
	 * @param ids
	 * @throws SQLException 
	 */
	void batchDel(String[] ids);

}
