package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeveloperDocumentLocator {

	@FindBy(how=How.XPATH,using = "/html/head")
	public WebElement header;
	
	@FindBy(how=How.ID,using = "footer")
	public WebElement footer;
	
	@FindBy(how=How.XPATH,using = "//*[@id=\"container-secondary\"]/div[1]/div/div[1]/div/h1")
	public WebElement title;
	
}
