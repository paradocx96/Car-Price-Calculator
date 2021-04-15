package osgi_carsale;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import osgi_financecompany.FinanceCompanyImpl;
import osgi_financecompany.IFinanceCompany;

public class Activator implements BundleActivator {

	Scanner scanner = new Scanner(System.in);
	ServiceReference serviceReference;	

	// variable for continue checking
	String checkAgain;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Car Sale Start");
		
		serviceReference = context.getServiceReference(IFinanceCompany.class.getName());
		IFinanceCompany iFinanceCompany = (IFinanceCompany) context.getService(serviceReference);
		System.out.println(iFinanceCompany.financeCompany());
		
		System.out.println("*******************************************************************\n");
		
		do {
			System.out.print("Enter car Price : ");
			double carPrice = scanner.nextDouble();

			System.out.print("Enter DownPayment Value : ");
			double downPayment = scanner.nextDouble();

			System.out.print("How long you need finance support. Enter years : ");
			int years = scanner.nextInt();

			FinanceCompanyImpl financeCompanyImpl = new FinanceCompanyImpl(carPrice, downPayment, years);

			financeCompanyImpl.CalculateInstallment();
			
			System.out.println("*******************************************************************\n");

			// ask subscriber to continue
			System.out.print("Do you want to check again (y/n) ? ");
			checkAgain = scanner.next();
			System.out.println();

		} while (checkAgain.equals("y"));
	
	}
	
//	private void active(BundleContext context) throws Exception {}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Car Sale Stop");
		context.ungetService(serviceReference);
	}

}
