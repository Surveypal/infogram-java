package net.infogram.api.content.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	                   "type",
	                   "text"
                   })
public class Body extends InfographicElement
{
	final static String TYPE = "body";

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
	private void setType(String type)
	{
		this.type = type;
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
	public Body setText(String text)
	{
		this.text = text;
		return this;
	}

}
