package com.sist.servlet;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.sist.dao.*;

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 변환 => 전송 (HTML,XML,JSON)
		// 브라우저로 미리 알려준다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 사용자가 request한 페이지를 받는다
												// ?요청한값=
		String strPage=request.getParameter("page"); 
		/*
		 *  getParameter()  클라이언트로부터 전달된 HTTP 요청의 매개변수(parameter) 값을 가져오는 데 사용
		 */
		if(strPage==null)
			strPage="1"; // default값 => 설정하지 않으면 500 오류
		int curpage=Integer.parseInt(strPage); // curpage 현재 페이지
		
		BoardDAO dao = BoardDAO.newInstance();
		List<BoardVO> list = dao.boardListData(curpage); // curpage 리스트 불러오기
		
		// 총페이지 받기
		int totalpage=dao.boardTotalPage(); 
		
		out.println("<html>");
		out.println("<head>");
		/*  <head>
		 *   웹 페이지의 설정과 메타데이터를 정의하여 검색 엔진 최적화(SEO),
		 *   스타일링, 외부 리소스 로드, 스크립트 연결 등을 관리하는 데 사용
		 */
		out.println("<link rel=stylesheet href=html/table.css>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>자유 게시판</h1>");
		out.println("<table width=700 class=table_content>");
		out.println("<tr>"); // <tr>은 행
		out.println("<td>"); // <td>는 셀
		out.println("<a href=BoardInsertServlet>새글</a>");
		/*
		 * <a> : 사용자가 클릭하면 다른 웹 페이지, 문서, 위치, 파일 또는 URL로 이동하도록 합니다.
		 * href: <a> 태그의 필수 속성으로, 클릭 시 이동하고자 하는 대상의 URL을 지정합니다.
		 * 		 대상 URL은 절대 경로나 상대 경로로 지정할 수 있습니다.
		 */
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table width=700 class=table_content>");
		out.println("<tr>");
		out.println("<th width=10%>번호</th>"); // <th> table header 제목
		out.println("<th width=45%>제목</th>");
		out.println("<th width=15%>이름</th>");
		out.println("<th width=20%>작성일</th>");
		out.println("<th width=10%>조회수</th>");
		out.println("</tr>");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		for(BoardVO vo:list)
		{
			out.println("<tr class=dataTr>"); // table.css 파일에서 dataTr 클래스를 커서를 갖다대면 yellow색으로 되도록 설정함
			out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
			out.println("<td width=45%><a href=BoardDetailServlet?no="+vo.getNo()+">"+vo.getSubject()+"</a>");
			if(today.equals(vo.getDbday()))
			{
				out.println("&nbsp;<sup style=\"color:red\">new</sup>");
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+vo.getName()+"</td>");
			out.println("<td width=20% align=center>"+vo.getDbday()+"</td>");
			out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan=5 align=center>");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">이전</a>");
		out.println(curpage+" page / "+totalpage+ " pages");
		out.println("<a href=BoardListServlet?page="+(curpage<totalpage?curpage+1:curpage)+">다음</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
