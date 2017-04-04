package com.org.hackaton.model;

//import java.util.Date;

public class Tranaction {
	
	private String tranactionDate;
	private int customerId;
	private float transAmount;
	private String transType;
	public Tranaction()
	{
		
	}
	public Tranaction(String tranactionDate, int customerId, float transAmount,
			String transType) {
		super();
		this.tranactionDate = tranactionDate;
		this.customerId = customerId;
		this.transAmount = transAmount;
		this.transType = transType;
	}
	public String getTranactionDate() {
		return tranactionDate;
	}
	public void setTranactionDate(String tranactionDate) {
		this.tranactionDate = tranactionDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(float transAmount) {
		this.transAmount = transAmount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
	

}
