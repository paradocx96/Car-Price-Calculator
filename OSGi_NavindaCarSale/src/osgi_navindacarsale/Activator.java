package osgi_navindacarsale;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import osgi_financecompany.FinanceCompanyImpl;
import osgi_financecompany.IFinanceCompany;
import osgi_governmentcarservicepublisher.IGovernmentTax;

public class Activator implements BundleActivator {

	
	ServiceReference serviceReference_FinanceCompany, serviceReference_GovernmentTax;
	Scanner scanner = new Scanner(System.in);
	private String checkService = null;
	private String checkVal = null;
	private int service = 0;
	private String userInputForRecheck = null;
	private String userInputForGetTaxes = null;	
	private static final String STARS = "****************************************************\n";
	private static final String LINE1 = "******** Welcome to Vehice Price Calculator ********\n";
	private static final String LINE2 = "Choose a Service to help you\n";
	private static final String LINE3 = "1. Manufacture Company Service";
	private static final String LINE4 = "2. Government Tax Service";
	private static final String LINE5 = "3. Finance Company Service\n";
	private static final String LINE6 = "Enter a Serveice (1-3) : ";
	private static final String LINE7 = "********** Start Navinda Car Sale Service **********";
	private static final String LINE8 = "********** Stop Navinda Car Sale Service ***********";
	private static final String LINE9 = "******** Welcome to Government Tax Service *********\n";
	private static final String LINE10 = "******** Welcome to Finance Company Service ********\n";
	private static final String INVALID = "Invalid Input Please Try Again!";
	private static final String ENTER_ENGINE_CAPACITY = "Enter Car Engine Capacity : ";
	private static final String ENTER_VAHICLE_PRICE = "Enter Vehicle Price : ";
	private static final String ENTER_DOWN_PAYMENT = "Enter Down-Payment Value : ";
	private static final String ENTER_YEARS = "How long you need finance support. Enter years : ";
	private static final String CHECK_TAX1 = "Do you want to know about Tax Rates(y/n) ? ";
	private static final String CHECK_TAX2 = "Do you want to check Tax Rates again (y/n) ? ";
	private static final String CHECK_FINANCE = "Do you want to calcualte again (y/n)? ";
	private static final String CHECK_MAIN = "\nDo you want to use any other service (y/n)? ";
	private static final String EXIT = "********** Exit from Application Services **********";

	public void start(BundleContext context) throws Exception {

		System.out.println(LINE7);
		
		/*  
		 * Registering services
		 */
		
		// Registering car sale with Government Tax service
		serviceReference_GovernmentTax = context.getServiceReference(IGovernmentTax.class.getName());
		IGovernmentTax govTaxrates = (IGovernmentTax) context.getService(serviceReference_GovernmentTax);

		// Registering car sale with Finance Company service
		serviceReference_FinanceCompany = context.getServiceReference(IFinanceCompany.class.getName());
		IFinanceCompany iFinanceCompany = (IFinanceCompany) context.getService(serviceReference_FinanceCompany);
		
		/*
		 * Start Navinda Car Sale Functions
		 */
		System.out.println(LINE1);
		System.out.println(LINE2);
		System.out.println(LINE3);
		System.out.println(LINE4);
		System.out.println(LINE5);
		System.out.print(LINE6);
		service = scanner.nextInt();
		
		do {
			
			if(service == 1) {
				
				/*  
				 * Calling Manufacturer company services
				 */					
				System.out.println("1. Manufacture Company Service");
				
			} else if (service == 2) {
				
				/*  
				 * Calling Finance Government Tax services
				 */			
				do {
					System.out.println(STARS);
					System.out.println(LINE9);
					
					System.out.print(ENTER_ENGINE_CAPACITY);
					int carEngineCC = scanner.nextInt();

					System.out.print(ENTER_VAHICLE_PRICE);
					double carPrice = scanner.nextDouble();

					govTaxrates.getCarTaxRate(carEngineCC, carPrice);

					System.out.println(STARS);

					System.out.print(CHECK_TAX1);
					userInputForGetTaxes = scanner.next();
					System.out.println(" ");
					if (userInputForGetTaxes.equals("y") || userInputForGetTaxes.equals("Y")) {				
						govTaxrates.getAllTaxRates();
					}

					System.out.println(STARS);

					System.out.print(CHECK_TAX2);
					userInputForRecheck = scanner.next();
					System.out.println(" ");

				} while (userInputForRecheck.equals("y") || userInputForRecheck.equals("Y"));
				
				System.out.println(STARS);
				
			} else if (service == 3) {
				
				/*  
				 * Calling Finance company services 
				 */		
				do {
					System.out.println(STARS);
					System.out.println(LINE10);

					// Getting keyboard input to calculate Monthly installment
					System.out.print(ENTER_VAHICLE_PRICE);
					double carPrice = scanner.nextDouble();

					System.out.print(ENTER_DOWN_PAYMENT);
					double downPayment = scanner.nextDouble();

					System.out.print(ENTER_YEARS);
					int years = scanner.nextInt();

					// Pass the value to Finance company as parameters
					FinanceCompanyImpl financeCompanyImpl = new FinanceCompanyImpl(carPrice, downPayment, years);

					// Calling Installment calculation method
					financeCompanyImpl.CalculateInstallment();

					System.out.println(STARS);

					// Check user to do the calculation again
					System.out.print(CHECK_FINANCE);
					checkVal = scanner.next();
					System.out.println();

				} while (checkVal.equals("y") || checkVal.equals("Y"));

				System.out.println(STARS);
				
			} else {
				
				System.out.println(STARS);
				System.out.println(INVALID);
				System.out.println(STARS);
			}
			
			// Check user to do the calculation again
			System.out.print(CHECK_MAIN);
			checkService = scanner.next();
			System.out.println();
			
			if (checkService.equals("y") || checkService.equals("Y")) {
				
				System.out.println(LINE1);
				System.out.println(LINE2);
				System.out.println(LINE3);
				System.out.println(LINE4);
				System.out.println(LINE5);
				System.out.print(LINE6);
				service = scanner.nextInt();
			}
			
		} while (checkService.equals("y") || checkService.equals("Y"));
		
		System.out.println(EXIT);
		System.out.println(STARS);		
	}

	// Method Stop Car sale service
	public void stop(BundleContext context) throws Exception {
		System.out.println(LINE8);
		
		// Unregistering Government Tax
		context.ungetService(serviceReference_GovernmentTax);
				
		// Unregistering Finance Company
		context.ungetService(serviceReference_FinanceCompany);
	}

}
