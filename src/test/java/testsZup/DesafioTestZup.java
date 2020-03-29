package testsZup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryZup.BrowserZup;
import pagesZup.PortalPage;

public class DesafioTestZup {

	WebDriver driver;
	PortalPage page;

	@BeforeTest
	public void launchBrowser() {

		driver = BrowserZup.StartBrowser("https://www.amazon.com.br/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page = new PortalPage(driver);
	}

	@Test(description = "Teste Desafio Zup Silmarillion")
	public void zupDesafioSilmarillion() {

		// realizar a busca do livro
		page.searchBook("Silmarillion");
		page.checkBook("O Silmarillion");
		page.selectBook();
		page.addBook();
		page.checkCart("Adicionado ao carrinho");

	}

	@Test(description = "Teste Desafio Zup Hobbit")
	public void zupDesafioHobbit() {

		// realizar a busca do livro
		page.searchBook("Hobbit");
		page.checkBook("Hobbit");
		page.selectBook();
		page.addBook();
		page.checkCart("Adicionado ao carrinho");

	}

	@Test(description = "Teste Desafio Zup Hurin")
	public void zupDesafioHurin() {

		// realizar a busca do livro
		page.searchBook("Os filhos de Húrin");
		page.checkBook("Os filhos de Húrin");
		page.selectBook();
		page.addBook();
		page.checkCart("Adicionado ao carrinho");

	}

	@Test(description = "Teste Desafio Zup Beowulf Sem Estoque")
	public void zupDesafioBeowulfSemEstoque() {

		// realizar a busca do livro
		page.searchBook("Beowulf: A Translation and Commentary, together with Sellic Spell (English Edition)");
		page.checkBook("Beowulf");
		page.selectBook();
		page.checkOneClick();

	}

	@Test(description = "Teste Desafio Zup Beowulf Sem Estoque")
	public void zupDesafioNaoEncontrado() {

		// realizar a busca do livro
		page.searchBook("marillionSil");
		page.checkWhenNotFound();

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
