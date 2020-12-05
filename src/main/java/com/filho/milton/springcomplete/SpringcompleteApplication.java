package com.filho.milton.springcomplete;

import java.util.Arrays;

import com.filho.milton.springcomplete.domain.Categoria;
import com.filho.milton.springcomplete.repositories.CategoriaRepositoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcompleteApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositoty categoriaRepositoty;

	public static void main(String[] args) {
		SpringApplication.run(SpringcompleteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		categoriaRepositoty.saveAll(Arrays.asList(cat1, cat2));

	}
}
