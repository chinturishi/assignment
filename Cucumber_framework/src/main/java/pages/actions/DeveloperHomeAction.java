package pages.actions;

import org.openqa.selenium.support.PageFactory;

import pages.locators.DeveloperHomeLocators;
import utils.SeleniumDriver;

public class DeveloperHomeAction {

	DeveloperHomeLocators locators = null;

	public DeveloperHomeAction() {
		this.locators = new DeveloperHomeLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), locators);
	}

	public void clickDocumentLink() {
		locators.documentLink.click();
	}
}
