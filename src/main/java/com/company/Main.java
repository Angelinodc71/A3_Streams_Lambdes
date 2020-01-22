package com.company;

import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        Scanner sc = new Scanner(System.in);
        ReaderXML readerXML = new ReaderXML();
        readerXML.metodo();
        System.out.println("OPCIO 1: Per quin camp volem buscar, títol, director, any, etc.");
        System.out.println("OPCIO 2: Que doni la opció de saber quantes pel·lícules d’una determinada llengua hi han en un any");
        System.out.println("OPCIO 3: Quants títols una determinada paraula hi apareix. ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                readerXML.consulta1();
                break;
            case 2:
                readerXML.consulta2();
                break;
            case 3:
                readerXML.consulta3();
                break;
            case 4:
                readerXML.consulta4();
                break;
            case 5:
                readerXML.consulta5();
                break;
            case 6:

                break;
            case 7:

                break;
        }
    }
}
