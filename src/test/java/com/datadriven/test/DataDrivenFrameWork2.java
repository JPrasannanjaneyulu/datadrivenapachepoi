package com.datadriven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenFrameWork2 
{
	static XSSFCell cell;
	public static void main(String[] args) throws IOException 
	{
		//webdriver code:
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		FileInputStream fis = null;
		try
		{
		fis=new FileInputStream("D:\\batch229\\workspace\\datadrivenapachepoi\\src\\main\\java\\com\\testdata\\MercuryToursTestDataPractice.xlsx");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("RegTestData");
		
		String firstName=sheet.getRow(1).getCell(0).toString().trim();
		System.out.println(firstName);
			
		//XSSFCell cell=sheet.getRow(i).getCell(0);
		//cell.setCellType(CellType.STRING);
			
		String lastName=sheet.getRow(1).getCell(1).toString().trim();
		System.out.println(lastName);
			
		//String phone=sheet.getRow(1).getCell(2).toString().trim();
		//System.out.println(phone);
		
		cell=sheet.getRow(1).getCell(2);
		cell.setCellType(CellType.STRING);
		String phone=cell.getStringCellValue();
		System.out.println(phone);
			
		String email=sheet.getRow(1).getCell(3).toString().trim();
		System.out.println(email);
			
		String address1=sheet.getRow(1).getCell(4).toString().trim();
		System.out.println(address1);
			
		String address2=sheet.getRow(1).getCell(5).toString().trim();
		System.out.println(address2);
			
		String city=sheet.getRow(1).getCell(6).toString().trim();
		System.out.println(city);
			
		String state=sheet.getRow(1).getCell(7).toString().trim();
		System.out.println(state);
			
		String postalCode=sheet.getRow(1).getCell(8).toString().trim();
		System.out.println(postalCode);
			
		String country=sheet.getRow(1).getCell(9).toString().trim();
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
		
		workbook.close();
	}
}
