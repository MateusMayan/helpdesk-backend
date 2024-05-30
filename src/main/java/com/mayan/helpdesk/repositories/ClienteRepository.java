package com.mayan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayan.helpdesk.domain.Pessoa;

public interface ClienteRepository extends JpaRepository<Pessoa, Integer>{

}
