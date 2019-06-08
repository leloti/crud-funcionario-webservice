package com.ciss.crudfuncionariows.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ciss.crudfuncionariows.model.Funcionario;
/**
 * @author Ariel L. Henz
 * 
 */
@Component
public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long>{
	
	List<Funcionario> findAll();
	Funcionario findById(Integer id);
	void deleteById(Integer id);
	
}