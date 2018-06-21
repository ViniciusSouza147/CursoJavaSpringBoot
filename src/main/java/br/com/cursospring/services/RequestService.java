package br.com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursospring.domain.Request;
import br.com.cursospring.repositories.RequestRepository;
import br.com.cursospring.services.exceptions.ObjectNotFoundExeception;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;

	public Request search(Integer id) {
		Optional<Request> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Object not foud! ID: " + id + ", Type: " + Request.class.getName()));
	}
}
