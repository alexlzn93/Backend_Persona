package com.alexlzn.persona.interfaces;

import java.util.List;

import com.alexlzn.persona.model.Persona;

public interface IPersonaService {

	List<Persona> listPersonas();
	Persona findById(Integer id);
	void deleteById(Integer id);
	void addPersona(Persona persona);
	
}
