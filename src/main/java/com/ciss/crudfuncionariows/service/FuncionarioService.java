package com.ciss.crudfuncionariows.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciss.crudfuncionariows.bo.FuncionarioBO;
import com.ciss.crudfuncionariows.dto.ErroDTO;
import com.ciss.crudfuncionariows.dto.FuncionarioDTO;
import com.ciss.crudfuncionariows.enums.ErroEnum;
/**
 * @author Ariel L. Henz
 * 
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FuncionarioService {
	
	@Autowired
	FuncionarioBO funcionarioBO;

	/**
	 * Metodo de consulta de funcionários.
	 * Lista todos os funcionários cadastrados.
	 * */
	@RequestMapping(method = RequestMethod.GET, value="/funcionarios")
	public List<FuncionarioDTO> listarFuncionarios() {		
		return funcionarioBO.listarFuncionarios();
	}

	/**
	 * Metodo de consulta de funcionário.
	 * Lista o funcionário a partir do id.
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/funcionario/{id}")
	public ResponseEntity<Object> buscarFuncionario(@PathVariable Integer id) {		
		ResponseEntity<Object> response = new ResponseEntity<>(new ErroDTO(ErroEnum.NAO_ENCONTRADO), HttpStatus.NOT_FOUND);
		
		if (funcionarioBO.funcionarioExiste(id)) {
			FuncionarioDTO funcionarioDto = funcionarioBO.buscarFuncionarioPorId(id);
			response = new ResponseEntity<>(funcionarioDto, HttpStatus.OK);
		}
		
		return response;
	}

	/**
	 * Metodo inserção de funcionário.
	 * Inclui um novo funcionário.
	 * */
	@RequestMapping(method = RequestMethod.POST, value = "/funcionario")
	public ResponseEntity<Object> adicionarFuncionario(
			@RequestBody FuncionarioDTO funcionarioDto) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Object objetoRetorno = funcionarioBO.validarObjeto(funcionarioDto);
		
		if (Objects.isNull(objetoRetorno)) {
			objetoRetorno = funcionarioBO.adicionarFuncionario(funcionarioDto);		
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(objetoRetorno, status);
	}

	/**
	 * Metodo de edição de funcionário.
	 * Edita um funcionário.
	 * */
	@RequestMapping(method = RequestMethod.PUT, value = "/funcionario/{id}")
	public ResponseEntity<Object> editarFuncionario(@PathVariable Integer id,
			@RequestBody FuncionarioDTO funcionarioDto) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Object objetoRetorno = funcionarioBO.validarObjeto(funcionarioDto);
		
		if (Objects.isNull(objetoRetorno) && funcionarioBO.funcionarioExiste(id)) {
			objetoRetorno = funcionarioBO.editarFuncionario(id, funcionarioDto);	
			status = HttpStatus.OK;
		}
		
		return new ResponseEntity<>(objetoRetorno, status);
	}

	/**
	 * Metodo para deletar um funcionário.
	 * Deleta um funcionário.
	 * */
	@RequestMapping(method = RequestMethod.DELETE, value = "/funcionario/{id}")
	public ResponseEntity<Object> deletarFuncionario(@PathVariable Integer id) {
		ResponseEntity<Object> response = new ResponseEntity<>(new ErroDTO(ErroEnum.NAO_ENCONTRADO), HttpStatus.NOT_FOUND);
		
		if(funcionarioBO.funcionarioExiste(id)) {
			funcionarioBO.deletarUsuario(id);
			response = new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		return response;
	}

}
