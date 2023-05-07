package home.sist.client;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import home.sist.common.ImageChange;
import home.sist.manager.*;

public class NetworkMain extends JFrame implements ActionListener{ //ActionListener 버튼 클릭
	MenuPanel mp;
	ControlPanel cp;
	SidePanel sp;
	JButton b1,b2,b3,b4,b5; //홈, 영화검색, 영화 상세 정보, 영화 뉴스, 채팅
	JLabel logo;
	Login login = new Login(); // 로그인 클래스 호출
	public NetworkMain() // 생성자 오버라이딩
	{
		mp = new MenuPanel();
		cp = new ControlPanel();
		sp = new SidePanel(); //클래스 호출
		
		setLayout(null); // 사용자 정의
		logo =new JLabel();
		Image img = ImageChange.getImage(new ImageIcon("c:\\java_datas\\MovieLogo.png"), 240, 200);
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(930, 15, 240, 200 );
		mp.setBounds(10, 15, 900, 50);
		cp.setBounds(10, 80, 900, 650);
		sp.setBounds(930, 230, 240,500);
		
		add(mp);
		add(cp);
		add(sp);
		add(logo);
		
		b1=new JButton("홈");
		b2 = new JButton("영화 검색");
		b3 = new JButton("영화 상세 정보");
		b4 = new JButton("뉴스");
		b5 = new JButton("채팅");
		
		mp.setLayout(new GridLayout(1, 5, 0, 10));
		mp.add(b1);
		mp.add(b2);
		mp.add(b3);
		mp.add(b4);
		mp.add(b5);
		
		setSize(1200,800); //윈도우 크기 설정
//		setVisible(true); // 윈도우를 보여준다 => 로그인이 되면 보여준다.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x 클릭시 메모리 해제 => 종료
		
		// 홈, 검색, 영화 상세 보기, 영화 뉴스, 채팅
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		// 로그인
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		// 채팅
		cp.chp.tf.addActionListener(this);
	}

	public static void main(String[] args) {
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		}catch(Exception ex) {}
		
		new NetworkMain();

	}

	// 버튼 클릭 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			cp.card.show(cp, "home");
		}
		else if(e.getSource()==b2)
		{
			cp.card.show(cp, "find");
		}
		else if(e.getSource()==b3)
		{
			cp.card.show(cp, "detail");
		}
		else if(e.getSource()==b4)
		{
			cp.card.show(cp, "news");
		}
		else if(e.getSource()==b5)
		{
			cp.card.show(cp, "chat");
		}
		else if(e.getSource()==login.b1) // 로그인 버튼을 누르면
		{
			login.setVisible(false); // 로그인 창은 사라지고
			setVisible(true); // 메인 윈도우창을 보여준다.
		}
		else if(e.getSource()==login.b2)
		{
			System.exit(0); // 프로그램 종료
		}
		else if(e.getSource()==cp.chp.tf)
		{
			cp.chp.initStyle();
			String msg = cp.chp.tf.getText();
			String color = cp.chp.box.getSelectedItem().toString();
			if(msg.length()<1) return;
			
			cp.chp.append(msg, color);
			
			cp.chp.tf.setText("");
		}
		
	}

}
