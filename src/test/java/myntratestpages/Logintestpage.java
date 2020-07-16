package myntratestpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basefile.Testbase;

import myntrapages.Homepage;
import myntrapages.Loginpage;
import myntrapages.Passwordresetpage;

public class Logintestpage extends Testbase {
	Homepage homepage;
	Loginpage loginpage;
	Passwordresetpage passwordresetpage;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		homepage = new Homepage();
		loginpage = new Loginpage();
		passwordresetpage = new Passwordresetpage();
		homepage.login();
	}
	@Test
	public void loginscreenimage()
	{
		boolean b = loginpage.loginscreenimage();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void loginlabel()
	{
		boolean b = loginpage.loginlabel();
		org.testng.Assert.assertTrue(b);
	}
	@Test
	public void telcode()
	{
		String acttext = (String) loginpage.telcode();
		String exptext = pr.getProperty("telcode");
		org.testng.Assert.assertEquals(exptext, acttext);
	}
	@Test
	public void login()
	{
		homepage = loginpage.login();
	}
	@Test
	public void passwordreset()
	{
		passwordresetpage = loginpage.resetpassword();
	}
@AfterMethod
public void quit()
{
	driver.quit();
}
}
