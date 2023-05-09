package home.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import home.sist.client.DetailPanel;
import home.sist.client.HomePanel;

public class ControlPanel extends JPanel {
	NewsPanel np = new NewsPanel();
	ChatPanel chp = new ChatPanel();
	FindPanel fp = new FindPanel();
	CardLayout card = new CardLayout();
	HomePanel hp;
	DetailPanel dp;
	public ControlPanel()
	{
//		setBackground(Color.yellow);
		dp = new DetailPanel(this);
		hp= new HomePanel(this);
		setLayout(card);
		add("home",hp);
		add("find",fp);
		add("news",np);
		add("chat",chp);
		add("detail",dp);
	}
}
