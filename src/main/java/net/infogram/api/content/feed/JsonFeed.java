package net.infogram.api.content.feed;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect
public class JsonFeed extends ArrayList<Sheet>
{

	public ArrayList<Sheet> getSheets()
	{
		return this;
	}

	public void setSheets(final ArrayList<Sheet> sheets)
	{
		this.addAll(sheets);
	}

	public Sheet createSheet()
	{
		Sheet sheet = new Sheet(this);
		this.add(sheet);
		return sheet;
	}
}
