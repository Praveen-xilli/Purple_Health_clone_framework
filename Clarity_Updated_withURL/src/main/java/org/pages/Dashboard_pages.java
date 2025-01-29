package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_pages {
	
	WebDriver driver;

	public Dashboard_pages(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='settings_projectIdLabel__RwMmr']" )
	WebElement project_ID;
	public WebElement project_ID()
	{
		return project_ID;
	}
	
	@FindBy(xpath="//span[text()='dashboard']/parent::span" ) 
	WebElement dashboard_page;
	public WebElement dashboard_page()
	{
		return dashboard_page;
	}
	
	@FindBy(xpath="//div[@data-testid='totalSessions']" ) 
	WebElement totalSessions;
	public WebElement totalSessions()
	{
		return totalSessions;
	}
	
	@FindBy(xpath="//div[@data-testid='dashboardTileUserOverview']//div[contains(@class, 'dashboard_usersNumber')]" ) 
	List<WebElement>  distinctUsers;
	public List<WebElement> distinctUsers()
	{
		return distinctUsers;
	}
	@FindBy(xpath="(//div[@title='Sessions with new users'])[2]//following-sibling::div[2]" )
	WebElement new_users;
	public WebElement new_users()
	{
		return new_users;
	}
	
	@FindBy(xpath="(//div[@title='Sessions with returning users'])[2]//following-sibling::div[2]" ) 
	WebElement returning_users;
	public WebElement returning_users()
	{
		return returning_users;
	}
	
	@FindBy(xpath="(//div[@class='dashboard_infoTileInfo__vHdsu dashboard_loud__ynA6u shared_darkBlueFont__owkq3'])[2]" ) 
	WebElement Pagesper_session;
	public WebElement Pagesper_session()
	{
		return Pagesper_session;
	}
	
	@FindBy(xpath="(//div[@class='dashboard_infoTileInfo__vHdsu dashboard_loud__ynA6u shared_darkBlueFont__owkq3'])[3]" ) 
	WebElement Scrolldepth;
	public WebElement Scrolldepth()
	{
		return Scrolldepth;
	}
	
	@FindBy(xpath="(//div[@class='dashboard_infoTileInfo__vHdsu dashboard_loud__ynA6u shared_darkBlueFont__owkq3'])[4]" )
	WebElement Time_spent;
	public WebElement Time_spent()
	{
		return Time_spent;
	}
	
	@FindBy(xpath="//a[@title='Referrer']/parent::div/parent::div/parent::div/parent::div/following-sibling::div[1]/div/div/div/div[1]/child::div/div[2]/div[2]" )
	List<WebElement> Referrers_count;
	public List<WebElement> Referrers_count()
	{
		return Referrers_count;
	}
	
	@FindBy(xpath="//a[@title='Referrer']/parent::div/parent::div/parent::div/parent::div/following-sibling::div[1]/div/div/div/div[1]/child::div/div/span" )
	List<WebElement> Referrers_URL;
	public List<WebElement> Referrers_URL()
	{
		return Referrers_URL;
	}
	
	@FindBy(xpath="//a[@title='Referrer']/parent::div/parent::div/parent::div/parent::div/following-sibling::div[1]/div/div/div/div[1]/child::div/div[2]/div[2]" )
	List<WebElement> Referrers_URLs_Count;
	public List<WebElement> Referrers_URLs_Count()
	{
		return Referrers_URLs_Count;
	}
	
	@FindBy(xpath="//a[@title='Top pages']/parent::div/parent::div/parent::div/parent::div/parent::div/div[2]/div/div/div/div[2]/div/div[2]/div[2]" )
	List<WebElement> popularPages_Count;
	public List<WebElement> popularPages_Count()
	{
		return popularPages_Count;
	}
	
	@FindBy(xpath="//a[@title='Top pages']/parent::div/parent::div/parent::div/parent::div/parent::div/div[2]/div/div/div/div[2]/div/div/span" )
	List<WebElement> popularPages_Text;
	public List<WebElement> popularPages_Text()
	{
		return popularPages_Text;
	}
	
	@FindBy(xpath="//a[@title='Top pages']/parent::div/parent::div/parent::div/parent::div/parent::div/div[2]/div/div/div/div[2]/div/div[2]/div[2]" )
	List<WebElement> PopularPages_Count;
	public List<WebElement> PopularPage_Count()
	{
		return PopularPages_Count;
	}
	
	

}
