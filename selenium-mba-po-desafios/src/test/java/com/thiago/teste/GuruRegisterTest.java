package com.thiago.teste;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGuruHome;
import com.thiago.page.PageRegister;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Locale;

@Listeners(InvokedMethodListener.class)
public class GuruRegisterTest {
 
    @Test
    public void validarRegistroConta() throws Exception {
		new PageRegister().openPage(PageRegister.class, "https://demo.guru99.com/test/newtours/register.php")
				.preencherFormulario("Felipe", "Pinheiro", "2021232010017@iesp.edu.br", "Brazil".toUpperCase(Locale.ROOT))
                .validaRegistro("Note: Your user name is 2021232010017@iesp.edu.br.");
    }
}