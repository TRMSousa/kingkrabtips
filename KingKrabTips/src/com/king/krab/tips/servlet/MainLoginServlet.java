package com.king.krab.tips.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.king.krab.tips.utils.KingKrabUtils;

@WebServlet("/MainLoginServlet")
public class MainLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String GET_LOGIN_PAGE = "loginPage";

	public static final String CMD_LOGIN = "login";
	public static final String CMD_LOGOUT = "logout";
	public static final String CMD_SIGN = "sign";

	public MainLoginServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");

		String forwardPage = "";
		if(cmd.equalsIgnoreCase(GET_LOGIN_PAGE)) {
			forwardPage = getLoginPage(request, response);
		} else if(cmd.equalsIgnoreCase(CMD_LOGIN)) {
			login(request, response);
			forwardPage = getLoginPage(request, response);
		} else if(cmd.equalsIgnoreCase(CMD_LOGOUT)) {
			logout(request, response);
			forwardPage = "";
		} else if(cmd.equalsIgnoreCase(CMD_SIGN)) {
			sign(request, response);
			forwardPage = "";
		}

		request.getRequestDispatcher(forwardPage).forward(request, response);
	}

	private String getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/login.jsp";
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("form-login-user-username");
		String password = request.getParameter("form-login-user-password");

        byte[] salt;
        String passwordWithSalt = "";
		try {
			salt = KingKrabUtils.getSalt();
			passwordWithSalt = KingKrabUtils.getSecurePassword(password, salt);

			//VERIFICAR SE O UTILIZADOR E PASSWORD COMBINAM
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void sign(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("form-sign-user-first-name");
		String lastName = request.getParameter("form-sign-user-last-name");
		String email = request.getParameter("form-sign-user-username");
		String password = request.getParameter("form-sign-user-password");

		byte[] salt;
        String passwordWithSalt = "";
		try {
			salt = KingKrabUtils.getSalt();
			passwordWithSalt = KingKrabUtils.getSecurePassword(password, salt);

			//VERIFICAR SE O UTILIZADOR E PASSWORD COMBINAM
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}	
	}

}
