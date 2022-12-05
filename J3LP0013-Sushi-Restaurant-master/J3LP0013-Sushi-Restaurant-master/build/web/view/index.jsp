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
            <script>
                document.querySelector('#header #topMenu > li:nth-child(1)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <div class="section article">
                                        <div class="content">
                                            <div class="img-simple span12 ">
                                                <div class="image " >
                                                    <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/eb/15/282319406464701931/i282319414620330848._szw1280h1280_.jpg">
                                                        <img src="/sushi-king.com/view/image/home1.jpg">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:forEach items="${requestScope.listObj}" var="article">
                                        <div class="section article">
                                            <div class="heading">
                                                <h3>${article.title}</h3>
                                            </div>

                                            <div class="content">
                                                <div class="img-simple span6 pull-left">
                                                    <div class="image">
                                                        <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/eb/15/282319406464701931/i282319414620340695._szw1280h1280_.jpg"><img src="${article.image}"></a>
                                                    </div>
                                                </div>
                                                <p><span>${article.description}</span></p>    </div>
                                        </div>
                                    </c:forEach>
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