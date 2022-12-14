package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController // expose some end points clients can consume
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
                personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getPerson(){
        return personService.selectAllPeople();
    }
    @GetMapping(path="{id}")
    public Optional<Person> selectPersonByID(@PathVariable("id") UUID id){
        return personService.selectPersonByID(id);
    }


}
