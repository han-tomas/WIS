package home.sist.manager;

import java.io.*;
import java.util.*;

public class MovieSystem {
	private static List<MovieVO> list = new ArrayList<MovieVO>();
	static
	{
		FileInputStream fis = null; //FileInputStream 파일 읽기
		ObjectInputStream ois = null;
		try
		{
			fis = new FileInputStream("c:\\java_datas\\DaumMovie.txt");
			ois = new ObjectInputStream(fis);
			list = (List<MovieVO>)ois.readObject();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				ois.close();
			}catch(Exception ex) {}
		}
	}
	public List<MovieVO> movieListData(int page)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		int j=0; // 20개씩 나눠주는 변수
		int rowSize = 12;
		int start =(page-1)* rowSize;
		/*
		 *    1page => 0~12
		 *    2page => 20~39
		 *    ...
		 */
		for(int i=0; i<list.size();i++)
		{
			if(j<rowSize && i>=start)
			{
				mList.add(list.get(i));
				j++;
			}
		}
		return mList;
	}
	public int movieTotalPage()
	{
		return (int)(Math.ceil(list.size())/12.0);
	}
	public List<MovieVO> movieCategoryData(int cno)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		for(MovieVO vo: list)
		{
			if(vo.getCno()==cno)
			{
				mList.add(vo);
			}
		}
		return mList;
		
	}
	public List<MovieVO> movieFindData(String title)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))
			{
				mList.add(vo);
			}
		}
		return mList;
	}
	public MovieVO movieDetailData(String title)
	{
		MovieVO vo = new MovieVO();
		for(MovieVO dvo:list)
		{
			if(dvo.getTitle().equals(title))
			{
				vo=dvo;
				break;
			}
		}
		return vo;
	}
	
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("예매순위(1) 박스오피스(2) OTT(3) : ");
			String cno = in.readLine();
			ms.movieCategoryData(Integer.parseInt(cno));
		}catch(Exception ex) {}
	}
}
