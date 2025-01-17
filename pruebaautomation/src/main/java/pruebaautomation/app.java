package pruebaautomation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;




public class app {

	   public static void main(String[] args) {
		   
		   ChromeOptions options = new ChromeOptions();
		   options.addArguments("start-maximized"); 
		   options.addArguments("enable-automation"); 
		   options.addArguments("--no-sandbox"); 
		   options.addArguments("--disable-infobars");
		   options.addArguments("--disable-dev-shm-usage");
		   options.addArguments("--disable-browser-side-navigation"); 
		   options.addArguments("--disable-gpu"); 
		   
		   WebDriver driver = new ChromeDriver();

		   driver.get("https://www.google.com/");

		   
	        // Imprime el título de la página
	        System.out.println("Título de la página: " + driver.getTitle());

	        // Cierra el navegador
	        driver.quit(); 
	    }

}
