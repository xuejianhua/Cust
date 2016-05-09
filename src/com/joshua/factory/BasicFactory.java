package com.joshua.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.joshua.dao.CustDao;

public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;

	private BasicFactory() {
	}

	static {
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static BasicFactory getFactory() {
		return factory;
	}
	//运用这样的方法将getDao与getService合在了一起写
	public <T> T getInstance(Class<T> clazz) {
		try {
			String cName = clazz.getSimpleName();
			String cImplName = prop.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	// public CustDao getDao() {
	// try {
	// String clazz = prop.getProperty("CustDao");
	// return (CustDao) Class.forName(clazz).newInstance();
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new RuntimeException();
	// }
	// }
}
