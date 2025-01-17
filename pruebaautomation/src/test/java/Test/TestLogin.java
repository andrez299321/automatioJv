package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utilities.DriverWrap;

public class TestLogin {
	private WebDriver _driver;
	private Login _objLogin;
	private String _url;
	
	@Before
	public void setUp() {
		_url = "https://pruebas-facial.securidbio.com/configuration";
		DriverWrap driver = new DriverWrap();
		_driver = driver.getDriver(_url);
		_objLogin = new Login(_driver);
	}
	
	@Test
	public void LoginSucess() {
		_objLogin.login("abc","1");
		
		// Crear WebDriverWait con un máximo de espera de 5 segundos
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));

        // Esperar hasta que el campo de búsqueda esté presente y sea visible
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-layout/app-header/app-menu/p/mat-toolbar/div/img")));
		assertTrue("La imagen debería estar visible en la página.",img.isDisplayed());
		
	}
	
	@Test
	public void LoginFail() { 
		_objLogin.login("abc","2");
		
		// Crear WebDriverWait con un máximo de espera de 5 segundos
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));

        // Esperar hasta que el campo de búsqueda esté presente y sea visible
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-error")));
		
        String data =searchBox.getText();
        System.out.println(data);
        
		assertEquals("Usuario o contraseña incorrectos.", data);
		
	}
	
	@After
	public void SetDown() {
		_driver.quit();
	}
}
