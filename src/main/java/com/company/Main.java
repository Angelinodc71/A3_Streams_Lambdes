package com.company;

import javax.xml.bind.JAXBException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        ReaderXML readerXML = new ReaderXML();
        readerXML.metodo();
        readerXML.consulta1();
    }
}
