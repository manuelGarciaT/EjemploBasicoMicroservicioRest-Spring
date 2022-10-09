package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.model.Persona;

//no necesitaremos crear métodos propios, porque JpaRepository tiene todo lo que se necesita
public interface  PersonaDAO extends JpaRepository <Persona, Integer>{

}
