package libraryClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getExcelData(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\Pranav\\eclipse-workspace\\SauceLabProject\\TestData\\Pranav.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("DDF");

		String data=sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}

	public static void getScreenShot(WebDriver driver, int TCID) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);	
		
		File des=new File("C:\\Users\\Pranav\\eclipse-workspace\\SauceLabProject\\ScreenShot\\TCID_"+TCID+".jpg");

		FileHandler.copy(src, des);

	}
	
	public static String getPFData(String key) throws IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Pranav\\eclipse-workspace\\SauceLabProject\\Properties.properties");
		Properties p=new Properties();
		
		p.load(file);
		
		String value=p.getProperty(key);
		return value;
	}

}
