package home.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	HomePanel hp = new HomePanel();
	FindPanel fp = new FindPanel();
	NewsPanel np = new NewsPanel();
	ChatPanel chp = new ChatPanel();
	CardLayout card = new CardLayout();
	public ControlPanel()
	{
//		setBackground(Color.yellow);
		setLayout(card);
		add("home",hp);
		add("find",fp);
		add("news",np);
		add("chat",chp);
	}
}
