package com.ba.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_booking")
public class Booking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7187348510206952329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String from;
	private String to ;
	private Long bookingNo;
	private LocalDateTime bookedOn ;
	private Long lrNumber;
	private String fromName;
	private String toName;
	
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
	private BigDecimal total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Long getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(Long bookingNo) {
		this.bookingNo = bookingNo;
	}
	public LocalDateTime getBookedOn() {
		return bookedOn;
	}
	public void setBookedOn(LocalDateTime bookedOn) {
		this.bookedOn = bookedOn;
	}
	public Long getLrNumber() {
		return lrNumber;
	}
	public void setLrNumber(Long lrNumber) {
		this.lrNumber = lrNumber;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public Long getFrom_phone() {
		return from_phone;
	}
	public void setFrom_phone(Long from_phone) {
		this.from_phone = from_phone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getFromValue() {
		return fromValue;
	}
	public void setFromValue(BigDecimal fromValue) {
		this.fromValue = fromValue;
	}
	public Long getInvNo() {
		return invNo;
	}
	public void setInvNo(Long invNo) {
		this.invNo = invNo;
	}
	public Long getTinNo() {
		return tinNo;
	}
	public void setTinNo(Long tinNo) {
		this.tinNo = tinNo;
	}
	public String getBillDesc() {
		return billDesc;
	}
	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc;
	}
	public Long getBillValue() {
		return billValue;
	}
	public void setBillValue(Long billValue) {
		this.billValue = billValue;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	public Boolean getIsPrinted() {
		return isPrinted;
	}
	public void setIsPrinted(Boolean isPrinted) {
		this.isPrinted = isPrinted;
	}
	public Long getTo_phone() {
		return to_phone;
	}
	public void setTo_phone(Long to_phone) {
		this.to_phone = to_phone;
	}
	public Long getItem_count() {
		return item_count;
	}
	public void setItem_count(Long item_count) {
		this.item_count = item_count;
	}
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	public String getFreight_status() {
		return freight_status;
	}
	public void setFreight_status(String freight_status) {
		this.freight_status = freight_status;
	}
	public BigDecimal getFreight_value() {
		return freight_value;
	}
	public void setFreight_value(BigDecimal freight_value) {
		this.freight_value = freight_value;
	}
	public BigDecimal getLoading_charges() {
		return loading_charges;
	}
	public void setLoading_charges(BigDecimal loading_charges) {
		this.loading_charges = loading_charges;
	}
	public BigDecimal getDoor_pick_charges() {
		return door_pick_charges;
	}
	public void setDoor_pick_charges(BigDecimal door_pick_charges) {
		this.door_pick_charges = door_pick_charges;
	}
	public BigDecimal getOther_charges() {
		return other_charges;
	}
	public void setOther_charges(BigDecimal other_charges) {
		this.other_charges = other_charges;
	}
	public BigDecimal getTotal_charges() {
		return total_charges;
	}
	public void setTotal_charges(BigDecimal total_charges) {
		this.total_charges = total_charges;
	}
	public BigDecimal getPaid() {
		return paid;
	}
	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}
	public BigDecimal getTopay() {
		return topay;
	}
	public void setTopay(BigDecimal topay) {
		this.topay = topay;
	}
	public BigDecimal getCash() {
		return cash;
	}
	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}
	public BigDecimal getRefund() {
		return refund;
	}
	public void setRefund(BigDecimal refund) {
		this.refund = refund;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
