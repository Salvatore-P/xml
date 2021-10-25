package com.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ValidationDom {

    ValidationDom(String FileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            HandlerDom.LancementHandler(builder);
            File fileXML = new File(FileName);
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            System.out.println(root.getNodeName());
        }
        catch (SAXParseException e) {}
        catch(ParserConfigurationException e) {e.printStackTrace();}
        catch(SAXException e) {e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        }


}

