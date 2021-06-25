package com.Budgets.Test.Sprint1;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Budgets.ReadPropertyFile;
import com.Budgets.SignInPage;
import com.Budgets.WaitWebElement;


public class PR8_TC002_SignIn_AdminUser_Failed extends WaitWebElement{

	public static void main(String[] args) throws InterruptedException, IOException {
    	

    	
    	System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	//WaitWebElement.setDriver(driver);
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	Properties prop=ReadPropertyFile.getProperties();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in with your Microsoft Account")).click();
        
       WaitWebElement.customWait(By.id(prop.getProperty("key.userName")), driver);
        
        
        driver.findElement(By.id(prop.getProperty("key.userName"))).sendKeys(prop.getProperty("value.AdminUser"));
        WaitWebElement.customWait(By.id("idSIButton9"), driver);
        driver.findElement(By.id("idSIButton9")).click();
        
        WaitWebElement.customWait(By.id(prop.getProperty("key.password")), driver);
        driver.findElement(By.id(prop.getProperty("key.password"))).sendKeys(prop.getProperty("wrongvalue.password"));
        
       waitTillClickable(By.xpath("//*[@id=\"idSIButton9\"]"), driver);
    
      //  WebElement w1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]")));
       // w1.click();
        
      
        String act_errorMsg=driver.findElement(By.id("passwordError")).getText();
		String exp_errorMsg="Your account or password is incorrect. If you don't remember your password, reset it now.";
		if(exp_errorMsg.equalsIgnoreCase(act_errorMsg)) 
		{
		System.out.println("Error message is Correct"+ exp_errorMsg); 
		}
		else
		{
		System.out.println("Error message is in-correct");
		}
        
       // driver.quit();
      
  
    }
}