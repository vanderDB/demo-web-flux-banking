package com.banking.demowebflux.core.domain.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Transaction {

    @Id
    private Long id;
    @Column("account_id")
    private Long accountId;
    @Column("transaction_type")
    private String transactionType;
    @Column("amount")
    private Double amount;
    @Column("transaction_date")
    private LocalDateTime transactionDate;
}
