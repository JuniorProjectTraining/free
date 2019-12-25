package com.zr.emss.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接数据库的工具类
*/

public class MyDBUtils {
	
	public static String dvier;
	private static String url;
	private static String username;
	private static String password;
	
	//用于存储db文件中数据的集合
	private static Properties properties = new Properties(); 
	
	/**私有化构造方法**/
	private MyDBUtils() {}
	
	static {
		try {
			//首先读取db文件
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			
			//把读取到的db文件中的数据加入到Properties集合中
			properties.load(is);
			
			//把读取到的数据赋值到程序中
			String driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
			//注册驱动
			Class.forName(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
