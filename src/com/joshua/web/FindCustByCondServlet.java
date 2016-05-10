package com.joshua.web;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FindCustByCondServlet
 */
@WebServlet("/FindCustByCondServlet")
public class FindCustByCondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCustByCondServlet() {
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
		try {
			CustService service=BasicFactory.getFactory().getInstance(CustService.class);
			//获取查询条件封装到bean中
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//调用service中插叙客户的方法，找出符合条件的客户
			List<Cust> list=service.findCustByCond(cust);
			//将找到的客户放到request域中， 带到custlist.jsp页面中展示
			request.setAttribute("list", list);
			request.getRequestDispatcher("/custList.jsp").forward(request, response);
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
