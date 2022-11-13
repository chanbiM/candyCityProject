package vo;

import java.sql.Date;

public class PostVO {
	/*
	 * post_code VARCHAR2(20), id VARCHAR2(20), --쓴사람 write_date DATE NOT NULL,
	 * title VARCHAR2(30) NOT NULL, contents VARCHAR2(500) NOT NULL, comment_o
	 * CHAR(1),
	 */
	
	private String postCode;
	private String id;
	private Date write_date;
	private String title;
	private String contents;
	private String commentO;
	public PostVO() {
		// TODO Auto-generated constructor stub
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCommentO() {
		return commentO;
	}
	public void setCommentO(String commentO) {
		this.commentO = commentO;
	}
	
	
}
