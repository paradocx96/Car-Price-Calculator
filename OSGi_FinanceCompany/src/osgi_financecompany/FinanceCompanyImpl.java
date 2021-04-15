package osgi_financecompany;

import java.text.NumberFormat;

public class FinanceCompanyImpl implements IFinanceCompany {

	double lastPrice, downpayment;
	int years;
		
	@Override
	public String financeCompany() {
		return "Connected to Finance Company.";
	}
	
	public FinanceCompanyImpl() {}
		
	public FinanceCompanyImpl(double lastPrice, double downpayment, int years) {
		super();
		this.lastPrice = lastPrice;
		this.downpayment = downpayment;
		this.years = years;
	}	

	@Override	
	public void CalculateInstallment() {
		
		double afterDownPaymentPrice = lastPrice - downpayment;
		double installmentPrice = afterDownPaymentPrice / (12 * years);		
		String price = String.format("%,.2f", installmentPrice);	
		
		System.out.println("A instalment amount is Rs." + price + "\n");		
	}
	

}
