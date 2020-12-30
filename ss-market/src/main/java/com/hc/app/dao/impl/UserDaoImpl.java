package com.hc.app.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hc.app.dao.UserDao;
import com.hc.app.vo.UserVo;
import com.hc.dbconnection.DBConnection;

@Component
public class UserDaoImpl implements UserDao{

	static Connection con;
	static PreparedStatement ps;
	
	@Override	
	public UserVo findUser(UserVo user)throws SQLException { 
		UserVo ab = new UserVo();
		ResultSet rs=null;
		/*try { 
			con=DBConnection.getConnection();
			ps=con.prepareStatement("SELECT * FROM T_USER WHERE user_id=? and password=?");
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery(); 
			while(rs.next()) {  
				ab.setUserId(rs.getString("user_id"));
				ab.setName(rs.getString("user_name").trim());
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role").trim());
			}  
		} catch(SQLException e) {
			System.out.println("Error in findUser"+e.getMessage());
			throw e;			
		} finally {
			closeConnectionrspscon(rs, ps, con);
		}*/
		return ab;
	}
	
	@Override	
	public List<UserVo> findUsers()throws SQLException{
		List<UserVo> list = new ArrayList<>();
		ResultSet rs = null;
		/*try{
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM T_USER");
			rs = ps.executeQuery();
			while(rs.next()) {
				UserVo ab = new UserVo();
				ab.setUserId(rs.getString("user_id"));
				ab.setName(rs.getString("name"));
				ab.setDob(rs.getString("dob"));
				ab.setDepartment(rs.getString("department"));
				ab.setDesignation(rs.getString("designation"));
				ab.setEmail(rs.getString("email"));
				BigDecimal bigdecimal = rs.getBigDecimal("mobile");
				ab.setMobile(bigdecimal.toString());
				ab.setLocation(rs.getString("location"));
				ab.setRole(rs.getString("role"));
				ab.setPassword(rs.getString("password")); 
				list.add(ab);
			} 
		}catch(SQLException e) {
			System.out.println("Error in findUsers"+e.getMessage());
			throw e;
		}finally {
			 closeConnectionrspscon(rs, ps, con);
		} */
		return list;  
	}
	
	
	public void closeConnectionpscon(PreparedStatement ps, Connection con) {
		try {
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnectionrspscon(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
