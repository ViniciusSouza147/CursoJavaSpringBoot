package br.com.cursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursospring.domain.Category;
import br.com.cursospring.domain.Product;
import br.com.cursospring.repositories.CategoryRepository;
import br.com.cursospring.repositories.ProductRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category catOne = new Category(null, "Info");
		Category catTwo = new Category(null, "Ofiice");
		
		Product productOne = new Product(null, "PC", 2000.00);
		Product productTwo = new Product(null, "Notebook", 3000.00);
		Product productThree = new Product(null, "Tv", 4500.00);
		
		catOne.getProducts().addAll(Arrays.asList(productOne, productTwo, productThree));
		catTwo.getProducts().addAll(Arrays.asList(productTwo));
		
		productOne.getCategories().addAll(Arrays.asList(catOne));
		productTwo.getCategories().addAll(Arrays.asList(catOne, catTwo));
		productThree.getCategories().addAll(Arrays.asList(catOne));
		
		categoryRepository.saveAll(Arrays.asList(catOne, catTwo));
		productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree));

	}
}
