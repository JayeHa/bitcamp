package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository
public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL문
	private final String USER_INSERT
		= "INSERT INTO USERS (ID, PASSWORD, NAME, ROLE) "
		+ "VALUES (?, ?, ?, ?)";
	
	private final String USER_UPDATE
		= "UPDATE USERS SET PASSWORD = ?, NAME = ?, ROLE = ? WHERE ID = ?";
	
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ?";
	
	private final String USER_LIST
		= "SELECT * FROM USERS ORDER BY ROLE";
	
	//생성자
	public UserDAO() {
		System.out.println(">> UserDAO() 객체 생성");
	}
	
	//입력
	public void insertUser(UserVO vo) {
		System.out.println("==> JDBC로 InsertUser() 실행");	
		try {
			conn=JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			int i = 1;
			stmt.setString(i++, vo.getId());
			stmt.setString(i++, vo.getPassword());
			stmt.setString(i++, vo.getName());
			stmt.setString(i++, vo.getRole());
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
			
		}
	}
	
	//상세조회(회원 하나 조회)
	public UserVO getUser(UserVO vo) {
		System.out.println("==> JDBC로 getUser() 실행");
		UserVO user = null;
		conn = JDBCUtil.getConnection();
		if (conn == null) return null;		
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return user;
	}

}
