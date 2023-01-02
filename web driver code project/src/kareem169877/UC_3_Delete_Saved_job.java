package kareem169877;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UC_3_Delete_Saved_job {
	public static void main(String[] args) throws InterruptedException {
		 // System Property for Chrome Driver   
       System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");  
         
       // Instantiate a ChromeDriver class to establish a connection       
       WebDriver driver=new ChromeDriver();  

		//Puts an implicit wait, will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch Website
		driver.get("http://www.gulftalent.com/");
		
			
		//Maximize the Browser
		driver.manage().window().maximize();
		//click on log in button
		driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/header/nav/div/div/div[2]/div/a[1]")).click();
				
		//enter the email address
		driver.findElement(By.name("email")).sendKeys("kareemmedhatcs@gmail.com");
				
		//enter the password
		driver.findElement(By.name("password")).sendKeys("15975321sqa");
				
		//Click on the Login Button
		driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[5]/div[1]/div/div[2]/div/div/div[2]/div[3]/div/div[1]/form/div[4]/button")).click();
				
		
				
		//wait 3000 miliseconds
		Thread.sleep(3000);
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the "Candidate Menu".
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/header/div/div/div/ul/li[6]/a"))).perform();
		
		//Click on "Saved jobs"
		driver.findElement(By.linkText("Saved Jobs")).click();
		
			
			
			
			
			
			//Click on the delete icon in order to delete this saved job
			driver.findElement(By.cssSelector("#main-block > div.page-content > div.container > div:nth-child(2) > div.col-sm-16.reset-width > div > table > tbody > tr > td:nth-child(4) > a > i")).click();
			
			
			/*click OK which will appear in the confirmation message to ensure that you want to delete the saved job*/
			driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[5]/div/div/div[2]/div[2]/div[1]/button")).click();
			
			
			
			
			
			
			
			
			
			
			//ensure that the element has been removed to the list of the saved jobs by ensure that the job isn't present now in the saved jobs page
			boolean elementpresent=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr/td[1]")).isDisplayed();
			if(elementpresent==true) {System.out.print("correct test case");}
			else {System.out.print("false test case");}
	driver.close();
	driver.quit();
	
	
		}
}
