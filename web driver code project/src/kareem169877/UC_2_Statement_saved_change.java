package kareem169877;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UC_2_Statement_saved_change {
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
				
		
			
			//Click on the search job field
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/div[1]/input")).click();
			
			
			
			//enter software Engineer in the job search
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/div[1]/input")).sendKeys("software Engineer");
			//choose Egypt choice from the drop down list 
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/div[2]/select")));
			//Select the 7th option which is Egypt
			dropdown.selectByIndex(7);
			//Click on Find jobs
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/button")).click();
			
			//choose the first job 
			driver.findElement(By.xpath("/html/body/main/div[2]/div[5]/div/div[2]/div[2]/div[1]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div/div/a/strong")).click();
			
			//assert that the statement changed to Job saved (Click to unsave)
			
			
			String result=	driver.findElement(By.xpath("//span/span[2]")).getText();
			
			//Check if actual result matches expected result
			
			//Print the result of the test
			if(result=="Job saved (Click to unsave)"){
				System.out.println("Correct!");
			}else{
				System.out.println("Incorrect answer!");
			}
			
			
			
			
			
		
			
			
			
			
	driver.close();
	driver.quit();
}}
