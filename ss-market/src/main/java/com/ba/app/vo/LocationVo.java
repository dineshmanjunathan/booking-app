package com.ba.app.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationVo implements Serializable {
	private static final long serialVersionUID = -7187348510206952329L;
	private long id;
	private String location;
	private String address;
	private LocalDateTime createon = LocalDateTime.now();
	private LocalDateTime updatedon = LocalDateTime.now();

}
