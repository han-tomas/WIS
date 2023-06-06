package com.sist.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class DataCollection {
	public void GenieMusicGenreData()
	{
		GenieMusicDAO dao = GenieMusicDAO.newInstance();
		try
		{
			String[] urls = {
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230604&genrecode=M0100",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0200",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0300",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0107",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0500",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0600"
		         };
			for(int i=0;i<urls.length;i++)
			{
				/*
				  	private int gno,rank, idcrement;
					private String title,singer,album,state,poster;
				 */
				Document doc = Jsoup.connect(urls[i]).get();
				Elements ranking = doc.select("td.number");
				Elements title = doc.select("table.list-wrap td.info a.title");
				Elements singer = doc.select("table.list-wrap td.info a.artist");
				Elements album = doc.select("table.list-wrap td.info a.albumtitle");
				Elements poster = doc.select("table.list-wrap a.cover img");
				Elements etc = doc.select("table.list-wrap span.rank");
				for(int j=0;j<title.size();j++)
				{
					String s = ranking.get(j).text();
					s= s.substring(0,2);
					s= s.trim();
					int rank = Integer.parseInt(s);
					System.out.println("순위 : "+rank);
					System.out.println("카테고리 번호 : "+(i+1));
					System.out.println(title.get(j).text());
					System.out.println(singer.get(j).text());
					System.out.println(album.get(j).text());
					System.out.println(poster.get(j).attr("src"));
					String ss = etc.get(j).text();
					String state ="";
					String id="";
					if(ss.contains("유지"))
					{
						state="유지";
						id="0";
					}
					else if(ss.contains("new"))
					{
						state="NEW";
						id="0";
					}
					//4상승
					else
					{
						state= ss.replaceAll("[0-9]", ""); // 상승
						id=ss.replaceAll("[가-힣]", ""); // 4
					}
					System.out.println("상태 : "+state);
					System.out.println("등폭 : "+id);
					System.out.println("=================================");
					GenieCategoryVO vo = new GenieCategoryVO();
					vo.setGno(i+1);
					vo.setRank(rank);
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setAlbum(album.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcrement(Integer.parseInt(id));
					dao.genieMusicCategoryInsert(vo);
					
				}
				System.out.println("저장완료");
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		DataCollection dc = new DataCollection();
		dc.GenieMusicGenreData();
	}

}
