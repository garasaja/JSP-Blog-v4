package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.model.Reply;
import com.cos.blog.model.Users;

//DAO
public class ReplyRepository {
	private static final String TAG = "ReplyRepository : ";
	private static ReplyRepository instance = new ReplyRepository();
	private ReplyRepository() {}
	public static ReplyRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int save(Reply reply) {
		final String SQL = "";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물을표 완성
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt);
		}		
		return -1;
	}
	
	public int update(Reply reply) {
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

	public List<Reply> findAll() {
		final String SQL = "";
		List<Reply> reply = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			// 물을표 완성
			
			//while문 돌려서 오브젝트에 집어넣기
			return reply;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "find : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt,rs);
		}		
		return null;
	}

	public Reply findById(int id) {
		final String SQL = "";
		Reply reply = new Reply();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			// 물을표 완성
			
			//if문 돌려서 오브젝트에 집어넣기
			return reply;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "find : " + e.getMessage());
		} finally {
			DBConn.close(conn,pstmt,rs);
		}		
		return null;
	}
}
