package com.ciss.crudfuncionariows.dto;

import com.ciss.crudfuncionariows.enums.ErroEnum;

/**
 * @author Ariel L. Henz
 * 
 */
public class ErroDTO {
	
	private String msgErro;

	public ErroDTO(ErroEnum erroEnum) {
		this.msgErro = erroEnum.toString();
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
}
