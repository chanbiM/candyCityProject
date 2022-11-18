package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JdbcUtill;
import vo.MemberVO;
import vo.PostVO;

public class PostDAO {
	//게시글 작성
	public int insertPost(PostVO postVo, MemberVO memberVo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into post values('post-'||post_seq.nextval,?,SYSDATE,?,?,?,'',?)";
	
		conn = JdbcUtill.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, postVo.getTitle());
			pstmt.setString(3, postVo.getContents());
			pstmt.setString(4, postVo.getCommentO());
			pstmt.setString(5, postVo.getPostType());
			
	
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt);
		}
		
		return n;
	}
	
	//게시글 수 업데이트
		public int updatePostNum(String id) {
			int n = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update member set post_num=post_num+1 where id=?";
			
			try {
				conn = JdbcUtill.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				n = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtill.close(conn, pstmt);
			}
			return n;
		}
}
