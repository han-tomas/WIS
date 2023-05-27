package home.sist.movie;
// 데이터 저장
/*
 *    1|
 *    쇼생크 탈출|
 *    드라마|
 *    https://movie-phinf.pstatic.net/20160119_278/...|
 *    팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|
 *    2016 .02.24 재개봉, 1995 .01.28 개봉|
 *    15세 관람가|
 *    프랭크 다라본트
 */
public class MovieVo {
	// 은닉화
	private int no;
	private String title;
	private String genre;
	private String posterLink;
	private String actor;
	private String regDate;
	private String age;
	private String director;
	
	//캡슐화
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPosterLink() {
		return posterLink;
	}
	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
