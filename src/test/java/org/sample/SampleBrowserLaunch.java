package org.sample;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SampleBrowserLaunch extends BaseClass{

	public static void main(String[] args) throws IOException, InterruptedException {
		loadBrowser();
		maxWindow();
		applyWaitsToAllLocators();
		launchUrl("https://www.facebook.com/");
		WebElement userName = driver.findElement(By.id("email"));
		fill(userName, "rohith");
		WebElement password = driver.findElement(By.id("pass"));
		fill(password, "rohith");
		Thread.sleep(3000);
		WebElement btnLogin = driver.findElement(By.className("_6ltg"));
		click(btnLogin);
		takesnap("facebook snap");
		getcurrenturl();
		getPageTitle();
		closeBrowser();
	}

}
