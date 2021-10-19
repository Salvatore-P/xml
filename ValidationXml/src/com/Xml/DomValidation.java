package com.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomValidation {

    DocumentBuilderFactory _factory;
    DocumentBuilder _builder;
    File _fileXML;
    Document _xml;
    Element _root;

    DomValidation(String FileXml) {
        _factory = DocumentBuilderFactory.newInstance();

        try {
            _factory.setValidating(true);
            _builder = _factory.newDocumentBuilder();

            _fileXML = new File(FileXml);
            _xml = _builder.parse(_fileXML);

            _root = _xml.getDocumentElement();
            System.out.println(_root.getNodeName());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
