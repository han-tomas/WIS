package home.sist.client;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

public class ChatPanel extends JPanel {
	JTextPane pane; // 텍스트 속성 지원
	JTextField tf;// 텍스트 입력란
	JButton b1,b2; // 쪽지 보내기, 정보보기
	JTable table; // 화면 UI
	DefaultTableModel model; // 데이터 관리
	JComboBox<String> box;
	public ChatPanel()
	{
//		setBackground(Color.darkGray);
		pane = new JTextPane();
		pane.setEditable(false); // false이면 텍스트 컴포넌트는 읽기 전용,true면 텍스트 컴포넌트 내용변경 가능
		JScrollPane js1= new JScrollPane(pane);
		b1 = new JButton("쪽지보내기");
		b2 = new JButton("정보보기");
		JPanel p = new JPanel();
		
		p.add(b1);
		p.add(b2);
		tf = new JTextField();
		box = new JComboBox<String>();
		
		box.addItem("black");
		box.addItem("blue");
		box.addItem("yellow");
		box.addItem("green");
		box.addItem("pink");
		box.addItem("orange");
		box.addItem("cyan");
		
		String[] col = {"아이디", "이름", "성별"};
		String[][] row = new String[0][3];
		model = new DefaultTableModel(row,col);
		table = new JTable(model);
		JScrollPane js2 = new JScrollPane(table);
		
		//배치
		setLayout(null);
		js1.setBounds(0, 0, 650, 700);
		tf.setBounds(0, 700, 500, 30);
		box.setBounds(500, 700, 150, 30);
		js2.setBounds(660, 0, 230, 700);
		p.setBounds(700,700,150,30);
		
		
		add(js1);
		add(tf);
		add(box);
		add(js2);
		add(p);
		//String[] data = {"hong","홍길동","남자"};
		//model.addRow(data);
	}
	public void initStyle()
	{
		Style blue = pane.addStyle("blue", null);
		StyleConstants.setForeground(blue, Color.blue);
		
		Style green = pane.addStyle("green", null);
		StyleConstants.setForeground(green, Color.green);
		
		Style pink = pane.addStyle("pink", null);
		StyleConstants.setForeground(pink, Color.pink);
		
		Style yellow = pane.addStyle("yellow", null);
		StyleConstants.setForeground(yellow, Color.yellow);
		
		Style cyan = pane.addStyle("cyan", null);
		StyleConstants.setForeground(cyan, Color.cyan);
		
		Style orange = pane.addStyle("orange", null);
		StyleConstants.setForeground(orange, Color.orange);
	}
	public void append(String msg,String color)
	{
		try
		{
			Document doc = pane.getDocument(); // Document 인터페이스
			doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));
		}catch(Exception ex) {}
	}
}
