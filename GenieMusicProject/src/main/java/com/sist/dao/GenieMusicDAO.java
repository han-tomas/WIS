package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dao.*;
import com.sist.dbconn.*;
public class GenieMusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDataBase db = new CreateDataBase();
	private static GenieMusicDAO dao;
	public static GenieMusicDAO newInstance()
	{
		if(dao==null)
			dao = new GenieMusicDAO();
		return dao;
	}
	// 1. 데이터 수집
	public void genieMusicCategoryInsert(GenieCategoryVO vo)
	{
		try
		{
			conn=db.getConnection();
			/*
				private int gno,rank, idcrement;
				private String title,singer,album,state,poster; 
			 */
			String sql="INSERT INTO geniemusic_category	VALUES(gc_no_seq.nextval,?,?,?,?,?,?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, vo.getGno());
			ps.setInt(2, vo.getRank());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getSinger());
			ps.setString(5, vo.getAlbum());
			ps.setInt(6, vo.getIdcrement());
			ps.setString(7, vo.getState());
			ps.setString(8, vo.getPoster());
			ps.executeUpdate();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			db.disConnection(conn, ps);
		}
	}
	// 2. 카테고리별 목록출력
	public List<GenieCategoryVO> genieMusiceCategory()
	{
		List<GenieCategoryVO> list = new ArrayList<GenieCategoryVO>();
		try
		{
			conn=db.getConnection();
			String sql="SELECT gno,rank,title,singer,album,idcrement,state,poster "
					+ "FROM geniemusic_category ORDER BY gno ASC,rank ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				GenieCategoryVO vo = new GenieCategoryVO();
				vo.setGno(rs.getInt(1));
				vo.setRank(rs.getInt(2));
				vo.setTitle(rs.getString(3));
				vo.setSinger(rs.getString(4));
				vo.setAlbum(rs.getString(5));
				vo.setIdcrement(rs.getInt(6));
				vo.setState(rs.getString(7));
				vo.setPoster(rs.getString(8));
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
}
