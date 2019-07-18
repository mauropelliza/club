package com.clubproject.service.impl;

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
}