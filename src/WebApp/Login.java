package WebApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Login {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\SEL\\driver\\chromedriver.exe");
	    WebDriver wd1 = new ChromeDriver();
	    wd1.manage().window().maximize();
	    
	    wd1.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);    
	    
	    wd1.get("https:/dashboard.optimisemedia.com/");
	    
	    
	  //Create an object of File class to open xlsx file
	    File file = new File("E:\\SEL\\credentials.xlsx");
	  //Create an object of FileInputStream class to read excel file
//	    FileInputStream inputstream = new FileInputStream(file);
//	    XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
//	    XSSFSheet sheet = workbook.getSheetAt(0);
//	    int row = sheet.getLastRowNum();
//	   int col= sheet.getRow(row).getLastCellNum();
//	   
//	   System.out.println(row);
//	   System.out.println(col);
//	   
//	   for(int i=0;i<=row;i++)
//	   {
//		  for(int j=0;j<col;j++)
//		  {
//			  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
//		  }
//	   }
//	    
	    
	    //Check condition if the file is xlsx file
	 
	    
	    
	    

	    wd1.findElement(By.xpath(".//input[@type='text']")).sendKeys("jyoti.sajwan@optimisemedia.com");
	    wd1.findElement(By.xpath("//input[@type= 'password']")).sendKeys("Saanvi@26");
//	    wd1.findElement(By.xpath("//span[text()='English (UK)']")).click();
//	    wd1.findElement(By.xpath("//span[text()='Portuguese']")).click();
	    
    wd1.findElement(By.xpath(".//button[@type='submit']")).click();
	    Thread.sleep(2000);
	   wd1.findElement(By.xpath("//a[@href='/agency/dashboard']")).click();
	    wd1.findElement(By.xpath("//span/span[text()='Dashboard']")).click();
	    
  wd1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
 Thread.sleep(23000);
	  
	   
            WebElement   dd = wd1.findElement(By.xpath("//span[text()='Account Manager']/parent::label/following-sibling::div/div/div/span[text()='All']"));
            
           			dd.click();
  
	   wd1.getWindowHandle();
  Thread.sleep(6000);
    	System.out.println(wd1.findElement(By.xpath("//span[text()='Account Manager']/parent::label/following-sibling::div/div/div")).getText());
    	wd1.findElement(By.xpath("//li[@data-value='1054762']")).click();
    	Thread.sleep(12000);
    	WebElement NC= wd1.findElement(By.xpath("//span[text()='How are my campaigns performing?']/parent::h6/following-sibling::div/label/following-sibling::div/div/div/span[text()='Conversions']"));
    	NC.click();
    	wd1.findElement(By.xpath("//li/span[text()='Clicks']")).click();
    	
    	
// What changes have there been at a publisher campaign level?
    	
    	// Measures dropdown
    	Thread.sleep(6000);    
    	WebElement NC2 = wd1.findElement(By.xpath("//span[contains(text(),'publisher campaign')]/parent::h6/following-sibling::div/label/following-sibling::div/div/div/span"));
    	 Actions actions= new Actions(wd1);
    	 actions.moveToElement(NC2).click().perform();
    	  	Thread.sleep(6000);   
    			WebElement NC3 =wd1.findElement(By.xpath("//li/span[text()='Clicks']"));
    			actions.moveToElement(NC3).click().build().perform();   
    	// Performance drop-down
    			Thread.sleep(3000);
    	WebElement NC4 = wd1.findElement(By.xpath("//span[text()='Performance']/parent::label/following-sibling::div/div/div[text()='Down']"));
    	NC4.click();
    	Thread.sleep(3000);
    	WebElement NC5 = wd1.findElement(By.xpath("//li[text()='Slightly Down']/span/span[@class='jss190']"));
    	NC5.click();
    	
    	// Frequency Drop-down
    	Thread.sleep(3000);
    	WebElement NC6 =wd1.findElement(By.xpath("//div[text()='Daily']"));
    	actions.moveToElement(NC6).click().build().perform(); 
    	WebElement NC7 =wd1.findElement(By.xpath("//li[text()='Twice Weekly']"));
    	actions.moveToElement(NC7).click().build().perform(); 
    	
    	
    	
//    	
//    	 wd1.findElement(By.xpath("name'span[text()='All']")).click();
//    	
//   
//    
//    wd1.findElement(By.xpath("//span[text()='Account Manager']/parent::label/following-sibling::div/div/div/following-sibling::input"));
//
//    wd1.findElement(By.xpath("//span/span[text()='All Reports']")).click();
//	    wd1.findElement(By.xpath("//span[text()='Add new report']")).click();
//	    wd1.findElement(By.xpath("//span[@class='jss199']/span[text()='All Reports']")).click();
      
//	   wd1.close(); 
	    
	}


}
