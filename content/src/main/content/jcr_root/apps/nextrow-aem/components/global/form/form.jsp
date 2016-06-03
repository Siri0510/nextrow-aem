<%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
%><%@ page import="com.nextrowaem.ReCaptchaService" %>


<% ReCaptchaService service = sling.getService(ReCaptchaService.class);
   String publickey = service.getRecaptchaPublicKey();
   String privatekey = service.getRecaptchaPrivateKey();
%>


 
<script src='https://www.google.com/recaptcha/api.js'></script>
<cq:includeClientLib categories="apps.nextrowaem"/>
<div class="Complete-form">
<form action="/bin/FormServlet" method="post" role="form">
  <div class="Internal-form">
  First-Name <input type="text" name="firstname" placeholder="First Name"><br><br>
  Last-Name <input type="text" name="lastname" placeholder="Last Name"><br><br>
 <div id="radioGroup">
  <div class="wrap" style="margin: 0 0 0 100px;">
    <label>Male</label> <input type="radio" name="gender" value="Male" style="padding-pright: 30px;" />
  </div>
  <div class="wrap" style="margin: 0 0 0 175px;">
    <label>Female</label> <input type="radio" name="gender" value="Female" />
  </div>
 </div>
  D.O.B:  <input type="date" name="bday"><br><br>
  Education <select name="groups">
  <option value="/content/dam/degrees/download (2).jpg">Masters</option>
  <option value="/content/dam/degrees/degreesspec-ed.jpg">Bachelors</option>
  <option value="/content/dam/degrees/high-school-degree.png">High School</option>
  </select><br><br>
  E-mail   <input type="text" id="email" name="email" placeholder="*Email ID" required /><br><br><br>
  <div class="formElement">
  	
  	<div class="g-recaptcha" data-sitekey="<%= publickey %>"></div>
  	<div class="g-recaptcha" data-sitekey="<%= privatekey %>"></div>
  </div>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
 </div>
</form>
</div>