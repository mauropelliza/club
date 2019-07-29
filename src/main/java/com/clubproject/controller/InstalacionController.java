package com.clubproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clubproject.model.Instalacion;
import com.clubproject.service.InstalacionService;

@RestController
public class InstalacionController {

	@Autowired
	private InstalacionService instalacionService;
	
	@PostMapping(value = "/altaInstalacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public String altaInstalacion(@RequestBody Instalacion dto) {
		return instalacionService.altaInstalacion(dto);
	}
	
	@DeleteMapping(value = "/bajaInstalacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public void bajaInstalacion(@RequestBody Integer id) {
		instalacionService.bajaInstalacion(id);
	}
	
	@PutMapping(value = "/modificarInstalacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public void modificarInstalacion(@RequestBody Instalacion dto) {
		instalacionService.modificarInstalacion(dto);
	}
	
	@GetMapping(value = "/buscarInstalacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Instalacion> buscarInstalacion(@RequestBody Instalacion dto) {
		instalacionService.buscarInstalacion(dto);
	}
} 