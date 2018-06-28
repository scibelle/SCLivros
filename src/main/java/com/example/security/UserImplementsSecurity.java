package com.example.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.models.Pessoa;
import com.example.repository.PessoaRepository;

@Repository
@Transactional
public class UserImplementsSecurity implements UserDetailsService{
	@Autowired	
	private PessoaRepository pessoaRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaRepository.findByLogin(login);
		
		if(pessoa == null) {
			throw new UsernameNotFoundException("Não existe esse login");
		}
		
		
		return new User(pessoa.getUsername(),pessoa.getPassword(),true,true,true,true,pessoa.getAuthorities());
	}

}

