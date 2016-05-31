<%--
  student enrollment form component.
  student enrollment form
--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
%><%@ page import="com.nextrowaem.reCaptchaService" %>


<%reCaptchaService service = sling.getService(reCaptchaService.class);

<c:set var="reCaptchaKeys" value="<%= service %>" />
<c:set var="reCaptchaMethod" value="${reCaptchaKeys.keyList}" />
<c:set var="reCaptchaPublicKey" value="${reCaptchaMethod.recaptchaPublicKey}" />
<c:set var="reCaptchaPrivateKey" value="${reCaptchaMethod.recaptchaPrivateKey}" />
 
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
  	<%--
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LeHaSATAAAAACXsz7QWJd8Bq9OMUze93DLifBwI", "6LeHaSATAAAAAPTHleCmEnQJh_zQ5li9y8FLXxs7", false);
          out.print(c.createRecaptchaHtml(null, null));
        --%>
        <%--
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("your_private_key");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          out.print("Answer was entered correctly!");
        } else {
          out.print("Answer is wrong");
        }
      --%>
  	<div class="g-recaptcha" data-sitekey="6LfFFiETAAAAACt5Kk351rnn-VXyui_c3B3vyhxB"></div>
  </div>
  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
 </div>
</form>
</div>