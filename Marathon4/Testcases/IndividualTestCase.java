package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.SpecificMethod1;
import pages1.AppLauncher;

public class IndividualTestCase extends SpecificMethod1 {
@BeforeTest
public void setUp() {
	excelFile="individual";
	testName="Create Individual";
	testDescription="Create with mandatory field";
	testCategory="functional";
	testAuthor="Sathiyapriya";
}
@Test(dataProvider = "fetchData")
public void runIndividual(String name) throws IOException, InterruptedException {
	AppLauncher ap=new AppLauncher(driver);
	ap.clickIndividual().dropDown().newIndividual().enterName(name).clickSave().verify();
}
}
