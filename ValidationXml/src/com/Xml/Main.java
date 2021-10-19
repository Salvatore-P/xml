package com.Xml;

public class Main {

    public static void main(String[] args) {
        String racine = "..\\Fichier\\";
        String fileXmlDtd = racine + "XML_ModifierDTD.xml";
        String fileXmlXsd = racine + "XML_ModifierXSD.xml";

        System.out.println("Debut de validation DTD");
        SaxValidation sv = new SaxValidation(fileXmlDtd);
        System.out.println("FIN DTD");
        System.out.println("Debut de validation XSD");
        sv = new SaxValidation(fileXmlXsd,"InfosXSD.xsd");
        System.out.println("FIN Xsd");
    }
}
