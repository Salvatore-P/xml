package com.Xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SaxValidation {

    SaxValidation(String FileXml){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SAXParser sp = factory.newSAXParser();
            sp.getXMLReader().parse(FileXml);
            sp.parse(FileXml, new HandlerSax());
        } catch (ParserConfigurationException pce) {
            System.out.println("ParserConfigurationException : " + pce.getMessage());
        } catch (IOException io) {
            System.out.println("IOException : " + io.getMessage());
        } catch (SAXException se) {
            System.out.println("SaxEXception : " + se.getMessage());
        }
    }
}