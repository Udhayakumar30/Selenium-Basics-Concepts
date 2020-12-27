package com.java.advancedselenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.browsercommands.Utility;

public class DateAndTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MM/dd/yy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		Date today = Calendar.getInstance().getTime();
		

		String date = dateFormat.format(today);

		System.out.println(date);
		
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);;
		cl.add(Calendar.DAY_OF_YEAR, 7);
		
		dt=cl.getTime();
		String str = df.format(dt);
		    System.out.println("the date today is " + str);

		/*WebDriver driver = Utility.customBrowser("chrome");
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement calendar_click = driver.findElement(By.id("datepicker"));
		calendar_click.click();

		List<WebElement> allDates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));

		Iterator<WebElement> itr = allDates.iterator();
		while (itr.hasNext()) {
			WebElement webElement = (WebElement) itr.next();
			if (webElement.getText().equalsIgnoreCase(date)) {
				webElement.click();
				String selecteddate = webElement.getText();
				System.out.println("selected date is" + "-----" + selecteddate);
				break;
			}

		}

	}*/
	}
}
