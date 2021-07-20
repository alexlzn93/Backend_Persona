package com.alexlzn.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexlzn.persona.model.Persona;
import com.alexlzn.persona.service.PersonaService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@GetMapping("/listPersonas")
	public List<Persona> listadoPersonas(){
		return service.listPersonas();
	}
	@DeleteMapping("/delete/{id}")
	public void eliminarPersona(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
	@PostMapping("/añadir")
	public Persona añadirPersona(@RequestBody Persona persona) {
		service.addPersona(persona);
		return persona;
	}
	@PutMapping("/editar/{id}")
	public Persona editarPersona(@RequestBody Persona persona, @PathVariable("id") Integer id) {
		
		Persona personaDB= service.findById(id);
		personaDB.setNombre(persona.getNombre());
		personaDB.setApellido(persona.getApellido());
		personaDB.setNacionalidad(persona.getNacionalidad());
		personaDB.setEdad(persona.getEdad());
		service.addPersona(personaDB);
		return personaDB;
		
		
	}
	
	
}
