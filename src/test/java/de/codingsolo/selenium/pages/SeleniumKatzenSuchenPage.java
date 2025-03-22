package de.codingsolo.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKatzenSuchenPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@FindBy(css = "p.lead")
	private WebElement textParagraph;
	
	@FindBy(id = "ECqe13G5B")
	private WebElement imageCat1;
	
	
	@FindBy(id = "S97Qj5YYO")
	private WebElement imgCat2;
	
	@FindBy(id = "0c9_EEtqQ")
	private WebElement imgCat3;
	
	@FindBy(id = "h6")
	private WebElement imgCat4;
	
	@FindBy(linkText = "Next")
	private WebElement linkNext;
	
	@FindBy(linkText = "Previous")
	private WebElement linkPrevious;
	
	@FindBy(id = "anzahlSelect")
	private WebElement selectAnzahlKatzen;
	
	@FindBy(linkText = "Katzensuche Testseite (AJAX)")
	private WebElement linkWebElementKatzensuche;
	
	@FindBy(id = "sortSelect")
	private WebElement selectSort;

	public SeleniumKatzenSuchenPage(WebDriver driver) {
		this.driver = driver;
		 
		PageFactory.initElements(driver, this);
	}
	
	public String beschreibungAuslesen() {
		return textParagraph.getText();
	}
	
	public String srcLinkImgKatze1Aus() {
		return imageCat1.getAttribute("src");
	}
	
	public String srcLinkImgKatze2Aus() {
		return imgCat2.getAttribute("src");
	}
	
	public String srcLinkImgKatze3Aus() {
		return imgCat3.getAttribute("src");
	}
	
	public String srcLinkImgKatze4Aus() {
		wait.until(ExpectedConditions.elementToBeClickable(imgCat4));
		return imgCat4.getAttribute("src");
	}
	
	public void linkNextAnklicken() {
		linkNext.click();
	}
	
	public void linkPreviousAnklicken() {
		linkPrevious.click();
	}

	public void anzahlImgEingeben(String anzahlValue) {
		Select anzahl = new Select(selectAnzahlKatzen);
		anzahl.selectByVisibleText(anzahlValue);
	}
	
	public void sortEingeben(String sortValue) {
		Select sort = new Select(selectSort);
		sort.selectByValue(sortValue);
	}

}
