package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
