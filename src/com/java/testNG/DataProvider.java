package com.java.testNG;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.browsercommands.Utility;

public class DataProvider {
	WebDriver driver;

	@BeforeTest
	public void launch() {
		if (driver == null) {
			driver = Utility.initBrowser();
		}
	}

	@AfterTest
	public void teardown() {
		// driver.close();
	}

	@Test(dataProvider = "source", dataProviderClass = TestDataInput.class)
	public void doAutoComplete(String key, String value, String text) throws InterruptedException {
		driver.get("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		WebElement auto_id = driver.findElement(By.id("tags"));
		auto_id.click();
		auto_id.sendKeys(key);
		Thread.sleep(1500);

		List<WebElement> li = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		System.out.println("size:" + li.size());
		boolean data = li.get(0).equals(text);

		Iterator<WebElement> itr = li.iterator();
		while (itr.hasNext()) {
			WebElement ele = (WebElement) itr.next();
			if (ele.getText().trim().equalsIgnoreCase(value)) {
				ele.click();

			}
		}
		Thread.sleep(1500);

	}

}