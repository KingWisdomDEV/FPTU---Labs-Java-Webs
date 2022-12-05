<%-- 
    Document   : index
    Created on : Jan 25, 2021, 9:09:12 AM
    Author     : hoang
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>My Blog - Blogging About My Life</title>
        <%@include file="common/head.jsp" %>
    </head>
    <body data-pid="422328564" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="common/header.jsp" %>

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper blog">
                                <div class="heading">
                                    <h1 class="page-title">My Blog</h1>
                                </div>

                                <div class="content">
                                    <c:forEach items="${requestScope.listObj}" var="blog">
                                        <div class="section">
                                            <div class="content">
                                                <c:choose>
                                                    <c:when test="${blog.type eq 'article'}">
                                                        <div class="avatar">
                                                            <i class="icon-pencil icon-4x" title="${blog.title}"></i>
                                                        </div>
                                                        <div class="item">
                                                            <div class="controls">
                                                                <span class="date-text"><fmt:formatDate pattern="dd-MM-yyyy" value="${blog.created_at}"/></span>
                                                            </div>
                                                            <div class="heading">
                                                                <h4><a rel="nofollow" href="detail?id=${blog.id}">${blog.title}</a></h4>
                                                            </div>

                                                            <div class="content">
                                                                <div class="img-simple span6 pull-left">
                                                                    <div class="image">
                                                                        <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979646._szw1280h1280_.jpg">
                                                                            <img src="${blog.image}"></a>
                                                                    </div>
                                                                </div>

                                                                <p>${blog.description}</p>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${blog.type eq 'quote'}">
                                                        <div class="avatar">
                                                            <i class="icon-quote-left icon-4x" title="${blog.title}"></i>
                                                        </div>
                                                        <div class="item">
                                                            <div class="controls">
                                                                <span class="date-text"><fmt:formatDate pattern="dd-MM-yyyy" value="${blog.created_at}"/></span>
                                                            </div>
                                                            <div class="heading">
                                                                <h4><a rel="nofollow" href="detail?id=${blog.id}">${blog.title}</a></h4>
                                                            </div>
                                                            <div class="content">
                                                                <blockquote class="pull-right">
                                                                    <p>${blog.description}</p>
                                                                    <small><cite title="${blog.author}">${blog.author}</cite></small>
                                                                </blockquote>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                    <c:when test="${blog.type eq 'photo'}">
                                                        <div class="avatar">
                                                            <i class="icon-camera-retro icon-4x" title="${blog.title}"></i>
                                                        </div>
                                                        <div class="item">
                                                            <div class="controls">
                                                                <span class="date-text"><fmt:formatDate pattern="dd-MM-yyyy" value="${blog.created_at}"/></span>
                                                            </div>
                                                            <div class="heading">
                                                                <h4><a rel="nofollow" href="detail?id=${blog.id}">${blog.title}</a></h4>
                                                            </div>
                                                            <div class="content">
                                                                <div class="img-simple  ">
                                                                    <div class="image">
                                                                        <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979644._szw1280h1280_.jpg">
                                                                            <img src="${blog.image}"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <!-- PAGING START -->
                                    <div class="pagination" style="margin-top: 30px">
                                        <c:set var="pageNum" value="${(param.page != null&& param.page.matches('^[0-9+]$')) ? param.page : 1}"/>
                                        <c:set var="startPage" value="${requestScope.startPage}"/>
                                        <c:set var="endPage" value="${requestScope.endPage}"/>
                                        <c:set var="totalPage" value="${requestScope.totalPage}"/>
                                        <!--Nếu số bản ghi không hiển thị hết trong cùng 1 trang thì hiển thị paging-->
                                        <c:if test="${totalPage gt 1}">
                                            <a href="home?page=1">&laquo;</a>
                                            <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
                                                <a class="${(pageNum eq i) ? "active" : ""}" href="home?page=${i}">${i}</a>
                                            </c:forEach>
                                            <a href="home?page=${totalPage}">&raquo;</a>
                                        </c:if>
                                    </div>
                                    <!-- PAGING END -->
                                    <ul class="pager">
                                        <li><a rel="nofollow" href="overview">Overview</a></li>
                                    </ul>
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