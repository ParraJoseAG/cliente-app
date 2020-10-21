package com.springboot.clienteapp.models.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.clienteapp.models.entity.Cliente;
import com.springboot.clienteapp.models.repository.ClienteRepository;
import com.springboot.clienteapp.models.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodo() {

		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteRepository.save(cliente);

	}

	@Override
	public Cliente buscarPorId(Integer id) {

		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		clienteRepository.deleteById(id);

	}

}
