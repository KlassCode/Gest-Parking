package com.klasscode.gestPark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klasscode.gestPark.bean.CategoryBean;
import com.klasscode.gestPark.model.CategoryDao;

/**
 * Servlet implementation class Category
 */
@WebServlet("/category/*")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryDao dao;

	@Override
	public void init() throws ServletException {
		dao = new CategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = requete.getPathInfo();
		System.out.println(url);
		switch (url) {

		case "/newCategory":
			newCategoryForm(requete, response);
			break;

		case "/add":
			insertCategory(requete, response);
			break;
		
		case "/categoryList":
			listCategory(requete,response);
			break;
		}

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	private void newCategoryForm(HttpServletRequest requete, HttpServletResponse response)
			throws ServletException, IOException {
		
		requete.setAttribute("emptyField", null);
		requete.setAttribute("success", null);

		requete.getRequestDispatcher("/categoryForm.jsp").forward(requete, response);
	}

	private void insertCategory(HttpServletRequest requete, HttpServletResponse response)
			throws ServletException, IOException {

		String name = requete.getParameter("nom");
		if (name.equals("")) {
			requete.setAttribute("emptyField", "Entrer le nom de la Categorie");
			requete.getRequestDispatcher("/categoryForm.jsp").forward(requete, response);
		} else {
			dao.insert(new CategoryBean(name));
			requete.setAttribute("success", "Categorie ajoutee avec succes");
			requete.getRequestDispatcher("/categoryForm.jsp").forward(requete, response);
		}

	}
	
	private void listCategory(HttpServletRequest requete, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = requete.getSession();
		if(session.getAttribute("userConnected") != null) {
			
			List<CategoryBean> categorys = dao.selectAll();
			requete.setAttribute("listCategory",categorys);
			requete.getRequestDispatcher("/categoryList.jsp").forward(requete, response);
			
		}else {
			response.sendRedirect("login");
		}
	}
}
