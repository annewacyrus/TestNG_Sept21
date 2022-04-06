package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMTest {
	WebDriver driver;
    //String browser = null; OR
	String browser;
    String url;
   //making the By Class global variable=for the By Elements
    By userNameLocator = By.xpath("//*[@id=\\'username\\']");
	By passwordLocator = By.xpath("//*[@id=\\'password\\']");
	By signInButtonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By dashBoardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard' )]");
    
	//Storing Element usinf By Class
	By USERNAME_FIELD = By.xpath("//*[@id=\\'username\\']");
	By PASSWORD_FIELD = By.xpath("//*[@id=\\'password\\']");
	By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div");//missing end
	By DASHBOARD_HEADER1_FIELD = By.xpath("//h2[contains(text(), 'Dashboard')]");//missing end
	By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
	By ADD_CUSTOMER_HEADER_FIELD = By.xpath("");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COMPANY_NAME_FIELD = By.xpath("//*[@id=\"cid\"]");//start w/ select
	By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
	By COUNTRY_NAME_FIELD = By.xpath("//*[@id=\"select2-country-container\"]");//diff
	
	// making Login Data Global variable
            String userName = "demo@techfios.com";
    		String password = "abc123";
    //Test or mock DATA
    		String fullName = "September batch";
    		String company = "Techfios";
    		String email = "abc123@techfios.com";
    		String country = "Albania";
    
    @BeforeClass 
    public void readConfig() {   //to be able to read property file//ways to read property file:Scanner,BufferedReader.InputStream,FileReader	
    	
    	Properties prop = new Properties();
    	
    	try {
    		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
    		prop.load(input);
    		prop.get("browser");
    		browser = prop.getProperty("browser");
    		System.out.println("Browser used: + browser");
    		url = prop.getProperty("url");
    	}catch(IOException e) {
    		e.printStackTrace();
    		
    	}
    	}
    
	// public void launchBrowser()//called init/initialization method

@BeforeMethod
	public void init() {
	    if (browser.equalsIgnoreCase("Chrome")) {
	    	
	    	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	    	      driver = new ChromeDriver();
	    	 }//else {
	    		 //System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
	    else if(browser.equalsIgnoreCase("Firefox")) { //this method gives us full control of our code
	    	System.setProperty("webdriver.gecko.driver", " ");
	    }     
	    driver = new FirefoxDriver();
	    	 }
{
	
	//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		//System.setProperty(webdriver.gecko.driver, "driver\\geckodriver-v0.30.0-win64\\New folder\\geckodriver.exe");
		//driver = new ChromeDriver();// creation of an object
		//driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

 @Test
	public void loginTestDetails() {By userNameLocator = By.xpath("//*[@id=\\'username\\']");
	//Storing WebElement using By Class
	/*By userNameLocator = By.xpath("//*[@id=\\'username\\']");
	By passwordLocator = By.xpath("//*[@id=\\'password\\']");
	By signInButtonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By dashBoardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard' )]");*/


	driver.findElement(userNameLocator).sendKeys("userName");//replace demo@techfios with global userName & abc123 w/ password
	driver.findElement(passwordLocator).sendKeys("password");
	driver.findElement(signInButtonLocator).click();
	
	String dashBoardHeader = driver.findElement(dashBoardHeaderLocator).getText();
	Assert.assertEquals(dashBoardHeader, "Dashboard", "Dashboard page not found!!");//assertion test
	}
 public void addContact() {
	//Storing WebElement using By Class
	 /*By userNameLocator1 = By.xpath("//*[@id=\\'username\\']");
	 By passwordLocator = By.xpath("//*[@id=\\'password\\']");
		By signInButtonLocator = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashBoardHeaderLocator = By.xpath("//h2[contains(text(), 'Dashboard' )]");*/


		driver.findElement(userNameLocator).sendKeys("userName");
		driver.findElement(passwordLocator).sendKeys("password");
		driver.findElement(signInButtonLocator).click();
		
		
		Random rnd = new Random();
		rnd.nextInt(999);
		int generatedNum = rnd.nextInt(999);
		driver.findElement(FULL_NAME_FILED).sendkeys(fullName + generated Num);
		String dashBoardHeader = driver.findElement(dashBoardHeaderLocator).getText();
		Assert.assertEquals(dashBoardHeader, "Dashboard", "Dashboard page not found!!");//assertion test
		}
	 
 
 
@AfterMethod
   public void tearDown() {
		driver.close();
		driver.quit();

	}
}
