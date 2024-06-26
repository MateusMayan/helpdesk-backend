package com.mayan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayan.helpdesk.domain.Chamado;
import com.mayan.helpdesk.domain.Cliente;
import com.mayan.helpdesk.domain.Tecnico;
import com.mayan.helpdesk.domain.enums.Perfil;
import com.mayan.helpdesk.domain.enums.Prioridade;
import com.mayan.helpdesk.domain.enums.Status;
import com.mayan.helpdesk.repositories.ChamadoRepository;
import com.mayan.helpdesk.repositories.ClienteRepository;
import com.mayan.helpdesk.repositories.TecnicoRepository;

@Service // O seu uso sugere que a classe desempenha papel de serviço, fornecendo lógica de negócios e operações específicas
public class DBService {

	/* Injeção de dependência - usado para injetar automaticamente um objeto gerenciado pelo Spring. 
	 Quando um objeto é criado, suas dependências são marcadas e automaticamente resolvidas */
	@Autowired 
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Mateus Mayan", "422.365.520-50", "mateusmayan@icloud.com", encoder.encode("123456"));
		Tecnico tec2 = new Tecnico(null, "Lucas Mayan", "451.797.090-67", "lucas@mail.com", encoder.encode("123456"));
		Tecnico tec3 = new Tecnico(null, "Emmily Mayan", "934.733.540-15", "emmily@mail.com", encoder.encode("123456"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "541.423.070-61", "torvalds@mail.com", encoder.encode("123456"));
		Cliente cli2 = new Cliente(null, "Albert Einstein", "350.071.980-56", "einstein@mail.com", encoder.encode("123456"));
		
		Chamado c1 = new Chamado(null, Prioridade.MÉDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Primeiro chamado", tec3, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		chamadoRepository.saveAll(Arrays.asList(c1, c2));
	}
}
