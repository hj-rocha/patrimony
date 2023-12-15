package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Person;
import com.pxp.SQLite.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createperson", method = RequestMethod.POST)
    public String createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @RequestMapping(value = "readpersons", method = RequestMethod.GET)
    public List<Person> readPersons(){
        return personService.readPersons();
    }

    @RequestMapping(value = "updateperson", method = RequestMethod.PUT)
    public String updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @RequestMapping(value = "deletepersonname", method = RequestMethod.DELETE)
    public String deletePersonByName(@RequestBody Person person){
        return personService.deletePersonByName(person);
    }
    @RequestMapping(value = "deletepersonid", method = RequestMethod.DELETE)
    public String deletePersonById(@RequestBody Person person){
        return personService.deletePersonById(person);
    }
}
