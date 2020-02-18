package com.ifpb.edu.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifpb.edu.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	
}
