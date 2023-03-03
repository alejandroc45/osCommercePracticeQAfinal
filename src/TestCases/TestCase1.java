package TestCases;

import org.jsoup.select.Selector;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controllers.ControlDrivers;
import Data.ImputData;
import Locators.PagesElements;
import Pages.Account;
import Pages.Catalog;
import Pages.CheckOut;
import Pages.Login;
import Pages.ShoppingCart;




public class TestCase1{
	
  static Catalog catalog=new Catalog();
  static ShoppingCart cart=new ShoppingCart();
  static Login login=new Login();
  static CheckOut checkout=new CheckOut();
  static Account account =new Account();
  PagesElements element =new PagesElements();
  private String quantity="2";
  private String quantityActual="";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ControlDrivers.createAndStartService();
		ControlDrivers.createDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		ControlDrivers.quitDriver();
	}

	@BeforeEach
	void setUp() throws Exception {
   
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	/*
	 * TEST CASE 1 sketch
      1. Go to http://sqademosatp.net/catalog/
      2. Click “Samsung Galaxy Tab” product
      3. Add to Cart
      4. Update quantity to 2
      5. Assert that quantity is 2
      6. Click checkout button
      7. Sign in (*)
      8. Select “Cash on delivery” payment method
      9. Click ”Pay now”
      10. Check that the message “Your order has been processed” is shown.
      11.Go to catalog
      12.Close session
    * previously manually create a new customer to be used as login data
	 */
	
	@Test
	void test1() {
		
		//Paso 1
        catalog.navigateToCommerce(ImputData.url);
        //paso 2
        //escribe nombre producto
        catalog.writeProduct(PagesElements.TextBoxSearchProduct_name,"Samsung Galaxy Tab","name");
        //busca el producto
        catalog.searchProduct(PagesElements.ButtonSearchProduct_xapth,"xpath");
        //accede al producto
        catalog.clickToProduct(element.getLocatorProduct("Samsung Galaxy Tab"),"xpath");
        //paso 3
        catalog.addCart(PagesElements.ButtonAddToCart_cssSelector,"cssSelector");
        //paso4
        cart.writeQuantity(PagesElements.TextboxQuantity_name,quantity,"name");
        cart.updateCart(PagesElements.ButtonUpdateQuantity_cssSelector,"cssSelector");
        //paso 5
        quantityActual=cart.QuantityInCart(PagesElements.TextboxQuantity_name,"value","name");
   	    try
   	    {
   	     Assertions.assertEquals(quantityActual,quantity,"El valor esperado es "+quantity+"y el valor actual es "+quantityActual);
   	    }
   	    finally
   	    {
        //paso 6
        cart.clickToCheckOut(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
        //paso 7
        login.writeUser(PagesElements.TextboxEmail_name,ImputData.user,"name");
        login.writePassword(PagesElements.TextboxPassword_name,ImputData.password,"name");
        login.clickSignIn(PagesElements.ButtonLogin_cssSelector,"cssSelector");
        //paso 8
        checkout.passedDeliveryInformation(PagesElements.ButtonContinue_cssSelector,"cssSelector");
        checkout.passedSelectPaymantMethod(PagesElements.CheckBoxPaymantMethod_xpath,"xpath");
        checkout.payNow(PagesElements.ButtonContinue_cssSelector,"cssSelector");
        //Validamos que aparece la informacion del pedido
        if(checkout.validationRevisionOrder(PagesElements.LabelBillingInformation_xpath,PagesElements.LabelShippingInformation_xpath,"xpath"))
         {
          System.out.println("la informacion del pedido aparece para el pedido 1");
        }
        //paso9
        checkout.payNow(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
        //paso10
        Assertions.assertEquals(ImputData.textOrderSuccess,checkout.textFromOrder(PagesElements.LabelOrderComplete_xpath,"xpath"));
        //paso 11
        checkout.goToCatalog(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
         //paso12
         account.logOut(PagesElements.LinkLogOut_xpath,"xpath");
   	    }
	}
  
	
	@Test
	void test2() {
		
		//Paso 1
        catalog.navigateToCommerce(ImputData.url);
        //paso 2
        //escribe nombre producto
        catalog.writeProduct(PagesElements.TextBoxSearchProduct_name,"Beloved","name");
        //busca el producto
        catalog.searchProduct(PagesElements.ButtonSearchProduct_xapth,"xpath");
        //accede al producto
        catalog.clickToProduct(element.getLocatorProduct("Beloved"),"xpath");
        //paso 3
        catalog.addCart(PagesElements.ButtonAddToCart_cssSelector,"cssSelector");
        //paso4
        cart.writeQuantity(PagesElements.TextboxQuantity_name,quantity,"name");
        cart.updateCart(PagesElements.ButtonUpdateQuantity_cssSelector,"cssSelector");
        //paso 5
        quantityActual=cart.QuantityInCart(PagesElements.TextboxQuantity_name,"value","name");
   	    try
   	    {
   	     Assertions.assertEquals(quantityActual,quantity,"El valor esperado es "+quantity+"y el valor actual es "+quantityActual);
   	    }
   	    finally
   	    {
        //paso 6
        cart.clickToCheckOut(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
        //paso 7
        login.writeUser(PagesElements.TextboxEmail_name,ImputData.user,"name");
        login.writePassword(PagesElements.TextboxPassword_name,ImputData.password,"name");
        login.clickSignIn(PagesElements.ButtonLogin_cssSelector,"cssSelector");
        //paso 8
        checkout.passedDeliveryInformation(PagesElements.ButtonContinue_cssSelector,"cssSelector");
        checkout.passedSelectPaymantMethod(PagesElements.CheckBoxPaymantMethod_xpath,"xpath");
        checkout.payNow(PagesElements.ButtonContinue_cssSelector,"cssSelector");
        //Validamos que aparece la informacion del pedido
        if(checkout.validationRevisionOrder(PagesElements.LabelBillingInformation_xpath,PagesElements.LabelShippingInformation_xpath,"xpath"))
         {
          System.out.println("la informacion del pedido aparece para el pedido 2");
        }
        //paso9
        checkout.payNow(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
        //paso10
        Assertions.assertEquals(ImputData.textOrderSuccess,checkout.textFromOrder(PagesElements.LabelOrderComplete_xpath,"xpath"));
        //paso 11
        checkout.goToCatalog(PagesElements.ButtonCheckOut_cssSelector,"cssSelector");
         //paso12
         account.logOut(PagesElements.LinkLogOut_xpath,"xpath");
   	    }
	}

}



