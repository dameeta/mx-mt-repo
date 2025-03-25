package com.example.validation.mxmodel;
import jakarta.xml.bind.annotation.*;
import lombok.Data;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TransactionDetails {
    @XmlElement(name = "TransactionID")
    private String transactionId;

    @XmlElement(name = "Amount")
    private BigDecimal amount;

    @XmlElement(name = "Currency")
    private String currency;

    @XmlElement(name = "Debtor")
    private String debtor;

    @XmlElement(name = "Creditor")
    private String creditor;
}
