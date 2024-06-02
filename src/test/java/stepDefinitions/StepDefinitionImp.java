package stepDefinitions;

import java.io.IOException;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;



public class StepDefinitionImp extends BaseTest{

	@Given("I landed on Ecommerce Page")
	public void I_landed_On_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		
		
		
		
	}


}
