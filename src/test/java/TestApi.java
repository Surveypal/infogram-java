import junit.framework.TestCase;
import net.infogram.api.InfogramAPI;
import net.infogram.api.content.ContentObjectMapper;
import net.infogram.api.content.InfographicContent;
import net.infogram.api.content.body.Body;
import net.infogram.api.content.chart.Chart;
import net.infogram.api.content.chart.Row;
import net.infogram.api.content.chart.Sheet;
import net.infogram.api.content.h1.HeadlineOne;
import net.infogram.api.response.Response;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Jorge
 * Date: 7.1.2016
 * Time: 13:10
 * Copyright Surveypal Ltd 2016
 */
@RunWith(JUnit4.class)
public class TestApi extends TestCase
{

	private static final Logger log = LoggerFactory.getLogger(TestApi.class);
  final static String KEY = System.getProperty("KEY");
	final static String SECRET = System.getProperty("SECRET");
	final static String infogramID = System.getProperty("INFOGRAM_ID");

	@Test
	public void testJsonGeneration() throws Exception
	{
		log.info("Testing content generation");
		final String jsonContent = createDummyJsonContent(true);
		System.out.println(jsonContent);
		assertEquals(MessageFormat.format("Generated json is not valid: \n [{0}]", jsonContent), isJSONValid(jsonContent), true);
		assertEquals(MessageFormat.format("Generated json contains type reference: \n [{0}]", jsonContent), jsonContent.contains("net.infogram.api") || jsonContent.contains("java.") , false);
	}

	@Ignore
	@Test
	public void testGetChartInfo() throws Exception
	{
		log.info("Testing GET infographic data");

		InfogramAPI api = new InfogramAPI(KEY, SECRET);

		try {
			Response response = api.sendRequest("GET", "infographics/"+infogramID, null);

			if (response.isSuccessful()) {
				InputStream is = response.getResponseBody();
				log.info(IOUtils.toString(is, Charset.defaultCharset()));

			} else {
				String errmsg = String.format("The server returned %d %s", response.getHttpStatusCode(), response.getHttpStatusMessage());
				System.err.println(errmsg);
				InputStream is = response.getResponseBody();
				System.err.println(IOUtils.toString(is, Charset.defaultCharset()));
			}
		} catch (IOException e) {
			System.err.println("There was a problem connecting to the server");
			e.printStackTrace();
		}


	}

  @Ignore
	@Test
	public void testUpdateChart() throws Exception
	{
		log.info("Testing update infogram method");

		InfogramAPI api = new InfogramAPI(KEY, SECRET);

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("theme_id", "278");
		parameters.put("publish", "true");
		parameters.put("content", createDummyJsonContent(false));
//		parameters.put("title", "Testing API");

		try {
		  Response response = api.sendRequest("PUT", "infographics/" + infogramID, parameters);

			if (response.isSuccessful()) {
				InputStream is = response.getResponseBody();
				log.info(IOUtils.toString(is, Charset.defaultCharset()));

			} else {
				String errmsg = String.format("The server returned %d %s", response.getHttpStatusCode(), response.getHttpStatusMessage());
				System.err.println(errmsg);
				InputStream is = response.getResponseBody();
				System.err.println(IOUtils.toString(is, Charset.defaultCharset()));
			}
		} catch (IOException e) {
			System.err.println("There was a problem connecting to the server");
			e.printStackTrace();
		}


	}

	private boolean isJSONValid(String test)
	{
		try
		{
			new JSONObject(test);
		}
		catch (JSONException ex)
		{
			try
			{
				new JSONArray(test);
			}
			catch (JSONException ex1)
			{
				return false;
			}
		}
		return true;
	}

	private String createDummyJsonContent(boolean pretty) throws IOException
	{
		InfographicContent content = new InfographicContent();
    content.add(new HeadlineOne().setText("some headline"));
		content.add(new Body().setText("some body"));
		Chart myChart = new Chart();
		myChart.setChartType("table");
		Sheet myChartSheet = new Sheet().addHeader("Name")
		                                .addHeader("Someone 1")
		                                .addHeader("Someone 2")
			                              .addHeader("Someone 3")
		                                .addRow(new Row().setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataHeader("Somewhere 1"))
		                                .addRow(new Row().setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataHeader("Somewhere 2"))
		                                .addRow(new Row().setDataElement(String.valueOf(Math.random()*100))
		                                                 .setDataElement(String.valueOf(Math.random()*100))
	                                                   .setDataElement("äöÅffffå")
	                                                   .setDataHeader("Somewhere 3"));

		myChart.setDataSheet(myChartSheet);
		content.add(myChart);
		return ContentObjectMapper.marshallJson(content, pretty);
	}

}
