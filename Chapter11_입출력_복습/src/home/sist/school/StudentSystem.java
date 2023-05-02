package home.sist.school;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentSystem {
	private static List<Student> stdList = new ArrayList<Student>();
	static
	{
		FileReader fr = null;
		try
		{
			fr = new FileReader("c:\\java_datas\\school.txt");
			StringBuffer sb = new StringBuffer();
			int i = 0;
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			String[] std = sb.toString().split("\n");
			for(String s:std)
			{
				StringTokenizer st = new StringTokenizer(s,"|");
				Student student = new Student();
				student.setHakbun(Integer.parseInt(st.nextToken()));
				student.setName(st.nextToken());
				student.setKor(Integer.parseInt(st.nextToken()));
				student.setEng(Integer.parseInt(st.nextToken()));
				student.setMath(Integer.parseInt(st.nextToken()));
				
				int total = student.getKor()+student.getEng()+student.getMath();
				student.setTotal(total);
				student.setAvg(total/3.0);
				
				stdList.add(student);
				
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace(); // 에러 위치 확인
		}
		finally
		{
			try
			{
				fr.close();
			}catch(Exception ex) {}
		}
	}
	// 메뉴 출력
	public int menu()
	{
		System.out.println("=================== 성적 관리 메뉴 ===================");
		System.out.println("1. 학생 목록");
		System.out.println("2. 학생 등록");
		System.out.println("3. 정보 수정");
		System.out.println("4. 정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("==================================================");
		int no = 0;
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			// 키보드 읽기(키보드 입력값 받기) ==> IO => IOException => CheckedException=> 예외처리 필수
			System.out.print("메뉴 번호 입력 : ");
			String str = in.readLine().trim();
			no = Integer.parseInt(str);
		}catch(Exception ex) {}
		return no;
	}
	public void process()
	{
		while(true)
		{
			int no = menu();
			if(no<1 || no>5)
			{
				System.out.println("없는 메뉴 번호입니다. 다시 입력하시오.");
				continue;
			}
			else
			{
				if(no==5)
				{
					int save = 0;
					try
					{
						System.out.print("저장 하시겠습니까? (1.네 2.아니요) : ");
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						String str = in.readLine();
						save = Integer.parseInt(str);
						if(save == 1)
						{
							FileWriter fw = null;
							try
							{
								fw = new FileWriter("c:\\java_datas\\school.txt");
								String temp = "";
								for(Student std : stdList)
								{
									temp+=std.getHakbun()+"|"+std.getName()+"|"+std.getKor()+"|"+std.getEng()+"|"+std.getMath()+"|"+"\n";
								}
								fw.write(temp);
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							finally
							{
								try 
								{
									fw.close();
								} catch (Exception ex) {}
							}
							System.out.println("저장 완료. 프로그램을 종료합니다.");
							break;
						}
						else if(save ==2)
						{
							System.out.println("프로그램을 종료합니다.");
							break;
						}
					}catch(Exception ex) {}
				}
				else if(no==1)
				{
					for(Student std : stdList)
					{
						int total = std.getKor()+std.getEng()+std.getMath();
						std.setTotal(total);
						std.setAvg(total/3.0);
						
						System.out.println(std.getHakbun()+" "
										+std.getName()+" 국어:"
										+std.getKor()+" / 영어:"
										+std.getEng()+" / 수학:"
										+std.getMath()+" => 총합 :"
										+std.getTotal()+" 평균 :"
										+String.format("%.2f", std.getAvg()));
						
						
					}
				}
				else if(no==2)
				{
					try
					{
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("이름 입력 : ");
						String name = in.readLine().trim(); // 좌우 공백 없애기
						System.out.print("국어 점수 : ");
						String kor = in.readLine();
						System.out.print("영어 점수 : ");
						String eng = in.readLine();
						System.out.print("수학 점수 : ");
						String math = in.readLine();
						
						// 시퀀스 => 자동 증가 번호 만들기 => 구분자
						int max=0;
						for(Student std: stdList)
						{
							if(std.getHakbun()>max)
								max=std.getHakbun();
						}
						
						Student student = new Student();
						student.setName(name);
						student.setHakbun(max+1);
						student.setKor(Integer.parseInt(kor));
						student.setEng(Integer.parseInt(eng));
						student.setMath(Integer.parseInt(math));
						
						stdList.add(student);
					}catch(Exception ex) {}
				}
				else if(no ==4)
				{
					try
					{
						BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("학번 입력 : ");
						String hakbun = in.readLine();
						for(Student std:stdList)
						{
							if(std.getHakbun()==Integer.parseInt(hakbun))
							{
								stdList.remove(std);
							}
						}
						
					}catch(Exception ex) {}
				}
			}
		}
	}
}
