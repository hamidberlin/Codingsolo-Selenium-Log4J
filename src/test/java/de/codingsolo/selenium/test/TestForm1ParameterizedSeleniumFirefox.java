package de.codingsolo.selenium.test;

// Importiert benötigte JUnit- und Selenium-Bibliotheken
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import de.codingsolo.selenium.configuration.Config;
import de.codingsolo.selenium.configuration.DriverHelper;
import de.codingsolo.selenium.pages.*;

// Aktiviert parametrisierten Testlauf mit JUnit
@RunWith(Parameterized.class)
public class TestForm1ParameterizedSeleniumFirefox {
	
	private static final Logger logger = LogManager
			.getLogger(TestForm1ParameterizedSeleniumFirefox.class.getName());

    // WebDriver-Instanz für den Browser
    WebDriver driver;

    // Testparameter
    String browsername;
    String username;
    String userpassword;
    String betreff;
    String name;
    String kursTitel;
    int[] firmenBox1;
    int[] firmenBox2;
    String assert1;
    String assert2;

    // Konstruktor für die Testparameter
    public TestForm1ParameterizedSeleniumFirefox(String testName, String browsername, String username, String userpassword, String betreff, String name,
                                                 String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {
        this.browsername = browsername;
//        this.browserdriver = browserdriver;
        this.username = username;
        this.userpassword = userpassword;
        this.betreff = betreff;
        this.name = name;
        this.kursTitel = kursTitel;
        this.firmenBox1 = firmenBox1;
        this.firmenBox2 = firmenBox2;
        this.assert1 = assert1;
        this.assert2 = assert2;
    }

    /**
     * Initialisiert den WebDriver und öffnet die Testseite.
     */
    @Before
    public void setUp() throws Exception {
    	logger.info("Initialisiere Webdriver");
        driver = DriverHelper.getDriver(browsername);
        driver.manage().window().maximize();
        driver.get(Config.getBasURL());
    }

    /**
     * Schließt den WebDriver nach dem Test.
     */
    @After
    public void tearDown() throws Exception {
    	logger.info("Test abgeschlossen- ich raume");
    	takeScreenshot(driver);
        driver.quit();
    }

    /**
     * Testfall: Formular ausfüllen und abschicken
     */
    @Test
    public void testForm1() {
    	logger.info("Starte TestForm1 Testseite");

        // Login
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        loginPage.zugangsdatenEingeben(username, userpassword);
        loginPage.loginButtonAnklicken();
        logger.info("Login war erfolgreich");

        // Navigation zur Formularseite
        SeleniumHomePage homePage = new SeleniumHomePage(driver);
        homePage.btnMenuAusklappen();
        homePage.seleniumTestLinkAnklicken();
        
        SeleniumTestApplikationenPage testAppPage = new SeleniumTestApplikationenPage(driver);
        testAppPage.testForm1Anklicken();
        logger.info("Navigation zum Formular");

        // Starte Formular
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);
        logger.info("Starte Eingabe Formular");
        testForm1Page.betreffEingeben(betreff);
        testForm1Page.nameEingeben(name);
        testForm1Page.kursAuswaehlen(kursTitel);
        testForm1Page.firmaInBox1Auswaehlen(firmenBox1);
        testForm1Page.firmenUerbernehmen();
        testForm1Page.firmaInBox2Auswaehlen(firmenBox2);
        testForm1Page.ausgewählteFirmenNachObenVerschieben();
        
        // Act
        // Formular speichern
        logger.info("Eingaben durchgefuehrt. Speicher das Formular");
        testForm1Page.formularSpeichern();

        // Überprüfung der Erfolgsnachricht
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        assertTrue(erfolgsMeldung.contains(assert1));

        // Überprüfung des ersten Listenelements
        String erstesElement = testForm1Page.erstesListenElementAuslesen();
        assertEquals(erstesElement, assert2);
    }

    /**
     * Parameterdaten für den Testlauf bereitstellen
     */
    @Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

		Object[][] daten = { { "Test Form 1 Test 1 FireFox", "firefox", "selenium102", "codingsolo",
				"Parametrisierter Test 1", "Dieter", "Java Grundlagen Kurs mit Dieter", new int[] { 2, 4, 6 },
				new int[] { 2 }, "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" } };

		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}
	
	private void takeScreenshot(WebDriver driver) {
		
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Path srcPath = srcFile.toPath();
			Path targetPath = new File("scrennshot_testform1.png").toPath();
			Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}