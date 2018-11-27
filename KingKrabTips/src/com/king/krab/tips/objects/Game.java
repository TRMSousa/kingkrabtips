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

public class Game {
	protected int id;
	protected int idHomeTeam;
	protected int idAwayTeam;
	protected int idSeason;
	protected int round;

	protected String nameHomeTeam;
	protected String nameAwayTeam;
	protected String homeAbbreviation;
	protected String awayAbbreviation;
	
	
	public Game() {
		super();
	}

	public Game(int id, int idHomeTeam, int idAwayTeam, int idSeason, int round, String nameHomeTeam,
			String nameAwayTeam, String homeAbbreviation, String awayAbbreviation) {
		super();
		this.id = id;
		this.idHomeTeam = idHomeTeam;
		this.idAwayTeam = idAwayTeam;
		this.idSeason = idSeason;
		this.round = round;
		this.nameHomeTeam = nameHomeTeam;
		this.nameAwayTeam = nameAwayTeam;
		this.homeAbbreviation = homeAbbreviation;
		this.awayAbbreviation = awayAbbreviation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdHomeTeam() {
		return idHomeTeam;
	}

	public Game setIdHomeTeam(int idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
		return this;
	}

	public int getIdAwayTeam() {
		return idAwayTeam;
	}

	public Game setIdAwayTeam(int idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
		return this;
	}

	public int getIdSeason() {
		return idSeason;
	}

	public Game setIdSeason(int idSeason) {
		this.idSeason = idSeason;
		return this;
	}

	public int getRound() {
		return round;
	}

	public Game setRound(int round) {
		this.round = round;
		return this;
	}

	public String getNameHomeTeam() {
		return nameHomeTeam;
	}

	public void setNameHomeTeam(String nameHomeTeam) {
		this.nameHomeTeam = nameHomeTeam;
	}

	public String getNameAwayTeam() {
		return nameAwayTeam;
	}

	public void setNameAwayTeam(String nameAwayTeam) {
		this.nameAwayTeam = nameAwayTeam;
	}
	
	public String getHomeAbbreviation() {
		return homeAbbreviation;
	}

	public void setHomeAbbreviation(String homeAbbreviation) {
		this.homeAbbreviation = homeAbbreviation;
	}

	public String getAwayAbbreviation() {
		return awayAbbreviation;
	}

	public void setAwayAbbreviation(String awayAbbreviation) {
		this.awayAbbreviation = awayAbbreviation;
	}

	public Game build(){
          Game oTeam = new Game();
          oTeam.id = this.id;
          oTeam.idHomeTeam = this.idHomeTeam;
          oTeam.idAwayTeam = this.idAwayTeam;
          oTeam.idSeason = this.idSeason;
          oTeam.round = this.round;
          oTeam.homeAbbreviation = this.homeAbbreviation;
          oTeam.awayAbbreviation = this.awayAbbreviation;
          return oTeam;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", idHomeTeam=" + idHomeTeam + ", idAwayTeam=" + idAwayTeam + ", idSeason=" + idSeason
				+ ", round=" + round + "]";
	}

	public static Game rowToObject(ResultSet rs) {
		Game oCountry = new Game();

		try {
			oCountry.setId(rs.getInt("ID"));
			oCountry.setIdHomeTeam(rs.getInt("ID_HOME_TEAM"));
			oCountry.setIdAwayTeam(rs.getInt("ID_AWAY_TEAM"));
			oCountry.setIdSeason(rs.getInt("ID_SEASON"));
			oCountry.setRound(rs.getInt("ROUND"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static String getTableName() {
		return "GAMES";
	}

	///////////////
	////METODOS////
	///////////////

	public static Game insert(Game oCountry) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" INSERT INTO " + getTableName());
			SQL.append(" (ID_HOME_TEAM,ID_AWAY_TEAM,ID_SEASON,ROUND) ");
			SQL.append(" VALUES ");
			SQL.append(" (?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setInt(1, oCountry.getIdHomeTeam());
			pstmt.setInt(2, oCountry.getIdAwayTeam());
			pstmt.setInt(3, oCountry.getIdSeason());
			pstmt.setInt(4, oCountry.getRound());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return oCountry;
	}
	
	public static List<Game> getAllActive(){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		List<Game> lstTeams = new ArrayList<>();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT * FROM " + getTableName());
			SQL.append(" ORDER BY NAME ");

			pstmt = conn.prepareStatement(SQL.toString());

			rs = pstmt.executeQuery();

			Game oTeam = null;
			while(rs.next()) {
				oTeam = rowToObject(rs);
				lstTeams.add(oTeam);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstTeams;
	}

	public static List<Game> getAllByRound(int round, int idCountry){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer SQL = new StringBuffer("");

		List<Game> lstTeams = new ArrayList<>();

		try {
			conn = DatabaseTasks.getInstance().getConnection(ApplicationConfiguration.SERVER_NAME, ApplicationConfiguration.DATASOURCE_TIPS);

			SQL.append(" SELECT G.*, TH.NAME  AS 'NAME_HOME_TEAM',TA.NAME  AS 'NAME_AWAY_TEAM', TH.ABBREVIATION AS 'HOME_ABBREVIATION', TA.ABBREVIATION AS 'AWAY_ABBREVIATION' FROM " + getTableName() + " G ");
			SQL.append(" INNER JOIN TIPS_TEAMS TH ON G.ID_HOME_TEAM = TH.ID ");
			SQL.append(" INNER JOIN TIPS_TEAMS TA ON G.ID_AWAY_TEAM = TA.ID ");
			SQL.append(" INNER JOIN SEASON S ON G.ID_SEASON = S.ID ");
			SQL.append(" INNER JOIN TIPS_COUNTRY TC ON TH.ID_COUNTRY = TC.ID ");
			SQL.append(" WHERE G.ROUND = ? AND TC.ID = ? ");
			SQL.append(" ORDER BY S.YEARS, G.ROUND ");
			
			System.out.println(SQL.toString());
			
			pstmt = conn.prepareStatement(SQL.toString());
			pstmt.setInt(1, round);
			pstmt.setInt(2, idCountry);

			rs = pstmt.executeQuery();

			Game oTeam = null;
			while(rs.next()) {
				oTeam = rowToObject(rs);
				oTeam.setNameHomeTeam(rs.getString("NAME_HOME_TEAM"));
				oTeam.setNameAwayTeam(rs.getString("NAME_AWAY_TEAM"));
				oTeam.setHomeAbbreviation(rs.getString("HOME_ABBREVIATION"));
				oTeam.setAwayAbbreviation(rs.getString("AWAY_ABBREVIATION"));
				lstTeams.add(oTeam);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lstTeams;
	}
	
}
