<%--

  Text Image component.

  this is a text image component

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<cq:includeClientLib categories="apps.nextrowaem"/>
<div class="titlecard-wrap">
 <img class="tc-img" src="${properties.path}" />
 <h1 class="tc-title">${properties.title1}</h1>
 <p class="tc-description">${properties.area}</p>
</div>
