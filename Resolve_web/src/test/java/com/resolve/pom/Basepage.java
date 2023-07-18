package com.resolve.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.resolve.generic.DriverManager;
import com.resolve.generic.Waitstrategy;

public class Basepage {
	
	protected  Basepage() {
		
	}
	
	
	
	protected void sendkeysAction(String by,String locatortype, Waitstrategy strategy,String value) {
		By element =null;
		if (locatortype.contentEquals("xpath")) {
			element = By.xpath(by);
		} else {
			element = By.cssSelector(by);
		}
		performExplicitWait(strategy,element).sendKeys(value);
	}



	protected static WebElement performExplicitWait(Waitstrategy waitstrategy,By element) {
		WebElement ele =null;

		try {
			
			if (waitstrategy== Waitstrategy.CLICKABLE) {
				ele= new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(element));
			}
			else if (waitstrategy == Waitstrategy.PRESENT) {
				ele= new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.presenceOfElementLocated(element));
			}
			else if (waitstrategy == Waitstrategy.VISIBLE) {
				ele=new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(element));
				
			}
			else if (waitstrategy == Waitstrategy.NONE) {
				ele =DriverManager.getDriver().findElement(element);
			}

			scrolltoelement(ele);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(element.toString()+" is not present", true);
		}

		return ele;
	}




	protected static void scrolltoelement(WebElement ele) {

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
	}


}
