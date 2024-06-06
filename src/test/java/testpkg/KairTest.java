package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.KairPage;
import utilities.Excelutilities;

public class KairTest {
	WebDriver driver;
	String baseurl="https://kairfashion.com/";
	KairPage ob;
	
	@BeforeTest
	public void setvalues()
	{
		driver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		driver.get(baseurl);
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void beforemthd() {
		
		ob=new KairPage(driver);
	}
	
	
	@Test(priority = 1)
	public void accttest()
	{
		
		ob.logintest();
	}
	
	
	@Test(priority = 2)
	public void  kairtest() throws Exception
	{
		
		String xl="C:\\Users\\User\\Desktop\\project1.xlsx";
		String Sheet="sheet1";
		int rowCount=Excelutilities.getRowCount(xl,Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			String Username=Excelutilities.getCellValue(xl, Sheet, i, 0);
			System.out.println("username---"+Username);
			String Pswd=Excelutilities.getCellValue(xl, Sheet, i, 1);
			System.out.println("password----"+Pswd);
			ob.setvalues(Username, Pswd);
		
		}
		
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 3)
	public void newborntest()
	{
		ob.category();
	}
	
	
	@Test(priority = 4)
	public void newbaby()
	{
		ob.newbornitems();;
	}
	
	
	@Test(priority = 5)
	public void quantityncontishop()
	{
		ob.quantityinc();
	}
	
	
	@Test(priority=6)
	public void searchmthd()
	{
		ob.searchitem();
	}
	
	
	@Test(priority = 7)
	public void carttest()
	{
		ob.viewcartmthd();
	}
	
	
	@Test(priority=8)
	public void scrnshottest() throws Exception
	{
		ob.scrnshot();
	}
	
	
	@Test(priority=9)
	public void contnshpgtest()
	{
		ob.continueshopping();
	}
	
	
	
	
	@Test(priority=10)
	public void menutest()
	{
		ob.menudisplay();
	}
	
	
	
	

}
