package kareem169877;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class UC_1_save_job {
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
			
			
			
			//enter software Engineer in the job search field
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/div[1]/input")).sendKeys("software Engineer");
			//choose Egypt choice from the drop down list 
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/div[2]/select")));
			//Select the 7th option which is Egypt
			dropdown.selectByIndex(7);
			//Click on Find jobs which will begin the search
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[1]/div/div/div/form/button")).click();
			
			//click on the first job 
			driver.findElement(By.xpath("/html/body/main/div[2]/div[5]/div/div[2]/div[2]/div[1]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div/div/a/strong")).click();
			
			//click on the star of saving this job
			driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[4]/div[2]/div[1]/div/div[1]/div[2]/div/span/a/i")).click();
			
			//wait 3000 miliseconds
			Thread.sleep(3000);
			
			//Creating object of an Actions class
			Actions action = new Actions(driver);

			//hover over the Candidate menu to display the choices
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/header/div/div/div/ul/li[6]/a"))).perform();
			
			//Click on "Saved jobs"
			driver.findElement(By.linkText("Saved Jobs")).click();
			
			//ensure that the element has been added to the list of the saved jobs by ensuring the presence of the saved job
			
			boolean elementpresent=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr/td[1]")).isDisplayed();
			if(elementpresent==true) {System.out.print("correct test case");}
			else {System.out.print("false test case");}
	driver.close();
	driver.quit();
	
	
		}
	
}
