package Base_Utility_CommonFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;




public class UtilityClass 


{
	
	public static WebDriver driver;
	
	
	public static Properties prop;
	
	
	public static void Login() throws IOException 
	{
		
		prop = new Properties();
		
		FileInputStream reader = new FileInputStream("C:\\Users\\NishantM2\\eclipse-workspace\\TestSiteAutomation\\src\\test\\resources\\Properties\\Config.properties");
		
		prop.load(reader);
		
//		System.setProperty(prop.getProperty("key"), prop.getProperty("chromedriver"));
		
		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		options.addArguments("--remote-allow-origins=*");
		
		driver =  new ChromeDriver(options);
		
		String timeout = prop.getProperty("GlobalTimeOut");
		
		int intTimeout = Integer.parseInt(timeout);
		
		driver.manage().timeouts().implicitlyWait(intTimeout, TimeUnit.SECONDS);

		driver.get(prop.getProperty("AppUrl"));
		
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("nishant.mane@citiustech.com");
		
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//	driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("T@rzan1998");
		
	//	driver.findElement(By.xpath("//span[@id='submitButton']")).click();   
		
		//System.out.println(driver.getTitle());
	}
	
	public static void closeBrowser()
	{
		
		driver.close();
	}
	

	public static String getvalue(int rowindex, int colindex) throws InvalidFormatException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\NishantM2\\eclipse-workspace\\TestSiteAutomation\\src\\test\\resources\\TestData\\Automation_TestData.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String value = sh.getRow(rowindex).getCell(colindex).getStringCellValue();
		
		return value;
		
	}
	
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException 
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\NishantM2\\eclipse-workspace\\TestSiteAutomation\\FailedScreenshots"+TCID+".jpeg");
		
		FileHandler.copy(source, destination);	
	}
	
}
