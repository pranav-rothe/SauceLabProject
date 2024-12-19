package libraryClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	
	@Parameters("browser")
	public void openBrowser(String browser) throws IOException {
//		driver=new ChromeDriver();
//		driver.get(Utility.getPFData("URL"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
		if(browser==null|| browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Utility.getPFData("URL"));
		
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(Utility.getPFData("URL"));

		}
		else if(browser.equalsIgnoreCase("edge"))
		{
	
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(Utility.getPFData("URL"));
		
		}
	
	     else 
	    {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get(Utility.getPFdata("URL"));
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
