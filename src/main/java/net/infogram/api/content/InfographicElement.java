package net.infogram.api.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.infogram.api.content.body.Body;
import net.infogram.api.content.chart.Chart;
import net.infogram.api.content.h1.HeadlineOne;
import net.infogram.api.content.h1.HeadlineTwo;
import net.infogram.api.content.map.Map;
import net.infogram.api.content.quote.Quote;

/**
 * User: Jorge
 * Date: 7.1.2016
 * Time: 15:21
 * Copyright Surveypal Ltd 2016
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = JsonTypeInfo.Id.class, property = "type")
@JsonSubTypes({
	              @JsonSubTypes.Type(value = Body.class, name = "body"),
	              @JsonSubTypes.Type(value = HeadlineOne.class, name = "h1"),
	              @JsonSubTypes.Type(value = HeadlineTwo.class, name = "h2"),
	              @JsonSubTypes.Type(value = Chart.class, name = "chart"),
	              @JsonSubTypes.Type(value = Map.class, name = "map"),
	              @JsonSubTypes.Type(value = Quote.class, name = "quote")
              })
public abstract class InfographicElement
{
}
