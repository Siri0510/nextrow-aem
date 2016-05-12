<%--
  Form Details component.
  form details
--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%@page import="com.day.cq.wcm.foundation.Image,
				org.apache.sling.api.resource.ResourceResolver,
				com.day.cq.wcm.api.Page,
				com.day.cq.dam.api.Asset"%>
<cq:includeClientLib categories="apps.nextrowaem"/>				
<div class="form-info">
<h1 style="text-align:center;">THANK YOU!</h1>
<h2 style=" color: violet;">Student Information</h2>
<div class="container">
<div>First Name : ${properties.firstName}</div>
<div>Last Name : ${properties.lastName}</div>
<div>Email : ${properties.email}</div>
<div>Education: <img style = "height: 150px; width: 150px;" src = "${properties.groups}"/></div>
</div>
</div>
