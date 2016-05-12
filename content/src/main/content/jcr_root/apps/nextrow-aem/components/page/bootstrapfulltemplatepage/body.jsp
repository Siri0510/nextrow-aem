<%--

  Bootstrap Template Page component.

  this is a bootstrap template page for bootstrap template

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	// TODO add you code here
%>
<cq:include script="/libs/wcm/core/components/init/init.jsp"/>
<body>
	<div><cq:include script = "header.jsp"/></div>
    <div><cq:include script = "content.jsp"/></div>
    <div><cq:include script = "footer.jsp"/></div>
</body>