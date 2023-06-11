package com.sist.manager;
import java.util.*;
import java.util.regex.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class DataCollection {
	public void travelData() 
	{
		try
		{
			String[] urls = new String[21];
			int k=0;
			for(int i=0;i<21;i++)
			{
				urls[i]= "http://www.jejutori.com/CS/TourInfo/index.aspx?page="+(i+1);
			}
			for(int i=0;i<urls.length;i++)
			{
				Document doc = Jsoup.connect(urls[i]).get();
				Elements title= doc.select("h1.ttlGoodsList");
				Elements subject = doc.select("td.ListRoundBox_m");
				for(int j=0;j<title.size();j++)
				{
					System.out.println(k);
					System.out.println(title.get(j).text());
					String s = subject.get(j).text();
					String location="";
					String duration="";
					Pattern locationPattern = Pattern.compile("위치 : ([^ ]+)");
			        Matcher locationMatcher = locationPattern.matcher(s);
			        if (locationMatcher.find()) {
			            location = locationMatcher.group(1);
			            System.out.println("위치: " + location);
			        }

			        // 관람 소요 시간 추출
			        Pattern durationPattern = Pattern.compile("관람소요시간 : ([^ ]+)");
			        Matcher durationMatcher = durationPattern.matcher(s);
			        if (durationMatcher.find()) {
			            duration = durationMatcher.group(1);
			            System.out.println("관람 소요 시간: " + duration);
			        }
			        else 
			        {
			        	duration="x";
			        	 System.out.println("관람 소요 시간: " + duration);
			        }
			        System.out.println("==================");
			        TravelVO vo = new TravelVO();
			        vo.setNo(k);
			        vo.setTitle(title.get(j).text());
			        vo.setLocation(location);
			        vo.setDuration(duration);
			        k++;
				}
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataCollection dc = new DataCollection();
		dc.travelData();
	}

}
