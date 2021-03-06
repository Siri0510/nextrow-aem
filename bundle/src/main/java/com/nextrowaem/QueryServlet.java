package com.nextrowaem;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.ValueFactory;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.TidyJSONWriter;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;

@SuppressWarnings("serial")
@SlingServlet(generateService = true, 
			  generateComponent = true, 
			  metatype = true, 
			  methods = { "GET" }, 
			  paths = {"/bin/QueryServlet" })

public class QueryServlet extends SlingSafeMethodsServlet {
	private Logger log = LoggerFactory.getLogger(QueryServlet.class);
	ResourceResolver resourceResolver;
	ValueFactory valueFactory;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		log.info("/////inside the queryServelet");
		try {
			log.info("@@@@@@@@@@@@@@@request  : " + request);
			resourceResolver = request.getResourceResolver();
			Session session = resourceResolver.adaptTo(Session.class);
			Calendar calendar = Calendar.getInstance();
		    calendar.add(Calendar.DATE, -7);
		    String expiredDateUpperBound = session.getValueFactory().createValue(calendar).toString();
//     		Calendar calendar = Calendar.getInstance();
//    		calendar.add(Calendar.DATE, -7);
//			log.info("^^^calenderdate" +Calendar.DATE);
//			Value x = valueFactory.createValue(calendar);
//			log.info("^^^calenderdatevalue"+x);
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", "/content/boot"); 
			map.put("type", "cq:PageContent");
			map.put("daterange.property", "cq:lastModified");
			map.put("daterange.lowerBound", expiredDateUpperBound);
			map.put("orderby", "@jcr:content/cq:lastModified");
			map.put("orderby.sort", "desc");
			map.put("p.limit", "-1");

			PredicateGroup predicate = PredicateGroup.create(map);
			QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
			Query query = queryBuilder.createQuery(predicate, resourceResolver.adaptTo(Session.class));

			TidyJSONWriter tidyJSONWriter = new TidyJSONWriter(response.getWriter());

			String resultTitle = null, resultTemplate = null, resultDate = null;
			tidyJSONWriter.array();
			ValueMap props;
			for (Hit hit : query.getResult().getHits()) {

				props = resourceResolver.getResource(hit.getPath()).adaptTo(ValueMap.class);
				resultTitle = props.get("jcr:title").toString();
				resultTemplate = props.get("cq:template").toString();
				resultDate = props.get("cq:lastModified").toString();
				tidyJSONWriter.object();
				tidyJSONWriter.key("title");
				tidyJSONWriter.value(resultTitle);
				tidyJSONWriter.key("template");
				tidyJSONWriter.value(resultTemplate);
				tidyJSONWriter.key("Date");
				tidyJSONWriter.value(resultDate);
				tidyJSONWriter.endObject();
			}
			tidyJSONWriter.endArray();
		} catch (Exception e) {
			log.error("Error parsing slection" + e);
		} finally {
			response.getWriter().flush();
			response.getWriter().close();
		}
	}
}