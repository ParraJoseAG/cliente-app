package com.springboot.clienteapp.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Ciudad;
import com.springboot.clienteapp.models.repository.CiudadRepository;
import com.springboot.clienteapp.models.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {
	
	@Autowired
	private CiudadRepository ciudadRepository;

	@Override
	public List<Ciudad> listaCiudades() {
		
		List<Ciudad> listaCiudades = (List<Ciudad>) ciudadRepository.findAll();
		return listaCiudades;
	}

}
