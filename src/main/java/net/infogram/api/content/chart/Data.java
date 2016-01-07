
package net.infogram.api.content.chart;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "sheets"
})
public class Data {

    @JsonProperty("sheets")
    private ArrayList<Sheet> sheets = new ArrayList<Sheet>();

    /**
     * 
     * @return
     *     The sheets
     */
    @JsonProperty("sheets")
    public ArrayList<Sheet> getSheets() {
        return sheets;
    }

    /**
     * 
     * @param sheets
     *     The sheets
     */
    @JsonProperty("sheets")
    private void setSheets(ArrayList<Sheet> sheets) {
        this.sheets = sheets;
    }

	  @JsonIgnore
	  public Data addSheet(Sheet sheet)
	  {
		  this.sheets.add(sheet);
		  return this;
	  }

}
