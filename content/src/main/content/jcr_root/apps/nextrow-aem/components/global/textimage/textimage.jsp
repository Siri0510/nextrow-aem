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

String text = properties.get("title1"," ");
String path = properties.get("path"," ");
String textarea = properties.get("area", " ");

%>
<div style="margin: 5px; margin-weight: solid; display:inline-block;">
 <img src="<%=path%>" />
 <h1 style="color:red"><%=text%></h1>
 <p style="color: blue"><%=textarea%></p>
</div>
