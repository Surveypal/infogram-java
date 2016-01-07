
package net.infogram.api.content.chart;

import java.util.ArrayList;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "header",
    "rows"
})
public class Sheet {

    @JsonProperty("header")
    private ArrayList<String> header = new ArrayList<String>();
    @JsonProperty("rows")
    private ArrayList<Row> rows = new ArrayList<Row>();

    /**
     * 
     * @return
     *     The header
     */
    @JsonProperty("header")
    public ArrayList<String> getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    @JsonProperty("header")
    private void setHeader(ArrayList<String> header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The rows
     */
    @JsonProperty("rows")
    public ArrayList<Row> getRows() {
        return rows;
    }

    /**
     * 
     * @param rows
     *     The rows
     */
    @JsonProperty("rows")
    private void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

	  @JsonIgnore
	  public Sheet addRow(Row row)
	  {
        this.rows.add(row);
		    return this;
	  }

		@JsonIgnore
		public Sheet addHeader(String header)
		{
			this.header.add(header);
			return this;
		}

}
