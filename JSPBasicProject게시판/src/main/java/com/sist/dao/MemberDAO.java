package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.vo.MemberVO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static MemberDAO dao; // static => 저장공간이 한개

	// 싱글턴 처리
	public static MemberDAO newInstance()
	{
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	// 드라이버 등록
	public MemberDAO()
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
		} catch (Exception ex) {}
	}
	// 오라클 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// 로그인 처리
	public MemberVO isLogin(String id, String pwd)
	{
		MemberVO vo = new MemberVO();
		try
		{
			getConnection();
			// ID 존재여부 확인
			String sql="SELECT COUNT(*) FROM jspMember "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs =ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			
			if(count==0) // 입력된 ID가 없는 상태
			{
				vo.setMsg("NOID");
			}
			else // ID가 존재하는 상태
			{
				sql="SELECT id,name,sex,pwd "
						+ "FROM jspMember "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				rs.next();
				String db_id=rs.getString(1);
				String name=rs.getString(2);
				String sex=rs.getString(3);
				String db_pwd=rs.getString(4);
				rs.close();
				
				if(db_pwd.equals(pwd)) // 비밀번호가 같을 때
				{
					vo.setId(db_id);
					vo.setName(name);
					vo.setSex(sex);
					vo.setMsg("OK");
				}
				else // 비밀번호가 다른 경우
				{
					vo.setMsg("NOPWD");
				}
				
			}
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
