package WebApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\SEL\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");

		// Select the dropdown

		// driver.findElement(By.xpath("//input[@id =
		// 'ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.id("divpaxinfo")).click();

		// Thread.sleep(2000L);

		for (int i = 1; i < 4; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt"))).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
