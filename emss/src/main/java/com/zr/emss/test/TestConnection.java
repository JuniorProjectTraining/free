package com.zr.emss.test;

import java.sql.Connection;
import com.zr.emss.utils.MyDBUtils;

public class TestConnection {
	
	public static void main(String[] args) {
		
		Connection connection = MyDBUtils.getConnection();
		System.out.print(connection);
	}
}
