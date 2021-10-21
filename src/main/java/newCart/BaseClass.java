package newCart;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
		
	public static WebDriver driver;
	
		public static WebDriver browserLaunch(String browserName) {
			
			if(browserName.equalsIgnoreCase("chrome"))
			{
			
			System.setProperty("webdriver.chrome.driver", 
					"E:\\Java\\AdactinCucumber\\Driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			}else {
				
				System.out.println("Invalid Browser");
			}
			
			driver.manage().window().maximize();
			return driver;
			

		}
		
		public static void getUrl(String URL) {
			
			driver.get(URL);
		}
		
		public static void navigate(WebDriver driver, String action) {
			
			if(action.equalsIgnoreCase("forward"))
			{
				driver.navigate().forward();
			}else if(action.equalsIgnoreCase("backward"))
			{
				driver.navigate().back();
			}else if(action.equalsIgnoreCase("Refresh"))
			{
				driver.navigate().refresh();
			} else {
				System.out.println("Please enter valid navigate function like Forward, Backward or Refresh ");
			}
					

		}
		
		public static void waitForElementVisiblity(WebElement element) {
			
			WebDriverWait wait = new WebDriverWait(driver, 5, 10);
			wait.until(ExpectedConditions.visibilityOf(element));		

		}
		
		public static void inputValuestoElement(WebElement element, String value) {
			
			waitForElementVisiblity(element);
			element.sendKeys(value);
		}
		
		public static void clickonElement(WebElement element) {
			
			waitForElementVisiblity(element);
			element.click();
		}
		
		public static void SelectDropDown(WebElement element, String Options, String Value) {

			
			Select s = new Select(element);
			
			if (Options.equalsIgnoreCase("Index")) {
				
				s.selectByIndex(Integer.parseInt(Value));
				
			} else if(Options.equalsIgnoreCase("VisibleText")) {
				
				s.selectByVisibleText(Value);
			}
				else if(Options.equalsIgnoreCase("Value")){
					s.selectByValue(Value);
				}else {
					System.out.println("Please select between..." + "/n" + 
							"i)Index" +"/n" + 
							"ii)VisibleText" + "/n" + 
							"iii)Value");
				}
										
				}
		
		public static String getTitle() {
			String CurrentTitle = driver.getTitle();
			return CurrentTitle;
			

		}

		public static void getScreenShot(String scrShotPath) throws InterruptedException{
			
			String path = scrShotPath + System.currentTimeMillis()+".png";
			System.out.println(path);
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File scrSource = ts.getScreenshotAs(OutputType.FILE);
			try {
				File scrDestn = new File(path);
				FileUtils.copyFile(scrSource, scrDestn);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Exception Occurred while handling the file path");
			} finally {
				System.out.println("Screenshotted and saved in the provided path");
			}
		}				
		
		
}


