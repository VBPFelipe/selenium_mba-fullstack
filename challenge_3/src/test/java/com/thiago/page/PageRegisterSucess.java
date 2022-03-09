package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageRegisterSucess extends CorePage<PageRegisterSucess>{

	public PageRegisterSucess() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[3]/td[1]/p[1]/font[1]/b[1]")
	private WebElement labelSucessUserName;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")
	private WebElement labelNote;

	public void validaRegistro(String message){
		aguardarElementoVisivel(labelSucessUserName);
//		Assert.assertEquals(getTextElement(labelNote), "Note: Your user name is 2021232010017@iesp.edu.br.");
		Assert.assertEquals(getTextElement(labelNote), message);
//		Assert.assertTrue(getTextElement(labelNote).contains("Note: Your user name is"));
	}
}
