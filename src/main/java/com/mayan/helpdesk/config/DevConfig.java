package com.mayan.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mayan.helpdesk.services.DBService;

@Configuration //Centralizar a configuração em classes específicas facilita a gestão e modificação da configuração da aplicação.
@Profile("dev") // É usado para definir o perfil de configuração e ele só será carregado se o perfil definido estiver ativo.
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDB() {
		if (value.equals("create")) {
			this.dbService.instanciaDB();
		} 
		return false;
	}
}