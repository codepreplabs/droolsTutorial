package com.codeprep.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.codeprep.model.CustomerRuleObject;

public class App {

	public static void main(String[] args) {
		
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");
		
		CustomerRuleObject ruleObject = new CustomerRuleObject();
		ruleObject.setFirstName("CODEPREP");
		kieSession.insert(ruleObject);
		kieSession.fireAllRules();
		System.out.println(ruleObject.getMessage());
	}

}
