package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.SpecificMethod1;
import pages1.AppLauncher;

public class DeleteIndividual extends SpecificMethod1 {
@BeforeTest
public void setUp() {
	excelFile="DeleteIndividual";
	testName="Delete Individual";
	testDescription="Delete by using name";
	testCategory="functional";
	testAuthor="Sathiyapriya";
}
@Test(dataProvider = "fetchData")
public void runEdit(String ename,String cname) throws IOException, InterruptedException {
	AppLauncher ap=new AppLauncher(driver);
	ap.clickIndividual().search(ename).clickdrop().clickDelete().confirmDelete().verifyDelete(cname);
}
}
