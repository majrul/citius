package com.citiustech.test;

import java.lang.reflect.Field;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class DIRule implements MethodRule {

	CalculatorTest2 testObj;
	
	public DIRule(CalculatorTest2 testObj) {
		this.testObj = testObj;
	}
	
	@Override
	public Statement apply(Statement base, FrameworkMethod method, Object target) {
		//before
		
		for(Field f : testObj.getClass().getDeclaredFields()) {
			if(f.isAnnotationPresent(DI.class)) {
				try {
					f.setAccessible(true);
					Object obj = f.getType().newInstance();
					f.set(testObj, obj);
				} catch (Exception e) { }
			}
		}
		
		try {
			base.evaluate(); //execute the underlying test method
		} catch (Throwable e) {
			e.printStackTrace();
		}

		//after
		
		return base;
	}
	
	
}
