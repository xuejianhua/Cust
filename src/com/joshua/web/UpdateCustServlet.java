package com.joshua.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.joshua.domain.Cust;
import com.joshua.factory.BasicFactory;
import com.joshua.service.CustService;

/**
 * Servlet implementation class UpdateCustServlet
 */
@WebServlet("/UpdateCustServlet")
public class UpdateCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		try {
			// pack the data and check the data
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());

			String[] prefs = request.getParameterValues("preference");
			StringBuilder sb = new StringBuilder();
			for (String pref : prefs) {
				sb.append(pref).append(",");
			}
			String pref = sb.substring(0, sb.length() - 1);
			cust.setPreference(pref);
			// use method from service to adjust the info
			service.adjustInfo(cust);
			// redirect to custList.jsp
			// response.sendRedirect(request.getContextPath()+"/custList.jsp");
			request.getRequestDispatcher("CustListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
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

}
