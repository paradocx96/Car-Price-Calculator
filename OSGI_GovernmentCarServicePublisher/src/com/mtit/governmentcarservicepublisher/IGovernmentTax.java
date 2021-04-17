package com.mtit.governmentcarservicepublisher;

public interface IGovernmentTax {

	public void getAllTaxRates();

	public void getCarTaxRate(int engineCapacity, double carPrice);
	
	public double getTotalPrice();

}
