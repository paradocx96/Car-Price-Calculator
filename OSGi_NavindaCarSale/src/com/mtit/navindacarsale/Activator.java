// IT19180526 - Chandrasiri S.A.N.L.D.

package com.mtit.navindacarsale;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.financecompany.FinanceCompany;
import com.mtit.governmentcarservicepublisher.IGovernmentTax;
import com.mtit.hondapublisher.HondaServicePublish;
import com.mtit.toyotapublisherService.ToyotaServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference_FinanceCompany, serviceReference_GovernmentTax, toyotaServiceReference,
			hondaServiceReference;
	Scanner scanner = new Scanner(System.in);
	private String checkService = null;
	private String checkVal = null;
	private int service = 0;
	private String userInputForRecheck = null;
	private String userInputForGetTaxes = null;
	private static final String STARS = "****************************************************\n";
	private static final String LINE1 = "********** Welcome to Car Price Calculator ********\n";
	private static final String LINE2 = "Choose a Service to help you\n";
	private static final String LINE3 = "1. Manufacture Company Service";
	private static final String LINE4 = "2. Government Tax Service";
	private static final String LINE5 = "3. Finance Company Service\n";
	private static final String LINE6 = "Enter a Serveice (1-3) : ";
	private static final String LINE7 = "********** Start Navinda Car Sale Service **********";
	private static final String LINE8 = "********** Stop Navinda Car Sale Service ***********";
	private static final String LINE9 = "********** Welcome to Government Tax Service *******\n";
	private static final String LINE10 = "********** Welcome to Finance Company Service ******\n";
	private static final String INVALID = "Invalid Input Please Try Again!";
	private static final String ENTER_ENGINE_CAPACITY = "Enter Car Engine Capacity : ";
	private static final String ENTER_ENGINE_CAPACITY2 = "Car Engine Capacity : ";
	private static final String ENTER_VAHICLE_PRICE = "Enter Car Price : ";
	private static final String ENTER_VAHICLE_PRICE2 = "Car Price : ";
	private static final String ENTER_DOWN_PAYMENT = "\nEnter Down-Payment Value : ";
	private static final String ENTER_YEARS = "How long you need finance support. Enter years : ";
	private static final String CHECK_TAX1 = "Do you want to know about Tax Rates(y/n) ? ";
	private static final String CHECK_TAX2 = "Do you want to check Tax Rates again (y/n) ? ";
	private static final String CHECK_FINANCE = "Do you want to calcualte again (y/n)? ";
	private static final String CHECK_MAIN = "\nDo you want to use any other service (y/n)? ";
	private static final String EXIT = "********** Exit from Application Services **********";

	String j = "continue";
	String model = new String();
	int engineCapacity;
	double price;

	public void start(BundleContext context) throws Exception {

		System.out.println(LINE7);

		/*
		 * Registering services
		 */

		// Registering car sale with Government Tax service
		serviceReference_GovernmentTax = context.getServiceReference(IGovernmentTax.class.getName());
		IGovernmentTax govTaxrates = (IGovernmentTax) context.getService(serviceReference_GovernmentTax);

		// Registering car sale with Finance Company service
		serviceReference_FinanceCompany = context.getServiceReference(FinanceCompany.class.getName());
		FinanceCompany financeCompany = (FinanceCompany) context.getService(serviceReference_FinanceCompany);

		// Registering car sale with Toyota Manufacture
		toyotaServiceReference = context.getServiceReference(ToyotaServicePublish.class.getName());
		ToyotaServicePublish toyotaServicePublish = (ToyotaServicePublish) context.getService(toyotaServiceReference);
		System.out.println("Manufacturer published: " + toyotaServicePublish.publishService());

		// Registering car sale with Honda Manufacture
		hondaServiceReference = context.getServiceReference(HondaServicePublish.class.getName());
		HondaServicePublish hondaServicePublish = (HondaServicePublish) context.getService(hondaServiceReference);
		System.out.println("Manufacturer published: " + hondaServicePublish.publishService());

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

			if (service == 1) {

				/*
				 * Calling Manufacturer company services
				 */
				// carSaleInterface();
				System.out.println("Starting car sale (Subscriber) Service.");
				System.out.println("Enter 'exit' to exit this interface.");

				while (!j.equals("exit")) {

					System.out.println("Enter car brand: ");
					j = scanner.nextLine();

					if (j.equals("exit")) {
						break;
					} else {
						if (j.toLowerCase().equals("toyota")) {
							System.out.println("Enter the model");
							model = scanner.nextLine();
							engineCapacity = toyotaServicePublish.getEngineCapacity(model);
							price = toyotaServicePublish.getPrice(model);

							if (engineCapacity == -1) {
								continue;
							}
						} else if (j.toLowerCase().equals("honda")) {
							System.out.println("Enter the model");
							model = scanner.nextLine();
							engineCapacity = hondaServicePublish.getEngineCapacity(model);
							price = hondaServicePublish.getPrice(model);

							if (engineCapacity == -1) {
								continue;
							}
						} else {
							System.out.println("Sorry! The brand you entered is not currently supported.");
							continue;
						}

						System.out.println(j + " " + model);
						System.out.println("Engine Capacity: " + engineCapacity);
						System.out.println("Manufacturer Price: " + price);
					}

				}

			} else if (service == 2) {

				/*
				 * Calling Finance Government Tax services
				 */
				do {
					System.out.println(STARS);
					System.out.println(LINE9);

					System.out.print(ENTER_ENGINE_CAPACITY2 + engineCapacity);
					// int carEngineCC = scanner.nextInt();

					System.out.print(ENTER_VAHICLE_PRICE2 + price);
					// double carPrice = scanner.nextDouble();

					govTaxrates.getCarTaxRate(engineCapacity, price);

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
					double carPrice = govTaxrates.getTotalPrice();
					System.out.print(ENTER_VAHICLE_PRICE2 + carPrice);
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

				System.out.println(STARS);

			} else {

				System.out.println(STARS);
				System.out.println(INVALID);
				System.out.println(STARS);
			}

			// Check user want to do the calculation again
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