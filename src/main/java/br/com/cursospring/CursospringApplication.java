package br.com.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursospring.domain.Category;
import br.com.cursospring.repositories.CategoryRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category catOne = new Category(null, "Info");
		Category catTwo = new Category(null, "Ofiice");
		
		categoryRepository.saveAll(Arrays.asList(catOne, catTwo));

	}
}
