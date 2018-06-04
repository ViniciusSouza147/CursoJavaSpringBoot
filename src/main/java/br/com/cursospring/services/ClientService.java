package br.com.cursospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursospring.domain.Client;
import br.com.cursospring.repositories.ClientRepository;
import br.com.cursospring.services.exceptions.ObjectNotFoundExeception;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client search(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				"Object not foud! ID: " + id + ", Type: " + Client.class.getName()));
	}
}
