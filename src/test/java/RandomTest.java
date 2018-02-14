
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class RandomTest {

		
	//Animal à variabiliser
	String animal = "dogs";
	//Transformation de la variable précédente pour convenir à la casse
	String animalBis = animal.substring(0, 1).toUpperCase()+animal.substring(1);
	
	@Test
	public void test() {
	
	//Set Up du navigateur
	String nav = System.getProperty("navigateur");
	WebDriver browser = null;
	
	//nav = "chrome";
	
	if(nav.equals("chrome")) {

	    browser = new ChromeDriver();
	}
	
	if(nav.equals("firefox")) {
		//Sélection de firefox comme navigateur	

		System.setProperty("webdriver.gecko.driver", "C:\\FORMATION\\installeurs\\Selenium\\geckodriver.exe");	
		FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		options.addPreference("browser.tabs.remote.autostart", false);
		//options.addPreference("browser.tabs.remote.autostart.1", false);
		//options.addPreference("browser.tabs.remote.autostart.2", false);

		browser = new FirefoxDriver(options);
	}
	

	browser.get("http://localhost:8081/jpetstore");
	browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	//Step 1: Entrée dans le magasin

	WebElement entree = browser.findElement(By.linkText("Enter the Store")); 	
	entree.click();
	
	//Step 2: Click sur l'animal variabilisé

	WebElement animalButton = browser.findElement(By.xpath("//img[@src='../images/" + animal + "_icon.gif']")); 	
	animalButton.click();	
	
	//Step 3: vérification du titre de la page affichée

	WebElement animalTitreWE = browser.findElement(By.xpath("//div[@id='Catalog']/h2"));	
	String animalTitre = animalTitreWE.getText();
	assertEquals(animalBis, animalTitre);
	
	//Fermeture du navigateur

	browser.close();
	
	
	}

}
