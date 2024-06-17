package org.example.controller;

import org.example.model.Coffee;
import org.example.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffee") // localhost:8080/coffee
public class CoffeeController {

    // Constructor - Autowired - Setter

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }


    @GetMapping("/get") // localhost:8080/coffee/get - GET-method
    public List<Coffee> getAll() {
        return coffeeService.getAll();
    }
}