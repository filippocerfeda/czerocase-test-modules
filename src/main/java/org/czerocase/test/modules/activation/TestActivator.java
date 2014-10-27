/*
 *  Czero Case is the Open Source Platform, realized by ImagoItalia Srl,
 *  to quickly develop and deploy innovative Case Management solutions.
 *  Czero Case framework, based on Java environment, enables designer
 *  and developers to build advanced solutions for document and process
 *  management ensuring compliance with government regulations
 *  and industry standards.
 * 
 *  Copyright (C) 2012 ImagoItalia srl <http://www.imagoitalia.com>
 *  
 *  This file is part of Czero Case.
 *  
 *  Czero Case is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *   
 *  Czero Case is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *   
 *  You should have received a copy of the GNU General Public License
 *  along with Czero Case.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.czerocase.test.modules.activation;


import org.czerocase.test.client.invoker.ConnectorInvoker;
import org.czerocase.test.modules.logservice.invoker.LogInvoker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TestActivator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		TestServiceInvoker testServiceInvoker = new TestServiceInvoker();
		ConnectorInvoker logInvoker = new LogInvoker(bundleContext);
		testServiceInvoker.addInvoker(logInvoker);
		//To create a factory class to generate a invoker required from input or properties file
	}

	public void stop(BundleContext arg0) throws Exception {
		this.serviceRegistration.unregister();
	}
}
