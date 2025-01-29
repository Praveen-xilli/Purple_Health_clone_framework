package Clarity_URL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Urls {
	
	public static String projectPath = System.getProperty("user.dir");
	public static String Report_file_path;
	public static XSSFWorkbook wb;
	@Test
	public void Clarity_GetDataFinal() throws InterruptedException, IOException {
		
		
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9988");
		WebDriver driver=new ChromeDriver(opt); 
		Thread.sleep(6000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int count2 = driver.findElements(By.xpath("//i[@data-icon-name='setting']")).size();	
		System.out.println("number of details : "+count2);
		FileInputStream file = new FileInputStream("C:\\Users\\praveenr\\Downloads\\xl_inputdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);  
		XSSFSheet sheet = wb.getSheet("Sironix");
		if (sheet == null) {
			sheet = wb.createSheet("Sironix");
		}
			for(int i=1;i<=count2;i++)
			{			
				XSSFRow row =sheet.getRow(i);
				//String x =row.getCell(0).getStringCellValue();
				//String y =row.getCell(1).getStringCellValue();
				
				try {
					 XSSFRow row1=sheet.createRow(0);
					 row1.createCell(0).setCellValue("Doctor Name");
					 row1.createCell(1).setCellValue("Website");
					 row1.createCell(2).setCellValue("Project URL");
					 row1.createCell(3).setCellValue("Dashboard URL");
					Thread.sleep(1000);
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					String name =  driver.findElement(By.xpath("(//div[@class='projects_projectFriendlyName__HITpY'])["+i+"]")).getText();
					System.out.println("DR name is" + name);
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);					     
					String link_O=driver.findElement(By.xpath("(//span[@class='projects_projectTag__my0hH shared_lightGrayFont__IAlG3'])["+i+"]")).getText();
					Thread.sleep(1000); 

					String link = link_O.replace("URL: www.","");

					System.out.println("Website is "+ link);
					driver.findElement(By.xpath("(//span[@class='projects_projectTag__my0hH shared_lightGrayFont__IAlG3'])["+i+"]")).click();
					
					Thread.sleep(3000); 
					
						String Current_URL = driver.getCurrentUrl();
						System.out.println("Current url is "+Current_URL);
										    
						 XSSFRow row2=sheet.createRow(i);
					       
						if (Current_URL.contains("gettingstarted")) {
												
							row2.createCell(0).setCellValue(name);
							row2.createCell(1).setCellValue(link);
							row2.createCell(2).setCellValue(Current_URL);
							row2.createCell(3).setCellValue("No Dashbaord");
						        
						       			
						}
						else {
							
							row2.createCell(0).setCellValue(name);
							row2.createCell(1).setCellValue(link);
							
							Thread.sleep(2000);
//							driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//
//							driver.findElement(By.xpath("(//span[@class='filterBadgeLabel'])[1]")).click();
//
//							Thread.sleep(1000);
//							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//							driver.findElement(By.xpath("(//span[text()='Last 30 days'])[2]")).click();
//							
							//Thread.sleep(2000);
							String currentUrl = driver.getCurrentUrl();
							row2.createCell(3).setCellValue(currentUrl);
							System.out.println("30 days URLs"+currentUrl);
						}
						
						System.out.println("Website count is "+i);
						//my_projects
						driver.findElement(By.xpath("(//span[@data-automationid='splitbuttonprimary'])[1]")).click();	  	    		
						Thread.sleep(1000);
						
				} catch (Exception e) {
					//my_projects
					driver.findElement(By.xpath("(//span[@data-automationid='splitbuttonprimary'])[1]")).click();	  	    		
					Thread.sleep(1000);
				}	
				
				FileOutputStream fos =new FileOutputStream("C:\\Users\\praveenr\\Downloads\\xl_inputdata.xlsx");
				wb.write(fos);  	
						 						
	}
			wb.close();
			
			//FileOutputStream fos =new FileOutputStream("D:\\Clarity urls\\Nov URL\\Final_URLs aristo.xlsx");
			
		
		
		
		


	}
}
