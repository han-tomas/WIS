package home.sist.movie;
// 기능 구현
/*
 *   메뉴 생성
 *   1. 영화 페이지별 목록 출력
 *   2. 선택 영화 상세보기
 *   3. 이름 검색
 *   4. 장르별 영화 검색
 *   5. 출연 배우 영화 검색
 *   6. 감독 영화 검색
 *   
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MovieSystem {
	/*
	 *  프로그램을 사용하는 사용자들이 모두 같은 내용을 확인해야하므로 static 선언
	 */
	private static List list = new ArrayList();
	// 초기화
	static
	{
		try
		{
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt"); // java.io는 CheckedException이기 때문에 반드시 예외처리 필요
			int i = 0;
			StringBuffer sb = new StringBuffer(); // FileReader로 읽어온 데이터를 저장하기 위해 StringBuffer 클래스를 호출에 sb객체에 저장. 
			while((i=fr.read())!=-1) // 읽어온 fr 객체가 끝날때까지(-1) 반복문을 돌린다.
			{
				sb.append((char)i);//fr.read()는 데이터를 정수형으로 불러오기 때문에 문자형으로 형변환 하여 sb객체에 append()메소드를
				/*
				 *    fr.read()는 데이터를 정수형으로 불러오기 때문에 문자형으로 형변환하여,
				 *    sb객체에 StringBuffer클래스의 append()메소드로 데이터를 추가하여 저장.
				 */
			}
			fr.close(); // 파일을 다 읽었으면 종료.
			String[] movies = sb.toString().split("\n"); // movies 배열을 만들어, sb객체에 저장된 문자열을 \n으로 나눠서 저장
			/*
			 * movies[0]=1|쇼생크 탈출|드라마|https://...|팀 로빈스(앤디 듀프레인),...|2016 .02.24 재개봉,...|15세 관람가|프랭크 다라본트
			 * movies[1]=2|원더|드라마|https://...|제이콥 트렘블레이(어기 풀먼),...|2017 .12.27 개봉|전체 관람가|스티븐 크보스키
			 *    ...
			 */
			for(String m:movies) // for-each문 돌려서 배열 출력
			{
				StringTokenizer st = new StringTokenizer(m,"|"); // m 문자열을 |마다 분리
				MovieVo vo = new MovieVo(); // MovieVo 클래스 호출 
				vo.setNo(Integer.parseInt(st.nextToken())); // 영화 번호 저장
				// 처음 자른 문자열 "1"은 String 형이기때문에 Integer.parseInt()를 통해 정수형(int)으로 형변환
				vo.setTitle(st.nextToken()); // 제목 저장
				vo.setGenre(st.nextToken()); // 장르 저장
				vo.setPosterLink(st.nextToken()); // 포스터 링크 저장
				vo.setActor(st.nextToken()); // 배우 저장
				vo.setRegDate(st.nextToken()); // 개봉일 저장
				vo.setAge(st.nextToken()); // 시청 가능 연령 저장
				vo.setDirector(st.nextToken()); // 감독 저장
				list.add(vo); // list에 모두 저장
			}
		}catch(Exception ex) {}
	}
	// 메뉴 출력
	public int menu() // 정수 값(int) return : 메뉴 번호 리턴.
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("===================== 메뉴 선택 =====================");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 상세 보기");
		System.out.println("3. 영화 제목 검색");
		System.out.println("4. 장르별 영화 검색");
		System.out.println("5. 배우 영화 검색");
		System.out.println("6. 감독 영화 검색");
		System.out.println("==================================================");
		System.out.print("메뉴 선택 : ");
		return scan.nextInt() ;
	}
	// 1. 영화 목록(페이지별)
	public ArrayList movieList(int page)
	{
		int totalpage = (int)(Math.ceil(list.size()/10.0));
		int start = (page-1)*10; // 페이지 첫번째 시작 index번호 0 => 1번
		int end = page*10; // 페이지 끝 index 번호 9 => 10번
		if(page==totalpage)
		{
			end = (page*10)-(10-list.size()%10);
		}
		ArrayList movieList = new ArrayList(list.subList(start, end));
		return movieList;
	}
	// 2. 영화 상세보기
	public MovieVo movieDetailData(int no)
	{
		return (MovieVo)list.get(no-1); //list에서 가져온 정보를 MovieVo 데이터형으로 형변환하여 리턴
	}
	// 3. 영화 제목 검색
	public ArrayList movieFind(String title)
	{
		ArrayList movie = new ArrayList(); // 해당 검색어가 포함된 영화데이터를 담기위한 ArrayList 생성
		for(int i = 0;i<list.size();i++) // list 객체 사이즈 (데이터 전체) 동안 반복
		{
			MovieVo vo = (MovieVo)list.get(i); //list에 저장된 정보를 MovieVo데이터형의 vo객체에 담고
			if(vo.getTitle().contains(title)) // vo 객체에 담긴 데이터 중 title 정보를 가져와서 그중에 검색어가 포함되어있다면
			{
				movie.add(vo); // ArrayList 데이터형인 movie 객체에 담고
			}
		}
		return movie; // ArrayList 데이터형인 movie 리턴
	}
	// 4. 장르별 영화 검색
	public ArrayList movieGenre(String genre)
	{
		ArrayList movie = new ArrayList();
		for(int i = 0;i<list.size();i++)
		{
			MovieVo vo = (MovieVo)list.get(i);
			if(vo.getGenre().contains(genre))
			{
				movie.add(vo);
			}
		}
		return movie;
	}
	// 5. 배우 영화 검색
	public ArrayList movieActor(String actor)
	{
		ArrayList movie = new ArrayList();
		for(int i = 0;i<list.size();i++)
		{
			MovieVo vo = (MovieVo)list.get(i);
			if(vo.getActor().contains(actor))
			{
				movie.add(vo);
			}
		}
		return movie;
	}
	// 6. 감독 영화 검색
	public ArrayList movieDirector(String director)
	{
		ArrayList movie = new ArrayList();
		for(int i = 0;i<list.size();i++)
		{
			MovieVo vo = (MovieVo)list.get(i);
			if(vo.getDirector().contains(director))
			{
				movie.add(vo);
			}
		}
		return movie;
	}
	
	// 조립
	public void process() 
	{
		while(true) 
		{
			int menu = menu();
			if(menu != 9 &&(menu<1 || menu>6))
			{
				System.out.println("잘못된 메뉴 번호 입니다. 다시 입력해 주세요");
				continue;
			}
			else
			{
				if(menu==9)
				{
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else if(menu==1)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("페이지 입력 (종료시 0): ");
						int page = scan.nextInt();
						if(page <0 || page>(int)(Math.ceil(list.size()/10.0))) 
						{
							System.out.println("없는 페이지 입니다. 페이지를 다시 입력하세요.");
							continue;//페이지가 0보다 작거나 총 페이지수를 넘어가면 다시입력.
						}
						else if(page>0 && page<=(int)(Math.ceil(list.size()/10.0)))//페이지 범위 내
						{
							ArrayList mList = movieList(page); //movieList 메소드 호출해서 ArrayList데이터형 mList객체에 담는다.
							for(int i = 0; i<mList.size();i++) // page에 해당되는 데이터가 담긴 mList데이터 크기동안 반복문 수행
							{
								MovieVo vo = (MovieVo) mList.get(i); // MovieVo 데이터형의 vo 객체에 mList데이터를 저장
								System.out.println(vo.getNo()+". "+vo.getTitle());	
							}
							continue;
						}
						else if(page==0)
						{
							System.out.println("페이지 출력 종료."); // page에 0입력시 종료.		
						}
						break;
					}
				}
				else if(menu==2)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("상세 볼 영화 번호 입력 (1~1938) : ");
						int num = scan.nextInt();
						if(num<1 || num > list.size())
						{
							System.out.println("없는 영화 번호입니다. 다시 입력하세요.");
							continue;
						}
						else
						{
							MovieVo vo = movieDetailData(num);
							System.out.println("========================================================= 상세 정보 =========================================================");
							System.out.println("영화 번호 : "+vo.getNo());
							System.out.println("영화 제목 : "+vo.getTitle());
							System.out.println("장르 : "+vo.getGenre());
							System.out.println("영화 포스터 링크 : "+vo.getPosterLink());
							System.out.println("출연 배우 : "+vo.getActor());
							System.out.println("연령 제한 : "+vo.getRegDate());
							System.out.println("감독 : "+vo.getDirector());
							System.out.println("==========================================================================================================================");
							break;
						}
					}
				}
				else if(menu==3)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("영화 검색 : ");
						String title = scan.nextLine();
						ArrayList mfdList = movieFind(title); //ArrayList 데이터형인 mdfList에 movieFind 메소드에서 리턴된 값을 저장
						if(mfdList.size()==0) // mdfList 크기가 0이면 검색어가 포함된 데이터가 없는것을 의미하기때문에
						{
							System.out.println("해당 검색어를 포함한 영화가 없습니다. 다시 입력하세요."); //출력
							continue;
						}
						else // 아니라면
						{
							System.out.println("================== 검색 결과 ==================");
							for(int i = 0;i<mfdList.size();i++) // mdfList객체의 사이즈동안 반복문을 수행하여
							{
								MovieVo vo = (MovieVo)mfdList.get(i); //MovieVo 클래스 데이터형 객체인 vo에 mdfList객체의 데이터를 MovieVo 클래스 데이터형으로 형변환 하여 저장
								System.out.println(vo.getNo()+". "+vo.getTitle()); // MovieVo 클래스에 은닉화된 데이터를 getter로 읽기
							}
							System.out.println("=============================================");
							break;
						}
					}
					
				}
				else if(menu==4)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("장르 검색 : ");
						String genre = scan.nextLine();
						ArrayList mfdList = movieGenre(genre);
						if(mfdList.size()==0)
						{
							System.out.println("해당 장르는 없습니다. 다시 입력하세요.");
							continue;
						}
						else
						{
							System.out.println("================== 검색 결과 ==================");
							for(int i = 0;i<mfdList.size();i++)
							{
								MovieVo vo = (MovieVo)mfdList.get(i);
								System.out.println(vo.getNo()+". "+vo.getTitle()+"("+vo.getGenre()+")");
							}
							System.out.println("=============================================");
							break;
						}
					}
				}
				else if(menu==5)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("배우 검색 : ");
						String actor = scan.nextLine();
						ArrayList mfdList = movieActor(actor);
						if(mfdList.size()==0)
						{
							System.out.println("해당 배우는 없습니다. 다시 입력하세요.");
							continue;
						}
						else
						{
							System.out.println("================== 검색 결과 ==================");
							for(int i = 0;i<mfdList.size();i++)
							{
								MovieVo vo = (MovieVo)mfdList.get(i);
								System.out.println(vo.getNo()+". "+vo.getTitle());
								System.out.println("출연 배우 : "+vo.getActor());
							}
							System.out.println("=============================================");
							break;
						}
					}
				}
				else if(menu==6)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("배우 검색 : ");
						String director = scan.nextLine();
						ArrayList mfdList = movieDirector(director);
						if(mfdList.size()==0)
						{
							System.out.println("해당 배우는 없습니다. 다시 입력하세요.");
							continue;
						}
						else
						{
							System.out.println("================== 검색 결과 ==================");
							for(int i = 0;i<mfdList.size();i++)
							{
								MovieVo vo = (MovieVo)mfdList.get(i);
								System.out.println(vo.getNo()+". "+vo.getTitle());
								System.out.println("감독 : "+vo.getDirector());
							}
							System.out.println("=============================================");
							break;
						}
					}
				}
			}
			
		}
		
	}
	
}
