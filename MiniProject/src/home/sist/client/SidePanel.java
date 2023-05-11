package home.sist.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import home.sist.common.ImageChange;
import home.sist.manager.MovieSystem;
import home.sist.manager.MovieVO;

public class SidePanel extends JPanel {
	JTable table;
	JLabel la1;
	DefaultTableModel model;
	MovieSystem ms = new MovieSystem();
	public SidePanel() 
	{
//		setBackground(Color.green);
		String[] col = {"포스터","제목","평점"};
		Object[][] row = new Object[0][3];
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
		
		
		
		// 타이틀바 고정
		table.getColumn("포스터").setPreferredWidth(40);
		table.getColumn("제목").setPreferredWidth(160);
		table.getColumn("평점").setPreferredWidth(40);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		JScrollPane js = new JScrollPane(table);
		
		la1 = new JLabel("★☆7.0점 이상 영화 추천☆★");
		la1.setFont(new Font("나눔고딕",Font.BOLD,15));
		la1.setHorizontalAlignment(JLabel.CENTER);
		
		
		setLayout(null);
		js.setBounds(0, 23, 240, 518);
		la1.setBounds(0, 0, 240, 20);

		add(la1);
		add(js);
		try
		{
			List<MovieVO> list = ms.movieCategoryData(1);
			for(MovieVO vo:list)
			{
				URL url = new URL(vo.getPoster());
				Image img = ImageChange.getImage(new ImageIcon(url), 40, 50);
				 
					 Object[] data = { 
							 			new ImageIcon(img),			
										vo.getTitle(),
										vo.getGrade()
									 };
					 
					 // 평점 7.0이상 추천
					 if (Double.parseDouble(vo.getGrade()) > 7.0) {
						 model.addRow(data);
					 }
				 
			
			}
		}catch(Exception ex) {}

	}
}
