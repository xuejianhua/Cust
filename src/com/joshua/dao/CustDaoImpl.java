package com.joshua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.joshua.domain.Cust;
import com.joshua.untils.DaoUtils;

public class CustDaoImpl implements CustDao {

	@Override
	public Cust findUserByName(String name) {
		String sql = "select * from customer where name=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addCust(Cust cust) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(),
					cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Cust> getAllCust() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public Cust findCustById(String id) {
		String sql = "select * from customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void adjustCust(Cust cust) {
		String sql = "update customer set name=? ,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(),
					cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription(), cust.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteInfoById(String id) {
		String sql = "delete from customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteInfoByIdWithTrans(Connection conn, String id) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn, sql, id);

	}

	@Override
	public List<Cust> findCustByBond(Cust cust) {
		String sql = "select * from customer where 1=1 ";
		List<Object> list=new ArrayList<Object>();
		if (cust.getName() != null && !"".equals(cust.getName())) {
			sql += " and name like ? ";
			list.add("%"+cust.getName()+"%");
		}
		if (cust.getGender() != null && !"".equals(cust.getGender())) {
			sql += " and gender = ? ";
			list.add(cust.getGender());
		}
		if (cust.getType() != null && !"".equals(cust.getType())) {
			sql += " and type = ? ";
			list.add(cust.getType());
		}
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
			}else{
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class),list.toArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getCountRow() {
		String sql="select count(*) from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return((Long)runner.query(sql, new ScalarHandler())).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Cust> getCustByPage(int from, int count) {
		String sql="select * from customer limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql,new BeanListHandler<Cust>(Cust.class),from,count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
