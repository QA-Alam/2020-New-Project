package com.usa.loginpage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.usa.basepage.SupperClass;

public class FindPropertyPage extends SupperClass {

	// Page factory initialize
	public FindPropertyPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='dp-sticky-element']/descendant::p[1]")
	@CacheLookup
	private WebElement VerifyHousePrice;

	public WebElement getVerifyHousePrice() {
		return VerifyHousePrice;
	}

	@FindBy(name = "q")
	@CacheLookup
	private WebElement enterText;

	public WebElement getEnterTheText() {
		return enterText;

	}

	public void FindTotalHouse() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		System.out.println("Total number of suggestions in Search Property:::===> " + list.size()); // this line for
																									// count th																								// elements
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Search Property price :: " + list.get(i).getText());
		}
	}

	public void FindFifthProperty() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		for (int i = 0; i < list.size(); i++) {
			if (i > 4) {
				System.out.println(" I can selected " + i + " Number Property and i can see the price ::"
						+ list.get(i).getAttribute("text"));
				list.get(i).click();
				break;
			}
		}
	}

	public String validatePageTitle() {
		return driver.getTitle();

	}

}
