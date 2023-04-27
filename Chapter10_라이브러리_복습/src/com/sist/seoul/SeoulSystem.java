package com.sist.seoul;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sist.seoul.SeoulVO;

public class SeoulSystem {
	private static ArrayList list = new ArrayList();
	
	
	static {
		
		try {
			
			StringBuffer sb = new StringBuffer();
			int i=0;
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			while ((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			
			String[] locations = sb.toString().split("\n");

			for (String s:locations) {
				StringTokenizer st = new StringTokenizer(s, "|");
				SeoulVO vo = new SeoulVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setAddress(st.nextToken());
				list.add(vo); // SeoulVO 사용자 정의 데이터형으로하는 vo변수에 Seoul() 객체를 생성한후, 모든 데이터를 list에 추가한다.

			}
			
		} catch (Exception e) {
			
		}
	}
	
	
	// 1. 목록출력
	public ArrayList seoulList(int page) {
		
		int totalpage = (int)(Math.ceil(list.size() / 10.0));
		
		int start = (page-1)*10;
		
		int end = page*10;
		
		if (page == totalpage) {
			end = (totalpage*10) - (10-list.size() % 10); 
		}
		
		ArrayList movieList = new ArrayList(list.subList(start, end)); //start~end-1까지 => 1page index번호 0~9
		
		return movieList;
	}
	
	// 2. 상세보기
	public SeoulVO seoulDetailData(int no) {
		return (SeoulVO)list.get(no-1); //get()메소드는 Object를 리턴하기때문에 SeoulVO 클래스 자료형으로 형변환 필요
	}

	// 메뉴
	public int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("============ 메뉴 ==============");
		System.out.println("1. 목록 출력 (페이지별)");
		System.out.println("2. 상세보기");
//		System.out.println("3. 명소검색");
//		System.out.println("4. 주소검색");
		System.out.println("9. 종료");
		System.out.println("==========================");
		System.out.print("메뉴 선택 : ");
		return scan.nextInt();
	}

	
	// 조립
	public void process() {
		
		while(true) {
			int menu = menu();
			if (menu == 9) {
				System.out.println("종료합니다");
				break;
			} else if (menu == 1) {
				while(true) {
					Scanner scan = new Scanner(System.in);
					System.out.print("출력할 페이지를 입력하세요 : ");
					int page = scan.nextInt();
					
						if (page > (int)(Math.ceil(list.size() / 10.0))) {
							System.out.println("1~28사이를 입력해주세요");
							continue;
						}
					
					ArrayList pageList = seoulList(page);
	
					for (int i=0; i<pageList.size(); i++) {
						SeoulVO vo = (SeoulVO)pageList.get(i);
						System.out.println(vo.getNo() + "." + vo.getName());
					}
					break;
				}
			} else if (menu == 2) {
				while(true) {
					Scanner scan = new Scanner(System.in);
					System.out.print("상세히 볼 명소번호를 입력하세요 : ");
					int no = scan.nextInt();
					
					if (no > (int)(Math.ceil(list.size()))) {
						System.out.println("1~273사이를 입력해주세요");
						continue;
					}
					
					SeoulVO vo = seoulDetailData(no);
					
					System.out.println("===== 상세보기 =====");
					System.out.println("번호 : " + vo.getNo());
					System.out.println("명소명 : " + vo.getName());
					System.out.println("명소주소 : " + vo.getAddress());
					System.out.println("명소소개 : " + vo.getContent());
					break;
				}
			}
		}
	}
}