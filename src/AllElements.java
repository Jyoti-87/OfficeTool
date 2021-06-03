import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllElements {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "E://SEL//driver//chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gogle.com");
		System.out.println(driver.getPageSource());
		
// for all webelements on page
		List<WebElement>elements = driver.findElements(By.xpath(".//*"));
		
		for (WebElement el:elements)
		{
		System.out.println(el.getTagName() + ":" + el.getText());	
		}
		
//		for all ref on page
		
		List<WebElement> ref = driver.findElements(By.tagName("a"));
	
		for (WebElement ref2:ref) {
			System.out.println(ref2.getAttribute("href"));
		}

	}

}
