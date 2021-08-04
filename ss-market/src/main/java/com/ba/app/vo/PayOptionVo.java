package com.ba.app.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayOptionVo implements Serializable {
	private static final long serialVersionUID = -7187348510206952329L;
	private Long id;
	private String payOption;
	private String details;
	private LocalDateTime createon = LocalDateTime.now();
	private LocalDateTime updatedon = LocalDateTime.now();

}
