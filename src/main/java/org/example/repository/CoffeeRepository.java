package org.example.repository;

import org.example.model.Coffee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository {

    List<Coffee> findAll(); // JDBC
}
