package com.king.krab.tips.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.king.krab.tips.objects.Country;
import com.king.krab.tips.objects.Game;
import com.king.krab.tips.objects.Team;

@WebServlet("/FrontOfficeServlet")
public class FrontOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FrontOfficeServlet.class.getName());
	
	public static final String CMD_GET_HOMEPAGE = "getHomepage";
	public static final String CMD_GET_LEAGUE_PAGE = "getLeague";
	public static final String CMD_GET_COUNTRY_INFO = "getCountryInfo";
	
    public FrontOfficeServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
LOGGER.info("cmd || "+cmd);

		String forwardPage = "";
		if(cmd.equalsIgnoreCase(CMD_GET_HOMEPAGE)) {
			forwardPage = getHomePage(request, response);
		} else if(cmd.equalsIgnoreCase(CMD_GET_COUNTRY_INFO)) {
			getCountryInfo(request, response);
			forwardPage = getHomePage(request, response);
		} else if(cmd.equalsIgnoreCase(CMD_GET_LEAGUE_PAGE)) {
			forwardPage = getLeaguePage(request, response);
		}
		
		request.getRequestDispatcher(forwardPage).forward(request, response);
	}

	private String getLeaguePage(HttpServletRequest request, HttpServletResponse response) {
		int idCountry = request.getParameter("idCountry") == null ? 0 : Integer.parseInt(request.getParameter("idCountry"));
		int round = request.getParameter("round") == null ? 1 : Integer.parseInt(request.getParameter("round"));
		
		List<Team> lstTeams = Team.getByIdCountry(idCountry);
		List<Game> lstGames = Game.getAllByRound(round, idCountry);
		List<Country> lstCountries = Country.getAllActive();
		
		Country oCountry = Country.getObjectById(idCountry);

		request.setAttribute("nameCountry", oCountry.getName());
		request.setAttribute("lstTeams", lstTeams);
		request.setAttribute("lstGames", lstGames);
		request.setAttribute("lstCountries", lstCountries);
		return "/jsp/leagues.jsp";
	}

	private String getCountryInfo(HttpServletRequest request, HttpServletResponse response) {
		int idCountry = request.getParameter("idCountry") == null ? 0 : Integer.parseInt(request.getParameter("idCountry"));
		
		List<Team> lstTeams = Team.getAllActive();

		request.setAttribute("lstTeams", lstTeams);
		return "/jsp/leftmenu.jsp";
	}

	private String getHomePage(HttpServletRequest request, HttpServletResponse response) {
		List<Country> lstCountries = Country.getAllActive();
		List<Team> lstTeams = Team.getAllActive();
		request.setAttribute("lstCountries", lstCountries);
		request.setAttribute("lstTeams", lstTeams);
		return "/jsp/leftmenu.jsp";
	}

}
