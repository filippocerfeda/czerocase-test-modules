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

package org.czerocase.test.modules.logservice.invoker;

import org.czerocase.core.logging.Logger;
import org.czerocase.test.client.invoker.ConnectorInvoker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class LogInvoker implements ConnectorInvoker {
	private Logger logService;
	private int[] countData = new int[3];//count[0] totale test, count[1] success count[2] failure

	public LogInvoker(BundleContext bundleContext) {
		ServiceReference logServiceReference = bundleContext
				.getServiceReference(Logger.class.getName());
		logService = (Logger) bundleContext
				.getService(logServiceReference);

	}

	public boolean testDebug1(){
		countData[0] = countData[0] +1;
		try{
			logService.debug("Test Log");
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testDebug2() {
		countData[0] = countData[0] +1;
		try{
			logService.debug(LogInvoker.class,"Test Log");
		}catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1]+1;
		return true;
	}

	public boolean testDebug3() {
		countData[0] = countData[0] +1;
		try{
			logService.debug(LogInvoker.class,"Test Log",new NullPointerException());
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testInfo1() {
		countData[0] = countData[0] +1;
		try{
			logService.info("Test Log");
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;	
	}

	public boolean testInfo2() {
		countData[0] = countData[0] +1;
		try{
			logService.info(LogInvoker.class,"Test Log");
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testInfo3() {
		countData[0] = countData[0] +1;
		try{
			logService.info(LogInvoker.class,"Test Log",new NullPointerException());
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testWarn1() {
		countData[0] = countData[0] +1;
		try{
			logService.warn(LogInvoker.class,"Test Log");
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testWarn2() {
		countData[0] = countData[0] +1;
		try{
			logService.warn(LogInvoker.class,"Test Log",new Exception("log test"));
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testError1() {
		countData[0] = countData[0] +1;
		try{
			logService.error(LogInvoker.class,"Test Log",new Exception("log test"));
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testError2() {
		countData[0] = countData[0] +1;
		try{
			logService.error(LogInvoker.class,"Test Log",new Exception("log test"));
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testFatal1() {
		countData[0] = countData[0] +1;
		try{
			logService.fatal(LogInvoker.class,"Test Log");
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testFatal2() {
		countData[0] = countData[0] +1;
		try{
			logService.fatal(LogInvoker.class,"Test Log",new NullPointerException());
		}
		catch(Exception e){
			countData[2] = countData[2] +1;
			return false;
		}
		countData[1] = countData[1] +1;
		return true;
	}

	public boolean testServices() {
		testDebug1();
		testDebug2();
		testDebug3();
		testInfo1();
		testInfo2();
		testInfo3();
		testError1();
		testError2();
		testFatal1();
		testFatal2();
		logService.info(getResults());
		return true;
	}

	public String getResults(){
		StringBuilder result = new StringBuilder();
		result.append("Total Tests: "+countData[0]+" Success: "+countData[1]+" Failure: "+countData[2]+"\n");
		result.append("Module candidate to promotion: "+getPromotion());
		return result.toString();
	}
	
	public boolean getPromotion(){
		return countData[2] == 0 ? true : false;
	}
}
