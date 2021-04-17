//IT19014128
//A.M.W.W.R.L. Wataketiya

package com.mtit.hondapublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starting manufacturer-honda publisher");
		HondaServicePublish hondaServicePublish = new HondaServicePublishImpl();
		serviceRegistration = context.registerService(HondaServicePublish.class.getName(), hondaServicePublish, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping honda service");
		serviceRegistration.unregister();
	}

}
