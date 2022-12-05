<%-- 
    Document   : index
    Created on : Jan 5, 2021, 2:53:19 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Front page - Trekking and Hiking</title>
        <%@include file="Common/head.jsp" %>
    </head>
    <body data-pid="411013668" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="Common/header.jsp" %> <!-- this is the Header Wrapper -->
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <h4>Exception is: ${requestScope.error}</h4>
                                </div>
                            </div>
                        </div>
                        <%@include file="Common/social-network.jsp" %><!-- this is the Social Network Tile -->
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="Common/footer.jsp" %><!--this is the Footer Wrapper--> 
        </div>
    </body>
</html>
