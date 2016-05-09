package com.joshua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.joshua.domain.Cust;

public interface CustDao {
	/**
	 * find user by name
	 * @param name
	 * @return
	 */
	Cust findUserByName(String name);
	
	/**
	 * add a cust
	 * @param cust
	 */
	void addCust(Cust cust);
	
	/**
	 * get all the custs
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * get info of cust by id
	 * @param id
	 * @return
	 */
	Cust findCustById(String id);

	/**
	 * adjust customer's info
	 * @param cust
	 */
	void adjustCust(Cust cust);

	/**
	 * delete cust's info by id
	 * @param id
	 */
	void deleteInfoById(String id);
	
	/**
	 * delete info by id, and also manage the transaction
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	void deleteInfoByIdWithTrans(Connection conn, String id) throws SQLException;

	

}
