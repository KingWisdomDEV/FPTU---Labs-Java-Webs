<%-- 
    Document   : home
    Created on : Jan 17, 2021, 8:11:43 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Sushi Restaurant - Home </title>
        <%@include file="common/head.jsp" %>
    </head>
    <body data-pid="410907962" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <!-- this is the Header Wrapper -->
            <%@include file="common/header.jsp" %>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <h4>Error Code: 404 Not Found!</h4>
                                </div>
                            </div>
                        </div>
                        <%@include file="common/social-network.jsp" %>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <!-- this is the Footer Wrapper -->
            <%@include file="common/footer.jsp" %>
        </div>
    </body>
</html>