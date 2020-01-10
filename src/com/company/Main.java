package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    private static final String pathURL = "http://gencat.cat/llengua/cinema/provacin.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        URL url = new URL(pathURL);
        List<Film> films;


        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        FilmsHandler filmsHandler = new FilmsHandler();
        saxParser.parse(url.openStream(), filmsHandler);
    }
}
