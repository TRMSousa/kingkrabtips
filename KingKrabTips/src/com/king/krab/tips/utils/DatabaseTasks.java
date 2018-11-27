package com.king.krab.tips.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTasks {

	private static DatabaseTasks db;

	private DatabaseTasks(){ }

	public static synchronized DatabaseTasks getInstance( ) {
		if (db == null)
			db = new DatabaseTasks();
		return db;
	}
	
    public Connection getConnection(String serverName, String databaseName) throws SQLException, ClassNotFoundException {
    	Connection conn = null;
    	String attr = "user=SQLAdmin&password=Sq1@Dm1n&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    	Class.forName("com.mysql.cj.jdbc.Driver");			
    	conn = DriverManager.getConnection("jdbc:mysql://"+serverName+"/"+databaseName+"?"+attr);

    	return conn;
    }

    public void closeDatabase(Connection conn) {
    	try {
    		if (conn != null) {
				conn.close();
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(ResultSet rs) {
    	try {
    		if (rs != null) {
    			rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(PreparedStatement pstmt) {
    	try {
    		if (pstmt != null) {
    			pstmt.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(Connection conn, PreparedStatement pstmt) {
    	try {
    		if (conn != null) {
				conn.close();
    		}
    		if (pstmt != null) {
    			pstmt.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(Connection conn, ResultSet rs) {
    	try {
    		if (conn != null) {
				conn.close();
    		}
    		if (rs != null) {
    			rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(PreparedStatement pstmt, ResultSet rs) {
    	try {
    		if (pstmt != null) {
    			pstmt.close();
            }
    		if (rs != null) {
    			rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void closeDatabase(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    	try {
    		if (conn != null) {
				conn.close();
    		}
    		if (pstmt != null) {
    			pstmt.close();
            }
    		if (rs != null) {
    			rs.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
