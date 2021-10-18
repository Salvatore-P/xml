package com.Xml;

public class Main {

    public static void main(String[] args) {
        String racine = "..\\Fichier\\";
        String fileXmlDtd = racine + "XML_ModifierDTD.xml";
        String fileXmlXsd = racine + "XML_ModifierXSD.xml";

        SaxValidation sv = new SaxValidation(fileXmlXsd);
	// write your code here
    }
}
