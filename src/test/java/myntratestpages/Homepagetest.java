package myntratestpages;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basefile.Testbase;
import myntrapages.Cartpage;
import myntrapages.Categorypage;
import myntrapages.Homepage;
import myntrapages.Loginpage;
import myntrapages.Referpage;
import myntrapages.Wishlistpage;

public class Homepagetest extends Testbase {
	Homepage homepage;
	Categorypage categorypage;
	Referpage referpage;
	Loginpage loginpage;
	Wishlistpage wishlistpage;
	Cartpage cartpage;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage = new Homepage();
		categorypage = new Categorypage();
		referpage = new Referpage();
		loginpage = new Loginpage();
		wishlistpage = new Wishlistpage();
		cartpage = new Cartpage();
	}
	@Test
	public void logo()
	{
		boolean b = homepage.myntralogo();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void mencategory()
	{
		boolean b = homepage.mencategory();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void womencategory()
	{
		boolean b = homepage.womencategory();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	
		public void title()
		{
		String title = driver.getTitle();
		org.testng.Assert.assertEquals(title, "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
	}
	@Test
	public void searchsuggestio()
	{
		categorypage = homepage.searchsuggestion();
	}
	@Test
	public void adv()
	{
		boolean b = homepage.adv();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void selectcategory() throws Exception
	{
		categorypage = homepage.selectcategory();
	}
	@Test
	public void referbuttonclick()
	{
		referpage = homepage.referbutton();
	}
	@Test
	public void loginbuttonclick() throws Exception
	{
		loginpage = homepage.login();
	}
	@Test
	public void clickwishlist()
	{
		wishlistpage = homepage.clickwishlist();
		
	}
	@Test
	public void clickbag()
	{
		cartpage = homepage.clickbagbutton();
	}

	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	
}
