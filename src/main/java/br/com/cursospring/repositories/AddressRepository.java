package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
