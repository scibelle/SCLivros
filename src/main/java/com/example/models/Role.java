package com.example.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role /*implements GrantedAuthority*/{
	
	@Id
	private String papel;
	
	@ManyToMany(mappedBy = "roles")
	private List<Pessoa> pessoas;
	
	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	
	
	
}