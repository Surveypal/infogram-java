package net.infogram.api.content.quote;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "type",
	                   "text",
	                   "author"
                   })
public class Quote extends InfographicElement
{

	@JsonProperty("type")
	private String type;
	@JsonProperty("text")
	private String text;
	@JsonProperty("author")
	private String author;

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
	public Quote setType(String type)
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
	public Quote setText(String text)
	{
		this.text = text;
		return this;
	}

	/**
	 * @return The author
	 */
	@JsonProperty("author")
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @param author The author
	 */
	@JsonProperty("author")
	public Quote setAuthor(String author)
	{
		this.author = author;
		return this;
	}

}
