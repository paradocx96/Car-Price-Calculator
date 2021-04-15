package osgi_governmentcarservicepublisher;

public interface IGovernmentTax {

	public void getAllTaxRates();

	public void getCarTaxRate(int engineCapacity, double carPrice);

}
