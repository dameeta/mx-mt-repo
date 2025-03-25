package com.example.validation.mxmodel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Document {
    @XmlElement(name = "FIToFICustomerCreditTransfer", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08")
    private FIToFICustomerCreditTransfer fiToFICustomerCreditTransfer;
}

