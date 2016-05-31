<%@include file="/libs/foundation/global.jsp"%>
<%@page import="net.tanesha.recaptcha.*;" %>

<%
    //Getting remote ip address to validate catpcha 
    String ipAddress = request.getHeader("X-FORWARDED-FOR");  
    if (ipAddress == null) {  
   ipAddress = request.getRemoteAddr();  
   } 

 %>
    <input type="hidden" value="<%=ipAddress%>" id="remoteIPAdderess" >
    <input type="hidden" value="<%=currentNode.getPath()%>" id="curNodePath" >
    <% ReCaptcha reCaptcha = ReCaptchaFactory.newReCaptcha("6LeHaSATAAAAACXsz7QWJd8Bq9OMUze93DLifBwI", "6LeHaSATAAAAAPTHleCmEnQJh_zQ5li9y8FLXxs7", false); %>
    
    <h1 id="page-title" class="title">Google reCaptcha</h1>
    <form accept-charset="UTF-8" id="testCaptcha" method="post" action="" class="contact-press-form ajax-form">
        <div id= "gooleCaptcha">
            <input type="hidden" value="form-U5ArplaaF5MKYCMnyZkQDZfvXEy7bO7JLc5e6VCKses"  name="form_build_id"> 
            <input type="hidden" value="apollocontactpress_contact_form" name="form_id">
    
            <fieldset class="captcha form-wrapper">
                <legend>
                    <span class="fieldset-legend">CAPTCHA</span>
                </legend>
                <div class="fieldset-wrapper form-item form-item-captcha">
                    <%=reCaptcha.createRecaptchaHtml(null, "clean", null) %>
                    <div class="error-message"></div>
                </div>
            </fieldset>
            <input type="button" id="test" class='testCaptcha' value="test">
        </div>
    </form>

<script>

$(function() { 
  
  $('#gooleCaptcha').on('click','.testCaptcha',function(){
       alert("redy captch integration");
       var cpatchaFlag = false;
        var remoteIP=$('#remoteIPAdderess').val();
        var currentNodePath = $("#curNodePath").val();         
        var captchaField = $('#recaptcha_response_field');
        var capResponse=$('#recaptcha_response_field').val();
        var capChallange=$('#recaptcha_challenge_field').val();                 
        var captchValUrl=currentNodePath+'.validatecaptcha.html';
        if($.trim(capResponse).length === 0){
   alert("response is empty");
  }else{  
            var isValidCaptcha="";
            $.ajax({                          
                url: captchValUrl,
                async: false,
                data: {'remoteAddr':remoteIP,'recaptcha_response_field' : capResponse,'recaptcha_challenge_field':capChallange},
                success: function (response, status, xml) {
                    isValidCaptcha=response;
                }
            });
            
            if($.trim(isValidCaptcha) === 'true'){ 
                alert("valid captcha");
                $('#recaptcha_response_field').css({border : '1px solid black !important'});
            }else{
                alert("invalid captcha");
                $('#recaptcha_response_field').css({border : '1px solid red !important'});
            }
            
        }
  });  
});
</script>
