package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.apache.logging.log4j.core.util.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;

public class testBase {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializerDriver() throws IOException{
		
		prop=new Properties();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Maintain\\DartifactID\\src\\main\\java\\resource\\data.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium\\"
					+ "Selenium Softwares\\Chrom Driver\\" + "Java Chrome New\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();

			
		}
		else if(browserName.equals("firefox")){
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")){
			
		}
	
		// This applies to all testcases in the framework
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		

	}
	
	public void getScreenshot(String result) throws IOException{
		System.out.println(result);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://FWScreenshots//"+result+".png"));
		//org.apache.commons.io.FileUtils.copyFile(src, new File("C://FWScreenshots//"+result+".png"));
		
		
	}
	

}
