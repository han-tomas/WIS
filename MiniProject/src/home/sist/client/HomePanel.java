package home.sist.client;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import home.sist.manager.MovieVO;

import home.sist.client.PosterCard;
import home.sist.manager.MovieVO;

public class HomePanel extends JPanel {
	PosterCard[] pcs = new PosterCard[20];
	JPanel pan = new JPanel();
	JButton b1,b2;
	JLabel pageLa;
	public HomePanel()
	{
//		setBackground(Color.blue);
		b1= new JButton("이전");
		b2= new JButton("다음");
		pageLa = new JLabel("0 page /0 page");
		setLayout(null);
		pan.setLayout(new GridLayout(4,5,5,5));
		
		pan.setBounds(10, 15, 730, 600);
		add(pan);
		JPanel p = new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		p.setBounds(10, 720, 730, 35);
		add(p);
	}
	public void cardPrint(List<MovieVO> list)
	{
		int i=0;
		for(MovieVO vo:list)
		{
			pcs[i]= new PosterCard(vo);
			pan.add(pcs[i]);
			i++;
		}
	}
	public void cardInit(List<MovieVO> list) 
	{
		/*for(int i=0;i<list.size();i++)
		{
			pcs[i].poLa.setIcon(null);
			pcs[i].tLa.setText("");
		}*/
		pan.removeAll();
		pan.validate();
	}
}

