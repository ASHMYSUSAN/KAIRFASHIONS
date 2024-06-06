package pagepkg;

import java.io.File;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class KairPage {
WebDriver driver;

@FindBy(xpath="//*[@id=\"shopify-section-header\"]/header/div[1]/div/div/a")
WebElement popup;

@FindBy(xpath="//*[@id=\"customer_login_link\"]")
WebElement loginbutton;

@FindBy(xpath="//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[1]/input")
WebElement emailid;

@FindBy(xpath="//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[2]/input")
WebElement pass;

@FindBy(xpath="//*[@id=\"dropdown-customer\"]/div[2]/div/form/div[1]/div[3]/input")
WebElement loginsubmit;

@FindBy(xpath="//*[@id=\"sticky-wrapper\"]/div/div[1]/div/div/div/div/nav/ul/li[2]/a")
WebElement newborn;

@FindBy(xpath="//*[@id=\"sticky-wrapper\"]/div/div[1]/div/div/div/div/nav/ul/li[2]/div/ul/li[2]/a")
WebElement blanket;

@FindBy(xpath="//*[@id=\"shopify-section-collection-template-default\"]/div/div[2]/div[1]/div/div/div[1]/div[1]/a")
WebElement item1;

@FindBy(name="add")
WebElement cart;

@FindBy(xpath="//*[@id=\"baby-blanket-kair-fashion\"]/div[11]/div/div/div/div[1]/div[2]/div/div[2]/ul/li/div[2]/div[2]/div/a[2]")
WebElement quantity;

@FindBy(xpath="//*[@id=\"baby-blanket-kair-fashion\"]/div[11]/div/div/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/a[1]")
WebElement contishop;

@FindBy(xpath="//*[@id=\"kid-boys-printed-shirt\"]/div[11]/div/div/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/a[2]")
WebElement viewcart;
@FindBy(xpath="//*[@id=\"shopify-section-header\"]/header/div/div/div/div[2]/div[2]/div[1]/div/a")
WebElement kairlogo;

@FindBy(name="q")
WebElement search;

@FindBy(xpath="//*[@id=\"search-543-results-found-for-quot-shirt-quot\"]/div[4]/main/div/div/div[1]/div/div[2]/div/div/div[1]/div[1]/a")
WebElement shirt;

@FindBy(xpath="//*[@id=\"product-variants\"]/div[3]/div[3]/label")
WebElement sizechart;

@FindBy(name="add")
WebElement addtocart;

@FindBy(xpath="//*[@id=\"kid-boys-printed-shirt\"]/div[11]/div/div/div/div[1]/div[2]/div/div[1]/div[3]/div[2]/a[1]")
WebElement contnshpg;

@FindBy(xpath="//*[@id=\"sticky-wrapper\"]/div/div[1]")
WebElement menu;



public KairPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void logintest()
{
	popup.click();
	loginbutton.click();
	
}

public void setvalues(String email,String password) throws Exception
{
	emailid.clear();
	emailid.sendKeys(email);
	pass.clear();
	pass.sendKeys(password);
	loginsubmit.click();
	
	
}

public void category()
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	Actions act=new Actions(driver);
	act.moveToElement(newborn).perform();
	blanket.click();
}

public void newbornitems()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)", "");
	item1.click();
	cart.click();
}

public void quantityinc()
{
	quantity.click();
	viewcart.click();
	//contishop.click();
}

public void searchitem()
{
	search.sendKeys("shirt",Keys.ENTER);
	search.click();
	shirt.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)", "");
	sizechart.click();
	addtocart.click();
	
}


public void viewcartmthd()
{
	viewcart.click();
	
}

public void continueshopping()
{
	
	contnshpg.click();
}


public void menudisplay()
{
	List<WebElement> li=menu.findElements(By.tagName("li"));
	for(WebElement src:li)
	{
		String print=src.getText();
		if(!print.isEmpty())
		{
			System.out.println(print.trim());
	
		}
	}
}


public void scrnshot() throws Exception {
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("./kairscrnshot/checkoutpage1.png"));
	Thread.sleep(2000);
	
	
}


public void logodisplay()
{
	boolean logo=kairlogo.isDisplayed();
	if(logo)
	 {
	 	System.out.println("logo is present");
	 }
	 else  
	 {
	 	System.out.println("logo is not present");
	 }
}


public void titleverification()
{
	String actualtitle=driver.getTitle();
	String exptitle="Account";
	Assert.assertEquals(actualtitle, exptitle);
}


public void linkcount()
{
	List<WebElement> li=driver.findElements(By.tagName("a"));
	System.out.println("Total no: of links:"+li.size());
}

}
