/**
 * Developer: Jorge Garcia
 * Date: 10/27/2014
 * Time: 11:23 AM
 * Copyright Surveypal Ltd 2014
 */
package net.infogram.api.content;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;

public class ContentObjectMapper
{
	static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * This method returns a JSON String representing the Object <br>
	 * Author: Jorge Garcia
	 *
	 * @param pojo : Object instance to be serialized into JSON
	 */
	public static String marshallJson(Object pojo, boolean prettyPrint) throws IOException
	{
		StringWriter writer = new StringWriter();
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, prettyPrint);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		mapper.writeValue(writer, pojo);
		return writer.toString();
	}

	/**
	 * This method returns an object of the class set in the parameter. Casting is needed <br>
	 * Author: Jorge Garcia
	 *
	 * @param clazz : Object class to be generated from the Json String
	 * @param json  : Json String to unmarshall into object class.
	 */
	public static <T> T unmarshallJson(Class clazz, String json) throws IOException
	{
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		return (T) mapper.readValue(json, clazz);
	}

}
