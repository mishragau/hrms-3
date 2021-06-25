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
 
public class PR8_TC001_SignIn_AdminUser_Successful {
    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	
    	
    	System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
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
        driver.findElement(By.id(prop.getProperty("key.password"))).sendKeys(prop.getProperty("value.AdminPassword"));
    
        WebElement w1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]")));
        w1.click();
        driver.findElement(By.id("idBtn_Back")).click();

       	String act_title=driver.getTitle();
		String expected_title=prop.getProperty("expectedTitleLogin");
		 if(act_title.equalsIgnoreCase(act_title)) 
		 {
		System.out.println("Title is matched"); 
		 }
		 else
		 {
		System.out.println("Title is Incorrect");
		 }
		driver.findElement(By.xpath("//a[@href='/Core/Users/Profile']")).click();
		String act_UserContent=driver.findElement(By.id("basicContent")).getText();
		String ext_UserContent="Hi IP Dev TP 2";
		 
		 if(act_UserContent.equalsIgnoreCase(ext_UserContent))
		 {
		 System.out.println("This is Admin User");
		 }
		 else
		 {
			 System.out.println("This is Non Admin User");
		 }
		 
		 System.out.println("Login is Successful with Admin User ");
		 driver.quit();
       
    }
}