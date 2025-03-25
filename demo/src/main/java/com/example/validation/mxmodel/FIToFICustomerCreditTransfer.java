package com.example.validation.mxmodel;
import jakarta.xml.bind.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class FIToFICustomerCreditTransfer {
    @XmlElement(name = "MessageID")
    private String messageId;

    @XmlElement(name = "CreationDateTime")
    private LocalDateTime creationDateTime;

    @XmlElement(name = "NumberOfTransactions")
    private int numberOfTransactions;

    @XmlElement(name = "TransactionDetails")
    private TransactionDetails transactionDetails;
}
