package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LandingPage;





public class BaseTest {
	  public WebDriver driver;
	  public LandingPage landingPage;
	  
	
	  public WebDriver initializeDriver() throws IOException {
	        
	        Properties prop = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\Divyesh Pawaskar\\Documents\\Sajid Ansari\\Workspace\\Final Selenium Project\\AutomationProject\\src\\main\\java\\resources\\GlobalData.properties");
	        prop.load(fis);
	        String browserName = prop.getProperty("browser");

	        if (browserName.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divyesh Pawaskar\\Documents\\Sajid Ansari\\ChromeDriver\\chromedriver-win64 in use\\ChromeDriver V.124\\chromedriver.exe");
	            ChromeOptions options = new ChromeOptions();
	      //      options.setCapability(browserName, options);
	            options.addArguments("--remote-allow-origins=*");
	            driver = new ChromeDriver(options);
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            // Initialize the Firefox driver
	            
	        } else if (browserName.equalsIgnoreCase("edge")) {
	            // Initialize the Edge driver
	           
	        } else {
	            throw new IllegalArgumentException("Invalid browser specified in GlobalData.properties");
	        }

	        driver.manage().window().maximize();
	        return driver;
	    }           
	  

		
	     
	    @BeforeMethod(alwaysRun=true)
	    public LandingPage launchApplication() throws IOException {
	        driver = initializeDriver();
	    	landingPage = new LandingPage(driver);
	        landingPage.goTo();
	        return landingPage;
	    }
       	
	    @AfterMethod(alwaysRun=true)
	    public void tearDown() {
	        driver.close();
	    } 
	   
	    public String getScreenshot(String testCaseName , WebDriver driver ) throws IOException
        {
       	 TakesScreenshot ts = (TakesScreenshot)driver;
       	 File source = ts.getScreenshotAs(OutputType.FILE);
       	 File file = new File(System.getProperty("C:\\Users\\Divyesh Pawaskar\\Downloads\\Updated CODE\\Updated CODE\\Updated Framework\\src\\main\\java\\Screenshots\\Tc1.png"));
       	 FileUtils.copyFile(source, file);
       	 return System.getProperty("C:\\Users\\Divyesh Pawaskar\\Downloads\\Updated CODE\\Updated CODE\\Updated Framework\\src\\main\\java\\Screenshots\\Tc1.png");
        
        }
	 	
	 	 
   	    }

     
