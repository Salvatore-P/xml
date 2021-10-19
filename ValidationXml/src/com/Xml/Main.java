package com.Xml;

import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String racine = "..\\Fichier\\";
        String fileXmlDtd = racine + "XML_ModifierDTD.xml";
        String fileXmlXsd = racine + "XML_ModifierXSD.xml";
        Date Start;
        long time;

        System.out.println("Debut de validation DTD");
        Start = new Date();

        SaxValidation sv = new SaxValidation(fileXmlDtd);

        //Thread.sleep(10000);
        time = (new Date().getTime() - Start.getTime())/1000 %60;
        System.out.println("temps pour la validation avec SAX et DTD : " + time + " seconde");
        System.out.println("FIN DTD");


        System.out.println("Debut de validation XSD");
        Start = new Date();

        sv = new SaxValidation(fileXmlXsd, "InfosXSD.xsd");

        //Thread.sleep(5000);
        time = (new Date().getTime() - Start.getTime())/1000 %60;
        System.out.println("temps pour la validation avec SAX et XSD : " + time + " seconde");
        System.out.println("FIN Xsd");
    }
}
