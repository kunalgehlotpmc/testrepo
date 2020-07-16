package myntratestpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basefile.Testbase;
import myntrapages.Cartpage;
import myntrapages.Categorypage;
import myntrapages.Homepage;
import myntrapages.Loginpage;
import myntrapages.Passwordresetpage;
import myntrapages.Productpage;
import testutil.Testutil;

public class Producttestpage extends Testbase {
	Homepage homepage;
	Loginpage loginpage;
	Passwordresetpage passwordresetpage;
	Categorypage categorypage;
	Productpage productpage;
	Testutil testutil;
	WebDriverWait wait;
	Cartpage cartpage;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage = new Homepage();
		loginpage = new Loginpage();
		categorypage = new Categorypage();
		productpage= new Productpage();
		
		
		homepage.searchsuggestion();
		categorypage.clickproduct();
		/*homepage.login();
		loginpage.login();*/
		

		

		
		
}
	@Test
	public void title() throws Exception
	{
		
		String acttitle = productpage.gettitle();
		String exptitple = pr.getProperty("prodtitle");
		Assert.assertEquals(exptitple, acttitle);
	}
	@Test
	public void displaybreadcrumb()
	{
		productpage.breadcrumb();
	}
	@Test
	public void productname()
	{
		String actname =  productpage.productname();
		String expname = pr.getProperty("productname");
		Assert.assertEquals(expname, actname);
	}
	@Test
	public void sizechartconatinerdisplay()
	{
		boolean b = productpage.sizechart();
		Assert.assertTrue(b);
	}
	@Test
	public void size30()
	{
		boolean b = productpage.size30();
		Assert.assertTrue(b);
	}
	@Test
	
		public void pincodevalidation() throws Exception
		{
		boolean b = productpage.pincodevalidation();
		Assert.assertTrue(b);
		
	}
	@Test
	public void displaytickicon()
	{
		boolean b = productpage.entervalidpincode();
		Assert.assertTrue(b);
	}
	@Test
	public void clickchangebutton() throws Exception
	{
		boolean b = productpage.changebuttonclick();
		Assert.assertTrue(b);
	}
	@Test
	public void pincodevalidationmessage()
	{
		String acttext = productpage.invalidpincodevalidation();
		String exptext= pr.getProperty("invalidvalidationmessage");
		Assert.assertEquals(exptext, acttext);
	}
	@Test
	public void emiplan()
	{
		boolean b = productpage.emiplan();
		Assert.assertTrue(b);
	}
	@Test
	public void cartadded()
	{
		boolean b = productpage.addtobag();
		Assert.assertTrue(b);
	}
	@Test
	public void clickcart()
	{
		cartpage = productpage.clickcart();
	}
	@AfterMethod()
	public void quit()
	{
		driver.quit();
	}

}
