/**
 * JamendoV3API Java package library
 * Copyright (C) 2013  Javier Rueda
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 */
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
