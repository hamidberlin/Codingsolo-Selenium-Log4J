package de.codingsolo.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum AvailableBrowser {

	FIREFOX {
		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
			System.setProperty("webdriver.firefox.bin", "/opt/homebrew/bin/firefox");

			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("/opt/homebrew/bin/firefox");

			return new FirefoxDriver(options);
		}
	},

	CHROME {
		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
			return new ChromeDriver();
		}
	};

	public abstract WebDriver createDriver();
}
