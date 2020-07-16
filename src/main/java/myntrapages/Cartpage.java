package myntrapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basefile.Testbase;


public class Cartpage extends Testbase {
	public static WebDriverWait wait;
	@FindBy(xpath="//div[text()='My Shopping Bag (']")
	WebElement shoppingbag;
	@FindBy(xpath="//div[text()='1 Item']")
	WebElement numberofitem;
	@FindBy(xpath="//div//span[text()='Size: ']")
	WebElement sizeselection;
	@FindBy(xpath="//div//div[text()='32']")
	WebElement selectsize32;
	@FindBy(xpath="//div[text()='Done']")
	WebElement donebutton;
	@FindBy(xpath="//span[text()='32']")
	WebElement updatedsize;
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removebutton;
	@FindBy(xpath="//button[@class='inlinebutton-base-actionButton itemComponents-base-move itemComponents-base-inlineButton']")
	WebElement popupremovebutton;
	@FindBy(xpath="//div[@class='sprite-empty-bag emptyCart-base-emptyBagImage']")
	WebElement emptycart;
	@FindBy(xpath="//div/button[text()='APPLY']")
	WebElement applycoupon;
	@FindBy(xpath="//input[@id='coupon-input-field']")
	WebElement entercoupon;
	@FindBy(xpath="//div[@class='couponsForm-base-applyButton ' and text()='APPLY']")
	WebElement insertcoupon;
	@FindBy(xpath="//div[text()='Coupon code is not valid']")
	WebElement couponvalidation;
	@FindBy(xpath="//div[text()='Place Order']")
	WebElement placeorderbutton;
	
	
	


public Cartpage()
{
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver,20);
	
}
public String shoppingbagtext()
{
	return shoppingbag.getText();
}

public String changesize()
{
	sizeselection.click();
	selectsize32.click();
	donebutton.click();
	return updatedsize.getText();
}
public boolean clickremovebutton()
{
	removebutton.click();
	popupremovebutton.click();
	return emptycart.isDisplayed();
	
}
public boolean applyinvalidcoupon() throws Exception
{
	applycoupon.click();
	Thread.sleep(3000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("couponenterxpath"))));
	entercoupon.sendKeys(pr.getProperty("coupon"));
	insertcoupon.click();
	return couponvalidation.isDisplayed();
}
public Checkoutaddress clickplaceorder()
{
	placeorderbutton.click();
	return new Checkoutaddress();
	
}

}
