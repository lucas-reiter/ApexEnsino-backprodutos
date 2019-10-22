package com.produtos.exemplo.repositorio;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.produtos.exemplo.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends Repository<ProdutoModelo, Integer>{
	
	//Ações para o CRUD
	public void save(ProdutoModelo prodMod);
	public List<ProdutoModelo> findAll();
	public ProdutoModelo findByCodigo(Integer codigo);
	public void delete(ProdutoModelo prodMod);
	
}

