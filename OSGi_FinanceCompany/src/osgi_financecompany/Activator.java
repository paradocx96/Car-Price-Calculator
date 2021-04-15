package osgi_financecompany;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration financeServiceRegistration;
	

	public void start(BundleContext context) throws Exception {
		
		System.out.println("FinanceCompany Start");
		
		IFinanceCompany iFinanceCompany = new FinanceCompanyImpl();
		
		financeServiceRegistration = context.registerService(IFinanceCompany.class.getName(), iFinanceCompany, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("FinanceCompany Stop");
		financeServiceRegistration.unregister();
		
	}

}
