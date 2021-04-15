package osgi_governmentcarservicepublisher;

public class GovernmentTaxImpl implements IGovernmentTax {

	static final double underThosusandCC = 0.1;
	static final double underTwoThosusandCC = 0.15;
	static final double underFiveThosusandCC = 0.2;
	static final double aboveFiveThosusandCC = 0.3;

	static final String underThosusandCC_String = "10%";
	static final String underTwoThosusandCC_String = "15%";
	static final String underFiveThosusandCC_String = "20%";
	static final String aboveFiveThosusandCC_String = "30%";

	private double taxWithCarPrice = 0;
	private double totalTax = 0;

	@Override
	public void getAllTaxRates() {
		// TODO Auto-generated method stub
		System.out.println("Tax For Car Engine 1000CC Below : " + underThosusandCC_String);
		System.out.println("Tax For Car Engine 2000CC Below : " + underTwoThosusandCC_String);
		System.out.println("Tax For Car Engine 5000CC Below : " + underFiveThosusandCC_String);
		System.out.println("Tax For Car Engine 5000CC Above : " + aboveFiveThosusandCC_String);

	}

	@Override
	public void getCarTaxRate(int engineCapacity, double carPrice) {
		// TODO Auto-generated method stub
		System.out.println(" ");

		if (engineCapacity <= 1000) {

			System.out.println("Tax For Car Engine 1000CC Below : " + underThosusandCC_String);

			totalTax = carPrice * underThosusandCC;
			taxWithCarPrice = carPrice + totalTax;

			System.out.println("Tax For Your Car : " + totalTax);
			System.out.println("Car Price With Tax : " + taxWithCarPrice);

		} else if (engineCapacity <= 2000) {

			System.out.println("Tax For Car Engine 2000CC Below : " + underTwoThosusandCC_String);

			totalTax = carPrice * underTwoThosusandCC;
			taxWithCarPrice = carPrice + totalTax;

			System.out.println("Tax For Your Car : " + totalTax);
			System.out.println("Car Price With Tax : " + taxWithCarPrice);

		} else if (engineCapacity <= 5000) {

			System.out.println("Tax For Car Engine 5000CC Below : " + underFiveThosusandCC_String);

			totalTax = carPrice * underFiveThosusandCC;
			taxWithCarPrice = carPrice + totalTax;

			System.out.println("Tax For Your Car : " + totalTax);
			System.out.println("Car Price With Tax : " + taxWithCarPrice);

		} else {

			System.out.println("Tax For Car Engine 5000CC Above : " + aboveFiveThosusandCC_String);

			totalTax = carPrice * aboveFiveThosusandCC;
			taxWithCarPrice = carPrice + totalTax;

			System.out.println("Tax For Your Car : " + totalTax);
			System.out.println("Car Price With Tax : " + taxWithCarPrice);

		}

		System.out.println("");
	}

}
