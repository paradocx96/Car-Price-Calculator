package com.mtit.InstallmentModel;

public class Installment {

	private double lastPrice;
	private double downpayment;
	private int years;
	
	public Installment(double lastPrice, double downpayment, int years) {
		super();
		this.lastPrice = lastPrice;
		this.downpayment = downpayment;
		this.years = years;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public double getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(double downpayment) {
		this.downpayment = downpayment;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}	
}
