package br.com.mbaiesp.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.mbaiesp.driver.CoreDriver;


public class Aula1Selenium {

	public WebDriver driver;
	
	@Before
	public void before() {
		driver = CoreDriver.getDriver();
	}
	@After
	public void after() {
		driver = null;
		CoreDriver.resetDriver();
	}
	
	@Test
	public void teste01() {
		
		PageFactory.initElements(this.driver, this);
		driver.navigate().to("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("recursividade");
		driver.findElement(By.name("q")).submit();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"oFNiHe\"]/p/a")).getText(), "recursividade");
	}
}
