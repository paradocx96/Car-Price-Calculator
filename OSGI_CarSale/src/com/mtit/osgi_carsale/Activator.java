// IT19238722
// I.H.A.H.Karunathilaka

package com.mtit.osgi_carsale;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.financecompany.FinanceCompany;
import com.mtit.governmentcarservicepublisher.IGovernmentTax;
import com.mtit.hondapublisher.HondaServicePublish;
import com.mtit.toyotapublisherService.ToyotaServicePublish;

public class Activator implements BundleActivator {	

	Scanner scanner = new Scanner(System.in);
	private String checkEntrance = new String();
	private String checkService = new String();
	private String checkVal = new String();
	private String checkFinance = new String();
	private String userInputForRecheck = new String();
	private String userInputForGetTaxes = new String();
	private String checkBrand = "continue";
	private String model = new String();
	private int engineCapacity = 0;
	private double price = 0;
	private double profit = 0;
	private double totalPrice = 0;

	private static final String STARS = "************************************************************\n";
	private static final String WELCOME_CALCULATOR = "********** Welcome to Car Price Calculator **********\n";
	private static final String EXIT_CALCULATOR = "********** Exit from Application Services **********";
	private static final String WELCOME_GOVERNMENT_TAX = "++++++++++ Welcome to Government Tax Service\n";
	private static final String WELCOME_FINANCE_COMPANY = "++++++++++ Welcome to Finance Company Service\n";
	private static final String WELCOME_MANUFACTURER = "++++++++++ Welcome to Manufacture Company Service\n";
	private static final String CARSALE_START = "********** Start Car Sale Consumer";
	private static final String CARSALE_STOP = "********** Stop Car Sale Service";
	private static final String INVALID = "Invalid Input Please Try Again!";
	private static final String INVALID_BRAND = "Sorry! The brand you entered is not currently supported.";
	private static final String ENTER_BRAND = "Enter Car brand (Honda/Toyota) or Exit to Exit from interface : ";
	private static final String ENTER_MODEL = "Enter the model : ";
	private static final String ENTER_ENGINE_CAPACITY = "Enter Car Engine Capacity : ";
	private static final String ENTER_CAR_PRICE = "Enter Car Price : ";
	private static final String ENTER_DOWN_PAYMENT = "\nEnter Down-Payment Value : ";
	private static final String ENTER_YEARS = "How long you need finance support. Enter years : ";
	private static final String CAR_ENGINE_CAPACITY = "Car Engine Capacity : ";
	private static final String CAR_PRICE = "Car Price : ";
	private static final String CAR_BRAND = "\nCar Brand : ";
	private static final String CAR_MODEL = "Car Model : ";
	private static final String CAR_MANUFACTURE_PRICE = "Manufacturer Price : ";
	private static final String CHECK_TAX1 = "Do you want to know about Tax Rates(y/n) ? ";
	private static final String CHECK_TAX2 = "Do you want to check Tax Rates again (y/n) ? ";
	private static final String CHECK_FINANCE = "Do you want to calcualte monthly installment again (y/n)? ";
	private static final String CHECK_FINANCE_SUPPORT = "Do you need to check Finance support(y/n) ? ";
	private static final String CHECK_MAIN = "\nDo you want to use Application again (y/n)? ";
	private static final String CHECK_FIRST = "\nDo you want to process Application(yes/exit) ? ";
	
	ServiceReference serviceReference_FinanceCompany, serviceReference_GovernmentTax, toyotaServiceReference, hondaServiceReference;

	public void start(BundleContext context) throws Exception {

		System.out.println(CARSALE_START);

		/*
		 * Registering services
		 */

		// Registering car sale with Toyota Manufacture service
		toyotaServiceReference = context.getServiceReference(ToyotaServicePublish.class.getName());
		ToyotaServicePublish toyotaServicePublish = (ToyotaServicePublish) context.getService(toyotaServiceReference);
		toyotaServicePublish.publishService();

		// Registering car sale with Honda Manufacture service
		hondaServiceReference = context.getServiceReference(HondaServicePublish.class.getName());
		HondaServicePublish hondaServicePublish = (HondaServicePublish) context.getService(hondaServiceReference);
		hondaServicePublish.publishService();

		// Registering car sale with Government Tax service
		serviceReference_GovernmentTax = context.getServiceReference(IGovernmentTax.class.getName());
		IGovernmentTax govTaxrates = (IGovernmentTax) context.getService(serviceReference_GovernmentTax);

		// Registering car sale with Finance Company service
		serviceReference_FinanceCompany = context.getServiceReference(FinanceCompany.class.getName());
		FinanceCompany financeCompany = (FinanceCompany) context.getService(serviceReference_FinanceCompany);

		/*
		 * Start Car Sale Functions
		 */

		System.out.println(WELCOME_CALCULATOR);
		System.out.print(CHECK_FIRST);
		checkEntrance = scanner.next();
		System.out.println();

		if (checkEntrance.equals("yes") || checkEntrance.equals("YES")) {

			do {
				// ************************************************************************
				/*
				 * Calling Manufacturer company services
				 */

				System.out.println(WELCOME_MANUFACTURER);				

				while (!checkBrand.equals("exit")) {

					System.out.print(ENTER_BRAND);
					checkBrand = scanner.next();

					if (checkBrand.equals("exit")) {

						break;

					} else {

						if (checkBrand.toLowerCase().equals("toyota")) {

							System.out.print(ENTER_MODEL);
							model = scanner.next();
							engineCapacity = toyotaServicePublish.getEngineCapacity(model);
							price = toyotaServicePublish.getPrice(model);

							if (engineCapacity == -1) {
								continue;
							}
						} else if (checkBrand.toLowerCase().equals("honda")) {

							System.out.print(ENTER_MODEL);
							model = scanner.next();
							engineCapacity = hondaServicePublish.getEngineCapacity(model);
							price = hondaServicePublish.getPrice(model);

							if (engineCapacity == -1) {
								continue;
							}
						} else {
							System.out.println(INVALID_BRAND);
							continue;
						}

						System.out.println(CAR_BRAND + checkBrand);
						System.out.println(CAR_MODEL + model);
						System.out.println(CAR_ENGINE_CAPACITY + engineCapacity);
						System.out.println(CAR_MANUFACTURE_PRICE + price + "\n");
					}

				}


				// ************************************************************************
				/*
				 * Calling Government Tax services
				 */
				do {
					System.out.println(STARS);
					System.out.println(WELCOME_GOVERNMENT_TAX);

					System.out.print(CAR_ENGINE_CAPACITY + engineCapacity + "CC\n");
					// int carEngineCC = scanner.nextInt();

					System.out.print(CAR_PRICE + price);
					// double carPrice = scanner.nextDouble();

					govTaxrates.getCarTaxRate(engineCapacity, price);

					System.out.println(STARS);

					System.out.print(CHECK_TAX1);
					userInputForGetTaxes = scanner.next();
					System.out.println(" ");
					if (userInputForGetTaxes.equals("y") || userInputForGetTaxes.equals("Y")) {
						govTaxrates.getAllTaxRates();
						System.out.println();
					}

					System.out.println(STARS);

					System.out.print(CHECK_TAX2);
					userInputForRecheck = scanner.next();
					System.out.println(" ");

				} while (userInputForRecheck.equals("y") || userInputForRecheck.equals("Y"));

				System.out.println(STARS);

				// ************************************************************************

				/*
				 * Profit Calculation
				 */
				profit = (price * 2) / 100;
				totalPrice = profit + govTaxrates.getTotalPrice();

				// ************************************************************************

				System.out.print(CHECK_FINANCE_SUPPORT);
				checkFinance = scanner.next();
				System.out.println();

				if (checkFinance.equals("y") || checkFinance.equals("Y")) {
					/*
					 * Calling Finance company services
					 */
					do {
						System.out.println(STARS);
						System.out.println(WELCOME_FINANCE_COMPANY);

						// Getting keyboard input to calculate Monthly installment
						double carPrice = totalPrice;
						System.out.print(CAR_PRICE + carPrice);
						// double carPrice = scanner.nextDouble();

						System.out.print(ENTER_DOWN_PAYMENT);
						double downPayment = scanner.nextDouble();

						System.out.print(ENTER_YEARS);
						int years = scanner.nextInt();

						// Pass the value to Finance company as parameters
						financeCompany.serviceInitialization(carPrice, downPayment, years);

						// Calling Installment calculation method
						financeCompany.CalculateInstallment();

						System.out.println(STARS);

						// Check user to do the calculation again
						System.out.print(CHECK_FINANCE);
						checkVal = scanner.next();
						System.out.println();

					} while (checkVal.equals("y") || checkVal.equals("Y"));

					// ************************************************************************
					System.out.println(STARS);
				}

				// Check user want to do the calculation again
				System.out.print(CHECK_MAIN);
				checkService = scanner.next();
				System.out.println();
				checkBrand = "continue";

			} while (checkService.equals("y") || checkService.equals("Y"));

			System.out.println(EXIT_CALCULATOR);
			System.out.println(STARS);
		}
	}

	// Method Stop Car sale service
	public void stop(BundleContext context) throws Exception {
		System.out.println(CARSALE_STOP);

		// Unregistering Finance Company
		context.ungetService(serviceReference_FinanceCompany);

		// Unregistering Government Tax
		context.ungetService(serviceReference_GovernmentTax);

		// Unregistering Toyota Manufacture
		context.ungetService(toyotaServiceReference);

		// Unregistering Honda Manufacture
		context.ungetService(hondaServiceReference);

	}

}
