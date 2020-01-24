package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
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
        //Por la palabra que yo elijo me busca si la contiene algun titulo del xml
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
        //Ordena por el parametro que yo elija
        System.out.println("OPCIO 1 --> Titol\nOPCIO 2 --> Direccio\nOPCIO 3 --> Any\nOPCIO 4 --> Estrenada");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                films.stream()
                        .sorted(Comparator.comparing(Film::getTitol))
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            case 2:
                films.stream()
                        .sorted(Comparator.comparing(Film::getDireccio))
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            case 3:
                films.stream()
                        .sorted(Comparator.comparing(Film::getAny))
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            case 4:
                films.stream()
                        .sorted(Comparator.comparing(Film::getEstrena))
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
        }
    }

    void consulta5(){
        // Te agrupa todas las peliculas y por cada año las agrupa y las cuenta
        Map<String, List<Film>> resul = films.stream()
                .collect(Collectors.groupingBy(Film::getAny));
        resul.forEach((k,v) -> System.out.println("En el "+k+" hi havien "+v.size()+" pel·licules"));
    }
    void consulta6(){
        //Sacar el minimo y el maximo de un año
        System.out.println("L'any mínim és:");
        String minAny = String.valueOf(films.stream()
                .min(Comparator.comparing(Film::getAny))
                .get());
        System.out.println(minAny);
        System.out.println("L'any màxim és:");
        String maxAny = String.valueOf(films.stream()
                .max(Comparator.comparing(Film::getAny))
                .get());
        System.out.println(maxAny);
    }
}
