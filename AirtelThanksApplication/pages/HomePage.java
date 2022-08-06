import org.openqa.selenium.WindowType;
import org.testng.annotations.*;

public class HomePage extends TestBase
{
	public HomePage()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialisation();
	}
	
	@Test
	public void launchApp()
	{
		driver.get("https://www.google.com");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://airtel.in/");
	}
	
	
}