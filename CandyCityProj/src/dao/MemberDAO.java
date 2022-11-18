package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtill;
import vo.MemberVO;
import vo.PostVO;

public class MemberDAO {
	
	//로그인(패스워드 확인) 
	public boolean getMemberPwd(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member where id=?";
		boolean result = false;
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("pwd")))
					result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//회원가입
	public int insertMember(MemberVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,NULL,?,?,join_member_seq.nextval,0,0,0,'X',SYSDATE,NULL)";
		
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			System.out.println(vo.getGender());
			System.out.println(vo.getPwd());
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getPwd());
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt);
		}
		
		return n;
		
	}
	
	//아이디 중복확인
	public boolean getMemberId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from member where id=?";
		boolean result = false;
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString("id")))
					result = true;
				System.out.println("id 있음");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//관리자 확인
	public boolean getAdmin(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select manager from member where id=?";
		boolean result = false;
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("manager").equals("O")) {
					result = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		return result;
	}
	
	//유저 조회
	public MemberVO getMemberInfo(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		MemberVO result = new MemberVO();
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setGender(rs.getString("gender"));
				result.setJoin_num(rs.getInt("join_num"));
				result.setCandy(rs.getInt("candy"));
				result.setPostNum(rs.getInt("post_num"));
				result.setCommentNum(rs.getInt("comment_num"));
				result.setManager(rs.getString("manager"));
				result.setJoinDate(rs.getDate("join_date"));
				result.setLoginDate(rs.getDate("login_date"));
				result.setIntroduce(rs.getString("introduce"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//마지막 로그인 날짜
	public int updateLoginDate(String id) {
		int n = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set login_date=SYSDATE where id=?";
		
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
	
	//랭킹
	public ArrayList<MemberVO> getRank(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select ROWNUM, a.* from (SELECT id, name, post_num, RANK()OVER (order by post_num desc) rk "
				+ "FROM member ORDER BY rk asc) a where ROWNUM <= 4";
		
		try {
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPostNum(rs.getInt("post_num"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("테이블 데이터 조회 실패");
		} finally {
			 JdbcUtill.close(conn, pstmt, rs);
		}
		return list;
	}

	//미니홈피 조회
	public ArrayList<MemberVO> getHomepiList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member ORDER BY name asc";
		
		try {
			conn = JdbcUtill.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setJoinDate(rs.getDate("join_date"));
				vo.setLoginDate(rs.getDate("login_date"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("테이블 데이터 조회 실패");
		} finally {
			 JdbcUtill.close(conn, pstmt, rs);
		}
		return list;
	}
}

	

	
