package com.king.krab.tips.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectTasks {

	public static List<Object> getAll(String serverName, String databaseName, String tableName, String orderBy){
		List<Object> lstObject = new ArrayList<>();
		StringBuffer SQL = new StringBuffer("");
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		ResultSetMetaData rsMetaData = null;
		try {
			conn = DatabaseTasks.getInstance().getConnection(serverName, databaseName);
			
			SQL.append(" SELECT * FROM "+tableName);
			SQL.append(" ORDER BY "+orderBy);

			pstmt = conn.prepareStatement(SQL.toString());

			rs = pstmt.executeQuery();
			rsMetaData = rs.getMetaData();
			
			
			System.out.println(rs.toString());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstObject;
	}
	
	
}
