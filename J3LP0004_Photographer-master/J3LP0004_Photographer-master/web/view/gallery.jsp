<%-- 
    Document   : gallery
    Created on : Mar 1, 2021, 11:49:27 PM
    Author     : Hoang Van Tue
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Photographer - Galley</title>
        <%@include file="common/head.jsp" %>    <!-- This is Head File -->
    </head>
    <body>
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="common/header.jsp" %>  <!-- This is Header File -->

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper photo-album photo-album-exhibition">
                                <div class="heading">
                                    <h1 class="page-title">Gallery ${param.groupGallery}</h1>
                                </div>

                                <div class="content"> <!-- Slideshow -->
                                    <c:set var="listObj" value="${requestScope.listObj}"/>
                                    <c:set var="listSize" value="${listObj.size()}"/>
                                    <c:set var="maxRow" value="${(listSize - 1) / 4}"/>
                                    <div class="section">
                                        <div class="content">
                                            <div class="slideshow"  data-ss="albumslideshow">
                                                <img id="btn-play"  src="/kingphotos.com/view/images/play.png"/>
                                                <img id="show-img" src="${listObj.get(i).image}">
                                                <img id="btn-pause" style="display: none" src="/kingphotos.com/view/images/pause.png"/>
                                            </div>                   
                                        </div>
                                    </div>
                                    <div class="section"> 
                                        <div class="content">
                                            <c:forEach begin="0" end="${maxRow}" var="row">
                                                <ul class="thumbnails" data-ss="">
                                                    <c:forEach begin="${row*4}" end="${((row*4 + 3) < listSize - 1) ? (row*4 + 3) : (listSize - 1)}" var="i">
                                                        <li class="span3">
                                                            <div>
                                                                <div class="thumbnail">&nbsp;
                                                                    <a rel="nofollow" href="">
                                                                        <img alt="${listObj.get(i).title}" src="${listObj.get(i).image}">
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </li>                                                
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="pagination mt30  pull-right" >
                                        <c:set var="pageNum" value="${(param.page != null&& param.page.matches('^[0-9+]$')) ? param.page : 1}"/>
                                        <c:set var="startPage" value="${requestScope.startPage}"/>
                                        <c:set var="endPage" value="${requestScope.endPage}"/>
                                        <c:set var="totalPage" value="${requestScope.totalPage}"/>
                                        <!--Nếu số bản ghi không hiển thị hết trong cùng 1 trang thì hiển thị paging-->
                                        <c:if test="${totalPage gt 1}">
                                            <a href="gallery?page=1&groupGallery=${param.groupGallery}">&laquo;</a>
                                            <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i"> 
                                                <a class="${(pageNum eq i) ? "active" : ""}" href="gallery?page=${i}&groupGallery=${param.groupGallery}">${i}</a>
                                            </c:forEach> 
                                            <a href="gallery?page=${totalPage}&groupGallery=${param.groupGallery}">&raquo;</a>
                                        </c:if>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <%@include file="common/social-network.jsp" %>  <!-- This is Social Network File -->

                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="common/footer.jsp" %>      <!-- This is Footer File -->

        </div>
    </body>
</html>