package mySnapps;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import resource.testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import resource.testBase;

//Adding logs 
//Generating HTML reports
//Screenshots on failure
//Jenkins integration

public class HomePage extends testBase { 
	
	private static Logger log = LogManager.getLogger(HomePage.class);
	//private static Logger log = LogManager.getLogger(Log4j2Class.class);
	
	@BeforeTest
	public void initializeBrowser() throws IOException{
		driver =initializerDriver();
		
		log.info("Browser is successfully launched");
		driver.get(prop.getProperty("URL"));
		log.info("mySnapps homepage is successfully launched");
		log.info("Code is successfully pushed and pulled from Git frist time");
		log.info("Code is successfully pushed and pulled from Git second time");
	}
	
	
	@Test
	public void basePageNavigation(){ 

		 // Two methods to access the class 
		// Create object to that class or invoke methods of it 
		
		loginPage loginPageObj = new loginPage(driver);
		
		loginPageObj.clickOnSignInBtn().click();
		loginPageObj.email().sendKeys("willsons978@gmail.com");
		loginPageObj.password().sendKeys("Admin@123");
		loginPageObj.loginBtn().click();
		log.info("page is successfully loggedIn");
		//System.out.println(loginPageObj.logOut().getText());
		
		loginPageObj.logOut().click();
		log.info("page is successfully loggedOut");
		
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
		log.info("Brower is closed");
		driver.quit();
		log.info("Brower is quite");
		driver = null;
	}
	
	
	
	
}
