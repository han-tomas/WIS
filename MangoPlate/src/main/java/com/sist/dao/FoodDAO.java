package com.sist.dao;
import java.util.*;
import java.sql.*;

public class FoodDAO {
	// 연결 객체
	private Connection conn;
	// 송수신
	private PreparedStatement ps;
	// 오라클 URL 주소 설정
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	// 싱글턴
	private static FoodDAO dao;
	
	// 드라이버 등록
	public FoodDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// 싱글턴 설정
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	// 기능
	// 1. 카테고리 출력
	public List<CategoryVO> food_category_list()
	{
		List<CategoryVO> list=new ArrayList<CategoryVO>();
		try
		{
			getConnection();
			String sql="SELECT cno,title,subject,poster "
					  +"FROM food_category "
					  +"ORDER BY cno ASC";
			//String sql="SELECT /*+ INDEX_ASC(food_category fc_cno_pk)*/cno,title,subject,poster "
		    // +"FROM food_category";
			// => 자동 (PRIMARY,UNIQUE)
			//String sql="SELECT --+ INDEX_ASC(food_category fc_cno_pk) cno,title,subject,poster "
		    // +"FROM food_category";
			// => 자동 (PRIMARY,UNIQUE)
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CategoryVO vo=new CategoryVO();
				vo.setCno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setPoster(rs.getString(4));
				list.add(vo);
			}
			rs.close();
			// list=> 받아서 브라우저로 전송 실행 
			//             ------------ Servlet , JSP
			//             Spring => Servlet => DispatcherServlet
			// 사용가능한 언어 : Java,JSP,Spring,HTML,JavaScript
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	public CategoryVO food_category_info(int cno)
	{
		CategoryVO vo = new CategoryVO();
		try
		{
			getConnection();
			String sql ="SELECT title,subject FROM food_category "
					  +"WHERE cno="+cno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setTitle(rs.getString(1));
			vo.setSubject(rs.getString(2));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
}
