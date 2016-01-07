package net.infogram.api.content.chart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "header",
	                   "color",
	                   "data"
                   })
public class Row
{

	@JsonProperty("header")
	private String header;
	@JsonProperty("color")
	private String color;
	@JsonProperty("data")
	private ArrayList<String> data = new ArrayList<String>();

	/**
	 * @return The header
	 */
	@JsonProperty("header")
	public String getHeader()
	{
		return header;
	}

	/**
	 * @param header The header
	 */
	@JsonProperty("header")
	private void setHeader(String header)
	{
		this.header = header;
	}

	/**
	 * @return The header
	 */
	@JsonProperty("color")
	public String getColor()
	{
		return color;
	}

	/**
	 * @param header The header
	 */
	@JsonProperty("color")
	public Row setColor(String color)
	{
		this.color = color;
		return this;
	}

	/**
	 * @return The data
	 */
	@JsonProperty("data")
	public ArrayList<String> getData()
	{
		return data;
	}

	/**
	 * @param data The data
	 */
	@JsonProperty("data")
	public void setData(ArrayList<String> data)
	{
		this.data = data;
	}

	@JsonIgnore
	public Row setDataElement(String dataElement)
	{
		this.data.add(dataElement);
		return this;
	}

	@JsonIgnore
	public Row setDataHeader(String header)
	{
		this.header = header;
		return this;
	}

}
