package myntratestpages;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basefile.Testbase;
import junit.framework.Assert;
import myntrapages.Cartpage;
import myntrapages.Categorypage;
import myntrapages.Checkoutaddress;
import myntrapages.Homepage;
import myntrapages.Loginpage;
import myntrapages.Passwordresetpage;
import myntrapages.Productpage;
import testutil.Testutil;

public class Carttestpage extends Testbase {
	
	Homepage homepage;
	Loginpage loginpage;
	Passwordresetpage passwordresetpage;
	Categorypage categorypage;
	Productpage productpage;
	Testutil testutil;
	WebDriverWait wait;
	Cartpage cartpage;
	Checkoutaddress checkoutaddress;
	
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage = new Homepage();
		loginpage = new Loginpage();
		categorypage = new Categorypage();
		productpage= new Productpage();
		cartpage = new Cartpage();
		checkoutaddress = new Checkoutaddress();
		
		
		homepage.searchsuggestion();
		categorypage.clickproduct();
		/*homepage.login();
		loginpage.login();*/
		productpage.addtobag();
		
				
}
	@Test
	
		public void title()
		{
		productpage.clickcart();
			String actitle = driver.getTitle();
			String exttitle = pr.getProperty("cartpagetitle");
			org.testng.Assert.assertEquals(exttitle, actitle);
		}
	@Test
	public void shoppingbagtext()
	{
		productpage.clickcart();
		String acttext = cartpage.shoppingbagtext();
		String exptext = pr.getProperty("shoppingbagtext");
		org.testng.Assert.assertEquals(exptext, acttext);
	}
	
	@Test
	public void updatesize()
	{
		productpage.clickcart();
		String acttext = cartpage.changesize();
		String exptext = pr.getProperty("updatedsize");
		org.testng.Assert.assertEquals(exptext, acttext);
	}
	@Test
	public void clickremovebutton()
	{
		productpage.clickcart();
		cartpage.clickremovebutton();
	}
	@Test
	public void applyinvalidcoupon() throws Exception
	{
		productpage.clickcart();
		boolean b = cartpage.applyinvalidcoupon();
		org.testng.Assert.assertTrue(b);
		
	}
	@Test
	
		public void placeorder() throws Exception
		{
		homepage.login();
		loginpage.login();
		productpage.clickcart();
		checkoutaddress = cartpage.clickplaceorder();
	}
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
	

}
