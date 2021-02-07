package com.dil.cafeteria.controller;

import com.dil.cafeteria.model.Coffee;
import com.dil.cafeteria.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    CoffeeService coffeeService;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String greeting(){
        return "Hello from get method";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String greet(){
        return "Hello from post method";
    }

    @RequestMapping(value = "/coffee",method = RequestMethod.POST)
    public Coffee save(@RequestBody Coffee coffee){
        return  coffeeService.save(coffee);
    }

    @RequestMapping(value = "/coffee",method = RequestMethod.GET)
    public ResponseEntity<Coffee> fetchCoffee(@RequestBody int id){

        Coffee coffee=coffeeService.fetchCoffeeById(id);
        if(coffee==null){
            return  ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(coffee);
        }
    }


}
