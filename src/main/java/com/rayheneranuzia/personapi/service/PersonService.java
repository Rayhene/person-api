package com.rayheneranuzia.personapi.service;

import com.rayheneranuzia.personapi.dto.request.PersonDTO;
import com.rayheneranuzia.personapi.dto.response.MessageResponseDTO;
import com.rayheneranuzia.personapi.entities.Person;
import com.rayheneranuzia.personapi.mapper.PersonMapper;
import com.rayheneranuzia.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with id " + savedPerson.getId())
                .build();
    }
}
