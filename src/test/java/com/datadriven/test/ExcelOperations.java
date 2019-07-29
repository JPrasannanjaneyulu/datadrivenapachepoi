package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations 
{
	public static void main(String[] args) 
	{
		Xls_Reader reader=new Xls_Reader("D:\\batch229\\workspace\\datadrivenapachepoi\\src\\main\\java\\com\\testdata\\MercuryToursTestData.xlsx");
		
		//reader.addSheet("HomePage");
		
		if(!reader.isSheetExist("HomePage"))
		{
			reader.addSheet("HomePage");
		}
		
		int colCount=reader.getColumnCount("RegTestData");
		System.out.println("Total number of columns present in RegTestData sheet:   "+colCount);
		
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "prasanna"));
	}
}
