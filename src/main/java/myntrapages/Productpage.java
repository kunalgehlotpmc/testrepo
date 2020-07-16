package myntrapages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basefile.Testbase;

public class Productpage extends Testbase {
	public static WebDriverWait wait;
	public static Actions a;
	@FindBy(xpath="//div[text()='ADD TO BAG']")
	WebElement addtocart;
	@FindBy(xpath="//a[text()='Kook N Keech Jeans']")
	WebElement breadcrumblink;
	@FindBy(xpath="//div//h1[text()='Kook N Keech']")
	WebElement productname;
	@FindBy(xpath="//button[text()='Size Chart']")
	WebElement sizechart;
	@FindBy(xpath="//div[@class='sizeChartWeb-content']")
	WebElement sizechartcontainer;
	@FindBy(xpath="//button[@class='size-buttons-size-button size-buttons-size-button-default']//p[text()='30']")
	WebElement size30;
	@FindBy(xpath="//div//button[@class='size-buttons-size-button-selected size-buttons-size-button size-buttons-size-button-default']//p[text()='30']")
	WebElement size30selected;
	@FindBy(xpath="//input[@type='submit']")
	WebElement checkpincode;
	@FindBy(xpath="//div[@class='notify-error notify-content']")
	WebElement pincodevalidation;
	@FindBy(xpath="//input[@type='text' and @name='pincode']")
	WebElement enterpincode;
	@FindBy(xpath="//div[@class='pincode-tickcontainer']")
	WebElement tickicon;
	@FindBy(xpath="//button[text()='Change']")
	WebElement changebutton;
	@FindBy(xpath="//p[text()='Unfortunately we do not ship to your pincode']")
	WebElement invalidpincodevalidation;
	@FindBy(xpath="//div[@class='pdp-offers-offerTitle']//b[text()='EMI option available']")
	WebElement emioption;
	@FindBy(xpath="//span[text()='View Plan']")
	WebElement viewplan;
	@FindBy(xpath="//div[@class='emi-plans-header']//h3[text()='EMI PLANS']")
	WebElement emiplans;
	@FindBy(xpath="//span[text()='1']")
	WebElement verifyaddtocart;
	@FindBy(xpath="//span[@class='desktop-userTitle' and text()='Bag']")
	WebElement cart;
	
	
	public Productpage()
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,50);
		a = new Actions(driver);

	}
	public String gettitle() throws Exception
	{
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public boolean breadcrumb()
	{
		return breadcrumblink.isDisplayed();
	}
	public String productname()
	{
		return productname.getText();
	}
	public boolean sizechart()
	{
		sizechart.click();
		return sizechartcontainer.isDisplayed();
	}
	public boolean size30()
	{
		size30.click();
		return size30selected.isDisplayed();
		
	}
	public boolean pincodevalidation() throws Exception
	{
		checkpincode.click();
		Thread.sleep(3000);
		return pincodevalidation.isDisplayed();
	}
	public boolean entervalidpincode()
	{
		enterpincode.sendKeys(pr.getProperty("pincode"));
		checkpincode.click();
		return tickicon.isDisplayed();
	}
	public boolean changebuttonclick() throws InterruptedException
	{
		enterpincode.sendKeys(pr.getProperty("pincode"));
		checkpincode.click();
		Thread.sleep(3000);
		changebutton.click();
		return checkpincode.isDisplayed();
	}
	public String invalidpincodevalidation()
	{
		enterpincode.sendKeys(pr.getProperty("invalidpincode"));
		checkpincode.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("invalidpincodexpath"))));
		return invalidpincodevalidation.getText();
	}
	public boolean emiplan()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("emiplanxpath"))));
		a.moveToElement(emioption).build().perform();
		viewplan.click();
		
		return emiplans.isDisplayed();
	}
	public boolean addtobag()
	{
		size30.click();
		addtocart.click();
		return verifyaddtocart.isDisplayed();
	}
	public Cartpage clickcart()
	{
		cart.click();
		return new Cartpage();
	}

}
