package com.rayheneranuzia.personapi.controller;

import com.rayheneranuzia.personapi.dto.request.PersonDTO;
import com.rayheneranuzia.personapi.dto.response.MessageResponseDTO;
import com.rayheneranuzia.personapi.entities.Person;
import com.rayheneranuzia.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }
}
