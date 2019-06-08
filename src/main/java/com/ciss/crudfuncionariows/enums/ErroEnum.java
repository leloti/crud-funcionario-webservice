package com.ciss.crudfuncionariows.enums;

public enum ErroEnum {
	
	NAO_ENCONTRADO("Registro não encontrado."),
	EMAIL_INVALIDO("Email invalido."), 
	NIS_INVALIDO("Numero NIS invalido."),
	NOME_TAMANHO_INVALIDO("Tamanho do campo nome invalido."),
	SOBRENOME_TAMANHO_INVALIDO("Tamanho do campo sobrenome invalido.");
	
	private String msgErro;

	private ErroEnum(String msgErro) {
		this.msgErro = msgErro;
	}
	
}
