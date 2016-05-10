package com.joshua.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.joshua.domain.Page;
import com.joshua.factory.BasicFactory;
import com.joshua.service.CustService;

/**
 * Servlet implementation class CustPageServlet
 */
@WebServlet("/CustPageServlet")
public class CustPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		//获取当前要显示的页和每页记录数
		int thisPage=Integer.parseInt(request.getParameter("thisPage"));
		int rowPerPage=5;
		//调用service中分页查询客户的方法，查找出客户信息
		Page page=service.pageCust(thisPage,rowPerPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pageList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
