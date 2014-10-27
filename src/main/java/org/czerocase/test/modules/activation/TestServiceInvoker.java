package org.czerocase.test.modules.activation;

import java.util.ArrayList;
import java.util.List;

import org.czerocase.test.client.invoker.ConnectorInvoker;

public class TestServiceInvoker {
	public List<ConnectorInvoker> invokers;
	

	public TestServiceInvoker() {
		this.invokers = new ArrayList<ConnectorInvoker>();
	}
	
	public TestServiceInvoker(ConnectorInvoker... invoks) {
		this.invokers = new ArrayList<ConnectorInvoker>();
		for (ConnectorInvoker invoker : invoks) {
			invokers.add(invoker);
		}		
	}
	
	public void addInvoker(ConnectorInvoker invoker) {
		invokers.add(invoker);
	}
	
	public List<String> runningTests() {
		List<String> results = new ArrayList<String>();
		for (ConnectorInvoker invoker : invokers) {
			if(invoker.testServices()) {
				results.add(invoker.getResults());
			}
		}		
		return results;
	}

}
