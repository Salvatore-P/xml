package com.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerSax extends DefaultHandler {

    int cptTags = 0;

    // Quelques méthodes du ContentHandler
    public void characters(char[] ch, int start, int length) throws SAXException {
        /*String chaine = new String(ch, start, length).trim();
        if (chaine.length() > 0) {
            System.out.println("@ Caractères : " + chaine);
        }*/
    }

    public void startDocument() throws SAXException {
        System.out.println("** Début du document **");
    }

    public void endDocument() throws SAXException {
        System.out.println(this.toString());
        System.out.println("** Fin du document **");
    }

    public void startElement(java.lang.String uri, java.lang.String localName, java.lang.String qName, Attributes attr) throws SAXException {
       /* System.out.println("* Début d'un élément");
        cptTags++;
        System.out.println("++ compteur de tags : " + cptTags);
        if (uri != null && uri.length() > 0) {
            System.out.println(" uri : " + uri);
        }
        System.out.println(" nom complet : " + qName);
        if (uri != null && uri.length() > 0) {
            System.out.println(" nom complet : " + qName);
        }
        int nAttr = attr.getLength();
        System.out.println(" nombre d'attributs :" + nAttr);
        if (nAttr == 0) {
            return;
        }
        for (int i = 0; i < nAttr; i++) {
            System.out.println(" attribut n°" + i + " = " + attr.getLocalName(i) + " avec valeur : " + attr.getValue(i));
        }*/
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

