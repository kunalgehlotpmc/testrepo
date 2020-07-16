package myntrapages;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basefile.Testbase;

public class Categorypage extends Testbase {
	public static int i;
public static int k;
public static int j;
public static String counttext;
public static String expetext;
public static Actions a;
public static WebDriverWait wait;
public static int prod;

	@FindBy(xpath="//span[text()='Jeans Joggers Men']")
	WebElement breadcrumb;
	@FindBy(xpath="//li[@class='product-base']")
	List<WebElement> prodcount;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement imagecount;
	@FindBy(xpath="//li[@class='pagination-number']")
	List<WebElement> paginationnum;
	@FindBy(xpath="//li[@class='pagination-next']")
	WebElement nextbutton;
	@FindBy(xpath="//span[@class='title-count']")
	WebElement titlecount;
	@FindBy(xpath="//label[contains(text(),'20% and above')]")
	WebElement discountrange;
	@FindBy(xpath="//span[text()='20 % and above']")
	WebElement discountselection;
	@FindBy(xpath="//label//h4[text()='Fade']")
	WebElement fade;
	@FindBy (xpath="//label[text()='Light Fade']")
	WebElement lightfade;
	@FindBy(xpath="//div[text()='Light Fade']")
	WebElement fadeselection;
	@FindBy(xpath="//span[text()='CLEAR ALL']")
	WebElement clearallbutton;
	@FindBy(xpath="//div[@class='sort-sortBy']")
	WebElement sort;
	@FindBy(xpath="//label[text()='Price: Low to High']")
	WebElement lowtohigh;
	@FindBy(xpath="//li//a//div//h3[text()='Kook N Keech']")
	WebElement product;
	@FindBy(xpath="//div[@class='image-grid-similarColorsCta product-similarItemCta']//parent::li//a//div//h3[text()='Rodamo']")
	WebElement viewsimilaricon;
	@FindBy(xpath="//span[text()=\"VIEW SIMILAR\"]//parent::div//parent::li//a//div//h3[text()='Rodamo']")
	WebElement viewsimilar;
	@FindBy(xpath="//div[text()='Similar Products']")
	WebElement similarproducts;
	@FindBy(xpath="//div[text()='Similar Products']")
	By simiproducts;
	@FindBy(xpath="//span[text()='wishlist']//parent::div//preceding-sibling::a//h3[text()='Rodamo']")
	WebElement wishlist;
	@FindBy(xpath="//li//a//div//h3")
	List<WebElement> movetoprod;
	@FindBy(xpath="//div[@class='image-grid-similarColorsCta product-similarItemCta']//parent::li//a//div/h3[text()='Rodamo']")
	WebElement viewsimiliargrid;
	@FindBy(xpath="//a//h3[text()='Rodamo']//following-sibling::div//span[@class='product-discountedPrice']")
	WebElement discountedprice;
	@FindBy(xpath="//div[@class='brand-more']")
	WebElement morebutton;
	@FindBy(xpath="//div//ul//li[@data-item='k' and @class='']")
	WebElement selectk;
	@FindBy (xpath="//input[@type='checkbox' and @value='Kook N Keech']//parent::label//parent::li")
	WebElement selectbrand;
	@FindBy(xpath="//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")
	WebElement clickclosebutton;
	@FindBy(xpath="//ul//li//label[text()='Black']")
	WebElement selectblackcolor;
	@FindBy(xpath="//div//input[@placeholder='Search for Brand']")
	WebElement searchbox;
	
	
	
	public Categorypage()
	{
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
		wait = new WebDriverWait(driver,10);
	}
	public void totalprodcount() throws Exception
	{
		
		
		
		
		List<WebElement> prodlist = prodcount;
		for ( i=0;i<prodlist.size();i++)
		{
			prodlist.get(i);
			
		}
		System.out.println(i);
		
		List<WebElement> pagenum = paginationnum;
		for (k=0;k<pagenum.size();k++)
			if(pagenum.size()>0)
			{
				nextbutton.click();
				
				
				
				
				List<WebElement>prods = prodcount;
				for (j=0;j<prods.size();j++)
				{
					prods.get(j);
					
				}
				i =i+j;
			}
		System.out.println(i);
		counttext = titlecount.getText();
		
		expetext = "- " +i+ " items";
		System.out.println(expetext);
		
		
	}
	public boolean breadcrumb()
	{
		return breadcrumb.isDisplayed();
	}
	public boolean discountselection()
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		discountrange.click();
		return discountselection.isDisplayed();
		
	}
	public boolean filterselection()
	{
		fade.click();
		lightfade.click();
		return fadeselection.isDisplayed();
	}
	public boolean clearallbutton()
	{
		return clearallbutton.isDisplayed();
	}
	public void sort()
	{
		a.moveToElement(sort).build().perform();
		lowtohigh.click();
	}
	public void viewsimilar() throws Exception
	{
		List<WebElement> prodlist =  movetoprod;
		for(int prod=0;prod<prodlist.size();prod++)
			if (prodlist.get(prod).equals("Rodamo"))
			{
		
		a.moveToElement(prodlist.get(prod)).build().perform();
		
		
	}
		Thread.sleep(2000);
		a.moveToElement(viewsimiliargrid).build().perform();

}
	public Productpage clickproduct() throws Exception 
	{
		morebutton.click();
		Thread.sleep(3000);
		/*a.moveToElement(selectk).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("selectbrand"))));*/
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");*/
		
		selectbrand.click();
		clickclosebutton.click();
		selectblackcolor.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("product"))));
		Thread.sleep(3000);
	
	product.click();
		/*List<WebElement> prodlist =  movetoprod;
		for(int prod=0;prod<prodlist.size();prod++)
			System.out.println(prodlist.get(prod).getText());
			if (prodlist.get(prod).getText().equals(pr.getProperty("product")))
			{
				prodlist.get(prod).click();
			}*/
	
	ArrayList <String> list = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(list.get(1));
	Thread.sleep(3000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("productpagebreadcrumbxpath"))));
	return new Productpage();
}
	
	}

