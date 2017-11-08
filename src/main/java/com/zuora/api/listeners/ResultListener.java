package com.zuora.api.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.zuora.api.utils.LogHelper;



public class ResultListener extends TestListenerAdapter {


	@Override
	public void onTestStart(ITestResult itr) {
		super.onTestStart(itr);
		System.out.println();
		System.out.println();

		LogHelper.info("==");
		LogHelper.info("          ==============<TEST CASE START>:" + itr.getName() + "==================          ");
		LogHelper.info("==");

	}
	

	@Override
	public void onTestSkipped(ITestResult itr) {
		super.onTestSkipped(itr);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		printTestResult(itr, "SKIPPED");
	}
	
	@Override
	public void onTestSuccess(ITestResult itr) {
		super.onTestSuccess(itr);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		printTestResult(itr, "PASSED");
	}

	@Override
	public void onTestFailure(ITestResult itr) {
		super.onTestFailure(itr);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		printTestResult(itr, "FAILED");
	}

	@Override
	public void onStart(ITestContext testContext) {
		super.onStart(testContext);
		LogHelper.info("*************************************************************************************");
		LogHelper.info("*                                                                                   *");
		LogHelper.info("                        TEST START:[" + testContext.getName() + "]");
		LogHelper.info("*                                                                                   *");
		LogHelper.info("**************************************************************************************");
	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		//id = id + result.getParameters().hashCode();
		return id;
	}
	
	public void printTestResult(ITestResult itr,String status) {
		String testName = itr.getName();
		LogHelper.info("          ==============<TEST CASE "+status+">: "+ testName + "==================          ");
	}

//	@Override
//	public void onFinish(ITestContext testContext) {
//	}
	
//	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		LogHelper.info("*************************************************************************************");
		LogHelper.info("*                                                                                   *");
		LogHelper.info("                        TEST END:[" + testContext.getName() + "]");
		LogHelper.info("*                                                                                   *");
		LogHelper.info("**************************************************************************************");

		// Rerun failed test case will be marked as "Skip", so after test, we
		// need delete dup SKIP cases
		ArrayList<ITestResult> toBeRemove = new ArrayList<ITestResult>();
		HashSet<Integer> passTestIds = new HashSet<Integer>();
		HashSet<Integer> failTestIds = new HashSet<Integer>();
		ArrayList<Integer> skipTestIds = new ArrayList<Integer>();

		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			LogHelper.info("PassedTests = " + passedTest.getName());
			passTestIds.add(getId(passedTest));
		}
		for (ITestResult failTest : testContext.getFailedTests().getAllResults()) {
			LogHelper.info("FailTest = " + failTest.getName());
			failTestIds.add(getId(failTest));
		}

		for (ITestResult skipTest : testContext.getSkippedTests().getAllResults()) {
			LogHelper.info("SkipTest = " + skipTest.getName());
			skipTestIds.add(getId(skipTest));
		}

		LogHelper.info("fail:");
		for (int id : failTestIds) {
			String mm = id + "";
			LogHelper.info(mm);
		}

		LogHelper.info("pass:");
		for (int id : passTestIds) {
			String mm = id + "**";
			LogHelper.info(mm);
		}

		LogHelper.info("skip:");
		for (int id : skipTestIds) {
			String mm = id + "";
			LogHelper.info(mm);
		}

		for (ITestResult skipTest : testContext.getSkippedTests().getAllResults()) {
			int skipTestId = getId(skipTest);
			if (failTestIds.contains(skipTestId) || passTestIds.contains(skipTestId)) {
				LogHelper.info("Dup testid:" + skipTestId);
				toBeRemove.add(skipTest);
			}
		}
		
		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator = testContext.getSkippedTests().getAllResults().iterator(); iterator
				.hasNext();) {
			ITestResult testResult = iterator.next();
			if (toBeRemove.contains(testResult)) {
				LogHelper.info("Remove repeat Skip Test: " + testResult.getName());
				iterator.remove();
			}
		}
	}
}
