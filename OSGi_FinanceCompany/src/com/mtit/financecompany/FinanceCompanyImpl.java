package com.mtit.financecompany;

import com.mtit.InstallmentModel.Installment;

public class FinanceCompanyImpl implements FinanceCompany {
	
	Installment installment;
	
	@Override
	public void serviceInitialization(double carPrice, double downPayment, int years) {		
		installment = new Installment(carPrice, downPayment, years);		
	}

	@Override	
	public void CalculateInstallment() {
		
		double afterDownPaymentPrice = installment.getLastPrice() - installment.getDownpayment();
		double installmentPrice = afterDownPaymentPrice / (12 * installment.getYears());
		
		String vehiclePrice = String.format("%,.2f", installment.getLastPrice());
		String downPayment = String.format("%,.2f", installment.getDownpayment());
		String price = String.format("%,.2f", installmentPrice);
		
		System.out.println("\nVehicle Price Rs." + vehiclePrice);
		System.out.println("Down-Payment Rs." + downPayment);
		System.out.println("Monthly installment(Without TAX/Rate) is Rs." + price + "\n");		
	}

	
	

}
