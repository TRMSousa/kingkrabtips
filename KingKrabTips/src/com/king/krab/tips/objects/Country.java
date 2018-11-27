package com.king.krab.tips.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.king.krab.tips.initialization.ApplicationConfiguration;
import com.king.krab.tips.utils.DatabaseTasks;

public class Country {
	protected int id;
	protected String name; 
	protected String abbreviation;

	public Country() {
		super();
	}

	public Country(String name, String abbreviation) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Country setName(String name) {
		this.name = name;
		return this;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public Country setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}

	public Country build(){
          Country oCountry = new Country();
          oCountry.name = this.name;
          oCountry.abbreviation = this.abbreviation;
          return oCountry;
	}
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}

	public static Country rowToObject(ResultSet rs) {
		Country oCountry = new Country();

		try {
			oCountry.setId(rs.getInt("ID"));
			oCountry.setName(rs.getString("NAME"));
			oCountry.setAbbreviation(rs.getString("ABREVIATION"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static String getTableName() {
		return "TIPS_COUNTRY";
	}

	///////////////
	////METODOS////
	///////////////

	public static Country insert(Country oCountry) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" INSERT INTO TIPS_COUNTRY ");
			SQL.append(" (NAME, ABREVIATION) ");
			SQL.append(" VALUES ");
			SQL.append(" (?, ?) ");

			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setString(1, oCountry.getName());
			pstmt.setString(2, oCountry.getAbbreviation());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static List<Country> getAllActive(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		List<Country> lstCountry = new ArrayList<>();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT * FROM " + getTableName());
			SQL.append(" ORDER BY NAME ");

			pstmt = conn.prepareStatement(SQL.toString());

			rs = pstmt.executeQuery();

			Country oCountry = null;
			while(rs.next()) {
				oCountry = rowToObject(rs);
				lstCountry.add(oCountry);
			}

			System.out.println("1:"+lstCountry.size());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstCountry;
	}

	public static Country getObjectById(int idCountry) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");
		Country oCountry = new Country();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT * FROM " + getTableName());
			SQL.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setInt(1, idCountry);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				oCountry = rowToObject(rs);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
}
