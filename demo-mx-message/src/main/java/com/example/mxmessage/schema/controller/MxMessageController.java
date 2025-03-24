//package com.example.mxmessage.schema.controller;
package com.example.mxmessage.schema.controller;

import com.example.mxmessage.schema.Payment;
import com.example.mxmessage.schema.service.MxMessageService;
import com.example.mxmessage.schema.service.ValidationService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mx")
public class MxMessageController {

    @Autowired
    private MxMessageService mxMessageService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/parse")
    public ResponseEntity<String> parseAndValidate(@RequestBody String xml) {
        try {
            // Parsing XML to Payment Object
            Payment message = mxMessageService.parseMessage(xml, Payment.class);

            // Null Check
            if (message == null) {
                return ResponseEntity.badRequest().body("Error: Parsed message is null.");
            }

            // Validating the parsed object
            Set<ConstraintViolation<Payment>> violations = validationService.validate(message);

            if (!violations.isEmpty()) {
                String errors = violations.stream()
                        .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                        .collect(Collectors.joining("\n"));

                return ResponseEntity.badRequest().body("Validation failed:\n" + errors);
            }

            return ResponseEntity.ok("Message parsed and validated successfully!");

        } catch (JAXBException e) {
            return ResponseEntity.badRequest().body("XML Parsing Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Unexpected Error: " + e.getMessage());
        }
    }
}

//
//import com.example.mxmessage.schema.Payment;
//import com.example.mxmessage.schema.service.MxMessageService;
//import com.example.mxmessage.schema.service.ValidationService;
//import jakarta.validation.ConstraintViolation;
//import jakarta.xml.bind.JAXBException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/mx")
//public class MxMessageController {
//    @Autowired
//    private MxMessageService mxMessageService;
//    @Autowired
//    private ValidationService validationService;
//    @PostMapping("/parse")
//    public String parseAndValidate(@RequestBody String xml) throws JAXBException {
//        try{
//           var message = mxMessageService.parseMessage(xml, Payment.class);
//            Set<ConstraintViolation<Payment>>violations=validationService.validate(message);
//            if(!violations.isEmpty()){
//                StringBuilder errors = new StringBuilder();
//                for(var violation : violations)
//                {
//errors.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
//
//                }
//                return "Validation failed:\n" + errors;
//            }
//            return  "Message parsed and validated successfully!!";
//        }
//        catch (Exception e)
//        {
//            return "Error:" + e.getMessage();
//        }
//    }
//}
