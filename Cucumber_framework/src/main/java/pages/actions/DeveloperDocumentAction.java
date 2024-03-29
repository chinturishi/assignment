package pages.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import pages.locators.DeveloperDocumentLocator;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class DeveloperDocumentAction {

	DeveloperDocumentLocator locator = null;

	public DeveloperDocumentAction() {
		this.locator = new DeveloperDocumentLocator();
		PageFactory.initElements(SeleniumDriver.getDriver(), locator);
	}

	public void checktitle(String title) {
		String actualTitle = locator.title.getText();
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(actualTitle, title);
		assert1.assertAll();
	}

	public List<WebElement> getAllLinks() {
		List<WebElement> elements = SeleniumDriver.getDriver().findElements(By.tagName("a"));
		return elements;
	}

	/*
	 * public List<WebElement> getAllfooterLinks() { List<WebElement> elements =
	 * locator.footer.findElements(By.tagName("a")); return elements; }
	 */

	public void validateAllLinks(List<WebElement> elements) {
		//SoftAssert assert1 = new SoftAssert();
		System.out.println(elements.size()+":size");
		for (WebElement element : elements) {
			String link = element.getAttribute("href");
			if (link != null && link.contains("/documentation")) {
			boolean status = SeleniumHelper.chekStatusCode(link,element);
			//assert1.assertTrue(status, link + " not working.");
			Assert.assertTrue(status, link + " not working.");
			}			
			}
		}

	/*
	 * public List<String> getAllheaderLinks() { List<WebElement> elements =
	 * locator.header.findElements(By.tagName("link")); List<String> links = new
	 * ArrayList<String>(); for (WebElement element : elements) { String link =
	 * element.getAttribute("href"); if (link != null &&
	 * !link.contains("/documentation")) links.add(link); } return links; }
	 */
}
