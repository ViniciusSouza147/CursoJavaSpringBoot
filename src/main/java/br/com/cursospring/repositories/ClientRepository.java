package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
