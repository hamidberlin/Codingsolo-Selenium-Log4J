package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTestApplikationenPage {
	
	private WebDriver driver;
	
	// WebElement für den Menü-Button
	@FindBy(id = "portaltab-burger-menu")
	private WebElement btnMenu;
	
	// WebElement für den Link zu "Selenium Test Form1"
	@FindBy(linkText = "Selenium Test Form1")
	private WebElement linkSeleniumTestForm1;
	
	// WebElement für den Link zum "Drag and Drop Beispiel"
	@FindBy(linkText = "Drag and Drop Beispiel")
	private WebElement linkSeleniumDragDrop;
	
	// WebElement für den Link zum "IFrame Test"
	@FindBy(linkText = "IFrame Beispiel")
	private WebElement linkIframeTest;
		
	// WebElement für den Link zu den "Web Elementen" Beispielen
	@FindBy(linkText = "Web Elemente")
	private WebElement linkWebElemente;
	
	@FindBy(linkText = "Katzensuche Testseite (AJAX)")
	private WebElement linkWebElementKatzensuche;

	// Konstruktor zur Initialisierung der WebElemente auf dieser Seite
	public SeleniumTestApplikationenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente dieser Seite
	}
	
	// Methode, die auf den Menü-Button klickt, um das Menü auszuklappen
	public void btnMenuAusklappen() {
		btnMenu.click(); // Klickt auf den Menü-Button
	}
	
	// Methode, die auf den Link "Selenium Test Form1" klickt, um das entsprechende Formular zu öffnen
	public void testForm1Anklicken() {
		linkSeleniumTestForm1.click(); // Klickt auf den Link "Selenium Test Form1"
	}
	
	// Methode, die auf den Link "Drag and Drop Beispiel" klickt, um die Drag and Drop-Seite zu öffnen
	public void testDragDropAnklicken() {
		linkSeleniumDragDrop.click(); // Klickt auf den Link "Drag and Drop Beispiel"
	}
	
	// Methode, die auf den Link "IFrame Beispiel" klickt, um die IFrame-Seite zu öffnen
	public void iframeTestAnklicken() {
		linkIframeTest.click(); // Klickt auf den Link "IFrame Beispiel"
	}
	
	// Methode, die auf den Link "Web Elemente" klickt, um die Web-Elemente-Seite zu öffnen
	public void webElementeBeispielAnklicken() {
		linkWebElemente.click(); // Klickt auf den Link "Web Elemente"
	}

	public void linkTextKatzenSucheAnklicken() {
		linkWebElementKatzensuche.click();
		
	}

}
