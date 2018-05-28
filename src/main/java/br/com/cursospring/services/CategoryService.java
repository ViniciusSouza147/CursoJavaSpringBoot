package br.com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursospring.domain.Category;
import br.com.cursospring.repositories.CategoryRepository;
import br.com.cursospring.services.exceptions.ObjectNotFoundExeception;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category search(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Object not foud! ID: " + id + ", Type: " + Category.class.getName()));
	}
}
