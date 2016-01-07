
package net.infogram.api.content.chart;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.infogram.api.content.InfographicElement;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "chart_type",
    "data"
})
public class Chart extends InfographicElement
{
	  final static String TYPE = "chart";

    @JsonProperty("type")
    private String type = TYPE;
    @JsonProperty("chart_type")
    private String chartType;
    @JsonProperty("data")
    private Data data = new Data();

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    private void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The chartType
     */
    @JsonProperty("chart_type")
    public String getChartType() {
        return chartType;
    }

    /**
     * 
     * @param chartType
     *     The chart_type
     */
    @JsonProperty("chart_type")
    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    private void setData(Data data) {
        this.data = data;
    }

	  @JsonIgnore
	  public Chart setDataSheet(Sheet sheet)
	  {
		  this.data.getSheets().add(sheet);
		  return this;
	  }

}
