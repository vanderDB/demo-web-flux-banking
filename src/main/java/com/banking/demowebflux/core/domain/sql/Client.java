package com.banking.demowebflux.core.domain.sql;

import com.banking.demowebflux.web.bean.CreateClientBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {

    @Id
    private Long id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;

    @Transient
    private List<Account> accounts;

    public Client(CreateClientBean createClientBean) {

        this.firstName = createClientBean.getFirstName();
        this.lastName = createClientBean.getLastName();
        this.email = createClientBean.getEmail();
    }
}
