package net.infogram.api.content.feed;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.beans.Transient;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect
public class Row extends ArrayList<String>
{
  @JsonIgnore
	private Sheet sheet;
	@JsonIgnore
	private JsonFeed feed;


	@JsonIgnore
	public Row(final Sheet sheet, final JsonFeed jsonFeed)
	{
		this.sheet = sheet;
		this.feed = jsonFeed;
	}

	public ArrayList<String> getData()
	{
		return this;
	}

	public void setData(final ArrayList<String> data)
	{
		this.addAll(data);
	}

	public Row addData(final String value)
	{
		this.add(value);
		return this;
	}

	public Row newRow()
	{
		Row row = new Row(sheet, feed);
		sheet.add(row);
		return row;
	}

	public Sheet newSheet()
	{
		Sheet sheet = new Sheet(feed);
		feed.add(sheet);
		return sheet;
	}

}
