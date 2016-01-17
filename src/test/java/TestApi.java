import junit.framework.TestCase;
import net.infogram.api.InfogramAPI;
import net.infogram.api.content.ContentObjectMapper;
import net.infogram.api.content.InfogramAPIMethods;
import net.infogram.api.content.InfographicContent;
import net.infogram.api.content.InfographicElement;
import net.infogram.api.content.body.Body;
import net.infogram.api.content.chart.Chart;
import net.infogram.api.content.chart.Row;
import net.infogram.api.content.chart.Sheet;
import net.infogram.api.content.h1.HeadlineOne;
import net.infogram.api.content.infographic.InfograhicInfo;
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
import java.util.ArrayList;
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

	@Ignore
	@Test
	public void testJsonGeneration() throws Exception
	{
		log.info("Testing content generation");
		final String jsonContent = createDummyJsonContent(true);
		System.out.println(jsonContent);
		assertEquals(MessageFormat.format("Generated json is not valid: \n [{0}]", jsonContent), isJSONValid(jsonContent), true);
		assertEquals(MessageFormat.format("Generated json contains type reference: \n [{0}]", jsonContent), jsonContent.contains("net.infogram.api") || jsonContent.contains("java."), false);
		InfographicContent content = ContentObjectMapper.unmarshallJson(InfographicContent.class, jsonContent);;
		assertNotNull("Deserialized object is null: ",content);
		log.info("Success!");
	}

	@Ignore
	@Test
	public void testGetChartInfo() throws Exception
	{
		log.info("Testing GET infographic data");
		InfogramAPIMethods apiMethods = new InfogramAPIMethods(KEY,SECRET);
		InfograhicInfo info = apiMethods.getInforgraphicInfo(infogramID);
		assertNotNull(info);

	}

	@Ignore
	@Test
	public void testUpdateChart() throws Exception
	{
		log.info("Testing update infogram method");

		InfogramAPIMethods apiMethods = new InfogramAPIMethods(KEY,SECRET);
		apiMethods.setThemeID(apiMethods.getInforgraphicInfo(infogramID).getThemeId());
		apiMethods.setContent(createDummyJsonContent(false));
		apiMethods.updateInforgraphic(infogramID);
		assertTrue(apiMethods.isSuccessful());
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
		String value1 = String.valueOf(Math.random() * 100);
		String value2 = String.valueOf(Math.random() * 100);
		String value3 = String.valueOf(Math.random() * 100);

		content.add(new HeadlineOne().setText("some headline" + value1));
		content.add(new Body().setText("some body"));

		Chart myChart = new Chart();
		myChart.setChartType("progress-gauge");
		Sheet myChartSheet = new Sheet().addHeader("Name")
		                                .addHeader("Someone 1")
		                                .addHeader("Someone 2")
		                                .addHeader("Someone 3")
		                                .addRow(new Row().setDataElement(String.valueOf(0))
		                                                 .setDataElement(String.valueOf(0))
		                                                 .setDataElement(String.valueOf(0))
		                                                 .setDataHeader("MIN"))
		                                .addRow(new Row().setDataElement(String.valueOf(100))
		                                                 .setDataElement(String.valueOf(100))
		                                                 .setDataElement(String.valueOf(100))
		                                                 .setDataHeader("MAX"))
		                                .addRow(new Row().setDataElement(value1)
		                                                 .setDataElement(value2)
		                                                 .setDataElement(value3)
		                                                 .setDataHeader("VALUE"))
		                                .addRow(new Row().setDataElement(value1)
		                                                 .setDataElement(value2)
		                                                 .setDataElement(value3)
		                                                 .setDataHeader("LABEL"));
		myChart.setDataSheet(myChartSheet);
		content.add(myChart);
		return ContentObjectMapper.marshallJson(content, pretty);
	}
}
