package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestUsingTestNG {

	public ChromeDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_88.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}

	@Test
	public void FacebookSignUp() throws InterruptedException {

		driver.findElementByXPath("//a[text()='Create New Account']").click();
		driver.findElementByName("firstname").sendKeys("Muralikrishnan");
		driver.findElementByName("lastname").sendKeys("G");
		driver.findElementByName("reg_email__").sendKeys("test001@gmail.com");
		Thread.sleep(3000);
		driver.findElementByName("reg_email_confirmation__").sendKeys("test001@gmail.com");
		driver.findElementByName("reg_passwd__").sendKeys("123@@#$PDEsde");

		Select day = new Select(driver.findElementById("day"));
		day.selectByVisibleText("1");

		Select month = new Select(driver.findElementById("month"));
		month.selectByVisibleText("Jul");

		Select year = new Select(driver.findElementById("year"));
		year.selectByVisibleText("1995");
		
		driver.findElementByXPath("(//input[@name='sex'])[2]").click();

		driver.findElementByXPath("(//button[@type='submit'])[2]").click();


	}

	@AfterMethod
	public void tearDown() {

		driver.close();

	}
}
