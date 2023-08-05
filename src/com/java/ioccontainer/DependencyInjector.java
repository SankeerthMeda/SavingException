package com.java.ioccontainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DependencyInjector {
	private static DependencyInjector dependencyInjector;
	private DependencyInjector() {
		
	}
	public static DependencyInjector getInstance() {
		if(dependencyInjector ==null) {
			dependencyInjector=new DependencyInjector();
		}
		return dependencyInjector;
	}
	
	public <TLogger> TLogger createInstance(Class<TLogger> className) {
		try {
			Constructor<TLogger> constructor=className.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
