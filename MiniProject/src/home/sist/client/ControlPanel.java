package home.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	HomePanel hp = new HomePanel();
	FindPanel fp = new FindPanel();
	DetailPanel dp = new DetailPanel();
	NewsPanel np = new NewsPanel();
	ChatPanel chp = new ChatPanel();
	CardLayout card = new CardLayout();
	public ControlPanel()
	{
//		setBackground(Color.yellow);
		setLayout(card);
		add("hone",hp);
		add("find",fp);
		add("detail",dp);
		add("news",np);
		add("chat",chp);
	}
}
