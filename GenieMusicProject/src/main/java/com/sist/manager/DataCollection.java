package com.sist.manager;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class DataCollection {
	public void  genieMusicCategoryData()
	{
		GenieMusicDAO dao = GenieMusicDAO.newInstance();
		try
		{
			String[] urls = {
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0100",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0200",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0300",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0107",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0500",
			         "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230502&genrecode=M0600"
		         };
			for(int i=0;i<urls.length;i++)
			{
				/*
				GNO           NOT NULL NUMBER
				RANK          NOT NULL NUMBER
				TITLE         NOT NULL VARCHAR2(50)
				SINGER        NOT NULL VARCHAR2(50)
				ALBUM         NOT NULL VARCHAR2(50)
				IDCREMENT     NOT NULL NUMBER
				STATE         NOT NULL VARCHAR2(6)
				*/
				Document doc = Jsoup.connect(urls[i]).get();
				Elements rk = doc.select("td.rank");
				Elements title = doc.select("td.info a.title");
				Elements singer = doc.select("td.info a.artist");
				Elements album = doc.select("td.info a.albumtitle");
				Elements poster = doc.select("a.cover img");
				Elements etc = doc.select("span.rank");
				for(int j=0;j<title.size();j++)
				{
					String rank = rk.get(j).text();
					rank=rank.replaceAll("[가-힣]", "");
					System.out.println("순위 : "+Integer.parseInt(rank));
					System.out.println("카테고리 번호 : "+(i+1));
					System.out.println(title.get(j).text());
					System.out.println(singer.get(j).text());
					System.out.println(album.get(j).text());
					System.out.println(poster.get(j).attr("src"));
					String ss = etc.get(j).text();
//					System.out.println(ss);
					String state ="";
					String id=""; // 등폭
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
					GenieMusicVO vo = new GenieMusicVO();
					vo.setRank(Integer.parseInt(rank));
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					
				}
			}
			
		}catch(Exception ex){}
	}
	
	public static void main(String[] args) {
		

	}

}
