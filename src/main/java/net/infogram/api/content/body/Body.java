package net.infogram.api.content.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	                   "text"
                   })
public class Body extends InfographicElement
{

	@JsonProperty("text")
	private String text;


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
