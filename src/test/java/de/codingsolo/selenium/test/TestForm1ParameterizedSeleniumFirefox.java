package de.codingsolo.selenium.test;

// Importiert benötigte JUnit- und Selenium-Bibliotheken
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;

import de.codingsolo.selenium.configuration.Config;
import de.codingsolo.selenium.configuration.DriverHelper;
import de.codingsolo.selenium.configuration.EventHandler;
import de.codingsolo.selenium.pages.*;

// Aktiviert parametrisierten Testlauf mit JUnit
@RunWith(Parameterized.class)
public class TestForm1ParameterizedSeleniumFirefox {

    private static final Logger logger = LogManager.getLogger(TestForm1ParameterizedSeleniumFirefox.class.getName());

    // WebDriver-Instanz für den Browser
    private WebDriver driver;

    // Testparameter für den parametrisierten Testlauf
    private final String browsername;
    private final String username;
    private final String userpassword;
    private final String betreff;
    private final String name;
    private final String kursTitel;
    private final int[] firmenBox1;
    private final int[] firmenBox2;
    private final String assert1;
    private final String assert2;

    /**
     * Konstruktor für die Testparameter.
     * JUnit ruft diesen Konstruktor für jede Testdaten-Kombination auf.
     */
    public TestForm1ParameterizedSeleniumFirefox(String testName, String browsername, String username, String userpassword, String betreff, String name,
                                                 String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {
        this.browsername = browsername;
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
     * Initialisiert den WebDriver vor jedem Testfall.
     * Hier wird der EventFiringWebDriver registriert, um WebDriver-Events zu überwachen.
     */
    @Before
    @SuppressWarnings("deprecation") // EventFiringWebDriver ist veraltet, aber hier noch in Verwendung
    public void setUp() throws Exception {
        logger.info("Initialisiere WebDriver für Browser: " + browsername);
        driver = DriverHelper.getDriver(browsername);

        // EventFiringWebDriver wird registriert, um Ereignisse wie Klicks und Navigationen zu loggen
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        driver = eventDriver;

        // Browser-Fenster maximieren und die Basis-URL öffnen
        driver.manage().window().maximize();
        driver.get(Config.getBasURL());
    }

    /**
     * Schließt den WebDriver nach dem Testfall.
     * Macht einen Screenshot, bevor der WebDriver beendet wird.
     */
    @After
    public void tearDown() throws Exception {
        logger.info("Test abgeschlossen - Bereinigung wird durchgeführt");
        takeScreenshot(driver);
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Testfall: Formular ausfüllen und abschicken.
     * Überprüft anschließend die Erfolgsmeldung und die erwarteten Formulardaten.
     */
    @Test
    public void testForm1() {
        logger.info("Starte Test: Formular1 mit Browser: " + browsername);

        // Login-Seite öffnen und anmelden
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        loginPage.zugangsdatenEingeben(username, userpassword);
        loginPage.loginButtonAnklicken();

        // Navigation zur Formularseite
        SeleniumHomePage homePage = new SeleniumHomePage(driver);
        homePage.btnMenuAusklappen();
        homePage.seleniumTestLinkAnklicken();

        SeleniumTestApplikationenPage testAppPage = new SeleniumTestApplikationenPage(driver);
        testAppPage.testForm1Anklicken();
        logger.info("Navigiere zur Formularseite");

        // Formular ausfüllen
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);
        testForm1Page.betreffEingeben(betreff);
        testForm1Page.nameEingeben(name);
        testForm1Page.kursAuswaehlen(kursTitel);
        testForm1Page.firmaInBox1Auswaehlen(firmenBox1);
        testForm1Page.firmenUerbernehmen();
        testForm1Page.firmaInBox2Auswaehlen(firmenBox2);
        testForm1Page.ausgewählteFirmenNachObenVerschieben();

        // Formular speichern
        testForm1Page.formularSpeichern();

        // Überprüfung der Erfolgsnachricht nach Absenden des Formulars
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        assertTrue("Erfolgsmeldung enthält nicht den erwarteten Text", erfolgsMeldung.contains(assert1));

        // Überprüfung des ersten Listenelements in der Ergebnisliste
        String erstesElement = testForm1Page.erstesListenElementAuslesen();
        assertEquals("Das erste Listenelement stimmt nicht mit der erwarteten Ausgabe überein", assert2, erstesElement);
    }

    /**
     * Bereitstellung der Testdaten für den parametrisierten Testlauf.
     * JUnit führt den Test für jede Zeile der Datenmatrix aus.
     */
    @Parameters(name = "{0}")
    public static Collection<Object[]> provideTestData() throws Exception {
        return Arrays.asList(new Object[][]{
                {"Test Form 1 Test 1 FireFox", "firefox", "selenium102", "codingsolo",
                        "Parametrisierter Test 1", "Dieter", "Java Grundlagen Kurs mit Dieter",
                        new int[]{2, 4, 6}, new int[]{2}, "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti"}
        });
    }

    /**
     * Nimmt während des Tests einen Screenshot auf.
     * Speichert das Bild in das Projektverzeichnis als "screenshot_testform1.png".
     */
    private void takeScreenshot(WebDriver driver) {
        try {
            // Screenshot erstellen und als Datei speichern
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path srcPath = srcFile.toPath();
            // Zielpfad für den Screenshot im Projektordner
            Path targetPath = new File("screenshot_testform1.png").toPath();
            // Kopiere den Screenshot an das Zielverzeichnis und überschreibe ggf. existierende Dateien
            Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            logger.info("Screenshot gespeichert unter: screenshot_testform1.png");
        } catch (Exception e) {
            logger.error("Fehler beim Erstellen des Screenshots: " + e.getMessage());
        }
    }
}
