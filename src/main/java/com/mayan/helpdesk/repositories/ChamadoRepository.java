package com.mayan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayan.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
