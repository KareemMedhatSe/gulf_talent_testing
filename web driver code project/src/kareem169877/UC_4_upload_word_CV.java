package kareem169877;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UC_4_upload_word_CV {
	//is element present is a function that takes the element and the driver in order to know that whether the element is present or not
	static public boolean isElementPresent(By by,WebDriver driver) {
	    try {
	      driver.findElements(by);
	      return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	      return false;
	    }
	}
	public static void main(String[] args) throws InterruptedException {
		 // System Property for Chrome Driver   
      System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");  
        
      // Intiate a ChromeDriver class to establish a connection       
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
		Thread.sleep(3000);
		//navigate to edit cv
		//Creating object of Actions
		Actions action = new Actions(driver);

		//hover over the Candidate menu to display the choices
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/header/div/div/div/ul/li[6]/a"))).perform();
						
		//Click on "Saved Searches"
		driver.findElement(By.linkText("Update GulfTalent CV")).click();
		
		
		//iniate a webelement variable for the choose file button which use to chose the file from the pc
		WebElement choosefile=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/form/div[1]/div[1]/div[1]/div[2]/div/input[1]"));
		//iniate the word file name and its path which located in the uploads folder then send the path which is in uploads folder in the project
		String word_file_name="gulftalent.docx";
		String word_path=System.getProperty("user.dir")+"/uploads/"+word_file_name;
		choosefile.sendKeys(word_path);
		
		//iniate a web element variable for the submite button
		WebElement attach_new_file=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/form/div[2]/div/a"));
		//click on attach file
		attach_new_file.click();
		//ensure that the word has uploaded successfully 
		String confirmation=driver.findElement(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/div[1]/div[2]/div[1]/strong")).getText();
		if(isElementPresent(By.xpath("//*[@id=\"main-block\"]/div[2]/div[5]/div[2]/div[1]/div/div[9]/div[2]/div[1]/div[2]/div[2]/a/div"),driver)) {
			System.out.print("correct test case");
		}
		else System.out.print("wrong test case");
		
		
		
		
		driver.close();
		driver.quit();
		
		
			}
}
