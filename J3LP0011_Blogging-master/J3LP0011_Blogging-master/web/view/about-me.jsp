<%-- 
    Document   : about-me
    Created on : Jan 25, 2021, 9:09:54 AM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Me - Blogging about my life</title>
        <%@include file="common/head.jsp" %>     
    </head>
    <body data-pid="422328565" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->     
            <%@include file="common/header.jsp" %>

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <script>
                document.querySelector('#header #topMenu > li:nth-child(2)').className = "active";
                document.querySelector('#header #topMenu > li:nth-child(1)').className = "";
            </script>
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <c:set var="contact" value="${requestScope.contact}"/>
                                    <div class="section article">
                                        <div class="heading">
                                            <h3>About Me</h3>
                                        </div>

                                        <div class="content">
                                            <p><span>${contact.description}</span></p>    
                                        </div>
                                    </div>
                                    <div class="section signature">
                                        <div class="content">

                                            <div class="signature-text-noimg">
                                                <p>Kind regards</p>
                                                <div class="signature-sign" style="font-family: Pacifico,serif;">
                                                    ${contact.author}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@include file="common/social-network.jsp" %>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="common/footer.jsp" %>
        </div>

    </body>
</html>