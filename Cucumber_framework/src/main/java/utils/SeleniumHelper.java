package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {

	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean chekStatusCode(String link,WebElement element) {
		HttpURLConnection huc = null;
		int respCode = 200;
		try {
			huc = (HttpURLConnection) (new URL(link).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();
			System.out.println(respCode);

			if (respCode >= 400) {
				System.out.println(link + " is a broken link");
				return false;
			} else {
				new Actions(SeleniumDriver.getDriver()).keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(element).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String winHandleBefore = SeleniumDriver.getDriver().getWindowHandle();
				System.out.println(SeleniumDriver.getDriver().getWindowHandles().size());
				Iterator<String> it =SeleniumDriver.getDriver().getWindowHandles().iterator();
				String h = it.next();
				if(it.hasNext()) {
					String handle = it.next();
					SeleniumDriver.getDriver().switchTo().window(handle);
					SeleniumDriver.waitForAngularLoad();
					SeleniumDriver.getDriver().close();
					SeleniumDriver.getDriver().switchTo().window(winHandleBefore);
					System.out.println(link + " is a valid link");
				}
				
				return true;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	

}
