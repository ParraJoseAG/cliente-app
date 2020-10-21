package com.springboot.clienteapp.models.service;

import java.util.List;

import com.springboot.clienteapp.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> listarTodo();

	public void guardarCliente(Cliente cliente);

	public Cliente buscarPorId(Integer id);

	public void eliminar(Integer id);
}
