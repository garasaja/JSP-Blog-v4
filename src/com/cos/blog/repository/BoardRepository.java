package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.model.Board;


//DAO
public class BoardRepository {
	private static final String TAG = "BoardRepository : ";
	private static BoardRepository instance = new BoardRepository();
	private BoardRepository() {}
	public static BoardRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int save(Board board) {
		final String SQL = "INSERT INTO board(id, userId, title, content, readCount, createDate) VALUES(board_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성하기
			pstmt.setInt(1, board.getUserId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getReadcount());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+"save : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(Board board) {
		final String SQL = "";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물을표 완성
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt);
		}		
		return -1;
	}
	
	public int deleteById(int id) {
		final String SQL = "";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물을표 완성
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "delete : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt);
		}		
		return -1;
	}

	public List<Board> findAll() {
		final String SQL = "SELECT * FROM board ORDER BY id DESC";
		List<Board> boards = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			//while문 돌려서 오브젝트에 집어넣기
			while(rs.next()) {
				Board board = new Board(
						rs.getInt("id"),
						rs.getInt("userId"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("readCount"),
						rs.getTimestamp("createDate")
						);
				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "find : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt,rs);
		}		
		return null;
	}

	public Board findById(int id) {
		final String SQL = "";
		Board board = new Board();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			// 물을표 완성
			
			//if문 돌려서 오브젝트에 집어넣기
			return board;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "find : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt,rs);
		}		
		return null;
	}
}
