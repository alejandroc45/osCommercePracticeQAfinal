package Base;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Controllers.ControlDrivers;
import Data.ImputData;


//Encapsulamos Selenium como hacen en Cucumber
public class BasePage extends ControlDrivers {
	
	private Actions actions;
	private static WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
	  super(driver);
		
	}
	
	/*
	 * Funcion para acceder a una url
	 */
	protected  void NavigateTo(String url)
	{
		driver.get(url);
	}
	
	/*
	 * Funcion para encontrar elemento
	 */
	private WebElement Find(String locator,String typeLocator)
	{
		WebElement result=null;
		
	try
	{
				;
		if(typeLocator=="xpath")
		{
			result=driver.findElement(By.xpath(locator));
		}
		else if(typeLocator=="cssSelector")
		{
			result=driver.findElement(By.cssSelector(locator));
		}
		else if(typeLocator=="name")
		{
			result=driver.findElement(By.name(locator));
		}
	}catch(NoSuchElementException e) {
		System.out.println("El elemento no se encuentra");
		e.printStackTrace();
	}
			
		return result;
	}
	
	/*
	 * Funcion para hacer click en elemento
	 */
	protected void ClickElement(String locator,String typeLocator)
	{
		Find(locator,typeLocator).click();
	}
	/*
	 * Funcion para escribir en elementos tipo textbox,textarea
	 */
	protected void Write(String locator,String textTowrite,String typeLocator)
	{
		Find(locator,typeLocator).clear();
		Find(locator,typeLocator).sendKeys(textTowrite);
	}
	/*
	 * Funcion para seleccionar elemento de dropbox por valor
	 */
	protected void SelectDropdownByValue(String locator,String value,String typeLocator)
	{
		try {
		Select dropdown =new Select(Find(locator,typeLocator));
		dropdown.selectByValue(value);
		}
		catch(java.util.NoSuchElementException e)
		{
			System.out.println("No se encuenta¡ra el elemento dropdown");
			e.printStackTrace();
		}
	}
	/*
	 * Funcion para seleccionar elemento de dropbox por indice
	 */
	protected void SelectDropdownByIndex(String locator,int value,String typeLocator)
	{
	 try
	 {
		Select dropdown =new Select(Find(locator,typeLocator));
		dropdown.deselectByIndex(value);
	 }catch(java.util.NoSuchElementException e)
	 {
			System.out.println("No se encuenta¡ra el elemento dropdown");
			e.printStackTrace(); 
	 }
	}
	/*
	 * Funcion para seleccionar elemento de dropbox por valor visible
	 */
	protected void SelectDropdownByTextVisible(String locator,String value,String typeLocator)
	{
		try
		{
		 Select dropdown =new Select(Find(locator,typeLocator));
		 dropdown.deselectByVisibleText(value);
		}
	 catch(java.util.NoSuchElementException e)
	 {
			System.out.println("No se encuenta¡ra el elemento dropdown");
			e.printStackTrace(); 
	 }
	}
	/*
	 * Funcion para pasar el raton por ebcima de un elemento
	 */
	protected void HoveOverForElement(String locator,String typeLocator)
	{
		actions.moveToElement(Find(locator,typeLocator));
	}
	/*
	 * Funcion para hacer doble click en un elemento
	 */
	protected void doubleClick(String locator,String typeLocator)
	{
		actions.doubleClick(Find(locator,typeLocator));
	}
	/*
	 * Funcion para hacer  click derecho en un elemento
	 */
	protected void clickRight(String locator,String typeLocator)
	{
		actions.contextClick(Find(locator,typeLocator));
	}
	/*
	 * Funcion para devolver valor de una celda
	 */
	protected String getValueForTable(String locator,int row,int column,String typeLocator)
	{
		String cellNeed=locator+"/table/tbboy/tr["+row+"]"+"["+column+"]";
		return Find(cellNeed,typeLocator).getText();
	}
	/*
	 * Funcion para pner valor de una celda
	 */
	protected void setValueInTable(String locator,int row,int column,String text,String typeLocator)
	{
		String cellNeedwrite=locator+"/table/tbboy/tr["+row+"]"+"["+column+"]";
		Find(cellNeedwrite,typeLocator).sendKeys(text);
	}
	/*
	 * Funcion para acceder a un elemento frame
	 */
	protected void switchToIframe(int IndexIframe)
	{
	    try
	    {
		driver.switchTo().frame(IndexIframe);
	    }
	    catch(NoSuchFrameException e)
	    {
	    	System.out.println("No se encuentra el frame");
			e.printStackTrace(); 
	    }
	}
	/*
	 * Funcion para acceder a un elemento frame padre
	 */
	protected void switchToParentIframe()
	{
	    try
	    {
		  driver.switchTo().parentFrame();
	    }
	    catch(NoSuchFrameException e)
	    {
	    	System.out.println("No se encuentra el frame");
			e.printStackTrace(); 
	    }
	}
	/*
	 * Funcion para rechazar una alerta
	 */
	protected void dismissAlert()
	{
		try
		{
		driver.switchTo().alert().dismiss();
		}catch(NoAlertPresentException e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * Funcionpara devolver el texto de un elemento
	 */
	protected String textFromElement(String locator,String typeLocator)
	{
		return Find(locator,typeLocator).getText();
	}
	/*
	 * Funcion para acceder a la propiedad de un elemento y devolver su valor
	 */
	protected String valueFromElement(String locator,String Atribute,String typeLocator)
	{
		 return Find(locator,typeLocator).getAttribute(Atribute);
	}
	/*
	 * Funcion para comprobar si un elemento esta visible
	 */
	protected boolean elementIsDisplay(String locator,String typeLocator)
	{
		return Find(locator,typeLocator).isDisplayed();
	}
	/*
	 * Funcion para comprobar si un elemento esta habilitado
	 */
	protected boolean elementIsEnabled(String locator,String typeLocator)
	{
		return Find(locator,typeLocator).isEnabled();
	}
	/*
	 * Funcion para comprobar si un elemento esta seleccionado
	 */
	protected boolean elementIsSelected(String locator,String typeLocator)
	{
		return Find(locator,typeLocator).isSelected();
	}
	/*
	 * Funcion para buscar buscar un elemento en el dropbox y hacer click
	 */
	protected void  selectDropDown(String locator,String category,String typeLocator)
	{
		WebElement element=Find(locator,typeLocator);
		Select select=new Select(element);
	
		for(WebElement item : select.getOptions())
		{
			if(item.getText()==category)
			{
				item.click();
			}
		}
	}
	
	
}
