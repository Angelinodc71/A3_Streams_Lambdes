package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("1=Titol\n2=Direccio\n3=Any\n4=Estrenada");
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




}
