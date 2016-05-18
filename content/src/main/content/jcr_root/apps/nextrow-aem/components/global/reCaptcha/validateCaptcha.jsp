<%@include file="/libs/foundation/global.jsp"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.*" %>
<%
 ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
 reCaptcha.setPrivateKey("<Private Key>");
 String remoteAddr =  request.getParameter("remoteAddr");
 String challenge = request.getParameter("recaptcha_challenge_field");
 String uresponse = request.getParameter("recaptcha_response_field");
 ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
 
 if (reCaptchaResponse.isValid()) {
    out.print("true");
    log.info("valid capticha");
 } else {
    out.print("false");
    log.info("invalid capticha");
 }
 
%>