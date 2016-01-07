package net.infogram.api.content.h1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "type",
	                   "text"
                   })
public class HeadlineOne extends InfographicElement
{

	final static String TYPE = "h1";

	@JsonProperty("type")
	private String type = TYPE;
	@JsonProperty("text")
	private String text;

	/**
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType()
	{
		return type;
	}

	/**
	 * @param type The type
	 */
	@JsonProperty("type")
	private HeadlineOne setType(String type)
	{
		this.type = type;
		return this;
	}

	/**
	 * @return The text
	 */
	@JsonProperty("text")
	public String getText()
	{
		return text;
	}

	/**
	 * @param text The text
	 */
	@JsonProperty("text")
	public HeadlineOne setText(String text)
	{
		this.text = text;
		return this;
	}

}
