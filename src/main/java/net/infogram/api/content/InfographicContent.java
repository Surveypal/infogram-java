package net.infogram.api.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jorge
 * Date: 7.1.2016
 * Time: 14:10
 * Copyright Surveypal Ltd 2016
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfographicContent extends ArrayList<InfographicElement>
{

	@JsonUnwrapped
	public ArrayList<InfographicElement> getInfographicContent()
	{
		return this;
	}

	@JsonUnwrapped
	@JsonDeserialize(contentAs = InfographicElement.class)
	public void setInfographicContent(List<InfographicElement> infographicContent)
	{
		this.addAll(infographicContent);
	}

}
