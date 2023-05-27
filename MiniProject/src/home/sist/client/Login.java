package home.sist.client;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame{
	JLabel la1,la2,la3; // "아이디", "이름", "성명" 표시 
	JTextField tf1,tf2; // 아이디, 이름 입력 창
	JRadioButton rb1,rb2; // 남녀 성별 체크
	JButton b1,b2; // 로그인,취소 버튼
	
	public Login()
	{
		setLayout(null);
		la1 = new JLabel("아이디");
		la2 = new JLabel("이름");
		la3 = new JLabel("성별");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		
		rb1 = new JRadioButton("남자");
		rb2 = new JRadioButton("여자");
		ButtonGroup bg = new ButtonGroup(); // 버튼 그룹으로 묶는다.
		bg.add(rb1); bg.add(rb2);
		rb1.setSelected(true); // rb1이 디폴트
		
		b1 = new JButton("로그인");
		b2 = new JButton("취소");
		
		la1.setBounds(10, 15, 60, 30);
		tf1.setBounds(80, 15, 150, 30);
		
		la2.setBounds(10, 50, 60, 30);
		tf2.setBounds(80, 50, 150, 30);
		
		la3.setBounds(10, 85, 60, 30);
		rb1.setBounds(80, 85, 70, 30);
		rb2.setBounds(155, 85, 70, 30);
		
		JPanel p = new JPanel();
		p.add(b1);p.add(b2);
		
		p.setBounds(10, 120, 215, 30);
		
		add(la1); add(tf1); // 아이디 [        ]
		add(la2); add(tf2); // 이름 [        ]
		add(la3); add(rb1); add(rb2); // 성별 ●남자 ○여자
		add(p);
		
		setSize(270,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		

	}

}
