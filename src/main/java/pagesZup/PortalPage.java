package pagesZup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PortalPage {

	// driver
	WebDriver driver;

	// locators
	By searchId = By.id("twotabsearchtextbox");
	By searchCss = By.cssSelector(
			"#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-12.sg-col-8-of-16.sg-col-16-of-24.sg-col-12-of-20.sg-col-24-of-32.sg-col.sg-col-28-of-36.sg-col-20-of-28 > div > div:nth-child(1) > div > div > div:nth-child(1) > h2 > a > span");
	By livroCss = By.cssSelector(
			"#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div > span > div > div > div:nth-child(2) > div.sg-col-4-of-24.sg-col-4-of-12.sg-col-4-of-36.sg-col-4-of-28.sg-col-4-of-16.sg-col.sg-col-4-of-20.sg-col-4-of-32 > div > div > span > a");
	By cartId = By.id("add-to-cart-button");
	By cartCss = By.cssSelector("#huc-v2-order-row-confirm-text > h1");
	// sem estoque
	By oneClickId = By.id("one-click-button");
	// livro não encontrado
	By notFoundCss = By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.sg-row > div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28 > div > span:nth-child(4) > div > span > div > div > div:nth-child(1) > span:nth-child(1)");
	
	// Constructor
	public PortalPage(WebDriver driver) {

		this.driver = driver;

	}

	// Actions and metods
	// Search Book
	public void searchBook(String bookName) {

		WebElement search_bar = driver.findElement(searchId);
		search_bar.clear();
		search_bar.sendKeys(bookName);
		search_bar.submit();

	}

	// Check book find
	public void checkBook(String bookName) {

		WebElement check_search = driver.findElement(searchCss);
		System.out.println(check_search.getText());
		Assert.assertEquals(check_search.getText().contains(bookName), true);

		// Assert.assertEquals(check_search.getText(), "O Silmarillion");

	}

	// Select book find
	public void selectBook() {

		WebElement livro = driver.findElement(livroCss);
		livro.click();

	}

	// Add book to cart
	public void addBook() {

		WebElement btn_add_cart = driver.findElement(cartId);
		btn_add_cart.click();

	}
	
	// Check book at cart
	public void checkCart(String msgCart) {

		WebElement check_cart = driver.findElement(cartCss);
		System.out.println(check_cart.getText());
		Assert.assertEquals(check_cart.getText(), msgCart);

	}

	// Check one click - sem estoque
	public boolean checkOneClick() {

		return driver.findElement(oneClickId).isEnabled();

	}
	
	// Livro não encontrado
	public boolean checkWhenNotFound() {
		
		return driver.findElement(notFoundCss).isDisplayed();
		
	}

}
