package uz.asbt.ocr.mrz.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML {
    public static MRZData readXML(String xmlFile) throws Exception {
        System.out.println("Begin read XML data from file " + xmlFile);
        File file = new File(xmlFile);
        MRZData mrzData = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("MRZ");
        Node nNode = nodeList.item(0);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Begin parse XML file");
            Element eElement = (Element) nNode;
            mrzData = new MRZData();
            mrzData.setBirthDate(eElement.getAttribute("BirthDate"));
            mrzData.setCountry(eElement.getAttribute("Country"));
            mrzData.setDocNumber(eElement.getAttribute("DocNumber"));
            mrzData.setDocType(eElement.getAttribute("DocType"));
            mrzData.setExpDate(eElement.getAttribute("ExpDate"));
            mrzData.setLastName(eElement.getAttribute("LastName"));
            mrzData.setName(eElement.getAttribute("Name"));
            mrzData.setNationality(eElement.getAttribute("Nationality"));
            mrzData.setSex(eElement.getAttribute("Sex"));
            mrzData.setPersonalNumber(eElement.getAttribute("PersonalNumber"));
        }
        System.out.println("Can't parse XML data");
        return mrzData;
    }
}
