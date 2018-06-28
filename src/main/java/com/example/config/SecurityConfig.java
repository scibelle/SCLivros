 package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.security.UserImplementsSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserImplementsSecurity userDetailsImplements;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/*/*/*").permitAll() // Permito todo mundo acessar a página inicial
		.antMatchers("/paginaInicial").permitAll()
		.antMatchers("/cadastro").permitAll()
		.antMatchers("/pInicial").permitAll()
		.antMatchers("/atualizar/{id}").permitAll()
		.antMatchers("/produto/*").permitAll() // Permito todo mundo acessar o formulário de produto
		.antMatchers("/produto/listar").permitAll() // Permito todo mundo acessar o listar produto
		.antMatchers("/produto/salvar").permitAll() // todos acessam o pessoa salvar
		.antMatchers("/sobrenos").permitAll() // Permito todo mundo acessar a página inicial
		.antMatchers("/contato").permitAll() // Permito todo mundo acessar a página inicial
		.antMatchers("/produto").permitAll() // Permito todo mundo acessar a página inicial
		//.antMatchers("/pessoa/formulario").hasRole("USER") //Somente pessoa com papel "USER" acessa /pessoa/formulario
		.antMatchers("/pessoa/*").permitAll()
		
		//.antMatchers("/pessoa/salvar").hasAnyRole("USER","ADMIN") // Pessoa com papel "USER" ou "ADMIN" acessa /pessoa/salvar
		.antMatchers("/pessoa/salvar").permitAll() // todos acessam o pessoa salvar
		.antMatchers("/pessoa/listar").permitAll() // /pessoa/listar todo mundo pode acessar
		
		.anyRequest().authenticated() // o restante das páginas precisam de autenticação
		
		.and()
		.formLogin()
		.loginPage("/pessoa/logar") // Chama página de login
		.permitAll() //permitir acesso para essa url "entrar"
		
		//.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		.and()
		.logout()
		.logoutSuccessUrl("/pessoa/logar?logout") // logout sucesso
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsImplements).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**","/imagem/**"); // ignora e permite uri's com esses arquivos
	}

}

