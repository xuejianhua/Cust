package com.joshua.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.joshua.untils.DaoUtils;

public class AddTest {
	@Test
	public void addCustomers() throws SQLException {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";

		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		for(int i=0;i<30;i++){
			runner.update(sql,"name"+i,"male","1994-1-1","13333","55555","swimming","vip","dddsdfsfdsfs");
		}
	}
}
