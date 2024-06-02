package RahulShettyAutomationProject.AbstractComponents;


import java.time.Duration;//org.eclipse.ui.intro/showPage?id=overview
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;
import PageObjects.OrderPage;



public class AbstractComponent{
       
	    WebDriver driver;

		public AbstractComponent(WebDriver driver) {
			
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			// TODO Auto-generated constructor stub
		}
	
	@FindBy(css = "[routerlink*='cart']" )
	WebElement CartHeader ; 
	
	@FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader ;
	
	
	public void waitForElementToAppear(By findby) 
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	
	}
	
	public void waitForWebElementToAppear(WebElement findby) 
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(findby));
	
	}
	
	 @FindBy(css = ".cartSection h3")
	 private List<WebElement> cartProducts;
	
	 
	
	
	
	public CartPage goToCartPage() { 
		CartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrderPage goToOrdersPage() { 
		waitForWebElementToAppear(orderHeader);
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
    Thread.sleep(1000);	
	}
	
	
}
