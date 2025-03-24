package de.codingsolo.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {
    
    // Logger-Instanz zur Protokollierung von Testereignissen
    private static final Logger logger = LogManager.getLogger("Selenium Test Pages");

    // Wird vor dem Akzeptieren eines Alarms aufgerufen
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        
    }

    // Wird nach dem Akzeptieren eines Alarms aufgerufen
    @Override
    public void afterAlertAccept(WebDriver driver) {
       
    }

    // Wird nach dem Ablehnen eines Alarms aufgerufen
    @Override
    public void afterAlertDismiss(WebDriver driver) {
       
    }

    // Wird vor dem Ablehnen eines Alarms aufgerufen
    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        
    }

    // Wird aufgerufen, bevor zu einer neuen URL navigiert wird
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
       
    }

    // Wird aufgerufen, nachdem zu einer neuen URL navigiert wurde
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
       
    }

    // Wird vor dem Zurück-Navigieren im Browser-Verlauf aufgerufen
    @Override
    public void beforeNavigateBack(WebDriver driver) {
        
    }

    // Wird nach dem Zurück-Navigieren im Browser-Verlauf aufgerufen
    @Override
    public void afterNavigateBack(WebDriver driver) {
        
    }

    // Wird vor dem Vorwärts-Navigieren im Browser-Verlauf aufgerufen
    @Override
    public void beforeNavigateForward(WebDriver driver) {
       
    }

    // Wird nach dem Vorwärts-Navigieren im Browser-Verlauf aufgerufen
    @Override
    public void afterNavigateForward(WebDriver driver) {
       
    }

    // Wird aufgerufen, bevor die Seite neu geladen wird
    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        
    }

    // Wird aufgerufen, nachdem die Seite neu geladen wurde
    @Override
    public void afterNavigateRefresh(WebDriver driver) {
       
    }

    // Wird vor der Suche nach einem WebElement aufgerufen
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        
    }

    // Wird nach der Suche nach einem WebElement aufgerufen
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
       logger.info("Webelement {} wurde gefunden. ", element.toString());
    }

    // Wird vor dem Klicken auf ein WebElement aufgerufen
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        
    }

    // Wird nach dem Klicken auf ein WebElement aufgerufen
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
    	logger.info("Das Element {} wurde angeklickt. ", element.toString());
    }

    // Wird vor einer Wertänderung eines WebElements aufgerufen
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        
    }

    // Wird nach einer Wertänderung eines WebElements aufgerufen(.sendkeys-Funktionen)
    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Der Wert {} wurde an das Element {} gesendet. ", keysToSend, element.toString());
    }

    // Wird vor der Ausführung eines JavaScript-Skripts aufgerufen
    @Override
    public void beforeScript(String script, WebDriver driver) {
        
    }

    // Wird nach der Ausführung eines JavaScript-Skripts aufgerufen
    @Override
    public void afterScript(String script, WebDriver driver) {
       
    }

    // Wird aufgerufen, bevor zu einem anderen Fenster gewechselt wird
    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        
    }

    // Wird aufgerufen, nachdem zu einem anderen Fenster gewechselt wurde
    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        
    }

    // Wird aufgerufen, wenn eine Ausnahme im WebDriver auftritt
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        
    }

    // Wird vor der Erstellung eines Screenshots aufgerufen
    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
      
    }

    // Wird nach der Erstellung eines Screenshots aufgerufen
    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
       
    }

    // Wird aufgerufen, bevor der Text eines WebElements abgerufen wird
    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        // Noch nicht implementiert
    }

    // Wird aufgerufen, nachdem der Text eines WebElements abgerufen wurde
    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // Noch nicht implementiert
    }
}