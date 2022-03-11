package com.thiago.page;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageGuruDeleteCustomer extends CorePage<PageGuruDeleteCustomer> {

    public PageGuruDeleteCustomer(){
        this.driver = TLDriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input")
    private WebElement customerId;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
    private WebElement submit;

    public void guruDeleteCustomer(String element){
        aguardarElementoVisivel(customerId);
        preencherCampo(customerId, element);
        aguardarElementoClicado(submit);
        click(submit);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String alertMessage= driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Customer Successfully Delete!");
        alert.accept();
    }
}
