package com.example.mxmessage.schema;

import jakarta.xml.bind.annotation.XmlElement;

import java.math.BigDecimal;
//
//public class Payment{
//
//    private String id;
//    private String sender;
//    private String receiver;
//    private double amount;
//    private String currency;
//
//    public Payment(String id, String sender, String receiver, double amount, String currency) {
//        this.id = id;
//        this.sender = sender;
//        this.receiver = receiver;
//        this.amount = amount;
//        this.currency = currency;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public String getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(String receiver) {
//        this.receiver = receiver;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2025.03.24 at 10:36:48 AM IST
//


import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
@XmlRootElement(name="Payment")
public  class Payment{
private String id;
private String sender;
private String receiver;
private double amount;
private String currency;

    public Payment() {
    }

    public Payment(String id, String sender, String receiver, double amount, String currency) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
    }

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   @XmlElement(name = "Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlElement(name = "Sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
@XmlElement(name = "Receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
@XmlElement(name = "Amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
