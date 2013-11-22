package com.javirueda.JamendoV3Api;

import org.junit.BeforeClass;

import java.lang.reflect.Method;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class JamendoRadiosListTest {
    public static JamendoRadiosList jrl;

    @BeforeClass
    public static void beforeClass()
    {
        jrl = new JamendoRadiosList("b6747d04"); // Using provided Jamendo Test Client ID
    }

    @org.junit.Test
    public void testConnectToRadiosListServer() throws Exception {
        assertTrue(jrl.connectToRadiosListServer());
    }

    @org.junit.Test
    public void testGenerateRequestURL() throws Exception {
        // generateRequestURL method is private, so we are going to use Reflection.
        Method method = JamendoRadiosList.class.getDeclaredMethod("generateRequestURL", String.class);
        method.setAccessible(true);
        assertEquals("http://api.jamendo.com/v3.0/radios/?client_id=b6747d04&format=xml", method.invoke(jrl, "b6747d04"));
    }
}
