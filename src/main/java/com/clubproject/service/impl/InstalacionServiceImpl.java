package com.clubproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubproject.model.Instalacion;
import com.clubproject.repository.InstalacionJpaDao;
import com.clubproject.service.InstalacionService;

@Service
public class InstalacionServiceImpl implements InstalacionService {

	@Autowired
	private InstalacionJpaDao instalacionJpaDao;
	
	@Override
	public String altaInstalacion(Instalacion dto) {
		Instalacion instalacion = instalacionJpaDao.saveAndFlush(dto);
		
		return instalacion.getDescripcion();
	}

	@Override
	public void bajaInstalacion(Integer id) {
		Optional<Instalacion> instalacion = instalacionJpaDao.findById(id);
		if (instalacion.isPresent())
			instalacionJpaDao.delete(instalacion.get());
	}

	@Override
	public void modificarInstalacion(Instalacion dto) {
		instalacionJpaDao.saveAndFlush(dto);
	}

	@Override
	public List<Instalacion> buscarInstalacion(Instalacion dto) {
		return null;
	}
	
	
}