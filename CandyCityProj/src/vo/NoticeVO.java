package vo;

import java.sql.Date;

public class NoticeVO {
////notice_code VARCHAR2(20),
//    id VARCHAR2(20),
//    type CHAR(1), --이벤트 E, 공지사항 N, 당첨자 R
//    title VARCHAR2(30) NOT NULL,
//    contents VARCHAR2(500) NOT NULL,
//    end_o CHAR(1),
//    write_date DATE NOT NULL,
	
	private String noticeCode;
	private String id;
	private String type;
	private String title;
	private String contents;
	private String endO;
	private Date writeDate;
	
	
	public NoticeVO() {
		super();
		
	}
	public String getNoticeCode() {
		return noticeCode;
	}
	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getEndO() {
		return endO;
	}
	public void setEndO(String endO) {
		this.endO = endO;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
}
