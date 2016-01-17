package net.infogram.api.content.map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.infogram.api.content.InfographicElement;

import javax.annotation.Generated;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "territory",
	                   "data"
                   })
public class Map extends InfographicElement
{
	@JsonProperty("territory")
	private String territory;
	@JsonProperty("data")
	private ArrayList<Datum> data = new ArrayList<Datum>();


	/**
	 * @return The territory
	 */
	@JsonProperty("territory")
	public String getTerritory()
	{
		return territory;
	}

	/**
	 * @param territory The territory
	 */
	@JsonProperty("territory")
	public Map setTerritory(String territory)
	{
		this.territory = territory;
		return this;
	}

	/**
	 * @return The data
	 */
	@JsonProperty("data")
	public ArrayList<Datum> getData()
	{
		return data;
	}

	/**
	 * @param data The data
	 */
	@JsonProperty("data")
	public Map setData(ArrayList<Datum> data)
	{
		this.data = data;
		return this;
	}

}
