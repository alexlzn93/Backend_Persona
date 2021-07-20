package com.alexlzn.persona.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alexlzn.persona.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Integer> {

}
