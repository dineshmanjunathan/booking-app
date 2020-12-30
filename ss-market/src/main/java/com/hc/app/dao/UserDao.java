package com.hc.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hc.app.vo.UserVo;

@Service("userDao")
public interface UserDao {
	
	public UserVo findUser(UserVo user)throws SQLException;
	public List<UserVo> findUsers()throws SQLException;

}
