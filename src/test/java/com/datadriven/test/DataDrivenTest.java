package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest 
{
	public static void main(String[] args) 
	{
		//get test data from excel:
		Xls_Reader reader=new Xls_Reader("D:\\batch229\\workspace\\datadrivenapachepoi\\src\\main\\java\\com\\testdata\\MercuryToursTestData.xlsx");
		
		String firstName=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName=reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);
		
		String phone=reader.getCellData("RegTestData", "phone", 2);
		System.out.println(phone);
		
		String email=reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		String address1=reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);
		
		String address2=reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);
		
		String city=reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String state=reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);
		
		String postalCode=reader.getCellData("RegTestData", "postalcode", 2);
		System.out.println(postalCode);
		
		String country=reader.getCellData("RegTestData", "country", 2);
		System.out.println(country);
		
		
		//webdriver code:
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		//dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//enter data:
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		
		driver.findElement(By.name("phone")).sendKeys(phone);
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
		
		driver.findElement(By.name("address1")).sendKeys(address1);
		
		driver.findElement(By.name("address2")).sendKeys(address2);
		
		driver.findElement(By.name("city")).sendKeys(city);
		
		driver.findElement(By.name("state")).sendKeys(state);
		
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
		
		Select s=new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText(country);
	}
}
