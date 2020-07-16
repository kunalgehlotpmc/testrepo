package testutil;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basefile.Testbase;

public class Testutil extends Testbase {
	public static long implicitwait = 20;
	public static WebDriverWait wait;
	
	public void expwait()
	{
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr.getProperty("prodxpath"))));
		
	}

	
		
	}



