package StepDefinition;
	
import org.junit.Assert;

import com.test.constants.Constants;
import com.test.page.EggTimerPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class EggTimer {				
	EggTimerPage eggTimerPage;
     
    @Given("^I open the EggTimer website (.*) and launched the application$")				
    public void navigateToPage(String url) 
    {
        eggTimerPage= new EggTimerPage();
        eggTimerPage.navigateTo(url);
  
    }		

    @When("^I verify the title of the page$")					
    public void verifyTitle() throws Throwable 							
    {    	
       eggTimerPage= new EggTimerPage();
       Assert.assertTrue(eggTimerPage.getPageTitle().trim().equals(Constants.homePageTitle));
    }		

    @Then("^I verify Page load is successful$")					
    public void pageLoad() throws Throwable 							
    {    		
    	eggTimerPage= new EggTimerPage();
        Assert.assertTrue(eggTimerPage.verifyPage());			
    }	
    
    @And("^I Specify time in seconds (.*)$")					
    public void specifyTimer(String time) throws Throwable 							
    {    		
    	eggTimerPage= new EggTimerPage();
        Assert.assertTrue(eggTimerPage.provideTimer(time));			
    }	
    
    @And("^I click Start button$")					
    public void clickStart() throws Throwable 							
    {    		
    	eggTimerPage= new EggTimerPage();
        Assert.assertTrue("Please specify correct time since Start button is disabled..",eggTimerPage.clickStartButton());			
    }	
    
    @And("^I verify counter (.*)$")					
    public void validateTimer(String time) throws Throwable 							
    {    		
    	eggTimerPage= new EggTimerPage();
        eggTimerPage.verifyTimer(time);		
        Assert.assertTrue(eggTimerPage.validateTimer(time));	
    }

}