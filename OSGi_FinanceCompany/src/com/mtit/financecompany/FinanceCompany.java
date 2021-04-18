// IT19180526 
// Chandrasiri S. A. N. L. D.

package com.mtit.financecompany;

public interface FinanceCompany {
	
	// Method for set details
	public void serviceInitialization(double carPrice, double downPayment, int years);
	
	// Method for get details to calculate Monthly installment	
	public void CalculateInstallment();
	
}
