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
}
