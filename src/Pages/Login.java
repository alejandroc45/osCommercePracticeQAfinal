package Pages;

import Base.BasePage;

public class Login extends BasePage {
	
	public Login()
	{
		super(driver);
	}
	
	public void writeUser(String locator,String text,String typeLocator)
	{
		Write(locator,text,typeLocator);
	}
	
	public void writePassword(String locator,String pass,String typeLocator)
	{
		Write(locator,pass,typeLocator);
	}
	
	public void clickSignIn(String locator,String typeLocator)
	{
		ClickElement(locator,typeLocator);
	}
}
