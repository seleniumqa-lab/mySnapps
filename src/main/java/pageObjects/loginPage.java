package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	
	
	//driver.findElement(By.xpath("//footer/ul/li[2]/a")).click();
	
	public WebDriver driver;
	
	By signInBtn = By.xpath("//*[@id='signIn']/a");
	By email = By.id("Username");
	By password = By.id("Password");
	By loginBtn = By.id("BtnLogin");
	By logOut = By.xpath("//*[@id='header']/div/div[3]/div/div[2]/span/a");
	
		
	
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement clickOnSignInBtn(){
		return driver.findElement(signInBtn);
	}
	
	public WebElement email(){
		return driver.findElement(email);
	}
	
	public WebElement password(){
		return driver.findElement(password);
	}
	
	public WebElement loginBtn(){
		return driver.findElement(loginBtn);
	}
	
	public WebElement logOut(){
		return driver.findElement(logOut);
	}
	
}
