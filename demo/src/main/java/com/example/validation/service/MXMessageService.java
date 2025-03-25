package com.example.validation.service;

import com.example.validation.mxmodel.Document;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Service
public class MXMessageService {
private static  final String XSD_PATH = "src/main/resources/mx_message.xsd";
private static final String XML_PATH = "src/main/resources/sample_mx_message.xml";

public Document parseXML() throws JAXBException {
    Unmarshaller unmarshaller = null;
    try {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        unmarshaller = context.createUnmarshaller();
        validateXMLSchema(XML_PATH, XSD_PATH);
    } catch (Exception e) {
        System.out.println("Not valid xml"+ e.getMessage());
    }
    return (Document) unmarshaller.unmarshal(new File(XML_PATH));

}

private void validateXMLSchema(String xmlFile,String xsdFile) throws SAXException, IOException {
    SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema= factory.newSchema(new File(xsdFile));
    Validator validator=schema.newValidator();
    validator.validate(new StreamSource(new File(xmlFile)));
    System.out.println("XML is valid");
}

}
