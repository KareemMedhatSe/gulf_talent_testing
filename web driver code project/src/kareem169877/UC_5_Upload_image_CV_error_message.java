package kareem169877;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UC_5_Upload_image_CV_error_message {
	
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
		//navigate to edit cv
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the "Candidate Menu".
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/header/div/div/div/ul/li[6]/a"))).perform();
		
		//Click on "update GulfTalent CV"
		driver.findElement(By.linkText("Update GulfTalent CV")).click();
		//iniate a webelement variable for the choose file button which use to choose the file from the pc
		WebElement choosefile=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/form/div[1]/div[1]/div[1]/div[2]/div/input[1]"));
		//iniate the image file name and its path which located in the uploads folder then send the path
		String image_name="Screenshot_3.png";
		String image_path=System.getProperty("user.dir")+"/uploads/"+image_name;
		choosefile.sendKeys(image_path);
		
		//iniate a web element variable for the submite button
		WebElement attach_new_file=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/form/div[2]/div/a"));
		//click on attach the file button
		attach_new_file.click();
		//ensure that an error message will display that the website won't accept any files except word or pdf
		boolean ConfirmationDialogEnabled = driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[5]/div[1]/div/div[2]/p")).isEnabled();
		if(ConfirmationDialogEnabled)
		 System.out.println("Passed");
		else
		 System.out.println("Failed");
		
		
		
		
		driver.close();
		driver.quit();
		
		
			}
}
