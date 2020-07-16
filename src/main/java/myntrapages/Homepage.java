package myntrapages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basefile.Testbase;

public class Homepage extends Testbase {
	public static Actions a;
	@FindBy(xpath="//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo']")
			WebElement logo;
	@FindBy(xpath="//a[@href='/shop/men' and @class='desktop-main']")
	WebElement mencategory;
	@FindBy(xpath="//a[@href='/shop/women' and @class='desktop-main']")
	WebElement womencategory;
	@FindBy(xpath="//div[@class=' desktop-autoSuggest desktop-showContent']//ul//li")
	List<WebElement> searchsuggestion;
	@FindBy(xpath="//input[@class='desktop-searchBar']")
	WebElement search;
	@FindBy(xpath="//p[@class='FreeShippingBanner-sidebar-content']")
	WebElement adv;
	@FindBy(xpath="//a[text()='Leggings, Salwars & Churidars' and @class='desktop-categoryLink']")
	WebElement menucategory;
	@FindBy(xpath="//button[@class='referrals-banner-exchange-more-btn']")
	WebElement referbutton;
	@FindBy(xpath="//div[@class='desktop-userIconsContainer']")
	WebElement profile;
	@FindBy(xpath="//a[text()='login / Signup' and @class='desktop-linkButton']")
	WebElement loginbutton;
	@FindBy(xpath="//span[text()='Wishlist']")
	WebElement wishlist;
	@FindBy(xpath="//span[text()='Bag']")
	WebElement bagbutton;
	public Homepage()
	{
	PageFactory.initElements(driver, this);
	a= new Actions(driver);

}
	public boolean myntralogo()
	{
		return logo.isDisplayed();
	}
	public boolean mencategory()
	{
		return mencategory.isDisplayed();
	}
	public boolean womencategory()
	{
		return womencategory.isDisplayed();
	}
	public Categorypage searchsuggestion()
	{
		search.sendKeys(pr.getProperty("search"));
		List<WebElement> list =  searchsuggestion;
		for (int i=0;i<list.size();i++)
			if (list.get(i).getText().equals("Jeans Joggers Men"))
			{
				list.get(i).click();
				
			}
		return new Categorypage();
	}
	
	public boolean adv()
	{
		return adv.isDisplayed();
	}
	public Categorypage selectcategory() throws Exception
	{
		a.moveToElement(womencategory).build().perform();
		Thread.sleep(2000);
		menucategory.click();
		return new Categorypage();
	}
	public Referpage referbutton()
	{
		referbutton.click();
		return new Referpage();
	}
	public Loginpage login() throws Exception
	{
		a.moveToElement(profile).build().perform();
		Thread.sleep(2000);
		loginbutton.click();
		return new Loginpage();
	}
	public Wishlistpage clickwishlist()
	{
		wishlist.click();
		return new Wishlistpage();
	}
	public Cartpage clickbagbutton()
	{
		bagbutton.click();
		return new Cartpage();
	}
	
}
