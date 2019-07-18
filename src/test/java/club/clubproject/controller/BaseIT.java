package club.clubproject.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.clubproject.util.HttpClientUtil;
import com.clubproject.util.HttpClienteResponse;

import org.springframework.test.annotation.DirtiesContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@DirtiesContext
public class BaseIT {
	protected HttpClienteResponse doPostRequestJson(String url, String jsonObject) {

		HttpClienteResponse httpClienteResponse = null;
		try {
			httpClienteResponse = HttpClientUtil.executePostJson(url, jsonObject);
//			baseItLog.info("Test Invocacion Rest -> " + httpClienteResponse);
		} catch (Exception e) {
//			baseItLog.error("Error de conexion", e);
		}

		return httpClienteResponse;
	}

//	protected HttpClienteResponse doDeleteRequestJWT(String url) {
//
//		HttpClienteResponse httpClienteResponse = null;
//		try {
//			httpClienteResponse = HttpClientUtil.executeDelete(url);
////			baseItLog.info("Test Invocacion Rest -> " + httpClienteResponse);
//		} catch (Exception e) {
////			baseItLog.error("Error de conexion", e);
//		}
//
//		return httpClienteResponse;
//	}
//
//	protected HttpClienteResponse doPutRequestJWT(String url, String jsonObject) {
//
//		HttpClienteResponse httpClienteResponse = null;
//		try {
//			httpClienteResponse = HttpClientUtil.executePut(url, jsonObject);
//			baseItLog.info("Test Invocacion Rest -> " + httpClienteResponse);
//		} catch (Exception e) {
//			baseItLog.error("Error de conexion", e);
//		}
//
//		return httpClienteResponse;
//	}
}
