package com.ba.app.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class BookingVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	private String id;
	private String from;
	private String to ;
	private Long bookingNo;
	private LocalDateTime bookedOn ;
	private Long lrNumber;
	
	private Long from_phone;
	private String remarks;
	private BigDecimal fromValue;
	private Long invNo;
	private Long tinNo;
	private String billDesc;
	private Long billValue;
	private String bookedBy;
	private Boolean isPrinted;
	
	private Long to_phone;
	private Long item_count;
	private Long weight;
	private String freight_status;
	private BigDecimal freight_value;
	private BigDecimal loading_charges;
	private BigDecimal door_pick_charges;
	private BigDecimal other_charges;
	private BigDecimal total_charges;
	private BigDecimal paid;
	private BigDecimal topay;
	private BigDecimal cash;
	private BigDecimal refund;
	
	
		
}
