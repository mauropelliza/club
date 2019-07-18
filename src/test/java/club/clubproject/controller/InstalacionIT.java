package club.clubproject.controller;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.clubproject.model.Instalacion;
import com.clubproject.util.HttpClienteResponse;
import com.clubproject.util.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class InstalacionIT extends BaseIT {
	
	@Autowired
	private EntityManager clubEntityManager;
	
	@Test
	public void altaInstalacion() {

		borrarInstalacionAlta();
		final int codigoInstalacion = -888888880;
		final String updateUrl = "http://localhost:8080/altaInstalacion";

		HttpClienteResponse httpClienteResponse = doPostRequestJson(updateUrl,
				JSONUtil.convertObjectToJSON(createInstalacionFilterDTOAlta(codigoInstalacion)));

		Assertions.assertTrue(httpClienteResponse.getStatusCode() == HttpStatus.CREATED.value());
		
		clubEntityManager.clear();

	}

	private Instalacion createInstalacionFilterDTOAlta(int codigoInstalacion) {
		
		Instalacion instalacion = new Instalacion();
		instalacion.setId(3);
		instalacion.setDescripcion("cancha 1");
		instalacion.setPrecioPorHora(BigDecimal.TEN);
		
		return instalacion;
	}

	private void borrarInstalacionAlta() {
		// TODO Auto-generated method stub
		
	}
}