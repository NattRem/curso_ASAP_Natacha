package com.gabrielCode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import com.gabrielCode.repository.IPersona;

public class PersonaServiceImpl implements IpersonaService{
	
	@Autowired
	@Qualifier("persona1")
	IPersona repo;
	@Override
	public void registrarHandler(String pNombre) {
		repo.registrar(pNombre);		
	}
	
}
