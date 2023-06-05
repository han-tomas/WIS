package com.sist.dao;
/*
GNO           NOT NULL NUMBER
RANK          NOT NULL NUMBER
TITLE         NOT NULL VARCHAR2(50)
SINGER        NOT NULL VARCHAR2(50)
ALBUM         NOT NULL VARCHAR2(50)
IDCREMENT     NOT NULL NUMBER
STATE         NOT NULL VARCHAR2(6)
*/
public class GenieMusicVO {
	private int gno,rank, idcrement;
	private String title,singer,album,state;
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
