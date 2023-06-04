package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbconn.*;
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db = new CreateDataBase();
	private static BoardDAO dao;
	
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	
	// 기능
	// 1. 페이지 목록 출력
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		try 
		{	
			conn=db.getConnection();
			String sql="SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD'),hit, num "
					+ "FROM(SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD'),hit rownum AS num "
					+ "FRPM(SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD'),hit "
					+ "FROM freeboard ORDER BY no DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize = 10;
			int start = (page*rowSize)-(rowSize-1);
			int end = page*rowSize;
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return list;
	}
	// 1-1. 총페이지 구하기
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			conn=db.getConnection();
			String sql = "SELECT CEIL(COUNT(*)/10.0) "
					+ "FROM freeboard";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return total;
	}
	// 2. 상세보기 => 조회수 증가(UPDATE), 상세볼 게시물 읽기(SELECT)
	public BoardVO BoardDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		try
		{
			conn=db.getConnection();
			String sql = "";
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
		return vo;
	}
}
