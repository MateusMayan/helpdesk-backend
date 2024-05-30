package com.mayan.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mayan.helpdesk.domain.Chamado;
import com.mayan.helpdesk.domain.Cliente;
import com.mayan.helpdesk.domain.Tecnico;
import com.mayan.helpdesk.domain.enums.Perfil;
import com.mayan.helpdesk.domain.enums.Prioridade;
import com.mayan.helpdesk.domain.enums.Status;
import com.mayan.helpdesk.repositories.ChamadoRepository;
import com.mayan.helpdesk.repositories.ClienteRepository;
import com.mayan.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	/* Injeção de dependência - usado para injetar automaticamente um objeto gerenciado pelo Spring. 
	 Quando um objeto é criado, suas dependências são marcadas e automaticamente resolvidas */
	@Autowired 
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Mateus Mayan", "123456789101", "mateusmayan@icloud.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "234567891011", "torvalds@mail.com", "123456");
		
		Chamado c1 = new Chamado(null, Prioridade.MÉDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
