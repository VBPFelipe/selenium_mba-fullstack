package com.thiago.teste;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.PageGuruDrag;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(InvokedMethodListener.class)
public class GuruDragTest {

    @Test
    public void guruDragTest() throws Exception{
        new PageGuruDrag()
                .openPage(PageGuruDrag.class, "https://demo.guru99.com/test/drag_drop.html")
                .guruDrag();
    }
}
