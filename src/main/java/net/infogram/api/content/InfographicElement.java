package net.infogram.api.content;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * User: Jorge
 * Date: 7.1.2016
 * Time: 15:21
 * Copyright Surveypal Ltd 2016
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE,defaultImpl = JsonTypeInfo.None.class)
public abstract class InfographicElement
{
}
