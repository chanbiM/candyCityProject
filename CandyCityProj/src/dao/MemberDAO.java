package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;
import vo.MemberVO;

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
				System.out.println(rs.getString("pwd"));
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
		String sql = "insert into member(id, name, gender, pwd, join_num, candy, post_num, comment_num, manager) "
				+ "values(?,?,?,?,join_member_seq.nextval,0,0,0,'X')";
		
		
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
}
