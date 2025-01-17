package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {

	public WebDriver _driver;
	
	public Client(WebDriver driver) {
		_driver = driver;
	}
	
	public void createClient(String nameClient, String codeRNEC, String identityClient, String organizationClient) {
		WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(5));
		WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-layout/app-header/app-menu/p/mat-toolbar/button")));
		element6.click();
		
		WebElement element7 = _driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/button[2]"));
		element7.click();
		
		WebElement element8 = _driver.findElement(By.id("add"));
		element8.click();
		
		WebElement element1 = _driver.findElement(By.id("name"));
		element1.clear();
		element1.sendKeys(nameClient);
		
		WebElement element2 = _driver.findElement(By.id("codeRNEC"));
		element2.clear();
		element2.sendKeys(codeRNEC);
		
		WebElement element3 = _driver.findElement(By.id("numberIdentity"));
		element3.clear();
		element3.sendKeys(identityClient);
		
		WebElement element4 = _driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-client-form/form/mat-card/mat-card-content/mat-grid-list/div/mat-grid-tile[9]/div/mat-form-field/div[1]/div[2]/div/mat-select"));
		element4.click();
		List<WebElement> elements = _driver.findElements(By.className("mat-mdc-option"));
		for (WebElement item : elements) {
			String text = item.getText();
			if (text.equals(organizationClient)) {
				item.click();
				break;
			}
		}
		
		try {
		    Thread.sleep(2000); // 2000 milisegundos = 2 segundos
		} catch (InterruptedException e) {
		    e.printStackTrace(); // Manejo de excepción si el hilo es interrumpido
		}
		
		WebElement element9 = _driver.findElement(By.xpath("/html/body/app-root/app-layout/div/app-client-form/form/mat-card/mat-card-content/mat-grid-list/div/mat-grid-tile[8]/div/mat-form-field/div[1]/div[2]/div/mat-select"));
		element9.click();
		List<WebElement> elementss = _driver.findElements(By.className("mat-mdc-option"));
		for (WebElement item2 : elementss) {
			String text2 = item2.getText();
			if (text2.equals("Activo")) {
				item2.click();
				break;
			}
		}
		
		WebElement element5 = _driver.findElement(By.id("save"));
		element5.click();
	}
}
