package moduleTwo_Cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import libraryClass.TestBase;
import libraryClass.Utility;
import moduleOne_Login.SauceLabLoginPage;
import moduleOne_Login.SauceLab_Home_Page;
import moduleOne_Login.SauceLab_Menu_Page;
import moduleTwo_Cart.SauceLab_YourCart_Page;

public class SauceLab_AddToCart_Test extends TestBase {

	SauceLabLoginPage login;
	SauceLab_Menu_Page menu;
	SauceLab_Home_Page home;
	SauceLab_YourCart_Page cart;

	@Parameters("browser")
	@BeforeClass
	public void openBrrowser(@Optional("Chrome") String browser) throws IOException {
		openBrowser(browser);
		login=new SauceLabLoginPage(driver);
		menu=new SauceLab_Menu_Page(driver);
		home=new SauceLab_Home_Page(driver);	
		cart=new SauceLab_YourCart_Page(driver);
	}

	@BeforeMethod
	public void login() throws IOException {		
		login.enter_SauceLab_UserName(Utility.getPFData("UN"));
		login.enter_SauceLab_Password(Utility.getPFData("PASS"));
		login.click_SauceLab_LoginButton();
	}

	@Test
	public void addToCart() throws InterruptedException {
		home.addToCart_Item("Sauce Labs Backpack");
		Thread.sleep(2000);
		home.addToCart_Item("Sauce Labs Bike Light");
		Thread.sleep(2000);
		//home.addToCart_Item("Sauce Labs Fleece Jacket");

		home.click_sauceLab_HomePage_CartButton();

		try {
			int x=cart.displayed_Quantity();
			int y=cart.actual_sizeOfCart();
			assertEquals(x, y, "Quantity not match");
		}
		catch(Exception e) {
			System.out.println("Cart is empty");
		}
		
		//cart.click_sauceLab_CheckOut_Button();

	}

	@AfterMethod
	public void logout() {
		//home.click_sauceLab_HomePage_MenuButton();

		//menu.click_sauceLab_MenuPageLogoutButton();
	}

	@AfterClass
	public void browserClose() throws InterruptedException {
		Thread.sleep(3000);
		//closeBrowser();
	}

}
