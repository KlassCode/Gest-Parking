package com.klasscode.gestPark.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klasscode.gestPark.bean.SlotBean;
import com.klasscode.gestPark.model.DashboardDao;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DashboardDao dashDao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		dashDao = new DashboardDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("slotMesg", null);
		if(dashDao.getAvailableSlot() != 0) {
			int nb = dashDao.getAvailableSlot();
			request.setAttribute("avslot", nb);
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("userConnected") != null)
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subType = request.getParameter("addSlot");
		if (subType != null) {
			int slotNo = Integer.parseInt(request.getParameter("slotNo"));
			SlotBean slot = new SlotBean();
			slot.setNoSlot(slotNo);
			slot.setDispo(true);
			if (dashDao.checkExistSlot(slotNo)) {
				request.setAttribute("slotMesg", "Numero de Place deja Ajoute");
			} else {
				dashDao.addSlot(slot);
				request.setAttribute("slotMesg", "yes");
				int nb = dashDao.getAvailableSlot();
				request.setAttribute("avslot", nb);
			}
			
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}
	}

}
