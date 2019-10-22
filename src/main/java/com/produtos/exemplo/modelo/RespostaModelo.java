package com.produtos.exemplo.modelo;

public class RespostaModelo {

	//Atributo
	private String mensagem;

	//Construtores
	public RespostaModelo() {}
	
	public RespostaModelo(String msg) {
		this.mensagem = msg;
	}
	
	//Get e Set
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
