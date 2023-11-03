package com.banking.demowebflux.core.domain.sql;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {

    @Id
    private Long id;

    @Column("client_id")
    private Long clientId;
    @Column("account_type")
    private String accountType;
    @Column("account_number")
    private Long accountNumber;
    @Column("balance")
    private Double balance;
    @Column("status")
    private String status;

    @Transient
    private Client client;
}
