package com.the.simone.seor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema="cachethesimone", name = "otpCache")
public class Otp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactioId;
	private String otp;
	private String username;
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getTransactioId() {
		return transactioId;
	}
	public void setTransactioId(long transactioId) {
		this.transactioId = transactioId;
	}
	
	
	
	

}
