package com.example.mxmessage.schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.xml.bind.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

@SpringBootApplication
public class DemoMxMessageApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoMxMessageApplication.class, args);
		Payment payment=new Payment("1001","Comfort","John",45900.56,"dollar");
        try {
            JAXBContext context= JAXBContext.newInstance(Payment.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			StringWriter writer=new StringWriter();
			marshaller.marshal(payment,writer);
			System.out.println("printing xml data...");
			System.out.println(writer.toString());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



//		try{
//			Payment message=new Payment("1001","Comfort","John", 67000.345,"Euro");
//			ObjectMapper mapper=new ObjectMapper();
//			String jsonString = mapper.writeValueAsString(message);
//			System.out.println("Json data is:" + jsonString);
//		} catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

    }


