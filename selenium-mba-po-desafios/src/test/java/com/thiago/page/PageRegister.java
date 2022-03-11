package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRegister extends CorePage<PageRegister>{

	public PageRegister() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(name="firstName")
	private WebElement inputFirstName;

	@FindBy(name="lastName")
	private WebElement inputLastName;

	@FindBy(name="phone")
	private WebElement inputPhone;

	@FindBy(name = "userName")
	private WebElement inputUserName;

	@FindBy(name = "address1")
	private WebElement inputAddress1;

	@FindBy(name = "city")
	private WebElement inputCity;

	@FindBy(name = "state")
	private WebElement inputState;

	@FindBy(name = "postalCode")
	private WebElement inputPostalCode;

	@FindBy(name = "country")
	private WebElement inputCountry;

	@FindBy(name = "email")
	private WebElement inputEmail;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(name = "confirmPassword")
	private WebElement inputConfirmPassword;

	@FindBy(name = "submit")
	private WebElement inputSubmit;

	public PageRegisterSucess preencherFormulario(String firstName, String lastName, String userName, String country){
		aguardarElementoVisivel(inputFirstName);
		preencherCampo(inputFirstName, firstName);
		preencherCampo(inputLastName, lastName);
		preencherCampo(inputPhone, "87992572808");
//		preencherCampo(inputUserName, "2021232010017@iesp.edu.br");
		preencherCampo(inputUserName, userName);
		preencherCampo(inputAddress1, "Rua Edvan Mendes de Sá 320, Loteamento Recife");
		preencherCampo(inputCity, "Petrolina");
		preencherCampo(inputState, "Pernambuco");
		preencherCampo(inputPostalCode, "56320-795");
		selectElementByVisibleValue(inputCountry, country);
		preencherCampo(inputEmail, "2021232010017@iesp.edu.br");
		preencherCampo(inputPassword, "2021232010017");
		preencherCampo(inputConfirmPassword, "2021232010017");
		click(inputSubmit);
		return new PageRegisterSucess();
	}

	public void preencherFirstName() {
		aguardarElementoVisivel(inputFirstName);
		preencherCampo(inputFirstName, "Felipe");
	}

	public void preencherLastName() {
		aguardarElementoVisivel(inputLastName);
		preencherCampo(inputLastName, "Pinheiro");
	}

}
