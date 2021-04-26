package hln.be;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","C:/dev/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
	driver.get("https://www.hln.be/sport/");
	driver.manage().window().maximize();
	
	

	WebElement frame = driver.findElement(By.xpath("//div[contains(@id,'sp_message')]//iframe"));
	driver.switchTo().frame(frame);
	
	WebElement button = driver.findElement(By.xpath("//div[contains(@class,'message-component')]//button[@title='Akkoord']"));
	button.click();
	driver.switchTo().defaultContent();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@class='page-main-footer']//section[@class='footer__bar']")));
		
	WebElement scroll = driver.findElement(By.xpath("//footer[@class='page-main-footer']//section[@class='footer__bar']"));
	js.executeScript("arguments[0].scrollIntoView();", scroll);
	
	WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'dpgmedia')]"));
	
	String actualText = ele.getText();
	String expectedText = "Mediaplein 1, 2018 Antwerpen";
	Assert.assertTrue(expectedText, actualText.contains("Mediaplein 1, 2018"));
	
	
	List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@class='advertisement']//div[contains(@data-id,'sky--1')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='advertisement']//div[contains(@data-id,'sky--1')]")));
	if(dynamicElement.size() != 0)
	 System.out.println("Advertisement is present");
	else
	 System.out.println("Advertisement is not present");
	
	driver.close();
	}

}
