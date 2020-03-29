package libraryZup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserZup {

	static WebDriver driver;

	static ChromeOptions options;

	static String appUrl;

	public static WebDriver StartBrowser(String url) {

		// Set the path for chromedriver.exe
		//System.setProperty("webdriver.chrome.driver", "//home//totvs//Downloads//drivers//chromedriver");

		// Driver e configurações
		options = new ChromeOptions();

		// set options
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Driver instance
		driver = new ChromeDriver(options);

		driver.get(url);
		return driver;
	}

}
