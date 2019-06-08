package com.ciss.crudfuncionariows.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciss.crudfuncionariows.dto.ErroDTO;
import com.ciss.crudfuncionariows.dto.FuncionarioDTO;
import com.ciss.crudfuncionariows.enums.ErroEnum;
import com.ciss.crudfuncionariows.model.Funcionario;
import com.ciss.crudfuncionariows.repositorio.FuncionarioRepositorio;
import com.ciss.crudfuncionariows.util.Util;

/**
 * @author Ariel L. Henz
 * 
 */
@Component
public class FuncionarioBO {

	@Autowired
	FuncionarioRepositorio repositorio;

	@Autowired
	private ModelMapper modelMapper;

	private FuncionarioDTO convertToDto(Funcionario funcionario) {
		FuncionarioDTO funcionarioDto = modelMapper.map(funcionario, FuncionarioDTO.class);

		return funcionarioDto;
	}

	private Funcionario convertToEntity(FuncionarioDTO funcionarioDto) {
		Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);

		return funcionario;
	}

	private List<FuncionarioDTO> convertListToDto(List<Funcionario> listaFuncionarios) {
		List<FuncionarioDTO> listaFuncionariosDto = new ArrayList<>();

		for (Funcionario funcionario : listaFuncionarios) {
			listaFuncionariosDto.add(convertToDto(funcionario));
		}

		return listaFuncionariosDto;
	}

	public List<Funcionario> gerarFuncionariosMemoria(Integer qtdFuncionarios) {
		List<Funcionario> listaFuncionario = new ArrayList<>();

		for (int i = 0; i < qtdFuncionarios; i++) {
			Funcionario funcionario = new Funcionario(null,
				Util.randomize(30, true, false), 
				Util.randomize(50, true, false),
				Util.randomize(30, true, false), 
				Util.randomize(11, false, true)
			);
			listaFuncionario.add(funcionario);
		}

		return listaFuncionario;
	}
	
	public Boolean funcionarioExiste(Integer id) {
		if (Objects.isNull(buscarFuncionarioPorId(id))) {
			return false;
		}
		
		return true;
	}
	
	public Object validarObjeto(FuncionarioDTO funcionarioDto) {
		if(!Objects.isNull(funcionarioDto.getNumeroPis()) 
				&& !Util.isApenasNumeros(funcionarioDto.getNumeroPis())) {
			return new ErroDTO(ErroEnum.NIS_INVALIDO);
		}
		
		if (!Objects.isNull(funcionarioDto.getEmail()) 
				&& !Util.isEmailValido(funcionarioDto.getEmail())) {
			return new ErroDTO(ErroEnum.EMAIL_INVALIDO);
		}
		
		if(!Objects.isNull(funcionarioDto.getNome()) 
				&& (funcionarioDto.getNome().length() < 2 || funcionarioDto.getNome().length() > 30)) {
			return new ErroDTO(ErroEnum.NOME_TAMANHO_INVALIDO);
		}
		
		if(!Objects.isNull(funcionarioDto.getSobrenome()) 
				&& (funcionarioDto.getSobrenome().length() < 2 || funcionarioDto.getSobrenome().length() > 50)) {
			return new ErroDTO(ErroEnum.SOBRENOME_TAMANHO_INVALIDO);
		}
		
		return null;
	}

	public List<FuncionarioDTO> listarFuncionarios() {
		List<Funcionario> listaFuncionarios = repositorio.findAll();
		List<FuncionarioDTO> listaFuncionarioDTO = convertListToDto(listaFuncionarios);
		return listaFuncionarioDTO;
	}

	public FuncionarioDTO buscarFuncionarioPorId(Integer id) {
		Funcionario funcionario = repositorio.findById(id);
		FuncionarioDTO funcionarioDto = null;
		
		if (!Objects.isNull(funcionario)) {
			funcionarioDto = convertToDto(funcionario);
		}
		
		return funcionarioDto;
	}
	
	public FuncionarioDTO adicionarFuncionario(FuncionarioDTO funcionarioDto) {
		Funcionario funcionario = convertToEntity(funcionarioDto);
		repositorio.save(funcionario);
		return convertToDto(funcionario);
	}
	
	public Object editarFuncionario(Integer id, FuncionarioDTO funcionarioDto) {
		FuncionarioDTO funcionarioBancoDto = buscarFuncionarioPorId(id);
		Funcionario funcionario = new Funcionario(
				id,
				funcionarioDto.getNome(), 
				funcionarioDto.getSobrenome(), 
				funcionarioDto.getEmail(), 
				funcionarioDto.getNumeroPis());
		
		repositorio.save(funcionario);		
		funcionarioBancoDto = convertToDto(funcionario);		
		return funcionarioBancoDto;
	}
	
	public void deletarUsuario(Integer id) {
		Funcionario funcionario = convertToEntity(buscarFuncionarioPorId(id));
		repositorio.delete(funcionario);
	}
}
