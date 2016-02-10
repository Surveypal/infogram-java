package net.infogram.api.content.chart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	                   "chart_type",
	                   "data",
	                   "icon"
                   })
public class Chart extends InfographicElement
{
	@JsonProperty("chart_type")
	private String chartType;
	@JsonProperty("data")
	private Data data = new Data();
	@JsonProperty("icon")
	private String icon;

	/**
	 * @return The chartType
	 */
	@JsonProperty("chart_type")
	public String getChartType()
	{
		return chartType;
	}

	/**
	 * @param chartType The chart_type
	 */
	@JsonProperty("chart_type")
	public void setChartType(String chartType)
	{
		this.chartType = chartType;
	}

	/**
	 * @return The icon
	 */
	public String getIcon()
	{
		return icon;
	}

	/**
	 * @param icon The icon
	 */
	public void setIcon(final String icon)
	{
		this.icon = icon;
	}

	/**
	 * @return The data
	 */
	@JsonProperty("data")
	public Data getData()
	{
		return data;
	}

	/**
	 * @param data The data
	 */
	@JsonProperty("data")
	private void setData(Data data)
	{
		this.data = data;
	}

	@JsonIgnore
	public Chart setDataSheet(Sheet sheet)
	{
		this.data.getSheets().add(sheet);
		return this;
	}

}
