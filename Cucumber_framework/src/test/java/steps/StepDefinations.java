package steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.DeveloperDocumentAction;
import pages.actions.DeveloperHomeAction;
import utils.SeleniumDriver;

public class StepDefinations {
	DeveloperHomeAction homeAction=new DeveloperHomeAction();
	DeveloperDocumentAction docAction=new DeveloperDocumentAction();
	List<WebElement> links;
	
	@Given("^I am on the Home Page \"([^\"]*)\" of developer hear Website$")
	public void i_am_on_the_Home_Page_of_developer_hear_Website(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SeleniumDriver.openPage(url);
		
	}

	@When("^I click the document link in the developer hear Website$")
	public void i_click_the_document_link_in_the_developer_hear_Website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homeAction.clickDocumentLink();
	}

	@Then("^the \"([^\"]*)\" page should be loaded$")
	public void the_page_should_be_loaded(String title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		docAction.checktitle(title);
	    
	}

	@Then("^I get all the linkes related to \"([^\"]*)\"$")
	public void i_get_all_the_linkes_related_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		links=docAction.getAllLinks();
	}

	@Then("^all the links should be working and status code should be \"([^\"]*)\"$")
	public void all_the_links_should_be_working_and_status_code_should_be(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    docAction.validateAllLinks(links);
	}

	@Then("^get all links of footer not realted to \"([^\"]*)\"$")
	public void get_all_links_of_footer_not_realted_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//links=docAction.getAllfooterLinks();
	}

	@Then("^get all links of header not realted to \"([^\"]*)\"$")
	public void get_all_links_of_header_not_realted_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//links=docAction.getAllheaderLinks();
	}
}
