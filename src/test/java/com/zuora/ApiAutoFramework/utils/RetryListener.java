package com.zuora.ApiAutoFramework.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

//public class RetryListener implements IAnnotationTransformer {
//
//	@SuppressWarnings("rawtypes")
//	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//		// TODO Auto-generated method stub
//		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
//		if (retry == null) {
//			annotation.setRetryAnalyzer(Retry.class);
//		}
//	}
//}
