package com.Xml;

public class Main {

    public static void main(String[] args) {
        String racine = "..\\Fichier\\";
        String fileXmlDtd = racine + "XML_ModifierDTD.xml";
        String fileXmlXsd = racine + "XML_ModifierXSD.xml";

        SaxValidation sv = new SaxValidation(fileXmlDtd,"InfosXSD.xsd");
        sv.DtdValidation();
        System.out.println("FIN DTD");
        sv.XsdValidation();

	// write your code here
    }
}
