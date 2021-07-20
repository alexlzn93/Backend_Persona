package com.alexlzn.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexlzn.persona.interfaces.IPersonaService;
import com.alexlzn.persona.model.Persona;
import com.alexlzn.persona.repositories.PersonaDao;
@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaDao repositorio;
	
	@Override
	public List<Persona> listPersonas() {
		
		return (List<Persona>) repositorio.findAll();
	}

	@Override
	public Persona findById(Integer id) {
		Optional<Persona> persona= repositorio.findById(id);
		if (persona.isPresent()) {
			return persona.get();
		}
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public void addPersona(Persona persona) {
		repositorio.save(persona);
		
	}

}
