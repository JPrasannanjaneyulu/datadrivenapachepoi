package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest2 
{
	public static void main(String[] args) 
	{
		//webdriver code:
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//get test data from excel:
		Xls_Reader reader=new Xls_Reader("D:\\batch229\\workspace\\datadrivenapachepoi\\src\\main\\java\\com\\testdata\\MercuryToursTestData2.xlsx");
		int rowCount=reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "Status");
				
		//Parameterization always done by for-loop
		//Parameterization:
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{
			System.out.println("================================");
			String firstName=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);
					
			String lastName=reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);
					
			String phone=reader.getCellData("RegTestData", "phone", rowNum);
			System.out.println(phone);
					
			String email=reader.getCellData("RegTestData", "email", rowNum);
			System.out.println(email);
					
			String address1=reader.getCellData("RegTestData", "address1", rowNum);
			System.out.println(address1);
					
			String address2=reader.getCellData("RegTestData", "address2", rowNum);
			System.out.println(address2);
					
			String city=reader.getCellData("RegTestData", "city", rowNum);
			System.out.println(city);
					
			String state=reader.getCellData("RegTestData", "state", rowNum);
			System.out.println(state);
					
			String postalCode=reader.getCellData("RegTestData", "postalcode", rowNum);
			System.out.println(postalCode);
					
			String country=reader.getCellData("RegTestData", "country", rowNum);
			System.out.println(country);
					
			//enter data:
			driver.findElement(By.name("firstName")).clear();
			driver.findElement(By.name("firstName")).sendKeys(firstName);
					
			driver.findElement(By.name("lastName")).clear();
			driver.findElement(By.name("lastName")).sendKeys(lastName);
					
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys(phone);
			
			driver.findElement(By.xpath("//input[@id='userName']")).clear();
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
			
			driver.findElement(By.name("address1")).clear();
			driver.findElement(By.name("address1")).sendKeys(address1);
			
			driver.findElement(By.name("address2")).clear();
			driver.findElement(By.name("address2")).sendKeys(address2);
			
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys(city);
					
			driver.findElement(By.name("state")).clear();
			driver.findElement(By.name("state")).sendKeys(state);
					
			driver.findElement(By.name("postalCode")).clear();
			driver.findElement(By.name("postalCode")).sendKeys(postalCode);
					
			Select s=new Select(driver.findElement(By.name("country")));
			s.selectByVisibleText(country);
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");
		}
	}
}
