package hln.be;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/dev/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
	driver.get("https://www.hln.be/");
	driver.manage().window().maximize();
	
	
	WebElement frame = driver.findElement(By.xpath("//div[contains(@id,'sp_message')]//iframe"));
	driver.switchTo().frame(frame);
	
	WebElement button = driver.findElement(By.xpath("//div[contains(@class,'message-component')]//button[@title='Akkoord']"));
	button.click();
	driver.switchTo().defaultContent();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@class='page-main-footer']//section[@class='footer__bar']")));
		
	WebElement scroll = driver.findElement(By.xpath("//footer[@class='page-main-footer']//section[@class='footer__bar']"));
	js.executeScript("arguments[0].scrollIntoView();", scroll);
	
	WebElement ele = driver.findElement(By.xpath("//section[contains(@class,'footer__dpgmedia')]//div[contains(@class,'dpgmedia')]"));
	
	String actualText = ele.getText();
	String expectedText = "Mediaplein 1, 2018 Antwerpen";
	Assert.assertTrue(expectedText, actualText.contains("Mediaplein 1, 2018"));
	driver.close();

	}

}
