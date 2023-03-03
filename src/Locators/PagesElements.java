package Locators;

public class PagesElements {
	
	//Elementos en orden de ejecucion
	//selector name
	private String product="";
    public static final String TextBoxSearchProduct_name="keywords";
	//xpath
	public static final String ButtonSearchProduct_xapth="//input[@alt='Quick Find']";
	public String ImageProductPhone_xpath="";
	//public static final String ImageProducDVD_xpath="//img[@alt='Beloved']";
	//cssSelector
    public static final String ButtonAddToCart_cssSelector="#tdb4";
    //selector name
    public static final String TextboxQuantity_name="cart_quantity[]";
    //cssSelector              
    public static final String ButtonUpdateQuantity_cssSelector="#tdb4";
    //cssSelector
    public static final String ButtonCheckOut_cssSelector="#tdb5";
    //selector name
    public static final String TextboxEmail_name="email_address";
    public static final String TextboxPassword_name="password";
    //ccsSelector 
    public static final String ButtonLogin_cssSelector="#tdb1";
    public static final String ButtonContinue_cssSelector="#tdb6";
    //xpath
    public static final String  CheckBoxPaymantMethod_xpath="//input[@value='cod']";
    public static final String  LabelShippingInformation_xpath="//h2[contains(text(),'Shipping Information')]";
    public static final String  LabelBillingInformation_xpath="//h2[contains(text(),'Billing Information')]";
    public static final String  LabelOrderComplete_xpath="//h1[contains(text(),'Your Order Has Been Processed!')]";
    public static final String  LinkLogOut_xpath="//span[contains(text(),'Log Off')]";
    
    
    
    public  String  getLocatorProduct(String product)
    {
    	 ImageProductPhone_xpath= "//img[@alt='"+product+"']";
    	 return ImageProductPhone_xpath;
    }
  
}
