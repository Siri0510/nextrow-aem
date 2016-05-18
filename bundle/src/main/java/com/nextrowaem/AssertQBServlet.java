/*package com.nextrowaem;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;
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

/*public class QueryServlet extends SlingSafeMethodsServlet {
	private Logger log = LoggerFactory.getLogger(QueryServlet.class);
	ResourceResolver resourceResolver;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		log.info("/////inside the queryServelet");
		try {
			log.info("@@@@@@@@@@@@@@@request  : " + request);
			resourceResolver = request.getResourceResolver();
			Session session = request.getResourceResolver().adaptTo(Session.class);
		    ValueFactory valueFactory = null;
			Calendar calendar = Calendar.getInstance();
			int deletion_days = 7;
			calendar.add(Calendar.DATE, deletion_days);
			log.info("^^^calender" +calendar);
			log.info("^^^calenderdate" +Calendar.DATE);
			//String expiredUpperBound = session.valueFactory.createValue(calendar).toString();
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", "/content/boot"); 
			map.put("type", "cq:PageContent");
			map.put("daterange.property", "date");
			map.put("daterange.lowerBound", "-20d");
			map.put("daterange.upperBound", "valueFactory.createValue(calendar)");
			map.put("daterange.p.or","true");
			map.put("orderby", "@jcr:content/cq:lastModified");
			map.put("orderby.sort", "desc");
			map.put("p.limit", "-1");

			PredicateGroup predicate = PredicateGroup.create(map);
			QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
			Query query = queryBuilder.createQuery(predicate, resourceResolver.adaptTo(Session.class));

			TidyJSONWriter tidyJSONWriter = new TidyJSONWriter(response.getWriter());

			String resultTitle = null, resultTemplate = null;
			tidyJSONWriter.array();
			ValueMap props;
			for (Hit hit : query.getResult().getHits()) {
				
				  String Pagepath = "/content/geometrixx/en"; //This would be your page path
				  Resource r = resourceResolver.getResource(Pagepath+"/"+JcrConstants.JCR_CONTENT);
				  Node n = r.adaptTo(Node.class);

				props = resourceResolver.getResource(hit.getPath()).adaptTo(ValueMap.class);
				resultTitle = props.get("jcr:title").toString();
				resultTemplate = props.get("cq:template").toString();
				tidyJSONWriter.object();
				tidyJSONWriter.key("title");
				tidyJSONWriter.value(resultTitle);
				tidyJSONWriter.key("template");
				tidyJSONWriter.value(resultTemplate);
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
}*/