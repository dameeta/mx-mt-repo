package com.example.mxmessage.schema.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MxMessageService {

    // Cache JAXBContext instances to improve performance
    private static final ConcurrentHashMap<Class<?>, JAXBContext> jaxbContextCache = new ConcurrentHashMap<>();

    public <T> T parseMessage(String xml, Class<T> myClass) throws JAXBException {
        if (xml == null || xml.trim().isEmpty()) {
            throw new IllegalArgumentException("XML input cannot be null or empty.");
        }

        try {
            // Get or create JAXBContext instance
            JAXBContext context = jaxbContextCache.computeIfAbsent(myClass, key -> {
                try {
                    return JAXBContext.newInstance(key);
                } catch (JAXBException e) {
                    throw new RuntimeException("Failed to create JAXBContext for class: " + key.getName(), e);
                }
            });

            Unmarshaller unmarshaller = context.createUnmarshaller();
            T result = (T) unmarshaller.unmarshal(new StringReader(xml));

            if (result == null) {
                throw new JAXBException("Parsed object is null. Invalid XML structure?");
            }

            return result;
        } catch (JAXBException e) {
            throw new JAXBException("XML Parsing Error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error during XML parsing: " + e.getMessage(), e);
        }
    }
}


//package com.example.mxmessage.schema.service;
//
//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.JAXBException;
//import jakarta.xml.bind.Unmarshaller;
//import org.springframework.stereotype.Service;
//
//import java.io.StringReader;
//
//@Service
//public class MxMessageService {
//    public <T> T parseMessage(String xml,Class<T> myclass) throws JAXBException{
//        JAXBContext context = JAXBContext.newInstance(myclass);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        return (T) unmarshaller.unmarshal(new StringReader(xml));
//
//    }
//}
