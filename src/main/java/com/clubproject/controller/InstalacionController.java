package com.clubproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
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
}