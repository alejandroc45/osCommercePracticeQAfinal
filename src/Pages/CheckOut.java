package Pages;

import Base.BasePage;

public class CheckOut extends BasePage {
	
	public CheckOut()
	{
		super(driver);
	}
	
	public void passedDeliveryInformation(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	public void passedSelectPaymantMethod(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	
	public void payNow(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
	public boolean validationRevisionOrder(String validation1,String validation2,String typeLocator)
	{
		boolean result=elementIsDisplay(validation1,typeLocator) && elementIsDisplay(validation2,typeLocator);
		
	    return result;
	}
	
	public String textFromOrder(String locator,String typeLocator)
	{
		return textFromElement(locator,typeLocator);
	}
	
	public void  goToCatalog(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
}

