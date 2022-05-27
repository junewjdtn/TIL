package com.mvc.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDao {
	
	public List<MVCBoardDto> selectAll(){
		Connection con = getConnection();
		// 실행하기 위한 stmt
		Statement stmt = null;
		
		// 결과를 저장할 rs
		ResultSet rs = null;
		
		// 결과를 옮겨 담을 res
		List<MVCBoardDto> res = new ArrayList<MVCBoardDto>();
		
		String sql = " SELECT * FROM MVCBOARD ORDER BY SEQ DESC ";
		
		try {
			// sql 문을 데이터베이스에 보내기 위한 객체
			stmt = con.createStatement();
			System.out.println("03. query 준비: " + sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			// db의 테이블 내의 데이터를 한줄 추가 후 다음줄 추가 반복
			while(rs.next()) {
				// 테이블 첫번째 줄의 첫번째 값, 두번째값 .... 5번째 값 가져옴 (tmp에 저장)
				MVCBoardDto tmp = new MVCBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
												   rs.getString(4), rs.getDate(5));
				// 가져온 결과값(tmp)을 res에 추가
				res.add(tmp);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto res = new MVCBoardDto();
		
		String sql = " SELECT * FROM MVCBOARD WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("03. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				res.setSeq(rs.getInt(1));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	public int insert(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MVCBOARD VALUES(NULL, ?, ?, ?, NOW()) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. query 준비: "+ sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	public int delete(int seq) {
		
		return 0;
	}
	
	public int selectDelete(String[] seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		int[] cnt = null;
		
		// 삭제할 sql문 작성
		String sql = " DELETE FROM MVCBOARD WHERE SEQ=? ";
		
		try {
			// 삭제할 sql문을 준비(mysql과 연결)
			pstm = con.prepareStatement(sql);
			
			// 넘어온 seq의 길이만큼 반복문을 통해 sql문 작성
			for(int i=0; i<seq.length; i++) {
				pstm.setString(1, seq[i]);
				
				// 삭제할 sql문을 담아두기
				pstm.addBatch();
				System.out.println("03. query 준비 : "+ sql + " [seq=" + seq[i] + "]");
			}
			// 삭제할 sql문들을 cnt 배열에 담아, 담은 것을 실행하기(담은것을 삭제 실행)
			cnt = pstm.executeBatch();
			System.out.println("04. query 실행 및 리턴");

			// 내가 선택한 삭제 갯수와 삭제 성공한 갯수를 비교
			for(int i=0; i<cnt.length; i++) {
				if(cnt[i] == 1) {
					res++;
				}
			}
			
			// 선택한 삭제 갯수와 삭제 성공한 갯수가 같으면 저장 실패하면 롤백
			if(seq.length == res) {
				commit(con);
			} else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("03/04 단계 에러");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}

}
