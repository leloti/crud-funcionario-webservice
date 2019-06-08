package com.ciss.crudfuncionariows.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
/**
 * @author Ariel L. Henz
 * 
 */
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Size(min=2, max=30)
	private String nome;

	@Size(min=2, max=50)
	private String sobrenome;

	private String email;

	@Size(min=1, max=11)
	private String numeroPis;
	
    protected Funcionario() {}
    
    public Funcionario(Integer id, String nome, String sobrenome, String email, String numeroPis) {
    	this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.numeroPis = numeroPis;
    }
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroPis() {
		return numeroPis;
	}

	public void setNumeroPis(String numeroPis) {
		this.numeroPis = numeroPis;
	}

}
