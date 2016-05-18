package com.nextrowaem;

import java.io.IOException;
//import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import com.day.cq.wcm.api.PageManager;


@SlingServlet( generateService = true,
			   generateComponent = true,
			   metatype = true,
			   methods = {"POST"},
			   paths = {"/bin/FormServlet"})

public class FormServlet extends SlingAllMethodsServlet{
	
	private Logger log = LoggerFactory.getLogger(FormServlet.class);
		   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{
		try{
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String email = request.getParameter("email");
			//String date = request.getParameter("bday");
			String education = request.getParameter("groups");
			
			ResourceResolver resourceResolver =  request.getResourceResolver();
			Session session = resourceResolver.adaptTo(Session.class);
			PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
			pageManager.create("/content/boot", firstName, "/apps/nextrow-aem/templates/bootstraptemplate", firstName, true);
			Node jcrContentNode = request.getResourceResolver().getResource("/content/boot/"+firstName+"/jcr:content").adaptTo(Node.class);
			log.info("********* JCr Content Node :"+jcrContentNode);
			Node parNode = jcrContentNode.addNode("par","nt:unstructured");
			session.save();
			log.info("********** sirishanode : "+parNode);
			//parNode.setProperty("jcr:primaryType", "nt:unstructured");
			parNode.setProperty("sling:resourceType", "foundation/components/parsys");
			//parNode.setProperty("firstName", firstName);
			//parNode.setProperty("lastName", lastName);
			//parNode.setProperty("email", request.getParameter("email"));
			
			Node studentNode = parNode.addNode("forminfo","nt:unstructured");
			
			studentNode.setProperty("sling:resourceType", "nextrow-aem/components/global/formInfo");
			studentNode.setProperty("firstName", firstName);
			studentNode.setProperty("lastName", lastName);
			studentNode.setProperty("email", email);
			studentNode.setProperty("groups", education);
			session.save();	
			
		//	sling api vs jcr api
			
			
			//Node cq5 api
			/*student  --pagename
				/jcr:content -page content node
					/par  -parsys---
						/student  -componetnt
		
			/*response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print(firstName);
			out.print(lastName);
			out.print(email);
			out.print(date);
			out.print(education);*/
			//PrintWriter out = response.getWriter();
			//for(int i=0; i<state.size();i++){
			//JSONObject jsonobj = new JSONObject();
			//Map<String, String> map = new HashMap<String, String>();
			//map.put("text", state.get(i));
			//out.print(state.get(i));
			//}
			//out.print(text);
			//String redirect = "/content/geometrixx/en/toolbar.html";
			response.sendRedirect("/content/boot/"+firstName+".html");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

}
