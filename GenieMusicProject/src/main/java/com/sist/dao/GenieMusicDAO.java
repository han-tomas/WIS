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
	
}
