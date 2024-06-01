package com.mayan.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayan.helpdesk.domain.Tecnico;
import com.mayan.helpdesk.domain.dtos.TecnicoDTO;
import com.mayan.helpdesk.services.TecnicoService;

@RestController // Marca uma classe como controlador Spring, ela retorna dados diretamente em vez de exibir uma página HTML. 
@RequestMapping(value = "/tecnicos") // Mapeia URL's para classes ou métodos específicos.
public class TecnicoResource {

	@Autowired
	private TecnicoService service;
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
}
