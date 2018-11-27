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

public class Team {
	protected int id;
	protected int idCountry;
	protected String name; 
	protected String abbreviation; 

	public Team() {
		super();
	}

	public Team(int idCountry, String name) {
		super();
		this.idCountry = idCountry;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCountry() {
		return idCountry;
	}

	public Team setIdCountry(int idCountry) {
		this.idCountry = idCountry;
		return this;

	}

	public String getName() {
		return name;
	}

	public Team setName(String name) {
		this.name = name;
		return this;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public Team setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	
	public Team build(){
          Team oTeam = new Team();
          oTeam.idCountry = this.idCountry;
          oTeam.name = this.name;
          oTeam.abbreviation = this.abbreviation;
          return oTeam;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", idCountry=" + idCountry + ", name=" + name + ", abbreviation=" + abbreviation
				+ "]";
	}

	public static Team rowToObject(ResultSet rs) {
		Team oCountry = new Team();

		try {
			oCountry.setId(rs.getInt("ID"));
			oCountry.setIdCountry(rs.getInt("ID_COUNTRY"));
			oCountry.setName(rs.getString("NAME"));
			oCountry.setAbbreviation(rs.getString("ABBREVIATION"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static String getTableName() {
		return "TIPS_TEAMS";
	}

	///////////////
	////METODOS////
	///////////////

	public static Team insert(Team oCountry) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" INSERT INTO " + getTableName());
			SQL.append(" (ID_COUNTRY, NAME, ABBREVIATION) ");
			SQL.append(" VALUES ");
			SQL.append(" (?, ?, ?) ");

			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setInt(1, oCountry.getIdCountry());
			pstmt.setString(2, oCountry.getName());
			pstmt.setString(3, oCountry.getAbbreviation());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static List<Team> getAllActive(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		List<Team> lstTeams = new ArrayList<>();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT * FROM " + getTableName());
			SQL.append(" ORDER BY NAME ");

			pstmt = conn.prepareStatement(SQL.toString());

			rs = pstmt.executeQuery();

			Team oTeam = null;
			while(rs.next()) {
				oTeam = rowToObject(rs);
				lstTeams.add(oTeam);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstTeams;
	}

	public static List<Team> getByIdCountry(int idCountry) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		List<Team> lstTeams = new ArrayList<>();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT * FROM " + getTableName());
			SQL.append(" WHERE ID_COUNTRY = ? ");
			SQL.append(" ORDER BY NAME ");

			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setInt(1, idCountry);
			rs = pstmt.executeQuery();

			Team oTeam = null;
			while(rs.next()) {
				oTeam = rowToObject(rs);
				lstTeams.add(oTeam);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstTeams;
	}
	
}
