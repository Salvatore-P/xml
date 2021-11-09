package com.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Arrays;
import java.util.Comparator;

public class HandlerSax extends DefaultHandler {

    int cptTags = 0;
    int certification ;

    // Quelques méthodes du ContentHandler
    public void characters(char[] ch, int start, int length) throws SAXException {

        String chaine = new String(ch, start, length).trim();

        if(certification == 1){

            if(chaine.equals("PG-13")){

                cptTags++;

            }

        }

    }

    public void startDocument() throws SAXException {
        //System.out.println("** Début du document **");
    }

    public void endDocument() throws SAXException {
        //System.out.println("** Fin du document **");

        System.out.println("Nombre de film PG-13 : " + cptTags);
    }

    public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, Attributes attr) throws SAXException {

        certification = 0;

        if (uri != null && uri.length() > 0) {
        }

        if(qName.equals("Certification")){

            certification = 1;
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

