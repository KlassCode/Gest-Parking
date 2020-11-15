package com.klasscode.gestPark.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klasscode.gestPark.bean.CategoryBean;
import com.klasscode.gestPark.bean.ParkingBean;
import com.klasscode.gestPark.bean.SlotBean;
import com.klasscode.gestPark.bean.VehiculeBean;
import com.klasscode.gestPark.model.CategoryDao;
import com.klasscode.gestPark.model.DashboardDao;
import com.klasscode.gestPark.model.ParkingDao;
import com.klasscode.gestPark.model.VehiculeDao;
import com.klasscode.gestPark.utils.FunctionUtils;
import com.klasscode.gestPark.utils.RandomString;

/**
 * Servlet implementation class Vehicule
 */
@WebServlet("/vehicule/*")
public class Vehicule extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VehiculeDao vdao;
	private ParkingDao pdao;
	private CategoryDao cdao;
	private DashboardDao dashDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		vdao = new VehiculeDao();
		pdao = new ParkingDao();
		cdao = new CategoryDao();
		dashDao = new DashboardDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = request.getPathInfo();
		System.out.println(url);
		switch (url) {

		case "/newVehicule":
			showVehiculeForm(request, response);
			break;

		case "/addVehicule":
			insertVehicule(request, response);
			break;
		
		case "IncomingVehicules":
			//listIncomingVehicule(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showVehiculeForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		List<CategoryBean> categorys = cdao.selectAll();
		List<SlotBean> slots = dashDao.getAllSlots();

		request.setAttribute("categorys", categorys);
		request.setAttribute("slots", slots);
		request.setAttribute("errors", null);
		request.setAttribute("success", null);

		HttpSession session = request.getSession();
		if (session.getAttribute("userConnected") != null) {

			request.getRequestDispatcher("/vehiculeForm.jsp").forward(request, response);

		} else {
			response.sendRedirect("login");
		}
	}

	private void insertVehicule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CategoryBean> categorys = cdao.selectAll();
		List<SlotBean> slots = dashDao.getAllSlots();

		request.setAttribute("categorys", categorys);
		request.setAttribute("slots", slots);

		int idCat = Integer.parseInt(request.getParameter("listCategory"));
		int idSlot = Integer.parseInt(request.getParameter("listSlot"));
		String vehcomp = request.getParameter("vehcomp");
		String propnom = request.getParameter("propnom");
		String propmail = request.getParameter("propmail");
		String[] fields = { vehcomp, propnom, propmail };

		if (FunctionUtils.checkEmptyFields(fields)) {

			request.setAttribute("errors", "Remplissez les champs correctement");
			request.getRequestDispatcher("/vehiculeForm.jsp").forward(request, response);
		} else {
			CategoryBean category = new CategoryBean();
			category.setId(idCat);
			SlotBean slot = new SlotBean();
			slot.setId(idSlot);

			try {
				vdao.insert(new VehiculeBean(category, slot, vehcomp, propnom, propmail, true));
				int lastveh = vdao.lastInsert();

				VehiculeBean vehicule = new VehiculeBean();
				vehicule.setId(lastveh);
				RandomString gen = new RandomString(8, ThreadLocalRandom.current());

				if (lastveh != 0) {
					ParkingBean pb = new ParkingBean(vehicule, gen.nextString(), new Date(), "in", 0.0d, null);
					System.out.println(pb.toString());
					pdao.insert(pb);

					request.setAttribute("success", vehcomp + " ajoute dans le parking");

				}
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
//				request.setAttribute("errors", "Erreur Insertion");
			}
			request.getRequestDispatcher("/vehiculeForm.jsp").forward(request, response);
		}

	}
//	private void listIncomingVehicule(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		if(session.getAttribute("userConnected") != null) {
//			
//			List<VehiculeBean> vehicules = vdao.selectIncomingVehicule();
//			request.setAttribute("IncomVehicules",vehicules);
//			request.getRequestDispatcher("/listVehiculeForm.jsp");
//		}else {
//			response.sendRedirect("../login");
//		}
//	}
}
