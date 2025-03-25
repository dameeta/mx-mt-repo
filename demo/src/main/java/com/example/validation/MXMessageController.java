package com.example.validation;

import com.example.validation.mxmodel.Document;
import com.example.validation.service.MXMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mx")
public class MXMessageController {

    private final MXMessageService mxMessageService;

    public MXMessageController(MXMessageService mxMessageService)
    {
        this.mxMessageService=mxMessageService;
    }

    @GetMapping("/parse")
    public Document parseMXMessage() throws Exception {
        return  mxMessageService.parseXML();

    }
}
