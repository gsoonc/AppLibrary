package com.evc.applibrary.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evc.applibrary.backend.models.entity.Book;
import com.evc.applibrary.backend.models.services.IBookManagerService;

@RestController
@RequestMapping("/api/libros")
public class BookRestController {
	@Autowired
	private IBookManagerService bookManagerService;

	// Obtener los libros
	@GetMapping()
	public List<Book> verLibros() {
		return bookManagerService.getAllBooks();
	}

	// Obtener un libro por id
	@GetMapping("/{id}")
	public Book verLibro(@PathVariable("id") Integer id) {
		return bookManagerService.getBookInformation(id);
	}

	// Agregar un libro
	//@Valid valida las restricciones definidas en el entity
	@PostMapping()
	public Book agregarLibro(@Valid @RequestBody Book libro ) {
		return bookManagerService.registerBook(libro);
	}

	// Actualizar un libro
	@PutMapping()
	public Book actualizarLibro(@RequestBody Book libro) {
		return bookManagerService.updateBook(libro);
	}

	// Eliminar un libro por id
	@DeleteMapping("/{id}")
	public void eliminarLibro(@PathVariable("id") Integer id) {
		bookManagerService.removeBook(id);
	}

}
