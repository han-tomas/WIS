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
	JLabel titleLa,ageLa,/*contentLa,*/regDateLa,keyLa;
	JTextPane contentLa;
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
//		contentLa = new JLabel("");
		contentLa = new JTextPane();
		contentLa.setEditable(false);
		JScrollPane js = new JScrollPane(contentLa);
		regDateLa = new JLabel("");
		keyLa = new JLabel("");
		
		// 배치
		setLayout(null);
		imgLa.setBounds(0, 0, 400, 600);
		la1.setBounds(420, 15, 100, 40);
		titleLa.setBounds(490, 15, 300, 40);
		la1.setFont(new Font("나눔고딕", 0, 15));
		titleLa.setFont(new Font("나눔고딕",Font.BOLD,20));
		la2.setBounds(420, 70, 60, 40);
		ageLa.setBounds(490, 70, 300, 40);
		la2.setFont(new Font("나눔고딕", 0, 15));
		ageLa.setFont(new Font("나눔고딕",Font.BOLD,20));
		la3.setBounds(420, 125, 60, 40);
		js.setBounds(490, 135, 400, 200);
		la3.setFont(new Font("나눔고딕", 0, 15));
		la4.setBounds(420, 350, 60, 40);
		regDateLa.setBounds(490, 350, 100, 40);
		la4.setFont(new Font("나눔고딕", 0, 15));
		regDateLa.setFont(new Font("나눔고딕",Font.BOLD,20));
		
		keyLa.setBounds(100, 300, 300, 40);
		keyLa.setVisible(false);
		
		JPanel p = new JPanel();
		p.add(b1);
		p.add(b2);
		p.setBounds(450, 400, 365, 40);
		
		// 윈도우 추가
		add(imgLa);
		add(keyLa);
		add(la1);add(titleLa);
		add(la2);add(ageLa);
		add(la3);add(js);
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
											+"https://tv.naver.com/v/"
						 					+keyLa.getText());
				
			}catch(Exception ex) {}
		}
		else if(e.getSource()==b2)
		{
			cp.card.show(cp, "home");
		}
	}
}
