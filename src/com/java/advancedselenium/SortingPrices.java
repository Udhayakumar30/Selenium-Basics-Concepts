package com.java.advancedselenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.browsercommands.Utility;

public class SortingPrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Utility.customBrowser("chrome");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.click();
		search.sendKeys("mobiles" + Keys.ENTER);
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']"));
		String text = price.get(0).getText();
		System.out.println(text);
		// extract the prices from the price elements and store in a List
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price) {
			prices.add(e.getText());
			System.out.println("price is" + " " + e.getText());
		}

		// make a copy of the list
		List<String> sortedPrices = new ArrayList<String>(prices);

		// sort the list
		Collections.sort(sortedPrices);
		System.out.println("--------" + sortedPrices);

		// true if the prices are sorted
		System.out.println(sortedPrices.equals(prices));

	}

}
