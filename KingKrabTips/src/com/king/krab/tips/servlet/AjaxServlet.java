package com.king.krab.tips.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.king.krab.tips.objects.Game;
import com.king.krab.tips.objects.Team;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AjaxServlet.class.getName());

	public static final String CMD_GET_GAME_ROUND = "getGameRound";
	
    public AjaxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
LOGGER.info("cmd || "+cmd);

		if(cmd.equalsIgnoreCase(CMD_GET_GAME_ROUND)) {
			getGameRound(request, response);
		} 
	
	}

	private void getGameRound(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int round = request.getParameter("round") == null ? 1 : Integer.parseInt(request.getParameter("round"));
		
		List<Game> lstGames = Game.getAllByRound(round, 0);

		Gson gson = new GsonBuilder().create();
		gson.toJson(lstGames);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(gson);
		out.flush();
	}

}
