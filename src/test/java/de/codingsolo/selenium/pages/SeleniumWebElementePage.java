package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumWebElementePage {
	
	private WebDriver driver;
	
	// WebElements für die Checkboxen
	@FindBy(id = "checkBoxOption1")
	private WebElement checkBox1;
	
	@FindBy(id = "checkBoxOption2")
	private WebElement checkBox2;
	
	@FindBy(id = "checkBoxOption3")
	private WebElement checkBox3;
	
	// WebElements für die Radio-Buttons
	@FindBy(css = "input[value='radio1']")
	private WebElement redio1Btn;
	
	@FindBy(css = "input[value='radio2']")
	private WebElement redio2Btn;
	
	@FindBy(css = "input[value='radio3']")
	private WebElement redio3Btn;

	// Konstruktor zur Initialisierung der WebElemente
	public SeleniumWebElementePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialisiert alle WebElemente auf dieser Seite
	}
	
	// Methode, um die erste Checkbox anzuklicken
	public void checkBox1Anklicken() {
		checkBox1.click(); // Klickt auf die erste Checkbox
	}
	
	// Methode, um die zweite Checkbox anzuklicken
	public void checkBox2Anklicken() {
		checkBox2.click(); // Klickt auf die zweite Checkbox
	}
	
	// Methode, um die dritte Checkbox anzuklicken
	public void checkBox3Anklicken() {
		checkBox3.click(); // Klickt auf die dritte Checkbox
	}
	
	// Methode, um den Status der ersten Checkbox auszulesen (ob sie ausgewählt ist)
	public boolean checkBox1StatusAuslesen() {
		return checkBox1.isSelected(); // Gibt zurück, ob die erste Checkbox ausgewählt ist
	}
	
	// Methode, um den Status der zweiten Checkbox auszulesen (ob sie ausgewählt ist)
	public boolean checkBox2StatusAuslesen() {
		return checkBox2.isSelected(); // Gibt zurück, ob die zweite Checkbox ausgewählt ist
	}
	
	// Methode, um den Status der dritten Checkbox auszulesen (ob sie ausgewählt ist)
	public boolean checkBox3StatusAuslesen() {
		return checkBox3.isSelected(); // Gibt zurück, ob die dritte Checkbox ausgewählt ist
	}

	// Methode, um den ersten Radio-Button anzuklicken
	public void radioButton1Anklicken() {
		redio1Btn.click(); // Klickt auf den ersten Radio-Button
	}
	
	// Methode, um den zweiten Radio-Button anzuklicken
	public void radioButton2Anklicken() {
		redio2Btn.click(); // Klickt auf den zweiten Radio-Button
	}
	
	// Methode, um den dritten Radio-Button anzuklicken
	public void radioButton3Anklicken() {
		redio3Btn.click(); // Klickt auf den dritten Radio-Button
	}
	
	// Methode, um das Attribut eines Radio-Buttons auszulesen (z.B. "value", "checked", etc.)
	public String radioButton1getAttribute(String attributname) {
		return redio1Btn.getAttribute(attributname); // Gibt das Attribut des ersten Radio-Buttons zurück
	}
	
	// Methode, um das Attribut des zweiten Radio-Buttons auszulesen
	public String radioButton2getAttribute(String attributname) {
		return redio2Btn.getAttribute(attributname); // Gibt das Attribut des zweiten Radio-Buttons zurück
	}
	
	// Methode, um das Attribut des dritten Radio-Buttons auszulesen
	public String radioButton3getAttribute(String attributname) {
		return redio3Btn.getAttribute(attributname); // Gibt das Attribut des dritten Radio-Buttons zurück
	}
}
