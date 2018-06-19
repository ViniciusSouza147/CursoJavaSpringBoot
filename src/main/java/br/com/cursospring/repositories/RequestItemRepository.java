package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.RequestItem;

@Repository
public interface RequestItemRepository extends JpaRepository<RequestItem, Integer> {

}
