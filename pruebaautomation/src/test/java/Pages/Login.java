package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.*;

public class Login{
	public WebDriver _driver;
	
	public Login(WebDriver driver) {
		_driver = driver;
	}
	
	public void login(String username, String password) {
		
		WebElement element1 = _driver.findElement(By.name("username"));
		element1.clear();
		element1.sendKeys(username);
		
		WebElement element2 =_driver.findElement(By.name("password"));
		element2.clear();
		element2.sendKeys(password);
		
		WebElement element3 =_driver.findElement(By.name("login"));
		element3.click();
		
	}
}
