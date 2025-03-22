package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestForm1Page {

	WebDriver driver;

	// WebElement für die Überschrift des Formulars
	@FindBy(tagName = "h1")
	private WebElement testFormHeadline;

	// WebElement für das Eingabefeld "Betreff"
	@FindBy(id = "form-widgets-betreff")
	private WebElement inputBetreff;

	// WebElement für das Eingabefeld "Name"
	@FindBy(id = "form-widgets-name")
	private WebElement inputName;

	// WebElement für das Dropdown-Menü "Kurs"
	@FindBy(id = "form-widgets-auswahl1")
	private WebElement selectKurs;

	// WebElement für das Auswahlfeld "Firma Box 1" (aus der linken Auswahlbox)
	@FindBy(id = "form-widgets-auswahl2-from")
	private WebElement selectFirmaBox1;

	// WebElement für den Button, der Firmen aus Box 1 zur Auswahl hinzufügt
	@FindBy(name = "from2toButton")
	private WebElement btnAuswahlFirmaBox1;

	// WebElement für das Auswahlfeld "Firma Box 2" (aus der rechten Auswahlbox)
	@FindBy(id = "form-widgets-auswahl2-to")
	private WebElement selectFirmaBox2;

	// WebElement für den Button, um eine Firma in Box 2 nach oben zu verschieben
	@FindBy(name = "upButton")
	private WebElement btnAuswahlObenBox2;

	// WebElement für den "Speichern"-Button
	@FindBy(name = "form.buttons.speichern")
	private WebElement btnSpeicherDokument;

	// WebElement für die Statusmeldung nach dem Absenden des Formulars
	@FindBy(id = "message")
	private WebElement StatusMeldung;

	// WebElement für das erste Element in der Liste "Firma"
	@FindBy(xpath = "//ul[@id='companies']/li[1]")
	private WebElement textErstesElementListeFirma;

	// Konstruktor für die Initialisierung der WebElemente auf dieser Seite
	public SeleniumTestForm1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente dieser Seite
	}
	
	// Methode, die die Überschrift des Formulars zurückgibt
	public String ueberschriftAuslesen() {
		return testFormHeadline.getText(); // Gibt den Text der Überschrift zurück
	}

	// Methode, um den "Betreff" in das entsprechende Eingabefeld einzugeben
	public void betreffEingeben(String betreff) {
		inputBetreff.sendKeys(betreff); // Gebt den Betreff in das Eingabefeld ein
	}

	// Methode, um den Namen in das entsprechende Eingabefeld einzugeben
	public void nameEingeben(String name) {
		inputName.sendKeys(name); // Gebt den Namen in das Eingabefeld ein
	}

	// Methode, um einen Kurs aus der Dropdown-Liste auszuwählen
	public void kursAuswaehlen(String kursName) {
		Select selectKurs = new Select(this.selectKurs); // Erzeugt ein Select-Objekt für das Dropdown-Menü
		selectKurs.selectByVisibleText(kursName); // Wählt den Kurs anhand des sichtbaren Textes aus
	}

	// Methode, um Firmen aus Box 1 auszuwählen (über Indexe)
	public void firmaInBox1Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox1); // Erzeugt ein Select-Objekt für Box 1
		for (int i : auswahl) {
			selectFirma.selectByIndex(i); // Wählt jedes Element in Box 1 aus, basierend auf den Indexen
		}
	}

	// Methode, um die ausgewählten Firmen von Box 1 in Box 2 zu übertragen
	public void firmenUerbernehmen() {
		btnAuswahlFirmaBox1.click(); // Klickt auf den Button, um die Firmen zu übernehmen
	}

	// Methode, um Firmen aus Box 2 auszuwählen (über Indexe)
	public void firmaInBox2Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox2); // Erzeugt ein Select-Objekt für Box 2
		for (int i : auswahl) {
			selectFirma.selectByIndex(i); // Wählt jedes Element in Box 2 aus, basierend auf den Indexen
		}
	}

	// Methode, um die ausgewählten Firmen in Box 2 nach oben zu verschieben
	public void ausgewählteFirmenNachObenVerschieben() {
		btnAuswahlObenBox2.click(); // Klickt auf den Button, um die ausgewählten Firmen nach oben zu verschieben
	}

	// Methode, um das Formular zu speichern
	public void formularSpeichern() {
		btnSpeicherDokument.click(); // Klickt auf den Button, um das Formular zu speichern
	}

	// Methode, die die Statusmeldung nach dem Speichern des Formulars zurückgibt
	public String statusMeldungAuslesen() {
		return StatusMeldung.getText(); // Gibt den Text der Statusmeldung zurück
	}

	// Methode, die das erste Element der Liste der Firmen zurückgibt
	public String erstesListenElementAuslesen() {
		return textErstesElementListeFirma.getText(); // Gibt den Text des ersten Elements in der Liste der Firmen zurück
	}
}
