package home.sist.client;
import java.util.*;
import home.sist.manager.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DetailPanel extends JPanel implements ActionListener{
	JLabel imgLa;
	JLabel la1,la2,la3,la4;// 제목, 연령제한,줄거리, 개봉일
	JButton b1,b2; // 동영상, 목록
	JLabel titleLa,ageLa,contentLa,regDateLa,keyLa;
	ControlPanel cp;
	public DetailPanel(ControlPanel cp)
	{
//		setBackground(Color.pink);
		this.cp = cp;
		imgLa = new JLabel();
		la1 = new JLabel("제목");
		la2 = new JLabel("연령제한");
		la3 = new JLabel("줄거리");
		la4 = new JLabel("개봉일");
		
		b1 = new JButton("동영상");
		b2 = new JButton("목록");
		
		titleLa = new JLabel("");
		ageLa = new JLabel("");
		contentLa = new JLabel("");
		regDateLa = new JLabel("");
		keyLa = new JLabel("");
		
		// 배치
		setLayout(null);
		imgLa.setBounds(100, 15, 530, 350);
		la1.setBounds(100, 375, 60, 40);
		titleLa.setBounds(165, 375, 300, 40);
		la2.setBounds(100, 425, 60, 40);
		ageLa.setBounds(165, 425, 300, 40);
		la3.setBounds(100, 475, 60, 40);
		contentLa.setBounds(165, 475, 700, 40);
		la4.setBounds(100, 525, 60, 40);
		regDateLa.setBounds(165, 525, 300, 40);
		
		keyLa.setBounds(100, 625, 300, 40);
		keyLa.setVisible(false);
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(100, 725, 365, 40);
		
		// 윈도우 추가
		add(imgLa);
		add(keyLa);
		add(la1);add(titleLa);
		add(la2);add(ageLa);
		add(la3);add(contentLa);
		add(la4);add(regDateLa);
		add(p);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			//"C:\Program Files\Google\Chrome\Application\chrome.exe"
			try
			{
				Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
											+"http://youtube.com/embed/"
						 					+keyLa.getText());
				
			}catch(Exception ex) {}
		}
		else if(e.getSource()==b2)
		{
			cp.card.show(cp, "home");
		}
	}
}
