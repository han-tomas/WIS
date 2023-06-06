package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GenieCategoryVO;
import com.sist.dao.GenieMusicDAO;


@WebServlet("/GenieMusicCategoryServlet")
public class GenieMusicCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		GenieMusicDAO dao = GenieMusicDAO.newInstance();
		List<GenieCategoryVO> list = dao.genieMusiceCategory();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<h1>가요 TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=0;i<50;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		
		out.println("<p>");
		out.println("<h1>POP송 TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=50;i<100;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("<p>");
		out.println("<h1>OST TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=100;i<150;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("<p>");
		out.println("<h1>트롯 TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=150;i<200;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("<p>");
		out.println("<h1>JAZZ TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=200;i<250;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("<p>");
		out.println("<h1>CLASSIC TOP 50</h1>");
		out.println("<div>");
		out.println("<table>");	
		for(int i=250;i<300;i++)
		{
			GenieCategoryVO vo = list.get(i);
			out.println("<tr>");
			out.println("<td>"+vo.getRank()+"위 </td>");
			out.println("<td><img src=\""+vo.getPoster()+"\" style=\"width:20px\" \"height:20px\"></td>");	
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");			
			out.println("");
			out.println("");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");			
	}

}
