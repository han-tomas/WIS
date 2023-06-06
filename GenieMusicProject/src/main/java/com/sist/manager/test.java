package com.sist.manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class test {

	public static void main(String[] args) {
		try
		{
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20230604&genrecode=M0100").get();
			Elements ranking = doc.select("td.number");
			for(int i=0;i<ranking.size();i++)
			{
				String s = ranking.get(i).text();
				s= s.substring(0,2);
				s= s.trim();
				int rank = Integer.parseInt(s);
				System.out.println(rank);
				
			}
		}catch(Exception ex) {}
		

	}

}
