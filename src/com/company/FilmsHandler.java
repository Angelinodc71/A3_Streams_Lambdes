package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FilmsHandler extends DefaultHandler {
    private boolean btitol = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("TITOL")){
            btitol = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (btitol) {
            System.out.println(new String(ch, start, length));
            btitol = false;
        }
    }
}
