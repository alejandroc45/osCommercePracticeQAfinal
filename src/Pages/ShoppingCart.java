package Pages;

import Base.BasePage;

public class ShoppingCart extends BasePage{

    private String StrongElementInCart="//strong[contains(text(),'";
	public ShoppingCart()
	{
		super(driver);
	}
	
	public void writeQuantity(String locator,String quantity,String typeLocator)
	{
	
		Write(locator,quantity,typeLocator);
	}
	
	public void updateCart(String locator,String typeLocator)
	{
		ClickElement(locator, typeLocator);
	}
	
	public String QuantityInCart(String locator,String Atribute,String typeLocator)
	{
		return valueFromElement(locator,Atribute, typeLocator);
	}
	

	public void clickToCheckOut(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	public boolean existProductInCart(String text,String typeLocator)
	{
	    String xpath=StrongElementInCart+text+"')]";
		return elementIsDisplay(xpath,typeLocator);
	}
}
