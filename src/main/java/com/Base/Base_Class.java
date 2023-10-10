package com.Base;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
		public static WebDriver driver;

			public static WebDriver browserLaunch(String Browser) throws IOException{
				
				
				if(Browser.equalsIgnoreCase("Chrome")){
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(Browser.equalsIgnoreCase("edge")){
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
			}
				else if(Browser.equalsIgnoreCase("firefox")){
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					
			}
				return driver;
			}
			public static WebDriver urlLaunch(String text){

				driver.manage().window().maximize();
				driver.get(text);
				return driver;
			}
			
		public static void screenshot(String fileName) {

				try {
					TakesScreenshot ts = (TakesScreenshot) driver;
					File src = ts.getScreenshotAs(OutputType.FILE);
				//	File dest = new File(System.getProperty("user.dir") + "\\screenshots\\" +
					//fileName + ".png");
					File dest = new File( "C:\\Users\\ADMINE\\eclipse-workspace\\SeleniumBasics\\QAfox\\screenshots//"+fileName+".png");

					FileHandler.copy(src, dest);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			public static void clickElement(WebElement element){
				
				element.click();
			}

			public static void inputElement(WebElement element, String input){

				element.sendKeys(input);

			}
			
			public static String getCurrentTitle() {
				String title = driver.getTitle();
				return title;
			}
			public static String getText(WebElement element) {
				String text = element.getText();
				return text;
			}
			public static void mouseHover(WebElement element) {
				Actions a = new Actions(driver);
				a.moveToElement(element).build().perform();
			}

			public static void dragAndDrop(WebElement src, WebElement dest) {
				Actions a = new Actions(driver);
				a.dragAndDrop(src, dest).build().perform();
			}
			public static void confirmAlert(WebElement element, String condition) {

				Alert confirm_alert = driver.switchTo().alert();
				if (condition.equalsIgnoreCase("accept")) {
					confirm_alert.accept();
				} else if (condition.equalsIgnoreCase("dismiss")) {
					confirm_alert.dismiss();
				}

			}
			public static void selectFromDropDown(WebElement element, String value) {  //String option

				Select s = new Select(element);
				s.selectByVisibleText(value);
				
//				if (option.equalsIgnoreCase("index")) {
//					s.selectByIndex(Integer.parseInt(value));
//				} else if (option.equalsIgnoreCase("value")) {
//					s.selectByValue(value);
//				} else if (option.equalsIgnoreCase("visibleText")) {
//					s.selectByVisibleText(value);
//				}

			}
			
			public static void scrollUsingCoordinates(int width, int height) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(" + width + "," + height + ");");
			}
			
			public static void clickUsingJSE(WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()",element);
			}
			
			public static void frameUsingIndex(int index) {
				driver.switchTo().frame(index);
			}

			public static void frameUsingName(String name) {
				driver.switchTo().frame(name);
			}

			public static void frameUsingElement(WebElement element) {
				driver.switchTo().frame(element);
			}
			
			public static void switchToDefault() {
				driver.switchTo().defaultContent();
			}

			public static void switchWindow(int index) {
				
				Set<String> all_tab_id = driver.getWindowHandles();
				List<String> tab_id_list = new LinkedList<>(all_tab_id);
				driver.switchTo().window(tab_id_list.get(index));
			}
			
			public static void implicitWait() {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			
			public static void explicitWait(WebElement element) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			
			public static void exit() {
				driver.close();
			}
			public static void exitall() {
				driver.quit();
			}



		}



