package osgi_carsaleserviceconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.governmentcarservicepublisher.IGovernmentTax;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	private String userInputForRecheck = null;
	private String userInputForGetTaxes = null;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("***** Start Consumer Service *****");
		serviceReference = bundleContext.getServiceReference(IGovernmentTax.class.getName());
		IGovernmentTax govTaxrates = (IGovernmentTax) bundleContext.getService(serviceReference);

		System.out.println("*******************************************************************");
		do {

			System.out.print("Enter Car Engine Capacity : ");
			int carEngineCC = sc.nextInt();

			System.out.print("Enter Car Price : ");
			double carPrice = sc.nextDouble();

			govTaxrates.getCarTaxRate(carEngineCC, carPrice);

			System.out.println("*******************************************************************\n");

			System.out.print("Do you want to know about Tax Rates(y/n) ? ");
			userInputForGetTaxes = sc.next();

			if (userInputForGetTaxes.equals("y") || userInputForGetTaxes.equals("Y")) {
				System.out.println(" ");
				govTaxrates.getAllTaxRates();

			}

			System.out.println(" ");

			System.out.print("Do you want to check TaxRate again (y/n) ? ");
			userInputForRecheck = sc.next();
			System.out.println(" ");

		} while (userInputForRecheck.equals("y") || userInputForRecheck.equals("Y"));

	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("***** Stop Cosnumer Service *****");
		bundleContext.ungetService(serviceReference);

	}

}
