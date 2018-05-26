package br.com.cursospring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursospring.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {
	
	@RequestMapping (method=RequestMethod.GET)
	public List<Category> list() {
		
		Category catOne = new Category(1, "Computing");
		Category catTwo = new Category(2, "Office");
		
		List<Category> list = new ArrayList<Category>();
		list.add(catOne);
		list.add(catTwo);
		
		return list;	
	}
	
}
