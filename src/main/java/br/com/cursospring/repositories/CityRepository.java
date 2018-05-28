package br.com.cursospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursospring.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
