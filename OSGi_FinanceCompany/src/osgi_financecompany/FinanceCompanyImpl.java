package osgi_financecompany;

public class FinanceCompanyImpl implements IFinanceCompany {

	double lastPrice, downpayment;
	int years;
	
	public FinanceCompanyImpl() {
		this.lastPrice = 0.0;
		this.downpayment = 0.0;
		this.years = 0;
	}
		
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
		
		String vehiclePrice = String.format("%,.2f", lastPrice);
		String downPayment = String.format("%,.2f", downpayment);
		String price = String.format("%,.2f", installmentPrice);
		
		System.out.println("\nVehicle Price Rs." + vehiclePrice);
		System.out.println("Down-Payment Rs." + downPayment);
		System.out.println("Monthly installment(Without TAX/Rate) is Rs." + price + "\n");		
	}
	

}
