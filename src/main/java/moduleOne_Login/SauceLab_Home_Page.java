package moduleOne_Login;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SauceLab_Home_Page {

	@FindBy(id="react-burger-menu-btn") private WebElement menuButton;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//div[@class='inventory_list']/div//div[contains(text(),'Sauce Labs')]") private List<WebElement> l;
	@FindBy(xpath="//button[text()='Add to cart']") private List<WebElement> addToCart_Btn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cart_Btn;


	public SauceLab_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void click_sauceLab_HomePage_MenuButton() { //HomePage Menu Button
		menuButton.click();
	}

	public String verify_Login_HomePage() {
		String actual=logo.getText();	
		return actual;
	}

	public void addToCart_Item(String expected) {

		for(int i=0;i<=l.size();i++) {
			if(l.get(i).getText().equals(expected)) {
				addToCart_Btn.get(i).click();
				break;
			}		

		}
		
	}
	
	public void click_sauceLab_HomePage_CartButton() {
		cart_Btn.click();
	}

}
