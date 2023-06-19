package com.sist.dao;

import java.util.*;
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static MemberDAO dao;
	public static MemberDAO newInstance()
	{
		if(dao==null)
			dao = new MemberDAO();
		return dao;
	}
	public MemberDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
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
			if(conn!=null)conn.close();
		}catch(Exception ex) {}	
	}
	
	// 기능
	public List<ZipcodeVO> postFind(String dong)
	{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		try
		{
			getConnection();
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					+ "FROM zipcode WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ZipcodeVO vo = new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			rs.close();
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
	public int postFindCount(String dong)
	{
		int count = 0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM zipcode WHERE dong Like '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return count;
	}
}
