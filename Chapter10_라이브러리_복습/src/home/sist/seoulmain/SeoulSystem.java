package home.sist.seoulmain;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 기능 구현
public class SeoulSystem {
	private static List list = new ArrayList();
	
	/*
	 *  사용자들이 보는 정보가 같아야 하므로 static 
	 */
	static
	{
		try
		{
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			fr.close();
			String[] movies = sb.toString().split("\n");
			for(String m:movies)
			{
				StringTokenizer st = new StringTokenizer(m,"|");
				SeoulLocationVO vo = new SeoulLocationVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setLoc(st.nextToken());
				list.add(vo);	
			}
		}catch(Exception ex) {}
	}
	// 메뉴 출력
	public int seoulMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("================== 서울 명소 ==================");
		System.out.println("1. 페이지별 목록 보기");
		System.out.println("2. 상세 보기");
		System.out.println("3. 이름 검색");
		System.out.println("4. 장소 검색");
		System.out.println("9. 프로그램 종료");
		System.out.println("=============================================");
		System.out.print("메뉴 선택 : ");
		return scan.nextInt();
		
		
	}
	
	// 1. 목록 보기
	public ArrayList seoulListData(int page)
	{
		int totalpage = (int)(Math.ceil(list.size()/10.0));
		int startnum = (page-1)*10;
		int endnum = page*10; 
		if(page==totalpage)
		{
			endnum = (page*10)-(10-list.size()%10);
		}
		ArrayList seoulList = new ArrayList(list.subList(startnum, endnum));
		return seoulList;
		
	}
	// 2. 상세 보기
	public SeoulLocationVO seoulDetailData(int no)
	{
		return (SeoulLocationVO)list.get(no-1);
	}
	// 3. 이름 검색
	public ArrayList seoulNameFind(String name)
	{
	    ArrayList seoulName = new ArrayList();
	    for(int i=0;i<list.size();i++)
	    {
	        SeoulLocationVO vo = (SeoulLocationVO) list.get(i);
	        if(vo.getName().contains(name))
	        {
	            seoulName.add(vo);
	        }
	    }
	    return seoulName;
	}
	// 4. 장소 검색
	public ArrayList seoulLocFind(String name)
	{
		ArrayList seoulLoc = new ArrayList();
		for(int i=0;i<list.size();i++)
		{
			SeoulLocationVO vo = (SeoulLocationVO) list.get(i);
			if(vo.getLoc().contains(name))
			{
				seoulLoc.add(vo);
			}
		}
		return seoulLoc;
	}
	
	// 조립
	public void process()
	{
		while(true)
		{
			int menu = seoulMenu();
			
			if(menu !=9 && (menu < 1 || menu > 4))
			{
				System.out.println("메뉴 번호를 잘못 선택하였습니다. 다시 입력해 주세요.");
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
						System.out.print("페이지를 입력하시오 : ");
						int page = scan.nextInt();
					    if(page>(int)(Math.ceil(list.size()/10.0)))
					    {
					    	System.out.println("없는 페이지 입니다. 페이지를 다시 입력하세요.");
					    	continue;
					    }
					    else
					    {
					    	ArrayList sList = seoulListData(page);
					    	for(int i=0;i<sList.size();i++)
					    	{
					    		SeoulLocationVO vo = (SeoulLocationVO) sList.get(i);
					    		System.out.println(vo.getNo()+". "+vo.getName());
					    	}
					    	break;
					    }
					}
				}
				else if(menu==2)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("상세 정보가 필요한 명소 번호를 입력하시오 (1~273) : ");
						int no = scan.nextInt();
						if(no>list.size() || no<1)
						{
							System.out.println("없는 번호입니다. 다시 입력하세요");
							continue;
						}
						else
						{
							SeoulLocationVO vo = seoulDetailData(no);
							System.out.println("================== 상세 정보 ==================");
							System.out.println("번호 : "+vo.getNo());
							System.out.println("명소 이름 : "+vo.getName());
							System.out.println("명소 정보 : "+vo.getContent());
							System.out.println("주소 : "+vo.getLoc());
							System.out.println("=============================================");
							break;
						}
					}
					
				}
				else if(menu==3)
				{
					while(true)
					{
						Scanner scan = new Scanner(System.in);
						System.out.print("검색어를 입력하세요 : ");
						String name = scan.nextLine();
						ArrayList searchList = seoulNameFind(name);
						if (searchList.size() == 0) 
						{
							System.out.println("검색 결과가 없습니다.");
							continue;
						} 
						else
						{
							System.out.println("================== 검색 결과 ==================");
							for (int i = 0; i < searchList.size(); i++) 
							{
								SeoulLocationVO vo = (SeoulLocationVO) searchList.get(i);
								System.out.println(vo.getNo() + ". " + vo.getName());

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
						System.out.print("주소를 입력하세요 : ");
						String name = scan.nextLine();
						ArrayList locList = seoulLocFind(name);
						if(locList.size()==0)
						{
							System.out.println("검색어가 없습니다. 다시 입력하세요.");
							continue;
						}
						else
						{
							for (int i = 0; i < locList.size(); i++) 
							{
								SeoulLocationVO vo = (SeoulLocationVO) locList.get(i);
								System.out.println(vo.getNo() + ". " + vo.getName()+" : "+vo.getLoc());

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
