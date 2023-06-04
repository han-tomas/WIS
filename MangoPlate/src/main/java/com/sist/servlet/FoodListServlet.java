package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.sist.dao.*;


@WebServlet("/FoodListServlet")
public class FoodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String cno = request.getParameter("cno");
		FoodDAO dao = FoodDAO.newInstance();
		List<FoodVO> list = dao.food_category_data(Integer.parseInt(cno));
		CategoryVO cvo=dao.food_category_info(Integer.parseInt(cno));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style>");
		out.println(".container{margin-top:50px}");
		out.println(".row{");
		out.println("margin:0px auto;"); // 가운데 정렬
		out.println("width:1024px}</style>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<div class=row>");
		out.println("<div class=jumbotron>");
		out.println("<center>");
		out.println("<h3>"+cvo.getTitle()+"</h3>");
		out.println("<h4>"+cvo.getSubject()+"</h4>");
		out.println("</center>");
		out.println("</div>");
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<td>");
		for(FoodVO vo:list)
		{
			out.println("<table class=table>");
			out.println("<tr>");
			out.println("<td width=30% align=center rowspan=4>");
			out.println("<img src="+vo.getPoster()+" class=img-rounded style=\"width:240px; height:200px\">");
			out.println("</td>");
			out.println("<td width=70%>");
			out.println(vo.getName()+"&nbsp;<span style=\"color:orange\">"+vo.getScore()+"</span>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width=70%>");
			out.println(vo.getAddress());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width=70%>");
			out.println(vo.getPhone());
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width=70%>");
			out.println(vo.getType());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
