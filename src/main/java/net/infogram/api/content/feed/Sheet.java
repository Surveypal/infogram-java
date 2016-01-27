package net.infogram.api.content.feed;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect
public class Sheet extends ArrayList<Row>
{
  @JsonIgnore
	private JsonFeed feed;

	public Sheet(final JsonFeed feed)
	{
		this.feed = feed;
	}

	public ArrayList<Row> getRows()
	{
		return this;
	}

	public void setRows(final ArrayList<Row> rows)
	{
		this.addAll(rows);
	}

	public Row createRow()
	{
		Row row = new Row(this, feed);
		this.add(row);
		return row;
	}
}
