package org.example.service;

import org.example.model.Coffee;
import org.example.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private CoffeeRepository coffeeRepository;

    public List<Coffee> getAll() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        var coffee = new Coffee("Jakarta"); // бизнес-сущность
        return List.of(coffee); // inMemory
    }
}
