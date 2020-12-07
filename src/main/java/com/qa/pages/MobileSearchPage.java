package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.utility.Utility;

public class MobileSearchPage extends TestBase{

	@FindBy (xpath ="//*[@class='_2KpZ6l _2doB4z']")
	public static WebElement closeLoginPopup;
	
	@FindBy (xpath="//*[starts-with(@title,'Search')]")
	public static WebElement searchBox;
	
	@FindBy(xpath="//*[@type='submit']")
	public static WebElement searchButton;
	
	@FindBy(xpath="//*[@title='Mobiles']")
	public static WebElement catagory;
	
	@FindBy(xpath="//*[starts-with(@class,'_24_Dny ')]")
	public static WebElement selectFassured;
	
	public static List<WebElement> mobileName=null;
	public static List<String> mobName=null;
	public static List<String> mobLink=null;
	public static List<String> mobPrice=null;
	
	
	
	public MobileSearchPage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	public static void getProductDetails()
	{
		Utility.waitTillElementToBeClickable(closeLoginPopup);
		closeLoginPopup.click();
		searchBox.clear();
		Utility.waitTillElementToBeClickable(searchBox);
		searchBox.sendKeys("Mobile");
		searchButton.click();
		catagory.click();
		Utility.selectFassured("select"); // checking fassured checkbox
		Utility.selectBrand("Samsung"); // selecting brand
	
		
		mobileName=new ArrayList<WebElement>();
		
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//*[@class='_24_Dny']"))));
		mobileName=driver.findElements(By.xpath("//*[@class='_24_Dny']"));
		
		mobName=new ArrayList<String>();
		mobLink=new ArrayList<String>();
		mobPrice=new ArrayList<String>();
		
		for(int i=0; i<=mobileName.size()-1; i++)
		{
			//storeMobileDetails.put(mobileName.get(i).getText(), storeDetails);
			mobName.add(driver.findElement(By.xpath("(//*[@class='_4rR01T'])["+(i+1)+"]")).getText());
			
			mobLink.add(driver.findElement(By.xpath("(//*[@class='_1fQZEK'])["+(i+1)+"]")).getAttribute("href"));
			
			mobPrice.add(driver.findElement(By.xpath("(//*[@class='_30jeq3 _1_WHN1'])["+(i+1)+"]")).getText());
			
		}
		
		for(int i=0; i<=mobileName.size()-1; i++)
		{
			System.out.println("Mobile Name:" + mobName.get(i));
			System.out.println("Mobile Link:" + mobLink.get(i));
			System.out.println("Mobile Price:" + mobPrice.get(i));
		}
		
	}
	
	
	
}
