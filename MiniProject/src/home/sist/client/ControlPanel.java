package home.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import home.sist.client.BoardDetailPanel;
import home.sist.client.BoardInsertPanel;
import home.sist.client.BoardListPanel;

import home.sist.client.DetailPanel;
import home.sist.client.HomePanel;

public class ControlPanel extends JPanel {
	NewsPanel np = new NewsPanel();
	ChatPanel chp = new ChatPanel();
	FindPanel fp = new FindPanel();
	CardLayout card = new CardLayout();
	HomePanel hp;
	DetailPanel dp;
	BoardListPanel bp;
	BoardInsertPanel ip;
	BoardDetailPanel bdp;
	BoardUpdatePanel bup;
	BoardDeletePanel bdelp;
	public ControlPanel()
	{
//		setBackground(Color.yellow);
		dp = new DetailPanel(this);
		hp= new HomePanel(this);
		bp= new BoardListPanel(this);
		ip= new BoardInsertPanel(this);
		bdp=new BoardDetailPanel(this);
		bup=new BoardUpdatePanel(this);
		bdelp=new BoardDeletePanel(this);
		setLayout(card);
		add("home",hp);
		add("find",fp);
		add("news",np);
		add("chat",chp);
		add("detail",dp);
		add("board",bp);
		add("insert",ip);
		add("bdp",bdp);
		add("bup",bup);
    	add("delete",bdelp);
	}
}
