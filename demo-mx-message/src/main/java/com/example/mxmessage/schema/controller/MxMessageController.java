package com.example.mxmessage.schema.controller;

import com.example.mxmessage.schema.Payment;
import com.example.mxmessage.schema.service.MxMessageService;
import com.example.mxmessage.schema.service.ValidationService;
import jakarta.validation.ConstraintViolation;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/mx")
public class MxMessageController {
    @Autowired
    private MxMessageService mxMessageService;
    @Autowired
    private ValidationService validationService;
    @PostMapping("/parse")
    public String parseAndValidate(@RequestBody String xml) throws JAXBException {
        try{
           var message = mxMessageService.parseMessage(xml, Payment.class);
            Set<ConstraintViolation<Payment>>violations=validationService.validate(message);
            if(!violations.isEmpty()){
                StringBuilder errors = new StringBuilder();
                for(var violation : violations)
                {
                    errors.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");

                }
                return "Validation failed:\n" + errors;
            }
            return  "Message parsed and validated successfully!!";
        }
        catch (Exception e)
        {
            return "Error:" + e.getMessage();
        }
    }
}
