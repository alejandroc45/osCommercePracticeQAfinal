package Pages;

import org.openqa.selenium.WebDriver;

import Base.BasePage;
import Locators.PagesElements;

public class Catalog extends BasePage {
	
	
	

	public Catalog() {
		super(driver);
	
	}

	public void navigateToCommerce(String url)
	{
		NavigateTo(url);
	}
	public void clickToProduct(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	
    public void writeProduct(String locator,String textSearch,String typeLocator)
    {
    	Write(locator,textSearch,typeLocator);
   
    }
    
    public void searchProduct(String locator,String typeLocator)
    {
    	ClickElement(locator,typeLocator);
    }

	public void addCart(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	
}
