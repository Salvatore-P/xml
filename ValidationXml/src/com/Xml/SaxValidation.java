package com.Xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class SaxValidation {

    private String _fileName;
    private String _schema;
    private SAXParserFactory _factory;

    SaxValidation(String FileXml) {
        _fileName = FileXml;
        _factory = SAXParserFactory.newInstance();
        _factory.setValidating(false);
        try {
            SAXParser parser = _factory.newSAXParser();
            parser.getXMLReader().parse(_fileName);
            parser.parse(_fileName, new HandlerSax());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    SaxValidation(String FileXml, String schema) {
        _fileName = FileXml;
        _schema = "..\\Fichier\\" + schema;
        _factory = SAXParserFactory.newInstance();
        _factory.setValidating(false);
        try {
            SAXParser parser = _factory.newSAXParser();
            parser.parse(_fileName, new HandlerSax());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void DtdValidation() {
        _factory.setNamespaceAware(true);

    }

    void XsdValidation() {
        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        try {
            _factory.setSchema(schemaFactory.newSchema(new Source[]{new StreamSource(_schema)}));

        } catch (SAXException e) {
            System.out.println("SCHEMA : " + e.getMessage());  // problem in the XSD itself
        }
    }
}