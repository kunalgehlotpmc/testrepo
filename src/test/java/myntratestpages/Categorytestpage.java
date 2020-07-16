package myntratestpages;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import basefile.Testbase;

import myntrapages.Categorypage;
import myntrapages.Homepage;
import myntrapages.Loginpage;
import myntrapages.Passwordresetpage;
import myntrapages.Productpage;

public class Categorytestpage extends Testbase{
	Homepage homepage;
	Loginpage loginpage;
	Passwordresetpage passwordresetpage;
	Categorypage categorypage;
	Productpage productpage;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage = new Homepage();
		loginpage = new Loginpage();
		categorypage = new Categorypage();
		productpage= new Productpage();
		
		
		homepage.searchsuggestion();
		
		
}
	@Test
	public void productcount() throws Exception
	{
		categorypage.totalprodcount();
		org.testng.Assert.assertEquals(categorypage.expetext, categorypage.counttext);
	}
	@Test
	public void breadcrumb()
	{
		boolean b = categorypage.breadcrumb();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void discountselection()
	{
		boolean b = categorypage.discountselection();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void fadeselection()
	{
		boolean b = categorypage.filterselection();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void clearallbuttondisplay()
	{
		categorypage.filterselection();
		boolean b = categorypage.clearallbutton();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void title()
	{
		String actualtitle = driver.getTitle();
		String expectedtitle = pr.getProperty("categorypagetitle");
		org.testng.Assert.assertEquals(expectedtitle, actualtitle);
	}
	@Test
	public void sort()
	{
		categorypage.sort();
		String url = driver.getCurrentUrl();
		String expurl = pr.getProperty("sorturl");
		org.testng.Assert.assertEquals(expurl, url);
				
	}
	@Test
	public void similarproducts() throws Exception
	{
		 categorypage.viewsimilar();
		
	}
	@Test
	public void product() throws Exception
	{
		productpage = categorypage.clickproduct();
	}
	
	
	@AfterMethod
	
		public void quit()
		{
		driver.quit();
	}
}
