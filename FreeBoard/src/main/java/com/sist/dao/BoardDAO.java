package com.sist.dao;
import java.util.*;
import java.sql.*;
public class BoardDAO {
	// 연결 객체
	private Connection conn;
	// 송수신 객체(오라클(SQL문장 전송), 실행 결과값을 읽어온다)
	private PreparedStatement ps;
	// 모든 사용자가 1개의 DAO만 사용할 수 있게 만든다(싱글턴)
	private static BoardDAO dao;
	// 오라클 연결 주소 => 상수형
	private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public BoardDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	/* 싱글턴 : 특정 클래스의 인스턴스가 오직 하나만 존재하도록 보장하는 방법
	 * 		  해당 클래스의 객체를 전역적으로 접근 가능하며, 
	 * 		  여러 곳에서 동시에 동일한 인스턴스를 참조할 수 있습니다.
	 * 	1. 생성자를 private으로 선언하여 외부에서의 인스턴스 생성을 막습니다.
	 *	2. 클래스 내부에 private static 변수로 해당 클래스의 유일한 인스턴스를 저장합니다.
	 *	3. public static 메서드를 통해 클래스의 유일한 인스턴스에 접근할 수 있도록 합니다. 
	 *	   이 메서드는 인스턴스가 존재하지 않을 경우에만 인스턴스를 생성하고 반환합니다.
	 */
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	
	// 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			/*
			 * 	DriverManager : JDBC 드라이버를 관리하고 데이터베이스 연결을 관리하는 클래스
			 *  getConnection() : getConnection() 메서드는 데이터베이스에 연결하기 위한 메서드
			 */
		}catch(Exception ex) {}
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
	//============================================== 필수 : 클래스화
	
	
	// 기능
	// 1. 목록 출력 => 페이지 나누기(인라인뷰를 이용)
	/*
	 *  인라인뷰: 서브쿼리가 일시적으로 만드는 가상의 테이블 
 	 *		    메인쿼리가 일시적으로 참조하고 활용할수있도록 하는 가상의 테이블
 	 *			SELECT ... FROM(SELCET ...)
 	 *							---------- 서브쿼리
	 */
	public List<BoardVO> boardListData(int page) // 한페이지에 여러 데이터 출력 => List
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		try 
		{
			// 오라클 연결
			getConnection();
			// SQL 문장 생성
			String sql = "SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum AS num "  
					+"FROM (SELECT no,subject,name,regdate,hit "
					+"FROM freeboard ORDER BY no DESC)) "
				    +"WHERE num BETWEEN ? AND ?";
			/*
			 *  rownum은 중간에서 데이터를 추출할 수 없으므로 서브쿼리에서 선언하여 num이라는 별칭을 주고,
			 *  BETWEEN 'num' and 'num' 형식으로 중간 순서의 게시물을 추출할수 있도록 한다.
			 *  가장 최신 게시물은 no값이 높고, 이를 내림차순으로 추출하여 
			 *  no값이 높은=> 최신의 게시물을 맨 처음에 추출할수 있도록 한다.
			 */
			
			// SQL 문장 전송
			ps=conn.prepareStatement(sql);
			
			// 사용자가 요청한 데이터를 첨부한다
			// 그 이전에 ?에 값을 채운다
			int rowSize=10; //게시글 10개씩 추출하기 위함이다.
			int start = (page*rowSize)-(rowSize-1);
			int end = page*rowSize;
			ps.setInt(1, start);
			ps.setInt(2, end);
			/*
			 *  1page 1~10
			 *  2page 11~10
			 *  3page 21~30
			 *  ...
			 */
			ResultSet rs = ps.executeQuery();
			/*	executeQuery(): 주로 데이터베이스로부터 데이터를 검색하고 조회할 때 사용됩니다.
			 * 					 SELECT 문을 실행하여 결과를 가져오는 데 사용됩니다.
			 *  ResultSet : 쿼리 실행 결과를 나타내는 객체
			 *  			SELECT 쿼리를 실행하여 결과 집합을 가져올 때 사용
			 *  ResultSet 객체는 결과 집합의 행을 하나씩 차례대로 접근할 수 있다.
			 *  next() 메서드를 사용하여 다음 행으로 이동
			 *     => while 루프와 next() 메서드를 함께 사용하여 
			 *  	  결과 집합의 모든 행을 반복하면서 데이터를 처리할 수 있습니다.
			 */
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();/* 결과 집합이 클 경우 메모리 부하가 발생할 수 있기 때문에 
						* close()메소드를 수행하여 자원을 해제하는것이 좋음.
						*/
			
		}catch(Exception ex)
		{
			ex.printStackTrace(); //에러 확인
		}
		finally // 반드시 수행
		{
			// 오라클 연결 해제
			disConnection();
		}
		return list;		
	}
	// 1-1. 총 페이지 구하기(목록출력)
	public int boardTotalPage()
	{	
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM freeboard";
			// 43개의 게시물 10개씩 1페이지 : 43/10.0 = 4.3page=> (올림) 5page
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next(); //값이 출력되어 있는 위치에 커서를 이동
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	
	// 2. 상세보기 => 조회수 증가(UPDATE), 상세볼 게시물 읽기(SELECT)
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		try
		{
			getConnection();
			String sql = "UPDATE freeboard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			// UPDATE 테이블명 SET (수정할)컬럼명=(원하는)값 WHERE(조건문)...
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			/* executeUpdate(): 주로 데이터베이스의 데이터를 변경, 추가, 삭제하는 등의
			 * 				    작업을 수행할 때 사용됩니다. INSERT, UPDATE, DELETE 문 
			 * 				    등을 실행하여 데이터베이스를 수정하는 데 사용됩니다.
			 */
			sql="SELECT no,name,subject,content,"
					   +"TO_CHAR(regdate,'yyyy-MM-dd'),hit "
					   +"FROM freeboard "
					   +"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
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
	// 3.게시물 등록 => INSERT
	public void boardInsert(BoardVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO freeboard(no,name,subject,content,pwd) "
					  +"VALUES(fb_no_seq.nextval,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			// 실행 요청전에 ?에 값을 채운다 
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			// 실행 
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	// 4. 게시물 수정(UPDATE) => 먼저 입력된 게시물 읽고, 수정(비밀번호 검색)
	// 입력된 게시물 읽기
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			getConnection();
			String sql="SELECT no,name,subject,content,"
			   +"TO_CHAR(regdate,'yyyy-MM-dd'),hit "
			   +"FROM freeboard "
			   +"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
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
	// 비밀번호 확인후, 맞으면 수정
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false; // 비밀번호 => 본인 여부 확인 
		try
		{
			getConnection();
			String sql="SELECT pwd FROM freeboard "
					  +"WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd()))
			{
				bCheck=true;
				// 수정
				sql="UPDATE freeboard SET "
				   +"name=?,subject=?,content=? "
				   +"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				ps.executeUpdate();
				
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return bCheck;
	}
	// 5. 삭제(DELETE) => 비밀번호 검색
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck=false; // 비밀번호 => 본인 여부 확인 
		try
		{
			getConnection();
			String sql="SELECT pwd FROM freeboard "
					  +"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			//=============================> SELECT를 이용하여 비밀번호 추출후 비교
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				// 삭제 
				sql="DELETE FROM freeboard "
				   +"WHERE no="+no;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
				
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return bCheck;
	}
	
}
