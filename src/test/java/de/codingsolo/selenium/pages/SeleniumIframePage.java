package de.codingsolo.selenium.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumIframePage {
	
	private WebDriver driver;

	// WebElement für das Eingabefeld "Name"
	@FindBy(id = "name")
	private WebElement inputName;

	// WebElement für den "Alert" Button
	@FindBy(id = "alertbtn")
	private WebElement btnAlert;

	// Konstruktor zur Initialisierung der WebElemente
	public SeleniumIframePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente auf dieser Seite
	}
	
	// Wechselt zum eingebetteten iFrame auf der Seite
	public void wechselZuIframe() {
		driver.switchTo().frame("iframe"); // Wechselt zu einem iFrame mit der ID "iframe"
	}
	
	// Gibt einen Namen in das Eingabefeld "Name" ein
	public void nameEintragen(String name) {
		inputName.sendKeys(name); // Trägt den übergebenen Namen in das Eingabefeld ein
	}
	
	// Klickt auf den "Alert" Button
	public void alarmBtnAnklickken() {
		btnAlert.click(); // Klickt auf den Button, der einen Alert auslöst
	}
	
	// Liest den Text des angezeigten Alarms aus
	public String alarmNachrichtAuslesen() {
		return driver.switchTo().alert().getText(); // Holt den Text des angezeigten Alarms
	}

	// Bestätigt den Alarm, wodurch er geschlossen wird
	public void alarmNachrichtSchliessen() {
		driver.switchTo().alert().accept(); // Schließt den Alert, indem er akzeptiert wird
	}
}
