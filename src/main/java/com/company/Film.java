package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
@XmlRootElement(name = "dataroot")
@XmlAccessorType(XmlAccessType.PROPERTY)

class Films {
    @XmlElement(name = "FILM")
    public List<Film> films;

    @Override
    public String toString() {
        return "Films{" +
                "films=" + films +
                '}';
    }
}
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "IDFILM")
    String idfilm;
    @XmlElement(name = "PRIORITAT")
    String prioritat;
    @XmlElement(name = "TITOL")
    String titol;
    @XmlElement(name = "SITUACIO")
    String situacio;
    @XmlElement(name = "ANY")
    String any;
    @XmlElement(name = "CARTELL")
    String cartell;

    public String getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(String idfilm) {
        this.idfilm = idfilm;
    }

    public String getPrioritat() {
        return prioritat;
    }

    public void setPrioritat(String prioritat) {
        this.prioritat = prioritat;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getSituacio() {
        return situacio;
    }

    public void setSituacio(String situacio) {
        this.situacio = situacio;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
    }

    public String getCartell() {
        return cartell;
    }

    public void setCartell(String cartell) {
        this.cartell = cartell;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getInterprets() {
        return interprets;
    }

    public void setInterprets(String interprets) {
        this.interprets = interprets;
    }

    public String getSinopsi() {
        return sinopsi;
    }

    public void setSinopsi(String sinopsi) {
        this.sinopsi = sinopsi;
    }

    public String getVersio() {
        return versio;
    }

    public void setVersio(String versio) {
        this.versio = versio;
    }

    public String getIdioma_x0020_original() {
        return idioma_x0020_original;
    }

    public void setIdioma_x0020_original(String idioma_x0020_original) {
        this.idioma_x0020_original = idioma_x0020_original;
    }

    public String getQualificacio() {
        return qualificacio;
    }

    public void setQualificacio(String qualificacio) {
        this.qualificacio = qualificacio;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEstrena() {
        return estrena;
    }

    public void setEstrena(String estrena) {
        this.estrena = estrena;
    }

    @XmlElement(name = "ORIGINAL")
    String original;
    @XmlElement(name = "DIRECCIO")
    String direccio;
    @XmlElement(name = "INTERPRETS")
    String interprets;
    @XmlElement(name = "SINOPSI")
    String sinopsi;
    @XmlElement(name = "VERSIO")
    String versio;
    @XmlElement(name = "IDIOMA_x0020_ORIGINAL")
    String idioma_x0020_original;
    @XmlElement(name = "QUALIFICACIO")
    String qualificacio;
    @XmlElement(name = "TRAILER")
    String trailer;
    @XmlElement(name = "WEB")
    String web;
    @XmlElement(name = "ESTRENA")
    String estrena;

    public Film() {
        super();
    }

    @Override
    public String toString() {
        return "Film{" + "\n" +
                "idfilm='" + idfilm + '\'' +
                ", prioritat='" + prioritat + '\'' +
                ", titol='" + titol + '\'' +
                ", situacio='" + situacio + '\'' +
                ", any='" + any + '\'' +
                ", cartell='" + cartell + '\'' +
                ", original='" + original + '\'' +
                ", direccio='" + direccio + '\'' +
                ", interprets='" + interprets + '\'' +
                ", sinopsi='" + sinopsi + '\'' +
                ", versio='" + versio + '\'' +
                ", idioma_x0020_original='" + idioma_x0020_original + '\'' +
                ", qualificacio='" + qualificacio + '\'' +
                ", trailer='" + trailer + '\'' +
                ", web='" + web + '\'' +
                ", estrena='" + estrena + '\'' +
                '}';
    }
}
