package com.produtos.exemplo.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.exemplo.modelo.ProdutoModelo;
import com.produtos.exemplo.modelo.RespostaModelo;
import com.produtos.exemplo.repositorio.ProdutoRepositorio;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProdutoControle {

	//Repositório
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	//Listar todos os produtos
	@RequestMapping(value="/produto", method = RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listarProdutos(){
		return this.produtoRepositorio.findAll();
	}
	
	//Selecionar produto específico
	@RequestMapping(value="/produto/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ProdutoModelo obterProduto(@PathVariable("codigo") Integer codigo) {
		return this.produtoRepositorio.findByCodigo(codigo);
	}
	
	//Cadastrar produto
	@RequestMapping(value="/produto", method = RequestMethod.POST)
	public @ResponseBody RespostaModelo cadastrar(@RequestBody ProdutoModelo prodMod) {
		try {
			this.produtoRepositorio.save(prodMod);
			return new RespostaModelo("Produto cadastrado");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao cadastrar "+erro.getMessage());
		}
	}
	
	//Alterar produto
	@RequestMapping(value="/produto", method = RequestMethod.PUT)
	public @ResponseBody RespostaModelo alterar(@RequestBody ProdutoModelo prodMod) {
		try {
			this.produtoRepositorio.save(prodMod);
			return new RespostaModelo("Produto alterado");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao alterar "+erro.getMessage());
		}
	}
	
	//Remover produto
	@RequestMapping(value="/produto/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable("codigo") Integer codigo) {
		
		ProdutoModelo prodMod = this.produtoRepositorio.findByCodigo(codigo);
		
		try {
			this.produtoRepositorio.delete(prodMod);
			return new RespostaModelo("Produto removido");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao remover "+erro.getMessage());
		}
	}
	
	
	
}





