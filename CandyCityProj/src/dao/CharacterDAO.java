package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JdbcUtill;
import vo.CharacterVO;
import vo.CostumeVO;
import vo.PostVO;

public class CharacterDAO {
	
	//입고 있는 의상 조회
	public CharacterVO getCharacterCode(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from character where id=?";
		CharacterVO result = new CharacterVO();
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result.setId(rs.getString("id"));
				result.setHead(rs.getString("head"));
				result.setEyes(rs.getString("eyes"));
				result.setBody(rs.getString("body"));
				result.setShoes(rs.getString("shoes"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//의상 조회
	public CostumeVO getCostumeInfo(String costumeCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from costume where costume_code=?";
		CostumeVO result = new CostumeVO();
		
		conn = JdbcUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, costumeCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result.setCostumeCode(rs.getString("costume_code"));
				result.setCostumeName(rs.getString("costume_name"));
				result.setPrice(rs.getInt("price"));
				result.setParts(rs.getString("parts"));
				result.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtill.close(conn, pstmt, rs);
		}
		
		return result;
	}
}
