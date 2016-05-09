package com.joshua.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joshua.domain.Cust;
import com.joshua.factory.BasicFactory;
import com.joshua.service.CustService;

/**
 * Servlet implementation class CustInfoServlet
 */
@WebServlet("/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustService service=BasicFactory.getFactory().getInstance(CustService.class);
		//get the id of customer you want to change
		String id=request.getParameter("id");
		
		//use methods from service to find this customer
		Cust cust=service.findById(id);
		if(cust==null){
			throw new RuntimeException("can not find this customer!");
		}
		//put all the information you get into request, and dispatch the request into updateInfo.jsp
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
