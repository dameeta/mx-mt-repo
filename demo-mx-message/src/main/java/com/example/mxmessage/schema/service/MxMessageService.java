package com.example.mxmessage.schema.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class MxMessageService {
    public <T> T parseMessage(String xml,Class<T> myclass) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(myclass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xml));

    }
}
