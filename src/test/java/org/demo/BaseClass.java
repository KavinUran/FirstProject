package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseClass {
	WebDriver driver;
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	public void launchUrl(String data) {
		driver.get(data);
	}
	public void getTitle() {
		driver.getTitle();
	}
	public void getUrl() {
		driver.getCurrentUrl();
	}
	public void enterText(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element);
	}
	public void selectByIndex(WebElement element,int number) {
		Select s = new Select(element);
		s.selectByIndex(number);
	}
	public void selectByValue(WebElement element,String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}
	public void selectByVisibletext(WebElement element,String data) {
		Select s = new Select(element);
		s.selectByVisibleText(data);
		
	}
	private void sysout() {
		// TODO Auto-generated method stub

	}
	
	
		public static String excel(int rowno,int cellno) throws IOException {
			File file = new File("C:\\Users\\Administrator\\eclipse-workspace\\FrameWork\\DemoAutomation\\Excel\\Book1.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(stream);
			Sheet s = book.getSheet("sheet1");
			Row r = s.getRow(rowno);
			Cell c = r.getCell(cellno);
			int cellType = c.getCellType();
			String value ="";
			if (cellType==1) {
				 value = c.getStringCellValue();
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				value = format.format(dateCellValue);
				
			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l= (long) numericCellValue;
				value = String.valueOf(l);
			}
				return value;
		}
	}

	
	











