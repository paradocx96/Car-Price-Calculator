package com.mtit.financecompany;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	// Create an object of ServiceRegistration for register and unregister the service
	ServiceRegistration financeServiceRegistration;	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("********** Start Finance Company Service **********");
		
		// Create an object of FinanceCompanyImpl to register the service 	
		FinanceCompany iFinanceCompany = new FinanceCompanyImpl();
		
		// Pass the parameters to BundleContext and registerService method called
		financeServiceRegistration = context.registerService(FinanceCompany.class.getName(), iFinanceCompany, null);		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("********** Stop Finance Company Service **********");
		
		// Unregistering the service
		financeServiceRegistration.unregister();		
	}
}
