package moduleTwo_Cart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLab_YourCart_Page {
	
	@FindBy(xpath = "//button[text()='Remove']") private List<WebElement> qty;
	@FindBy(xpath = "//a/span[@class='shopping_cart_badge']") private WebElement displayedQty;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkOut_Btn;
	
	public SauceLab_YourCart_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int actual_sizeOfCart() {
		int size=qty.size();
				
		if(size==0) {
			System.out.println("Cart is empty");
		}
		else {
			System.out.println("Total items in cart: "+size);
		}
		return size;
	}
	
	public int displayed_Quantity() {
		String qunatity=displayedQty.getText();
		int qty= Integer.parseInt(qunatity);
		return qty;
	}
	
	public void click_sauceLab_CheckOut_Button() {
		checkOut_Btn.click();
	}


}
