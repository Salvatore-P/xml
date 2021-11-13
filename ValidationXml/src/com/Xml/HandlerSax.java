package com.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class HandlerSax extends DefaultHandler {

    int cptTags = 0;
    int certification, title, noteaverage ;
    List<Film> LFilm = new ArrayList<Film>();
    Film tmp;

    // Quelques méthodes du ContentHandler
    public void characters(char[] ch, int start, int length) throws SAXException {

        String chaine = new String(ch, start, length).trim();


        if(certification == 1){

            if(chaine.equals("PG-13")){

                cptTags++;

            }

        } else if(title == 1){
            if(chaine.equals("") == false)
                tmp.setTitle(chaine);

        }else if(noteaverage == 1){

            if(chaine.equals("") == false) {
                tmp.setNoteMoyenne(Double.parseDouble(chaine));
                LFilm.add(tmp);
            }
        }
    }

    public void startDocument() throws SAXException {
        //System.out.println("** Début du document **");
    }

    public void endDocument() throws SAXException {
        //System.out.println("** Fin du document **");

        Comparator<Film> compareByVote = new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {

                Double d1 = o1.getNoteMoyenne(), d2 = o2.getNoteMoyenne();

                if(d1 < d2) return -1;
                else if(d1>d2) return 1;
                else return 0;

            }
        };

        Collections.sort(LFilm, compareByVote);

        System.out.println("Nombre de film PG-13 : " + cptTags);
        System.out.println("Les 10 films avec la meilleure moyenne : ");
        for(int i= 1; i<11; i++)
            System.out.println(i +  " " + LFilm.get(LFilm.size() - i).getTitle() + " " + LFilm.get(LFilm.size() - i).getNoteMoyenne().toString());
    }

    public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, Attributes attr) throws SAXException {

        certification = 0;
        title = 0;
        noteaverage = 0;


        if (uri != null && uri.length() > 0) {
        }

        if(qName.equals("Certification")){

            certification = 1;
        }
        else if(qName.equals("Titre")){

            tmp = new Film();
            title = 1;

        }
        else if(qName.equals("Note")){

            noteaverage = 1;

        }

        if (uri != null && uri.length() > 0) {
        }
        int nAttr = attr.getLength();
        if (nAttr == 0) {
            return;
        }
        for (int i = 0; i < nAttr; i++) {
         }
    }

    public void endElement(java.lang.String uri, java.lang.String localName, java.lang.String qName) throws SAXException {
        /*System.out.println("* Fin de l'élément " + localName);
        cptTags++;
        System.out.println("++ compteur de tags : " + cptTags);*/
    }

    //Et d'autres du error handler
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("WARNING : " + e.getMessage()); // do nothing
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("ERROR : " + e.getMessage());
        System.out.println("Ligne : " + e.getLineNumber());
        throw e;
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("FATAL : " + e.getMessage());
        System.out.println("Ligne : " + e.getLineNumber());
        throw e;
    }
}

