package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAutomationProject.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
WebDriver driver;

@FindBy(css = ".totalRow button")
WebElement CheckoutEle;

@FindBy(css = "tr td:nth-child(3)")
List<WebElement> productNames;

public OrderPage(WebDriver driver) {
	super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this); 
}

public Boolean VerifyOderDisplay(String productName) {
	
	Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	return match;
}


}



