package net.infogram.api.content;

import com.google.common.base.Preconditions;
import net.infogram.api.InfogramAPI;
import net.infogram.api.content.infographic.InfograhicInfo;
import net.infogram.api.response.Response;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Jorge Garcia
 * Date: 1/17/2016
 * Time: 1:11 PM
 * Copyright Surveypal Ltd 2016
 */
public class InfogramAPIMethods
{
	private enum HttpMethod
	{
		GET, POST, PUT, DELETE
	}

	final private String THEME_ID_PARAM = "theme_id";
	final private String TITLE_PARAM = "title";
	final private String CONTENT_PARAM = "content";
	final private String PUBLISH_PARAM = "publish";
	final private String INFOGRAPIC_URL_PREFIX = "infographics";

	private InfogramAPI api;
	private Map<String, String> parameters = new HashMap<String, String>();
	private Response response;

	private static final Logger log = LoggerFactory.getLogger(InfogramAPIMethods.class);

	public InfogramAPIMethods(final String key, final String secret)
	{
		this.api = new InfogramAPI(key, secret);
	}

	public InfogramAPIMethods setThemeID(final int id)
	{
		parameters.put(THEME_ID_PARAM, String.valueOf(id));
		return this;
	}

	public InfogramAPIMethods setTitle(final String title)
	{
		parameters.put(TITLE_PARAM, title);
		return this;
	}

	public InfogramAPIMethods setContent(final String content)
	{
		parameters.put(CONTENT_PARAM, content);
		return this;
	}

	public InfogramAPIMethods setPublish(final boolean publish)
	{
		parameters.put(PUBLISH_PARAM, String.valueOf(publish));
		return this;
	}

	public InfogramAPIMethods updateInforgraphic(final String infogramID)
	{

		Preconditions.checkNotNull(parameters.get(CONTENT_PARAM), MessageFormat.format("Content is empty", parameters));
		Preconditions.checkArgument(infogramID != null && !infogramID.isEmpty(), MessageFormat.format("No Infogram ID provided", parameters));
		Preconditions.checkArgument(parameters.get(TITLE_PARAM) == null, "Title should not be set when updating an infographic");
		Preconditions.checkArgument(parameters.get(PUBLISH_PARAM) == null, "Publish parameter should not be set when updating an infographic");

		try
		{
			handleResponse(api.sendRequest(HttpMethod.PUT.name(), new StringBuilder().append(INFOGRAPIC_URL_PREFIX)
			                                                                         .append("/")
			                                                                         .append(infogramID)
			                                                                         .toString(), parameters));
		}
		catch (IOException e)
		{
			log.error("There was a problem connecting to the server");
			e.printStackTrace();
		}
		return this;
	}

	public InfograhicInfo getInforgraphicInfo(final String infogramID) throws IOException
	{
		Preconditions.checkArgument(infogramID != null && !infogramID.isEmpty(), MessageFormat.format("No Infogram ID provided", parameters));
		try
		{
			handleResponse(api.sendRequest(HttpMethod.GET.name(), new StringBuilder().append(INFOGRAPIC_URL_PREFIX)
			                                                                         .append("/")
			                                                                         .append(infogramID)
			                                                                         .toString(), null));

		}
		catch (IOException e)
		{
			log.error("There was a problem connecting to the server");
			e.printStackTrace();
		}
		return ContentObjectMapper.unmarshallJson(InfograhicInfo.class, getResponseBody());
	}

	private void handleResponse(final Response response) throws IOException
	{
		Preconditions.checkNotNull(response, "Response is null");
		if (response.isSuccessful())
		{
			this.response = response;
		}
		else
		{
			InputStream is = response.getResponseBody();
			String errmsg = String.format("The server returned %d %s content %s", response.getHttpStatusCode(), response.getHttpStatusMessage(), IOUtils.toString(is, Charset.defaultCharset()));
			log.error(errmsg);
		}
	}

	public boolean isSuccessful()
	{
		Preconditions.checkNotNull(response, "Response is null");
		return response.isSuccessful();
	}

	public String getResponseBody() throws IOException
	{
		Preconditions.checkNotNull(response, "Response is null");
		return IOUtils.toString(response.getResponseBody(), Charset.defaultCharset());
	}

}
