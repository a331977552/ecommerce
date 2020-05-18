package com.food.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JsonUtils {

	// jackson
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 *
	 * <p>Title: pojoToJson</p>
	 * <p>Description: </p>
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data) {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *
	 * <p>Title: pojoToJson</p>
	 * <p>Description: </p>
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data,DateFormat dateFormat) {
		try {
			DateFormat dateFormat2 = MAPPER.getDateFormat();
			MAPPER.setDateFormat(dateFormat);			
			String string = MAPPER.writeValueAsString(data);
			MAPPER.setDateFormat(dateFormat2);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T>   T jsonToObject(String json,TypeReference<T>  t) {
		
		
		try {
		return	MAPPER.readValue(json, t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *
	 *
	 * @param jsonData json data
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**

	 * <p>Title: jsonToList</p>
	 * <p>Description: </p>
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			return MAPPER.readValue(jsonData, javaType);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
