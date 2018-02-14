
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
	String animal = "fish";
	//Transformation de la variable précédente pour convenir à la casse
	String animalBis = animal.substring(0, 1).toUpperCase()+animal.substring(1);
	
	@Test
	public void test() {
	
	//Set Up du navigateur
	String nav = System.getProperty("navigateur");
	WebDriver navigateur = null;
	
	//nav = "chrome";
	
	if(nav.equals("chrome")) {
	    navigateur = new ChromeDriver();
	}
	
	if(nav.equals("firefox")) {
		//Sélection de firefox comme navigateur	
		System.setProperty("webnavigateur.gecko.navigateur", "C:\\FORMATION\\installeurs\\Selenium\\geckonavigateur.exe");	
		FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		options.addPreference("browser.tab.remote.autostart", false);
		options.addPreference("browser.tab.remote.autostart.1", false);
		options.addPreference("browser.tab.remote.autostart.2", false);
		navigateur = new FirefoxDriver(options);
	}
	
	navigateur.get("http://localhost:8081/jpetstore");
	navigateur.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//Step 1: Entrée dans le magasin
	WebElement entree = navigateur.findElement(By.linkText("Enter the Store")); 	
	entree.click();
	
	//Step 2: Click sur l'animal variabilisé
	WebElement animalButton = navigateur.findElement(By.xpath("//img[@src='../images/" + animal + "_icon.gif']")); 	
	animalButton.click();	
	
	//Step 3: vérification du titre de la page affichée
	WebElement animalTitreWE = navigateur.findElement(By.xpath("//div[@id='Catalog']/h2"));	
	String animalTitre = animalTitreWE.getText();
	assertEquals(animalBis, animalTitre);
	
	//Fermeture du navigateur
	navigateur.close();
	
	//Ajout d'un commentaire inutile : Maintenance
	
	//Ajout d'un commentaire inutile : Master
	
	}

}
