package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ReaderXML {
    private List<Film> films;
    void metodo () throws IOException, JAXBException {
        URL url = new URL("http://gencat.cat/llengua/cinema/provacin.xml");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = http.getInputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(Films.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        this.films = ((Films)jaxbUnmarshaller.unmarshal(is)).films;
    }

    void consulta1(){
        System.out.println("OPCIO 1 --> Titol\nOPCIO 2 -->Direccio\nOPCIO 3 --> Any\nOPCIO 4 --> Estrenada");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Exemple: "+films.get((int) (Math.random()*(int) films.stream().count()-1)).titol);
                String buscar = sc.nextLine();
                films.stream()
                        .filter(c -> c.getTitol().contains(buscar))
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.println("Exemple: "+films.get((int) (Math.random()*(int) films.stream().count()-1)).direccio);
                buscar = sc.nextLine();
                films.stream()
                        .filter(c -> c.getDireccio().contains(buscar))
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.println("Exemple: "+films.get((int) (Math.random()*(int) films.stream().count()-1)).any);
                buscar = sc.nextLine();
                films.stream()
                        .filter(c -> c.getAny().contains(buscar))
                        .forEach(System.out::println);
                break;
            case 4:
                System.out.println("Exemple: "+films.get((int) (Math.random()*(int) films.stream().count()-1)).estrena);
                buscar = sc.nextLine();
                films.stream()
                        .filter(c -> c.getEstrena().contains(buscar))
                        .forEach(System.out::println);
                break;

        }

    }

    void consulta2(){
        String any = String.valueOf(2019);
        String idioma = "català";
        films.stream()
                .filter(c -> c.getAny().contains(any))
                .filter(d -> d.getIdioma_x0020_original().contains(idioma))
                .forEach(System.out::println);
        long cant = films.stream()
                .filter(c -> c.getAny().contains(any))
                .filter(d -> d.getIdioma_x0020_original().contains(idioma))
                .count();
        System.out.println();
        System.out.println("En el "+any+" hi han "+cant+" pel·licules en "+idioma);
    }

    void consulta3(){
        String paraula="l\'";
        long cant =films.stream()
                .filter(c -> c.getTitol().contains(paraula)).count();
        films.stream()
                .filter(c -> c.getTitol().contains(paraula))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Totes aquestes pelicules contenen la paraula "+"\""+paraula+"\""+" aquesta quantitat de vegades "+cant);
    }

    void consulta4(){
        System.out.println("OPCIO 1 --> Titol\nOPCIO 2 -->Direccio\nOPCIO 3 --> Any\nOPCIO 4 --> Estrenada");
        films.stream()
                .sorted(Comparator.comparing(Film::getTitol)).
                collect(Collectors.toList())
                .forEach(System.out::println);
    //poner diferentes opciones
    }

    void consulta5(){
            while (true) {
                String resul = films.stream()
                        .map(c -> c.getInterprets().equals("--")).toString();
                System.out.println(resul);
            }
        }
}
