package com.banking.demowebflux.core.domain.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Transaction {

    @Id
    private Long id;
    private Long accountId;
    private String transactionType;
    private Double amount;
    private Date transactionDate;
}
