package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {

	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public static boolean chekStatusCode(String link) {
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
				System.out.println(link + " is a valid link");
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
