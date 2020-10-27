package com.klasscode.gestPark.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klasscode.gestPark.bean.LoginBean;
import com.klasscode.gestPark.model.LoginDao;
import com.klasscode.gestPark.utils.FunctionUtils;
import com.klasscode.gestPark.utils.Security;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		loginDao = new LoginDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		
		if (user!=null)
			request.setAttribute("username",user);
		
		request.setAttribute("error", null);
		request.setAttribute("emptyField", null);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String[] fields = {userName,password};
		
		
		if(FunctionUtils.checkEmptyFields(fields)) {
			
			request.setAttribute("emptyField","Remplissez correctement les champs");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			LoginBean lb = new LoginBean(userName,Security.encrypt(password));
			System.out.println();
			//proceder a la connexion avec jdbc
			if(loginDao.validate(lb)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userConnected", lb);
				response.sendRedirect("/dashboard");
				
			}else {
				request.setAttribute("error","Identifiant/Password incorrect");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
