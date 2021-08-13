package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void loadBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void fill(WebElement element,String text) {
		element.sendKeys(text);
	}
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	public static void applyWaitsToAllLocators() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	private void clearAllInput(By selector) {
		driver.findElement(selector).clear();
	}
	public static void copy() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void paste() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void cut() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	public static void getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	public static void takesnap(String fileName) throws IOException {
		TakesScreenshot ss= (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Rohith Kumar\\eclipse-workspace\\Sample\\Screenshot\\"+fileName+".png");
		FileHandler.copy(source, dest);
	}
	public static void click(WebElement element) {
		element.click();
	}
	public static void dragDrop(WebElement source ,WebElement dest) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, dest);
	}
	public static void movetoElement(WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(target);
	}
	public static void Doubleclickt(WebElement target) {
		Actions act=new Actions(driver);
		act.doubleClick(target);
	}
	public static void rightClick(WebElement target) {
		Actions act=new Actions(driver);
		act.contextClick(target);
	}
	public static void closeBrowser() {
		driver.quit();
	}
	public static void switchToframe(int index) {
		driver.switchTo().frame(index);
	}
}
	
