package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import RahulShettyAutomationProject.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
	 // Initializer  
		super(driver);
		this.driver = driver;
		                          
		PageFactory.initElements(driver, this);
	}
	
	
 
  @FindBy(id="userEmail")
  WebElement userEmail ;
   
  
  @FindBy(id="userPassword")
  WebElement password ;	
  	
  	
  @FindBy(id="login")  
  WebElement submit ;
  
  @FindBy(css="div[aria-label='Incorrect email or password.'")
  WebElement errorMessage;
  
  public ProductCatalogue loginApplication(String email,String Password) {
	  userEmail.sendKeys(email);
	  password.sendKeys(Password);
	  submit.click();
	  ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	  return productCatalogue;
  }  
  
  public String getErrorMessage()
  {  
	  waitForWebElementToAppear(errorMessage);
	  return errorMessage.getText(); 
  }
  
  
  
  
  public void goTo() {
	  driver.get("https://rahulshettyacademy.com/client");
	  
 
 }
	  
	  
	  
	  
  }
  
  
  
  

