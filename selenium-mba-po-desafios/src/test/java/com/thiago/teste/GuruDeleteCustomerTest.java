package com.thiago.teste;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGuruDeleteCustomer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(InvokedMethodListener.class)
public class GuruDeleteCustomerTest {

    @Test
    public void guruDeleteCustomerTest() throws Exception{
        new PageGuruDeleteCustomer()
                .openPage(PageGuruDeleteCustomer.class, "https://demo.guru99.com/test/delete_customer.php")
                .guruDeleteCustomer("automação");
    }
}
