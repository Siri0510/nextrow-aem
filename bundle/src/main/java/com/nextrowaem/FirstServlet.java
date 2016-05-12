package com.nextrowaem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;


import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.day.cq.commons.TidyJSONWriter;


@SlingServlet( generateService = true,
			   generateComponent = true,
			   metatype = true,
			   methods = {"GET"},
			   paths = {"/bin/StatesServlet"})

public class FirstServlet extends SlingSafeMethodsServlet{
	

		   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
		ServletException, IOException{
		try{
			response.setContentType("text/plain");
			TidyJSONWriter jsonwriter = new TidyJSONWriter(response.getWriter());
			jsonwriter.array();
			for(int i=0; i<state.size();i++){
				jsonwriter.object();
				jsonwriter.key("text");
				jsonwriter.value(state.get(i));
				jsonwriter.key("value");
				jsonwriter.value(state.get(i));
				jsonwriter.endObject();
			}
			jsonwriter.endArray();
			//PrintWriter out = response.getWriter();
			//for(int i=0; i<state.size();i++){
			//JSONObject jsonobj = new JSONObject();
			//Map<String, String> map = new HashMap<String, String>();
			//map.put("text", state.get(i));
			//out.print(state.get(i));
			//}
			//out.print(text);
			
			
		}catch(Exception e){
		}finally{
			response.getWriter().flush();
			response.getWriter().close();
		}
		}
	private List<String> state = new ArrayList<String>();{
	    state.add("Alabama");
	    state.add("Alaska"); 
	    state.add("Arizona"); 
	    state.add("Arkansas"); 
	    state.add("California"); 
	    state.add("Colorado"); 
	    state.add("Connecticut"); 
	    state.add("Delaware"); 
	    state.add("Florida"); 
	    state.add("Georgia"); 
	    state.add("Hawaii"); 
	    state.add("Idaho"); 
	    state.add("Illinois"); 
	    state.add("Indiana"); 
	    state.add("Iowa"); 
	    state.add("Kansas"); 
	    state.add("Kentucky"); 
	    state.add("Louisiana"); 
	    state.add("Maine"); 
	    state.add("Maryland"); 
	    state.add("Massachusetts"); 
	    state.add("Michigan"); 
	    state.add("Minnesota"); 
	    state.add("Mississippi"); 
	    state.add("Missouri"); 
	    state.add("Montana"); 
	    state.add("Nebraska"); 
	    state.add("Nevada"); 
	    state.add("New Hampshire"); 
	    state.add("New Jersey"); 
	    state.add("New Mexico"); 
	    state.add("New York"); 
	    state.add("North Carolina"); 
	    state.add("North Dakota"); 
	    state.add("Ohio"); 
	    state.add("Oklahoma"); 
	    state.add("Oregon"); 
	    state.add("Pennsylvania"); 
	    state.add("Rhode Island"); 
	    state.add("South Carolina"); 
	    state.add("South Dakota"); 
	    state.add("Tennessee"); 
	    state.add("Texas"); 
	    state.add("Utah"); 
	    state.add("Vermont"); 
	    state.add("Virginia"); 
	    state.add("Washington"); 
	    state.add("West Virginia"); 
	    state.add("Wisconsin"); 
	    state.add("Wyoming");
	}  
	public List<String> getStates(){
	    return this.state;
	}

}
