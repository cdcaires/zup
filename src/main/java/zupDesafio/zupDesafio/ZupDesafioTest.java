package zupDesafio.zupDesafio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZupDesafioTest {

	ChromeOptions options;

	WebDriver driver;

	String appUrl;

	@BeforeTest
	public void setUpTest() {

		// Driver e configurações
		options = new ChromeOptions();

		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// instância do Driver
		driver = new ChromeDriver(options);

		// página a ser acessada, URL
		appUrl = "https://www.amazon.com.br/";

	}

	@Test(description = "Teste Desafio Zup")
	public void zupDesafio() {

		// acessar a URL com o Driver
		driver.get(appUrl);
		// Maximixar a janela
		driver.manage().window().maximize();

		String expectedTitle = "Amazon.com.br | Compre livros, informática, Tvs, Casa & Cozinha, Kindle, Echo e Fire TV";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);

		// Mapear os elementos da tela, fazer a limpeza no campo e preencher
		WebElement search_bar = driver.findElement(By.id("twotabsearchtextbox"));
		search_bar.clear();
		search_bar.sendKeys("Silmarillion");
		search_bar.submit();
				
		WebElement check_search = driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > h2 > a > span"));
		System.out.println(check_search.getText());
		Assert.assertEquals(check_search.getText(), "O Silmarillion");			
		
		WebElement livro = driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-24.sg-col-4-of-12.sg-col-4-of-36.sg-col-4-of-28.sg-col-4-of-16.sg-col.sg-col-4-of-20.sg-col-4-of-32 > div > div > span > a"));
		livro.click();		

		WebElement btn_add_cart = driver.findElement(By.id("add-to-cart-button"));
		btn_add_cart.click();
		
		WebElement check_cart = driver.findElement(By.cssSelector("#huc-v2-order-row-confirm-text > h1"));
		System.out.println(check_cart.getText());
		Assert.assertEquals(check_cart.getText(), "Adicionado ao carrinho");		
		
	}

	@AfterTest
	public void tearDownTest() {

		// fechar o driver
		driver.close();
		System.out.println("Teste script executado com Sucesso!");
		// sair do sistema
		System.exit(0);

	}

}
