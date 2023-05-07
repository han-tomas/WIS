package home.sist.manager;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class DataCollectionManager {
	public static String youtubeKeyData(String title)
	{
		String key="";
		try
		{
			String url="https://www.youtube.com/results?search_query="+URLEncoder.encode(title,"UTF-8");
			//https://www.youtube.com/results?search_query=%EC%95%84%EC%9D%B4%EB%B8%8C
			Document doc = Jsoup.connect(url).get();
			String data = doc.toString();
			Pattern p = Pattern.compile("/watch\\?v=[^가-힣]+");
			Matcher m = p.matcher(data);
			while(m.find())
			{
				String s=m.group();
				s=s.substring(s.indexOf("=")+1,s.indexOf("\""));
				key=s;
				break;
			}
			
		}catch(Exception ex) {}
		return key;
	}

	public static void main(String[] args) {
		List<MovieVO> list = new ArrayList<MovieVO>(); //MovieVo 클래스 데이터형 list 생성
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; 
		try
		{
			fos = new FileOutputStream("c:\\java_datas\\DaumMovie.txt"); // 데이터 출력
			oos = new ObjectOutputStream(fos);// 데이터 객체 단위 저장
			
			String[] urls = {
								"https://movie.daum.net/ranking/reservation",// 예매율 순위
								"https://movie.daum.net/ranking/boxoffice/weekly",// 박스오피스 순위
								"https://movie.daum.net/ranking/ott" // ott순위
							}; // url 배열 생성
			/*
			 *      private int rank;
			 *	    private String title;
			 *		private String poster;
			 * 		private String age;
			 *      private String grade;
			 *		private String reservation;
			 *		private String regDate;
			 *		private String content;
			 *		private int cno;
			 *		private String key;
			 */
			
			for(int i=0;i<urls.length;i++)
			{
				Document doc = Jsoup.connect(urls[i]).get();
				Elements title = doc.select("strong.tit_item a.link_txt");
				Elements poster = doc.select("div.poster_movie img");
				Elements age = doc.select("span.ico_see");
				Elements grade = doc.select("span.txt_append span.txt_grade");
				Elements reservation = doc.select("span.txt_append span.txt_num");
				Elements regDate = doc.select("span.txt_info span.txt_num");
				Elements content = doc.select("a.link_strory");
				// index=16,뮤지컬 공연실황, 알쏭달쏭 캐치! 티니핑 <신비한 상자를 열어라!> 포스터가 없음.
//				if (i==0) {
//					poster.add(16, new Element("img")
//						    .attr("src", "https://t1.daumcdn.net/movie/movie2020/pc/ico_noimage.png"));
//					/*
//					 *    이 코드는 반복문에서 i가 0일 때 poster 리스트의 16번째 인덱스에 새로운 "img" 요소를 추가하고, 
//					 *    "src" 속성에 "https://t1.daumcdn.net/movie/movie2020/pc/ico_noimage.png" 값을 설정하는 것입니다.
//					 */
//				}
				if(i==1)
				{
					regDate.add(12, new Element("span.txt_info span.txt_num").appendText("개봉일 정보 없음"));
					age.add(12,new Element("span.ico_see").appendText("연령 제한 정보 없음"))	;
					/*
					 *    regDate와 age 라는 ArrayList의 12번 인덱스에 각각 span 요소를 추가하고, 
					 *    appendText() 메서드를 사용하여 내용을 추가하고 있습니다.
					 *    "개봉일 없음"과 "연령 제한 정보 없음"은 각각 span 요소 안에 들어가는 텍스트 내용입니다. 
					 *    따라서 해당 ArrayList의 12번 인덱스에는 span 요소가 추가되어 있을 것입니다.
					 */
				}
				int k=1; // 랭킹
				for(int j=0;j<title.size();j++)
				{
					MovieVO vo = new MovieVO();
					/*
					 *   예매 순위
					 *   = 순위, 제목, 포스터, 연령제한, 평점, 예매율, 개봉일, 내용
					 *   
					 *   박스오피스 순위
					 *   = 순위, 제목, 포스터, 연령제한, 개봉일, 내용
					 *   
					 *   OTT 순위
					 *   = 순위, 제목 ,포스터
					 *   
					 *   예매 순위, 박스오피스 순위, OTT순위 공통적으로 가지고있는 정보
					 *   = 순위, 제목, 포스터 (+ 유튜브)
					 */
					System.out.println("카테고리번호 : "+(i+1));
					System.out.println("영화 랭킹 : "+k);
					System.out.println("영화 제목 : "+title.get(j).text());
					if(!age.isEmpty())
					{
						System.out.println("연령제한 : "+age.get(j).text());
						vo.setAge(age.get(j).text());
					}
					if(!grade.isEmpty())
					{
						System.out.println("평점 : "+grade.get(j).text());
						vo.setGrade(grade.get(j).text());
					}
					if(!reservation.isEmpty())
					{
						System.out.println("예매율 : "+reservation.get(j).text());
						vo.setReservation(reservation.get(j).text());
					}
					if(!regDate.isEmpty())
					{
						System.out.println("개봉일 : "+regDate.get(j).text());
						vo.setRegDate(regDate.get(j).text());
					}
					if(!content.isEmpty())
					{
						System.out.println("줄거리: "+content.get(j).text());
						vo.setContent(content.get(j).text());
					}
					
					
					System.out.println("포스터 : "+poster.get(j).attr("src"));
					System.out.println("동영상: "+youtubeKeyData(title.get(j).text()));
					System.out.println("======================================");

					vo.setRank(k);
					vo.setCno(i);
					vo.setPoster(poster.get(j).attr("src"));
					vo.setKey(youtubeKeyData(title.get(j).text()));
					
					list.add(vo);
					k++;
					
				}
				
				
			}
			oos.writeObject(list);
			System.out.println("저장 완료!!");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fos.close();
				oos.close();
			} catch (Exception e) {}
		}
		
		
	}

}
