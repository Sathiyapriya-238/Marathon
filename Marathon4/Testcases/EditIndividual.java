package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.SpecificMethod1;
import pages1.AppLauncher;

public class EditIndividual extends SpecificMethod1 {
@BeforeTest
public void setUp() {
	excelFile="EditIndividual";
	testName="Edit Individual";
	testDescription="Edit with mandatory field";
	testCategory="functional";
	testAuthor="Sathiyapriya";
}
@Test(dataProvider = "fetchData")
public void runEdit(String ename,String lname) throws IOException, InterruptedException {
	AppLauncher ap=new AppLauncher(driver);
	ap.clickIndividual().search(ename).clickdrop().clickEdit().enterSalutaion().enterfname(lname).clickSave().editVerify();
}
}
