<%--

  Text Image component.

  this is a text image component

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<% 

//String text = properties.get("title"," ");
//String text1 = properties.get("title1"," ");
//String textarea = properties.get("area", " ");
//String image = properties.get("imageReference", " ");
//String img = properties.get("imageReferences")

%>
<cq:includeClientLib categories="apps.nextrowaem"/>
<div class="hero-wrap" style="background-image: url(${properties.imageReference}); width: 100%;">
<div class="text-container">
<div class="text-wrap" style="${properties.position}">
	<div class="titletext-box">
		<h5>${properties.title}</h5>
		<h2> ${properties.subtitle}</h2>
	</div>
 	<div class="desc-style">
	 	<p>${properties.description}</p>
	</div>
</div>
</div>
</div>
