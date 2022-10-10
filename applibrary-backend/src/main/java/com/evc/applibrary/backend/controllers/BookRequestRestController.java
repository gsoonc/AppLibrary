package com.evc.applibrary.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evc.applibrary.backend.models.entity.BookRequest;
import com.evc.applibrary.backend.models.services.IBookRequestManagerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/solicitudes")
public class BookRequestRestController {
	@Autowired
	private IBookRequestManagerService bookRequestService;

	// Obtener las solicitudes
	@GetMapping()
	public List<BookRequest> verSolicitudes() {
		return bookRequestService.viewRequests();
	}

	// Obtener las solicitudes de un usuario
	@GetMapping("/{userId}")
	public List<BookRequest> verSolicitudesPorUsuario(@PathVariable("userId") Integer userId) {
		return bookRequestService.viewRequestsByUser(userId);
	}

	// Enviar una solicitud

	@PostMapping()
	
	  public BookRequest enviarSolicitud(@RequestParam(value = "bookId") Integer bookId, @RequestParam(value = "userId") Integer userId) {
	  
		return bookRequestService.sendBookRequest(bookId, userId);
	 
	}
	

	// Aprobar una solicitud

	@PutMapping("/aprobarSolicitud/{bookRequestId}")
	public void aprobarSolicitud(@PathVariable("bookRequestId") Integer bookRequestId) {
		bookRequestService.approveBookRequest(bookRequestId);
	}

	// Rechazar una solicitud
	@PutMapping("/rechazarSolicitud/{bookRequestId}")
	public void rechazarSolicitud(@PathVariable("bookRequestId") Integer bookRequestId) {
		bookRequestService.rejectBookRequest(bookRequestId);
	}

}
