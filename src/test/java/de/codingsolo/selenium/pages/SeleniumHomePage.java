package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHomePage {
	
	private WebDriver driver;
	
	// WebElement für die Statusmeldung auf der Seite
	@FindBy(css = ".portalMessage")
	private WebElement statusMeldung;
	
	// WebElement für den Menü-Button
	@FindBy(id = "portaltab-burger-menu")
	private WebElement btnMenu;
	
	// WebElement für den Link im Seitenmenü
	@FindBy(linkText = "Selenium Testapplikationen")
	private WebElement linkSideMenuSeleniumTestApp;

	// Konstruktor für die Initialisierung der WebElemente auf der Seite
	public SeleniumHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente auf der Seite
	}

	// Gibt die Textnachricht der Statusmeldung auf der Seite zurück
	public String statusMeldungAuslesen() {
		return statusMeldung.getText(); // Text der Statusmeldung auslesen
	}
	
	// Klappt das Menü aus, indem der Menü-Button geklickt wird
	public void btnMenuAusklappen() {
		btnMenu.click(); // Klickt auf den Menü-Button
	}
	
	// Klickt auf den Link "Selenium Testapplikationen" im Seitenmenü
	public void seleniumTestLinkAnklicken() {
		linkSideMenuSeleniumTestApp.click(); // Klickt auf den Link "Selenium Testapplikationen"
	}
}
