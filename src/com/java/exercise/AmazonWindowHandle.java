
package com.java.exercise;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.java.browsercommands.Utility;

public class AmazonWindowHandle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = Utility.customBrowser("chrome");
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String oldWindow = driver.getWindowHandle();
		System.out.println(oldWindow);
		WebElement searchBox_xpath = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox_xpath.click();
		searchBox_xpath.sendKeys("mobiles");
		searchBox_xpath.sendKeys(Keys.ENTER);

		WebElement phone_xpath = driver.findElement(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		phone_xpath.click();

		Set<String> handles = driver.getWindowHandles();
		// for (String newWindow : handles) {
		// driver.switchTo().window(newWindow);

		// }
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {
			String newwindow = (String) itr.next();
			driver.switchTo().window(newwindow);
		}
		WebElement addToCart_xpath = driver.findElement(By.xpath(" //input[@id='add-to-cart-button']"));
		addToCart_xpath.click();

		WebElement addCartButton = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
		addCartButton.click();

		WebElement deleteCart = driver.findElement(By.xpath("//input[@value='Delete']"));
		deleteCart.click();
		//driver.close();
		//driver.quit();
		driver.switchTo().window(oldWindow);
		//WebElement todayDeals = driver.findElement(By.xpath("//a[@tabindex='27']"));
		//todayDeals.click();
	}

}
