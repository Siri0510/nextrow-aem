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
%>
<cq:includeClientLib categories="apps.nextrowaem"/>
<div class="menu">
            <h3>${properties.first}</h3>
            <div class="p1">
                <p>${properties.position}</p>
            </div>
            <h3 style="background-color: #${properties.color2}">${properties.states1}</h3>
            <div class="p2">
                <p><img style = "height: 50px; width: 50px; margin: auto 20px;" src = "${properties.fruits1}"/></p>
            </div>
            <h3 style="background-color: #${properties.color3}">${properties.states}</h3>
            <div class="p3">
                <p><img style = "height: 50px; width: 50px;" src = "${properties.fruits}"/></p>
            </div>
            <h3 style="background-color: #${properties.color3}">${properties.states2}</h3>
            <div class="p3">
                <p><img style = "height: 50px; width: 50px;" src = "${properties.fruits2}"/></p>
            </div>
</div>
    	 	



