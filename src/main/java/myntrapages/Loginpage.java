package myntrapages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basefile.Testbase;

public class Loginpage extends Testbase {
	@FindBy(xpath="//img[@class='img-responsive preLoad loaded']")
	WebElement loginscreenimage;
	@FindBy(xpath="//div//span[text()='or']")    
	WebElement loginlabel;
	@FindBy(xpath="//input[@type='tel']")
	WebElement enterphonenumber;
	@FindBy(xpath="//div[text()='CONTINUE']")
	WebElement continuebuttonclick;
	@FindBy(xpath="//span[@class='placeholderAlternative mobileNumber']")
	WebElement telcode;
	@FindBy(xpath="//span[text()=' Password ']")
	WebElement passwordlink;
	@FindBy(xpath="//input[@type='password']")
	WebElement enterpassword;
	@FindBy(xpath="//button[text()='LOGIN']")
	WebElement clickloginbutton;
	@FindBy(xpath="//a[text()='Reset here']")
	WebElement resetlink;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean loginscreenimage()
	{
		return loginscreenimage.isDisplayed();
	}
	public boolean loginlabel()
	{
		return loginlabel.isDisplayed();
	}
	public String telcode()
	{
		return telcode.getText();
		
	}
	public Homepage login()
	{
		enterphonenumber.sendKeys(pr.getProperty("mobilenumber"));
		continuebuttonclick.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
			try {
				passwordlink.click();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
		
		enterpassword.sendKeys(pr.getProperty("password"));
		
		clickloginbutton.click();
		return new Homepage();
	}
	
	public Passwordresetpage resetpassword()
	{
		enterphonenumber.sendKeys(pr.getProperty("mobilenumber"));
		continuebuttonclick.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		resetlink.click();
		return new Passwordresetpage();
	}
	public Homepage newlogin()
	{
		enterphonenumber.sendKeys(pr.getProperty("mobilenumber"));
		continuebuttonclick.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		passwordlink.click();
		
		
		
		
		enterpassword.sendKeys(pr.getProperty("password"));
		
		clickloginbutton.click();
		return new Homepage();
	

}
}
