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
            <script>
                document.querySelector('#header #topMenu > li:nth-child(1)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <div class="section">
                                        <div class="content">
                                            <ul class="thumbnails column-article-section">
                                                <c:forEach items="${requestScope.listObjCat}" var="listCat" >
                                                    <li class="span4">
                                                        <div class="img-simple span12 ">
                                                            <div class="image">
                                                                <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/b3/4e/285697106401250995/i285697114341417227._szw1280h1280_.jpg">
                                                                    <img src="${listCat.image}">
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <h4>
                                                            <a rel="nofollow" href="${listCat.link}">${listCat.name}</a>
                                                        </h4>
                                                        <p>${listCat.short_desc}</p>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <c:forEach items="${requestScope.listObj}" var="list" >
                                        <div class="section article">
                                            <div class="content">
                                                <div class="img-simple span12 ">
                                                    <div class="image">
                                                        <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/b3/4e/285697106401250995/i285697114341417188._szw1280h1280_.jpg">
                                                            <img src="${list.image}"></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="section article">
                                            <div class="heading">
                                                <h3>${list.title}</h3>
                                            </div>
                                            <div class="content">
                                                <p>
                                                    <span>${list.description}</span>
                                                </p>    
                                            </div>
                                        </div>
                                    </c:forEach>
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
