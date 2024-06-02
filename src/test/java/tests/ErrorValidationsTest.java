package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import resources.ExtentReporterNG;



public class ErrorValidationsTest extends BaseTest  {
	
    ExtentReporterNG report = new ExtentReporterNG();

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {
		report.getReportObject().createTest("validation");
		landingPage.loginApplication("ansarisjdmohd3072@gmail.com", "Passwor0");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
		report.getReportObject().flush();
   	
	}
   
	@Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    { 
	String productName="ZARA COAT 3";
    ProductCatalogue productCatalogue =landingPage.loginApplication("ansarisjdmohd3072@gmail.com", "Password0"); 
    List<WebElement> products = productCatalogue.getProductList();
    productCatalogue.addProductToCart(productName);
    CartPage cartPage = productCatalogue.goToCartPage();
    Thread.sleep(10000);
    Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
    Assert.assertFalse(match);
	

        
	}

}
