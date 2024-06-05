package com.mayan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayan.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
