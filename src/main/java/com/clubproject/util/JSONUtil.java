package com.clubproject.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	private static final Logger log = LoggerFactory.getLogger(JSONUtil.class);

	/**
	 * Convierte un Objecto a formato Json
	 */
	public static String convertObjectToJSON(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json_string = StringUtils.EMPTY;
		try {
			json_string = mapper.writeValueAsString(object);
		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		return json_string;
	}

	/**
	 * Genera un Objecto a partir de un archivo con formato json.
//	 */
//	public static <T> T jsonFileToObject(String fileName, Class<T> classType) {
//		ObjectMapper mapper = new ObjectMapper();
//		T object = null;
//		try {
//			String fileString = getFile(fileName);
//			object = mapper.readValue(fileString, classType);
//		} catch (Exception e) {
//			log.error("Error inesperado", e);
//		}
//		return object;
//	}

//	public static String getJsonFromFile(String fileName) {
//		return getFile(fileName);
//	}

	/**
	 * Genera un Objecto a partir de un string con formato json.
	 */
	public static <T> T jsonStringToObject(String textoJson, Class<T> classType) {
		if (classType.equals(String.class)) {
			return (T) textoJson;
		}
		ObjectMapper mapper = new ObjectMapper();
		T object = null;
		try {
			object = mapper.readValue(textoJson, classType);
		} catch (Exception e) {
			log.error("Error inesperado", e);
		}
		return object;
	}

//	private static String getFile(String fileName) {
//		String result = StringUtils.EMPTY;
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		try {
//			result = IOUtils.toString(classLoader.getResourceAsStream(fileName), Charset.defaultCharset());
//		} catch (IOException e) {
//			log.error("Error inesperado", e);
//		}
//
//		return result;
//
//	}

}
