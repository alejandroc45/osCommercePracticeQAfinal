package Pages;

import Base.BasePage;

public class Account extends BasePage {
	
	public Account() {
		
		super(driver);		
	
	}
	public void logOut(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
}
