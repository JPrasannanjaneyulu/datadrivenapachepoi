package com.datadriven.test;

import java.io.FileInputStream;
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

public class DataDrivenFrameWork 
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		FileInputStream fis=new FileInputStream("D:\\batch229\\workspace\\datadrivenapachepoi\\src\\main\\java\\com\\testdata\\MercuryToursTestDataPractice1.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("RegTestData");
		
		int lastRowNum=sheet.getLastRowNum();
		System.out.println(lastRowNum);
		
		int k=0;
		for(int i=1; i<=lastRowNum; i++)
		{
			System.out.println("===========================");
			String firstName=sheet.getRow(i).getCell(k).toString().trim();
			System.out.println(firstName);
			
			//XSSFCell cell=sheet.getRow(i).getCell(0);
			//cell.setCellType(CellType.STRING);
			
			String lastName=sheet.getRow(i).getCell(k+1).toString().trim();
			System.out.println(lastName);
			
			//String phone=sheet.getRow(i).getCell(k+2).toString().trim();
			//System.out.println(phone);
			
			cell=sheet.getRow(i).getCell(k+2);
			cell.setCellType(CellType.STRING);
			String phone=cell.getStringCellValue();
			System.out.println(phone);
			
			String email=sheet.getRow(i).getCell(k+3).toString().trim();
			System.out.println(email);
			
			String address1=sheet.getRow(i).getCell(k+4).toString().trim();
			System.out.println(address1);
			
			String address2=sheet.getRow(i).getCell(k+5).toString().trim();
			System.out.println(address2);
			
			String city=sheet.getRow(i).getCell(k+6).toString().trim();
			System.out.println(city);
			
			String state=sheet.getRow(i).getCell(k+7).toString().trim();
			System.out.println(state);
			
			String postalCode=sheet.getRow(i).getCell(k+8).toString().trim();
			System.out.println(postalCode);
			
			String country=sheet.getRow(i).getCell(k+9).toString().trim();
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
		}
		workbook.close();
	}
}
