package br.com.cursospring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cursospring.domain.Address;
import br.com.cursospring.domain.Category;
import br.com.cursospring.domain.City;
import br.com.cursospring.domain.Client;
import br.com.cursospring.domain.PayTicket;
import br.com.cursospring.domain.Payment;
import br.com.cursospring.domain.PaymentCard;
import br.com.cursospring.domain.Product;
import br.com.cursospring.domain.Request;
import br.com.cursospring.domain.State;
import br.com.cursospring.domain.enums.StatusPayment;
import br.com.cursospring.domain.enums.TypeClient;
import br.com.cursospring.repositories.AddressRepository;
import br.com.cursospring.repositories.CategoryRepository;
import br.com.cursospring.repositories.CityRepository;
import br.com.cursospring.repositories.ClientRepository;
import br.com.cursospring.repositories.PaymentRepository;
import br.com.cursospring.repositories.ProductRepository;
import br.com.cursospring.repositories.RequestRepository;
import br.com.cursospring.repositories.StateRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

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

		State estOne = new State(null, "Minas Gerais");
		State estTwo = new State(null, "São Paulo");

		City cityOne = new City(null, "Coronel Fabriciano", estOne);
		City cityTwo = new City(null, "Belo Horizonte", estOne);
		City cityThree = new City(null, "São Paulo", estTwo);

		estOne.getCities().addAll(Arrays.asList(cityOne, cityTwo));
		estTwo.getCities().addAll(Arrays.asList(cityThree));
		
		stateRepository.saveAll(Arrays.asList(estOne, estTwo));
		cityRepository.saveAll(Arrays.asList(cityOne, cityTwo, cityThree));
		
		Client cliOne = new Client(null, "Mariana", "mariana@gmail.com", "33344455506", TypeClient.PHYSICALPERSON);
		cliOne.getPhones().addAll(Arrays.asList("33999887766", "31988776655"));
		
		Address adOne = new Address(null, "Rua Padre Tiago", "316", "Ap 201", "Camargos", "30520-440", cliOne, cityTwo);
		Address adTwo = new Address(null, "Av. Tancredo Neves", "1084", "A", "Nazaré", "35170-054", cliOne, cityOne);
		cliOne.getAdresses().addAll(Arrays.asList(adOne, adTwo));
		
		clientRepository.saveAll(Arrays.asList(cliOne));
		addressRepository.saveAll(Arrays.asList(adOne, adTwo));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Request ordOne = new Request(null, sdf.parse("30/09/2018 12:30"), cliOne, adOne);
		Request ordTwo = new Request(null, sdf.parse("02/10/2018 14:30"), cliOne, adTwo);
		
		Payment payOne = new PaymentCard(null, StatusPayment.SETTLED, ordOne, 6);
		ordOne.setPayment(payOne);
		
		Payment payTwo = new PayTicket(null, StatusPayment.PENDING, ordTwo, sdf.parse("20/10/18 00:00"), null);
		ordTwo.setPayment(payTwo);
		
		cliOne.getRequests().addAll(Arrays.asList(ordOne, ordTwo));
		
		requestRepository.saveAll(Arrays.asList(ordOne, ordTwo));
		paymentRepository.saveAll(Arrays.asList(payOne, payTwo));
		
	}
}
