package com.zr.emss.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * �������ݿ�Ĺ�����
*/

public class MyDBUtils {
	
	public static String dvier;
	private static String url;
	private static String username;
	private static String password;
	
	//���ڴ洢db�ļ������ݵļ���
	private static Properties properties = new Properties(); 
	
	/**˽�л����췽��**/
	private MyDBUtils() {}
	
	static {
		try {
			//���ȶ�ȡdb�ļ�
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			
			//�Ѷ�ȡ����db�ļ��е����ݼ��뵽Properties������
			properties.load(is);
			
			//�Ѷ�ȡ�������ݸ�ֵ��������
			String driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
			//ע������
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