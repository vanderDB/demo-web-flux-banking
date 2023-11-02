package com.banking.demowebflux.core.repository;

import com.banking.demowebflux.core.domain.sql.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveCrudRepository<User, Long> {
}
