package home.sist.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.table.*;

import java.util.*;
import java.util.List;

import home.sist.common.ImageChange;
import home.sist.manager.*;

import home.sist.manager.MovieSystem;

public class FindPanel extends JPanel implements ActionListener{
	JTextField tf;
	JButton b1; // 검색
	JButton b2,b3,b4; // 예매 순위, 박스 오피스 순위, OTT 순위
	JTable table;
	DefaultTableModel model;
	MovieSystem ms = new MovieSystem();
	public FindPanel()
	{
//		setBackground(Color.cyan);
		tf = new JTextField();
		b1 = new JButton("검색");
		b2 = new JButton("예매 순위");
		b3 = new JButton("박스오피스");
		b4 = new JButton("OTT");
		
		String[] col = {"순위","포스터","제목","개봉일"};
		Object[][] row = new Object[0][4];
		model = new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
			
			
		};
		table = new JTable(model);
		// 출력 위치 길이 설정
		table.setRowHeight(50);
		// 타이틀바 고정
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane js = new JScrollPane(table);
		
		// 검색창 배치
		setLayout(null);
		tf.setBounds(10, 15, 750, 30);
		b1.setBounds(765, 15, 100, 30);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 6, 5, 5));
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.setBounds(10, 55, 850, 35);
		
		js.setBounds(10, 100, 850, 700);
		add(tf);
		add(b1);
		add(p);
		add(js);
		//default
		try
		{
			List<MovieVO> list = ms.movieCategoryData(1);
			for(MovieVO vo:list)
			{
				URL url = new URL(vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				if (vo.getCno()==3) 
				{
					Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										""
									};
					model.addRow(data);
				}
				 else 
				 {
					 Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										vo.getRegDate()
									 };
					 model.addRow(data);
				 }
				
			}
		}catch(Exception ex) {}
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		tf.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			findPrint(1);
		}
		else if(e.getSource()==b3)
		{
			findPrint(2);
		}
		else if(e.getSource()==b4)
		{
			findPrint(3);
		}
		else if(e.getSource()==b1 || e.getSource()==tf)
		{
			String title = tf.getText();
			if(title.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어 입력");
				tf.requestFocus();
				return;
			}
			findPrint2(title);
		}
	}

	// 카테고리 선택할때
	public void findPrint(int cno)
	{
		for(int i = model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		try
		{
			List<MovieVO> list = ms.movieCategoryData(cno);
			for(MovieVO vo:list)
			{
				
				URL url = new URL(vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				if (vo.getCno()==3) 
				{
					Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										""
									};
					model.addRow(data);
				}
				 else 
				 {
					 Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										vo.getRegDate()
									 };
					 model.addRow(data);
				 }
			}
		}catch(Exception ex) {}
	}
	// 검색할때
	public void findPrint2(String title)
	{
		for(int i=model.getRowCount()-1;i>=0;i--)
		{
			model.removeRow(i);
		}
		try
		{
			List<MovieVO> list = ms.movieFindData(title);
			for(MovieVO vo:list)
			{
				URL url = new URL(vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 30, 30);
				if (vo.getCno()==3) 
				{
					Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										""
									};
					model.addRow(data);
				}
				 else 
				 {
					 Object[] data = { 
										vo.getRank(),			
										new ImageIcon(img),
										vo.getTitle(),
										vo.getRegDate()
									 };
					 model.addRow(data);
				 }
				
			}
		}catch(Exception ex) {}
	}
	
}
