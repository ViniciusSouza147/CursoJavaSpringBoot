package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
