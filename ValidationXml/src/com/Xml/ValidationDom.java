package com.Xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

public class ValidationDom {

    ValidationDom(String FileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);

        try {

            //vérifier que l'on a un fichier DTD ou XSD
            if (isDTD(FileName) == true)
                factory.setValidating(true);
            else
                factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();

            HandlerDom.LancementHandler(builder);
            File fileXML = new File(FileName);
            Document xml = builder.parse(fileXML);
            Element root = xml.getDocumentElement();
            // System.out.println(root.getNodeName());

        } catch (SAXParseException e) {
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean isDTD(String FileName) {
        Boolean DTD = true;
        if (FileName.trim().equals("Fichier\\XML_ModifierDTD.xml") == false)
            DTD = false;
        return DTD;
    }
}



