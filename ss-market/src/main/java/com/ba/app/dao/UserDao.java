package com.ba.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ba.app.vo.MemberVo;

@Service("userDao")
public interface UserDao {
	
	public MemberVo findUser(MemberVo user)throws SQLException;
	public List<MemberVo> findUsers()throws SQLException;

}
