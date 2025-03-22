package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumLoginPage {

	private WebDriver driver;

	// WebElement für das Eingabefeld des Benutzernamens
	@FindBy(css = "#__ac_name")
	private WebElement inputBenutzername;
	
	// WebElement für das Eingabefeld des Passworts
	@FindBy(xpath = "//input[@id='__ac_password']")
	private WebElement inputPassword;
	
	// WebElement für den Button zur Anmeldung
	@FindBy(xpath = "//input[@value='Anmelden']")
	private WebElement btnAnmeldung;
	
	// WebElement für die Statusmeldung, die nach der Anmeldung erscheint
	@FindBy(css = ".portalMessage")
	private WebElement statusMeldung;
	
	// Konstruktor zur Initialisierung der WebElemente
	public SeleniumLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente auf dieser Seite
	}
	
	// Gibt die Zugangsdaten (Benutzername und Passwort) in die entsprechenden Felder ein
	public void zugangsdatenEingeben(String benutzername, String password) {
		inputBenutzername.sendKeys(benutzername); // Gibt den Benutzernamen ein
		inputPassword.sendKeys(password); // Gibt das Passwort ein
	}
	
	// Klickt auf den "Anmelden"-Button, um den Login-Prozess zu starten
	public void loginButtonAnklicken() {
		btnAnmeldung.click(); // Klickt auf den Anmelden-Button
	}
	
	// Liest die Statusmeldung nach der Anmeldung aus
	public String statusMeldungAuslesen() {
		return statusMeldung.getText(); // Gibt den Text der Statusmeldung zurück
	}
}
