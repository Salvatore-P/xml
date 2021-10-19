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
    private SAXParser _parser;

    SaxValidation(String FileXml)  {
        _factory = SAXParserFactory.newInstance();
        _factory.setValidating(true);
        _factory.setNamespaceAware(true);
        _fileName = FileXml;

        try {
            _parser = _factory.newSAXParser();
            _parser.getXMLReader().parse(_fileName);
            _parser.parse(_fileName, new HandlerSax());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    SaxValidation(String FileXml, String schema) {
        _factory = SAXParserFactory.newInstance();
        _factory.setValidating(false);
        _factory.setNamespaceAware(true);

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        _fileName = FileXml;
        _schema = "..\\Fichier\\" + schema;

        try {
            _factory.setSchema(schemaFactory.newSchema(new Source[]{new StreamSource(_schema)}));
            _parser = _factory.newSAXParser();
            _parser.parse(_fileName, new HandlerSax());

        } catch (SAXException e) {
            System.out.println("SCHEMA : " + e.getMessage());  // problem in the XSD itself
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


    }

}