package com.nextrowaem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

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
@SlingServlet(generateService = true, generateComponent = true, metatype = true, methods = { "GET" }, paths = {
		"/bin/QueryServlet" })
public class QueryServlet extends SlingSafeMethodsServlet {
	private Logger log = LoggerFactory.getLogger(QueryServlet.class);
	ResourceResolver resourceResolver;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		log.info("/////inside the queryServelet");
		try {
			log.info("@@@@@@@@@@@@@@@request  : " + request);
			resourceResolver = request.getResourceResolver();

			Map<String, String> map = new HashMap<String, String>();
			map.put("path", "/content/boot");
			map.put("type", "nt:unstructured");
			map.put("property", "sling:resourceType");
			map.put("property.value", "nextrow-aem/components/page/bootstraptemplatepage");
			map.put("p.limit", "-1");

			PredicateGroup predicate = PredicateGroup.create(map);
			QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
			Query query = queryBuilder.createQuery(predicate, resourceResolver.adaptTo(Session.class));

			TidyJSONWriter tidyJSONWriter = new TidyJSONWriter(response.getWriter());

			String resultTitle = null, resultTemplate = null;
			tidyJSONWriter.array();
			Node individualNode;
			ValueMap props;
			for (Hit hit : query.getResult().getHits()) {

				individualNode = resourceResolver.getResource(hit.getPath()).adaptTo(Node.class);
				resultTitle = individualNode.getProperty("jcr:title").getString();
				resultTemplate = individualNode.getProperty("cq:template").getString();
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
}