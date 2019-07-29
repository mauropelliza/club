package com.clubproject.service;

import java.util.List;

import com.clubproject.model.Instalacion;

public interface InstalacionService {

	public String altaInstalacion(Instalacion dto);

	public void bajaInstalacion(Integer id);

	public void modificarInstalacion(Instalacion dto);

	public List<Instalacion> buscarInstalacion(Instalacion dto);
}