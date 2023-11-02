package com.banking.demowebflux.core.domain.sql;

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
public class Account {

    @Id
    private Long id;

    @Column("user_id")
    private Long userId;
    @Column("account_type")
    private String accountType;
    @Column("account_number")
    private Long accountNumber;
    @Column("balance")
    private Double balance;
    @Column("status")
    private String status;

    @Transient
    private User user;
}
