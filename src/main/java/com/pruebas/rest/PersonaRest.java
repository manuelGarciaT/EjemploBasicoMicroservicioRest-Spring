package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;

@RestController
@RequestMapping("personas") //ruta pincipal, puede ser ("v1/personas")
public class PersonaRest {
	
	@Autowired //inyecta PersonasDAO
	private PersonaDAO personaDAO;
	
	//métodos [GET, PUT, POST, UPDATE] http - solicitudes al servidor
	//200 = ok
	//404 = no accede, revisar ruta
	//500 = error en la lógica
	
	@PostMapping("/guardar")
	//@RequestBody toma el Json con la data y lo pasa a objeto Java para poder guardar en la bbdd 
	public void guardar(@RequestBody Persona persona) { //se instancia la entidad Persona que es donde se generan las tablas de la bbdd
		personaDAO.save(persona);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	//@PathVariable toma la variable ingresada en la URL que se marca con {}
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	

}
