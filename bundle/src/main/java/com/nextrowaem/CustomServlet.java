package com.nextrowaem;

import java.io.IOException;
//import java.io.PrintWriter;
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
			   paths = {"/bin/FruitsServlet"})

public class CustomServlet extends SlingSafeMethodsServlet{
	   
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
			for(int i=0; i<fruits.size();i++){
				jsonwriter.object();
				jsonwriter.key("text");
				jsonwriter.value(fruits.get(i));
				jsonwriter.key("value");
				jsonwriter.value(image.get(i));
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
	private List<String> fruits = new ArrayList<String>();{
	    fruits.add("Apple");
	    fruits.add("Oranges"); 
	    fruits.add("Mango"); 
	    fruits.add("Grapes"); 
	    fruits.add("Guava"); 
	    fruits.add("Kiwi"); 
	    fruits.add("Pineapple"); 
	    fruits.add("Watermelon"); 
	    fruits.add("Papaya"); 
	    fruits.add("Banana");     
	}  
	public List<String> getStates(){
	    return this.fruits;
	}
	
	private List<String> image = new ArrayList<String>();{
		image.add("Apple");
		image.add("/content/dam/BootFruits/oranges.jpg"); 
		image.add("/content/dam/BootFruits/african-mango-review.jpg"); 
		image.add("/content/dam/BootFruits/grapes.jpg"); 
		image.add("/content/dam/BootFruits/guava-stock-2-600x600.jpg"); 
		image.add("/content/dam/BootFruits/17bd362a09149093ea78e76f9cb69a68.jpg"); 
		image.add("/content/dam/BootFruits/pineapple.jpg"); 
		image.add("/content/dam/BootFruits/isolated-slice-of-watermelon_w6khuv.jpg"); 
		image.add("/content/dam/BootFruits/papaya.jpg"); 
		image.add("/content/dam/BootFruits/download (1).jpg");     
	}  
	public List<String> getFruits(){
	    return this.image;
	}


}
