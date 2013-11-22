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

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class JamendoRadiosList {
    private String clientId ="d4a1b2a8"; // TODO Asignar valor al crear instancia clase
    private HttpResponse resp = null;
    public Document doc;

    public Boolean connectToRadiosListServer() {
        HttpGet uri = new HttpGet(generateRequestURL(clientId));

        DefaultHttpClient client = new DefaultHttpClient();

        try {
            resp = client.execute(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (200==resp.getStatusLine().getStatusCode());
    }

    public void retrieveRadiosList() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(resp.getEntity().getContent());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateRequestURL(String clientID) {
        StringBuilder str = new StringBuilder();
        String firstPart = "http://api.jamendo.com/v3.0/radios/?client_id=";
        String lastPart = "&format=xml";

        str.append(firstPart);
        str.append(clientID);
        str.append(lastPart);

        return str.toString();
    }

    public JamendoRadiosList(String c_id) {
        this.clientId = c_id;
    }
}