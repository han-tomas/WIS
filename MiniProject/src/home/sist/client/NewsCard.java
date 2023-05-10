package home.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class NewsCard extends JPanel{
	JLabel titleLa;
	JTextPane contentTa;
	JLabel dateLa;
	public NewsCard()
	{
		setLayout(null);
		titleLa = new JLabel("");
		contentTa = new JTextPane();
		contentTa.setEditable(false);
		JScrollPane js = new JScrollPane(contentTa);
		dateLa = new JLabel("");
		
		// 배치
		titleLa.setBounds(10, 10, 450, 15);
		js.setBounds(10, 25, 600, 100);
		dateLa.setBounds(470, 10, 200, 15);
		
		// 추가
		add(titleLa);
		add(js);
		add(dateLa);
	}
}
