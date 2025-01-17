package Test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.*;
import Utilities.DriverWrap;

public class TestClient {

	private WebDriver _driver;
	private Login _objLogin;
	private Client _objClient;
	private String _url;
	
	@Before
	public void setUp() {
		_url = "https://pruebas-facial.securidbio.com/configuration";
		DriverWrap driver = new DriverWrap();
		_driver = driver.getDriver(_url);
		_objLogin = new Login(_driver);
		_objClient = new Client(_driver);
	}
	
	@Test
	public void CreateClient() {
		_objLogin.login("abc","1");
		_objClient.createClient("ClienteJava3", "Java3252", "Java3252", "Organizacion Uno");
		
		WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
		WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-snackbar/mat-dialog-content/div/div")));
		String data =card.getText();
	    System.out.println(data);   
	    assertEquals("Cliente creado exitosamente", data.trim());
	    
	}
	
	@After
	public void SetDown() {
		_driver.quit();
	}
}
