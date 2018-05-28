package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
