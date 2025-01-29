package Clarity_GetData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.Dashboard_pages;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clarity_MonthlyReport_withURL {
public WebDriver driver;
public String Clarity_websiteURL;
public static String projectPath = System.getProperty("user.dir");
public XSSFSheet sheet1;
public int Popular_pages1;
public int Popular_pages13;
public int Referrers6;

	@Test
	public void Clarity_GetDataFinal() throws InterruptedException, IOException {
		

		WebDriverManager.chromedriver().setup(); 
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "localhost:9988");
		driver =new ChromeDriver(opt); 
		Thread.sleep(6000);
		
		FileInputStream file = new FileInputStream("C:\\Users\\praveenr\\Downloads\\xl_inputdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file); 
		 
		XSSFSheet sheet = wb.getSheet("Sironix");
		int lastrownum = sheet.getLastRowNum();
		Sheet sheet_name = wb.getSheet("Sironix output");
		// If the sheet doesn't exist, create it
				if (sheet_name == null) {
					sheet1 = wb.createSheet("Sironix output");
				}
		

				
//		int urlcount = sheet.getLastRowNum() +1;
//		System.out.println("Urls total count "+urlcount);
		
		
		Dashboard_pages db= new Dashboard_pages(driver);	
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");		
		String Report_file_path = projectPath+ "\\Report\\" + fileName+ "Sironix_new"+".xlsx";
		for(int i=1;i<=1;i++)
		{
			XSSFRow row1=sheet1.createRow(0);
			row1.createCell(0).setCellValue("Sl. No");				        
			row1.createCell(1).setCellValue("Dr Name");
			row1.createCell(2).setCellValue("Website");
			
			row1.createCell(3).setCellValue("project ID");
			row1.createCell(4).setCellValue("Total Sessions");
			
			row1.createCell(5).setCellValue("New users");
			row1.createCell(6).setCellValue("Returning users");
			
			row1.createCell(7).setCellValue("Unique_users");
			row1.createCell(8).setCellValue("Page per session ");
			row1.createCell(9).setCellValue("Scroll depth");
			row1.createCell(10).setCellValue("Time spent - Total");
			row1.createCell(11).setCellValue("Referrers");
			row1.createCell(12).setCellValue("Referrers - Google");
			row1.createCell(13).setCellValue("Referrers - Google");
			row1.createCell(14).setCellValue("Referrers - Instagram"); 
			row1.createCell(15).setCellValue("Referrers - Facebook");
			row1.createCell(16).setCellValue("Referrers - Others");
			row1.createCell(17).setCellValue("Popular pages - Home");

			row1.createCell(18).setCellValue("Popular pages - Doctor Listing"); //drop down
			row1.createCell(19).setCellValue("Popular pages - Doctor Listing");
			row1.createCell(20).setCellValue("Popular pages - Doctor Listing");
			row1.createCell(21).setCellValue("Popular pages - Doctor Listing"); //drop down

			row1.createCell(22).setCellValue("Popular pages - About Me");
			row1.createCell(23).setCellValue("Popular pages - Patient/Bookappointment"); //patient
			row1.createCell(24).setCellValue("Popular pages - Patient/Bookappointment"); //Bookappointment

			row1.createCell(25).setCellValue("Popular pages - Health info");
			row1.createCell(26).setCellValue("Popular pages - Health info");
			row1.createCell(27).setCellValue("Popular pages - Health Trackers");
			row1.createCell(28).setCellValue("Popular pages - Others");
			
			

//			XSSFRow row2=sheet.createRow(1);
//
//			row2.createCell(12).setCellValue("Referrers - Google.com");
//			row2.createCell(13).setCellValue("Referrers - Google.co.in");
//
//			row2.createCell(18).setCellValue("doctor-list-main/1"); //drop down
//			row2.createCell(19).setCellValue("doctor-list-main/2");
//			row2.createCell(20).setCellValue("doctor-list-main/3");
//			row2.createCell(21).setCellValue("doctor-list-main/4"); //drop down
//
//			row2.createCell(23).setCellValue("Patient"); //patient
//			row2.createCell(24).setCellValue("Bookappointment"); //Bookappointment
//
//			row2.createCell(25).setCellValue("HealthInfo");
//			row2.createCell(26).setCellValue("HealthBlog/healthInfo");
			
			try {
	
				XSSFRow row =sheet.getRow(i);			
				String doctor_name =row.getCell(0).getStringCellValue();
				System.out.println("New loop Started --     "+i + "  and the doctor name is ----     "+ doctor_name);
				String doctor_website =row.getCell(1).getStringCellValue();
				String Clarity_websiteURL1 =row.getCell(2).getStringCellValue();
				
				System.out.println("clarity url "+Clarity_websiteURL1);
				
				if (Clarity_websiteURL1.contains("www.")) {
					
					Clarity_websiteURL = doctor_website.replace("www.","");
					System.out.println("Website is "+ Clarity_websiteURL);
					
				}
				else {
					
					Clarity_websiteURL = doctor_website.replace("www.","");
					System.out.println("Website is "+ Clarity_websiteURL);
				}
				Thread.sleep(1000);
							
				driver.get(Clarity_websiteURL1);
				Actions act=new Actions(driver);
				Thread.sleep(5000);				
				//---//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.visibilityOf(db.project_ID()));
				String projectID = db.project_ID().getText();
				System.out.println("project ID is"+projectID);
                String dashboard_url =row.getCell(3).getStringCellValue();				
				System.out.println("clarity url "+dashboard_url);
				driver.get(dashboard_url);
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				wait.until(ExpectedConditions.elementToBeClickable(db.dashboard_page()));
//				act.moveToElement(db.dashboard_page()).click().build().perform();
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='firstContentItem']//div[@data-testid='dashboardInfoBanner']//following-sibling::div[@data-testid='dashboardContainer']//div[contains(@class, 'dashboard_legendLabel')]//following-sibling::div")));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='firstContentItem']//div[@data-testid='dashboardInfoBanner']//div[contains(@class, 'dashboard_infoTile')]//div[contains(@class, 'container')]//div[contains(@class, 'infoTileInfo')])[1]"))));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='firstContentItem']//div[@data-testid='dashboardInfoBanner']//div[contains(@class, 'dashboard_infoTile')]//div[contains(@class, 'container')]//div[contains(@class, 'infoTileInfo')])[2]"))));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='firstContentItem']//div[@data-testid='dashboardInfoBanner']//div[contains(@class, 'dashboard_infoTile')]//div[contains(@class, 'container')]//div[contains(@class, 'infoTileInfo')])[3]"))));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='firstContentItem']//div[@data-testid='dashboardInfoBanner']//div[contains(@class, 'dashboard_infoTile')]//div[contains(@class, 'container')]//div[contains(@class, 'infoTileInfo')])[4]"))));
				System.out.println("The page loaded successfully");
				
				Thread.sleep(3000);
				//---//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String Total_sessions =  db.totalSessions().getText();
				System.out.println("Totalsessions is :" + Total_sessions );
				//--//Thread.sleep(1000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//--//Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='dashboardTileUserOverview']//div[contains(@class, 'dashboard_usersNumber')][2]")));
				String Unique_users =  db.distinctUsers().get(1).getText();
				System.out.println("Distinctusers is :" + Unique_users );
//				Integer unique_users1 = Integer.parseInt(Unique_users);
//				System.out.println(unique_users1);
				String new_users =  db.new_users().getText();			     
				System.out.println("new users :" + new_users );
				Integer NewUsers = Integer.parseInt(new_users);
				System.out.println(NewUsers);
				
				String returning_users =  db.returning_users().getText();			     
				System.out.println("Returning users :" + returning_users );
				Integer ReturningUsers = Integer.parseInt(returning_users);
				System.out.println(ReturningUsers);
				
				//--//Thread.sleep(1000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String Pagesper_session =  db.Pagesper_session().getText();			     
				System.out.println("Pages per session is :" + Pagesper_session );

				//--//Thread.sleep(1000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String Scrolldepth =  db.Scrolldepth().getText();			     
				System.out.println("Scroll depth is :" + Scrolldepth );

				//--//Thread.sleep(1000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String Time_spent =  db.Time_spent().getText();		
				String Time_spent1 = Time_spent.replace("total","");
				System.out.println("Timespent is :" + Time_spent1  );

				int a = i+1;
				XSSFRow row0=sheet1.createRow(a);
				row0.createCell(0).setCellValue(i);
				row0.createCell(1).setCellValue(doctor_name);
				row0.createCell(2).setCellValue("www."+Clarity_websiteURL);
				row0.createCell(3).setCellValue(projectID);							
				row0.createCell(4).setCellValue(Total_sessions);		
				row0.createCell(5).setCellValue(NewUsers);
				row0.createCell(6).setCellValue(ReturningUsers);
				row0.createCell(7).setCellValue(Unique_users);
				row0.createCell(8).setCellValue(Pagesper_session);
				row0.createCell(9).setCellValue(Scrolldepth);	          
				row0.createCell(10).setCellValue(Time_spent1);
				
				

				//--//Thread.sleep(1000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				
				//--//Thread.sleep(2000);
				int Referrers_count = db.Referrers_count().size();			    
				//--//Thread.sleep(1000);
				System.out.println("Common xpath Referrers issss :"+Referrers_count);
				//--//Thread.sleep(2000);
				
				for(int k=0;k<Referrers_count; k++) {

					//--//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					String Referrers_1 =  db.Referrers_URL().get(k).getText();
					System.out.println(Referrers_1);
					//--//Thread.sleep(1000);			    
					

					System.out.println("link2 is  "+ Clarity_websiteURL);

					if(Referrers_1.contains(Clarity_websiteURL))
					{

						System.out.println(Referrers_1  + "--matching --" + Clarity_websiteURL );
						String Referrers1 =  db.Referrers_URLs_Count().get(k).getText();
						System.out.println("Referrers count :"+Referrers1 );
						row0.createCell(11).setCellValue(Referrers1);
					}
					else if(Referrers_1.contains("google.com"))
					{
						System.out.println(Referrers_1 + "--matching --" + "google.com" );
						String Referrers2_1 =  db.Referrers_URLs_Count().get(k).getText();
						int Referrers2 = Integer.parseInt(Referrers2_1);
						System.out.println("Referrers count :"+Referrers2);
						row0.createCell(12).setCellValue(Referrers2);
					}
					else if(Referrers_1.contains("google.co.in"))
					{

						System.out.println(Referrers_1 + "--matching --" +"google.co.in");
						String Referrers3_1 =  db.Referrers_URLs_Count().get(k).getText();
						int Referrers3 = Integer.parseInt(Referrers3_1);
						System.out.println("Referrers count :"+Referrers3 );

						row0.createCell(13).setCellValue(Referrers3);
					}

					else if(Referrers_1.contains("instagram"))
					{

						System.out.println(Referrers_1 + "--matching --" +"instagram");
						String Referrers4_1 =  db.Referrers_URLs_Count().get(k).getText();
						int Referrers4 = Integer.parseInt(Referrers4_1);
						System.out.println("Referrers count :"+Referrers4 );

						row0.createCell(14).setCellValue(Referrers4);
					}

					else if(Referrers_1.contains("facebook"))
					{

						System.out.println(Referrers_1 + "--matching --" +"facebook");
						String Referrers5_1 = db.Referrers_URLs_Count().get(k).getText();
						int Referrers5 = Integer.parseInt(Referrers5_1);
						System.out.println("Referrers count :"+Referrers5 );

						row0.createCell(15).setCellValue(Referrers5);
					}

					else { 

						System.out.println("No text matching");
						System.out.println("The actual text is ----  "+Referrers_1);
						String Referrers6_1 = db.Referrers_URLs_Count().get(k).getText();
						row0.createCell(16).setCellValue(Referrers6_1);
						System.out.println("Referrers count other is  :"+ Referrers6 ); //Referrers - Others

					} 
				}

				System.out.println("Exit from loop");
				//--//Thread.sleep(2000);
				//--//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.findElement(By.xpath("(//span[text()='Show more'])[2]")).click(); //show more
				
	
				int count1 = db.popularPages_Count().size();
				//--//Thread.sleep(1000);
				System.out.println("Common xpath popular pages is :"+count1 );

				int rowNum=18; 
				System.out.println("row num++ is first :"+ rowNum);

				for(int m=0;m<count1;m++) {
					String Popular_pages =  db.popularPages_Text().get(m).getText();
					//--//Thread.sleep(2000);			    
				
					System.out.println("Popular_page is"+Popular_pages);				                	
					String Popular_pages1_1_1 = Popular_pages.replace("https://wwww."+Clarity_websiteURL,"");									     
					System.out.println( "popular pages"+ Popular_pages1_1_1  );
					

					if(Popular_pages1_1_1.contains("/HealthInfo"))
					{

						System.out.println(Popular_pages1_1_1 +m+ "--matching --/HealthInfo");
						String Popular_pages2_1 =  db.PopularPage_Count().get(m).getText();
						int Popular_pages2 = Integer.parseInt(Popular_pages2_1);
						System.out.println("Popular page count :"+Popular_pages2 );

						row0.createCell(25).setCellValue(Popular_pages2);
					}
					else if(Popular_pages1_1_1.contains("/HealthBlog/healthInfo"))
					{

						System.out.println(Popular_pages1_1_1 +m+ "--matching --/HealthBlog/healthInfo");
						String Popular_pages3_1 = db.PopularPage_Count().get(m).getText();
						int Popular_pages3 = Integer.parseInt(Popular_pages3_1);
						System.out.println("Popular page count :"+Popular_pages3 );
						row0.createCell(26).setCellValue(Popular_pages3);
					}
					else if(Popular_pages1_1_1.contains("/home/doctor-list-main"))
					{
						System.out.println("row num is :"+ rowNum);
						System.out.println(Popular_pages1_1_1 +m+ "--matching --home/doctor-list-main/1");
						String Popular_pages4_1 =  db.PopularPage_Count().get(m).getText();
						int Popular_pages4 = Integer.parseInt(Popular_pages4_1);
						System.out.println("Popular page count :"+Popular_pages4 );
						row0.createCell(rowNum).setCellValue(Popular_pages4);
						rowNum++;	
					}
					else if(Popular_pages1_1_1.contains("about"))
					{
						System.out.println(Popular_pages1_1_1 +m+ "--matching --" +"about");
						String Popular_pages8_1 =  db.PopularPage_Count().get(m).getText();
						int Popular_pages8 = Integer.parseInt(Popular_pages8_1);
						System.out.println("Popular page count :"+Popular_pages8 );
						row0.createCell(22).setCellValue(Popular_pages8);				                    	 
					}
					else if(Popular_pages1_1_1.contains("patient"))
					{
						System.out.println(Popular_pages1_1_1 +m+ "--matching --patient");
						String Popular_pages9_1 =  db.PopularPage_Count().get(m).getText();
						System.out.println("Popular page count :"+Popular_pages9_1 );
						row0.createCell(23).setCellValue(Popular_pages9_1);				                    	 
					}
					else if(Popular_pages1_1_1.contains("bookappointment"))
					{
						System.out.println(Popular_pages1_1_1 +m+ "--matching -- bookappointment");
						String Popular_pages10_1 = db.PopularPage_Count().get(m).getText();
						int Popular_pages10 = Integer.parseInt(Popular_pages10_1);
						System.out.println("Popular page count :"+Popular_pages10 );
						row0.createCell(24).setCellValue(Popular_pages10);				                    	 
					}
					else if(Popular_pages1_1_1.contains("Health Trackers"))
					{
						System.out.println(Popular_pages1_1_1 +m+ "--matching --Health Trackers");
						String Popular_pages11_1 =  db.PopularPage_Count().get(m).getText();
						int Popular_pages11 = Integer.parseInt(Popular_pages11_1);
						System.out.println("Popular page count :"+Popular_pages11 );
						row0.createCell(27).setCellValue(Popular_pages11);				                    	 
					}
					else if(Popular_pages1_1_1.contains(Popular_pages)&& Popular_pages1==0)
					{
						System.out.println(Popular_pages + m + "--matching --" + Clarity_websiteURL );
						String Popular_pages1_1 =  db.PopularPage_Count().get(m).getText();
						Popular_pages1 = Integer.parseInt(Popular_pages1_1);
						System.out.println("Popular page count :"+Popular_pages1 );	
						row0.createCell(17).setCellValue(Popular_pages1);
					}
					else { 
						System.out.println("No text matching");
						System.out.println("The actual text is ----  "+Popular_pages1_1_1+" Which is not in the list");
						String Popular_pages12_1 =  db.PopularPage_Count().get(m).getText();
						row0.createCell(28).setCellValue(Popular_pages12_1);
					} 
				}
			}
			catch(Exception e) {
			}
			System.out.println(159+"----- :"+ i +": --- Input is Successfully completed---------");
		
			//Create folder name 
			//String Report_file_path = "D:\\Clarity urls\\Nov URL\\Final_URLs Rivela.xlsx";
			FileOutputStream fos =new FileOutputStream(Report_file_path);
			wb.write(fos);
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
	file.close();
	wb.close();
		
		
		

	

	
	}
}
