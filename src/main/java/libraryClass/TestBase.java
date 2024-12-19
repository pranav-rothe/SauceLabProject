package libraryClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.get(Utility.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}
