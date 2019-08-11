package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeveloperHomeLocators {

	@FindBy(how=How.XPATH,using = "//*[@id=\"container\"]/header/div/div[3]/div[1]/nav/ul/li[2]/a")
	public WebElement documentLink;
	
	
}
