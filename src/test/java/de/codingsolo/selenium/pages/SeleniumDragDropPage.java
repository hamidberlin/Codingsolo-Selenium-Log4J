package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDragDropPage {

    WebDriver driver;

    // Elemente, die auf der Drag-and-Drop-Seite verwendet werden
    @FindBy(id = "white-logo")
    private WebElement drgLogoWhite;

    @FindBy(id = "blue-logo")
    private WebElement drgLogoBlue;

    @FindBy(id = "red-logo")
    private WebElement drgLogoRed;

    @FindBy(id = "green-logo")
    private WebElement drgLogoGreen;

    @FindBy(id = "coding-logo")
    private WebElement drgCodeLogo;

    @FindBy(id = "droppable")
    private WebElement dropBox;

    @FindBy(css ="#droppable > p")
    private WebElement textStatusMessage;

    // Konstruktor initialisiert die WebElemente der Seite
    public SeleniumDragDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialisierung der Webelemente
    }

    // Standard Drag-and-Drop von allen Logos in die Drop-Box
    public void moveAllLogosToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoWhite, dropBox).build().perform();
        actions.dragAndDrop(drgLogoRed, dropBox).build().perform();
        actions.dragAndDrop(drgLogoBlue, dropBox).build().perform();
        actions.dragAndDrop(drgLogoGreen, dropBox).build().perform();
        actions.dragAndDrop(drgCodeLogo, dropBox).build().perform();
    }

    // Drag-and-Drop für jedes Logo einzeln
    public void moveWhiteLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoWhite, dropBox).build().perform();
    }

    public void moveRedLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoRed, dropBox).build().perform();
    }

    public void moveBlueLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoBlue, dropBox).build().perform();
    }

    public void moveGreenLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoGreen, dropBox).build().perform();
    }

    // Drag-and-Drop per Offset (manuelle Bewegung)
    public void moveWhiteLogoToPoint(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoWhite, x, y).build().perform();
    }

    public void moveBlueLogoToPoint(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoBlue, x, y).build().perform();
    }

    public void moveRedLogoToPoint(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoRed, x, y).build().perform();
    }

    public void moveGreenLogoToPoint(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoGreen, x, y).build().perform();
    }

    // Manuelles Drag-and-Drop, bei dem das Logo mit gedrückter Maustaste verschoben wird
    public void moveWhiteLogoToBoxManuell() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoWhite).perform();
        actions.moveByOffset(250, 0).perform(); // Logo in die Box bewegen
        actions.release(drgLogoWhite).perform(); // Logo ablegen
    }

    public void moveBlueLogoToBoxManuell() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoBlue).perform();
        actions.moveByOffset(250, 0).perform();
        actions.release(drgLogoBlue).perform();
    }

    public void moveRedLogoToBoxManuell() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoRed).perform();
        actions.moveByOffset(250, 0).perform();
        actions.release(drgLogoRed).perform();
    }

    public void moveGreenLogoToBoxManuell() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoGreen).perform();
        actions.moveByOffset(250, 0).perform();
        actions.release(drgLogoGreen).perform();
    }

    // Gibt die Statusnachricht auf der Seite zurück
    public String printStatusMessage() {
        return textStatusMessage.getText();
    }
}
