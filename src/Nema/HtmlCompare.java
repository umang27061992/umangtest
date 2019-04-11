package Nema;





import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

@Test
public class HtmlCompare {
  public void Html_test() throws IOException, InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.nema.org/About/Awards/pages/default.aspx");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String s1=driver.getPageSource();
		
		File file = new File("D:\\test1.txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(s1);
		Thread.sleep(3000);

	  System.out.println("Tesssst");
		driver.get("https://www.nema.org/About/Awards/pages/default.aspx");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		String s2= driver.getPageSource();
		File file1 = new File("D:\\test2.txt");
		FileWriter fileWriter1 = new FileWriter(file1);
		fileWriter1.write(s2);
		fileWriter.flush();
		fileWriter.close();
		boolean compare1and2 = FileUtils.contentEquals(file, file1);
		
		System.out.println(compare1and2);
		
		Actions action = new Actions(driver);
		WebElement web = driver.findElement(By.id(""));
				action.doubleClick(web).perform();





	    
  }
  
  
}
