package net.infogram.api.content.quote;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "text",
	                   "author"
                   })
public class Quote extends InfographicElement
{

	@JsonProperty("text")
	private String text;
	@JsonProperty("author")
	private String author;

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
