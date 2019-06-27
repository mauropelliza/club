package club.clubproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.clubproject.model.Instalacion;
import club.clubproject.repository.InstalacionJpaDao;
import club.clubproject.service.InstalacionService;

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