package com.ba.app.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	private String id;
	private String name;
	private String email;
	private Long phonenumber;
	private String password;
	private LocalDateTime createon = LocalDateTime.now();
	private LocalDateTime updatedon = LocalDateTime.now();
	private String role;
	private String memberStatus;
		
}
