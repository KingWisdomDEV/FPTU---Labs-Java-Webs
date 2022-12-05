<%-- 
    Document   : error
    Created on : Jan 24, 2021, 4:28:35 PM
    Author     : hoang
--%>

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
            
            <div class="container-fluid content-wrapper" id="content" style="height: 350px;"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <h3>${requestScope.error}</h3>
                    </div>
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <!-- this is the Footer Wrapper -->
            <%@include file="common/footer.jsp" %>
        </div>
    </body>
</html>