package com.joshua.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.joshua.dao.CustDao;
import com.joshua.domain.Cust;
import com.joshua.factory.BasicFactory;
import com.joshua.untils.DaoUtils;

public class CustServiceImpl implements CustService {
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);

	@Override
	public void add(Cust cust) {
		// to check if this customer exists
		if (dao.findUserByName(cust.getName()) != null) {
			throw new RuntimeException("this username already exists");
		}
		// use service from dao to add this customer
		dao.addCust(cust);
	}

	@Override
	public List<Cust> getAllCust() {
		// get all customers information
		return dao.getAllCust();
	}

	@Override
	public Cust findById(String id) {
		// get a customer's information by id
		return dao.findCustById(id);
	}

	@Override
	public void adjustInfo(Cust cust) {
		// adjust the information of a chosen customer
		dao.adjustCust(cust);

	}

	@Override
	public void deleteInfo(String id) {
		dao.deleteInfoById(id);
	}

	@Override
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try {
			conn.setAutoCommit(false);
			for (String id : ids) {
				dao.deleteInfoByIdWithTrans(conn, id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
