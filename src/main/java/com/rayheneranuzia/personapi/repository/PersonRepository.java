package com.rayheneranuzia.personapi.repository;

import com.rayheneranuzia.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
