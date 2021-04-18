// IT19240848 
// Malwatta H.G.
// Batch - WE

package com.mtit.governmentcarservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	// Create ServiceRegistration Object to register the services and unregister the
	// services
	ServiceRegistration govServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("********** Start Government Tax Publisher");
		// Create GovernmentTaxImpl object to register the tax service
		IGovernmentTax iGovernmentTaxService = new GovernmentTaxImpl();

		/*
		 * Pass the parameters for BundleContext registerService method called
		 ** IGovernmentTax class name and GovernmentTaxImpl object
		 */
		govServiceRegistration = bundleContext.registerService(IGovernmentTax.class.getName(), iGovernmentTaxService,
				null);

	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("********** Stop Government Tax Service");

		// Whenever want to unregister the Government Tax service
		govServiceRegistration.unregister();

	}

}
