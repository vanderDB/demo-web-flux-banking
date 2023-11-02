package com.banking.demowebflux.core.domain.sql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
