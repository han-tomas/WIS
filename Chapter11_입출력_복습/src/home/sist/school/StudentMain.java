package home.sist.school;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentMain {

	public static void main(String[] args) {
		File dir = new File("c:\\java_datas");
		if(!dir.exists())// 파일이 존재하지 않는 경우
		{
			dir.mkdir();
			System.out.println("폴더 만들기 성공 !");
		}
		File file = new File("c:\\java_datas\\school.txt");
		if(!file.exists())// 파일이 존재하지 않는 경우
		{
			try 
			{
				file.createNewFile();
			} catch (IOException ex) {}
			System.out.println("파일 만들기 성공 !");
			FileOutputStream fos = null;
			try 
			{
				fos = new FileOutputStream(file,true);
				String msg = "1|홍길동|80|70|90|240|80.0|\n";
				try 
				{
					fos.write(msg.getBytes());
				} catch (IOException e) {}
				
			} catch (FileNotFoundException e) {}// 파일이 존재할때 사용
			finally
			{
				try
				{
					fos.close();
				}catch(Exception ex) {}
			}
		}
		
		StudentSystem ss = new StudentSystem();
		ss.process();		
	}
	
}
		
		
		
