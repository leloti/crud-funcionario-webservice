package com.ciss.crudfuncionariows;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ciss.crudfuncionariows.bo.FuncionarioBO;
import com.ciss.crudfuncionariows.model.Funcionario;
import com.ciss.crudfuncionariows.repositorio.FuncionarioRepositorio;
import com.ciss.crudfuncionariows.util.Util;
/**
 * @author Ariel L. Henz
 * 
 */
@SpringBootApplication
public class Aplicacao {

	@Autowired
	FuncionarioBO funcionarioBo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class, args);

	}

	@Bean
	public CommandLineRunner criarDatabase(FuncionarioRepositorio repositorio) {
    	return (args) -> {
    		Integer numeroInicializar = 100;
    		List<Funcionario> listaFuncionarios = funcionarioBo.gerarFuncionariosMemoria(numeroInicializar);
    		
    		for (Funcionario func : listaFuncionarios) {
				repositorio.save(func);
			}
    		
    		Util.log("com.ciss.crudfuncionariows.Aplicacao", "Foram inicializados " + numeroInicializar + " funcionarios!");
    	};
    }
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}