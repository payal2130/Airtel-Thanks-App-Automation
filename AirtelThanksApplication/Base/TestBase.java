import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
  static WebDriver driver;
  static Properties prop;
  
  public TestBase()
  {
	  //Read properties file code, we can write here also
	  
	  {
			try
			{
			prop = new Properties();
			FileInputStream inp = new FileInputStream("/Users/b0224547/eclipse-workspace/AirtelThanksApplication/config/config.properties");
			prop.load(inp);
			System.out.println(prop.getProperty("browser"));
			}
			catch(Exception f)
			{
				System.out.println("File not found");
			}
			
		}
  }
  public static void initialisation()
  {
	  String browserName = prop.getProperty("browser");
	  
	  if(browserName.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("firefox"))  
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
	  try {
	  Thread.sleep(3000);
	  }
	  catch(Exception e)
	  {
		  System.out.println("Execution has been interrupted");
	  }
	  Dimension d = new Dimension(800, 800);
	  driver.manage().window().setSize(d);
	  
  }
  
  public static void main(String args[])
  {
	  TestBase t = new TestBase();
	  initialisation();
  }
  
}