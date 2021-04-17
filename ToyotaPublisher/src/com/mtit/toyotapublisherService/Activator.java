//IT19014128
//A.M.W.W.R.L. Wataketiya

package com.mtit.toyotapublisherService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.mtit.toyotapublisherService.ToyotaServicePublish;
import com.mtit.toyotapublisherService.TototaServicePublishImpl;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starting manufacturer-toyota publisher");
		ToyotaServicePublish toyotaServicePublish = new TototaServicePublishImpl();
		serviceRegistration = context.registerService(ToyotaServicePublish.class.getName(), toyotaServicePublish, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping toyota service");
		serviceRegistration.unregister();
	}

}
