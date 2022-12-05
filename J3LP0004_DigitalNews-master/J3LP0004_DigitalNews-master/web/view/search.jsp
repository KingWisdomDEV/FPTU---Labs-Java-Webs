<%-- 
    Document   : index
    Created on : Feb 24, 2021, 10:37:47 PM
    Author     : hoang
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Digital News - Result Search</title>
        <%@include file="common/head.jsp" %>
    </head>
    <body>
        <div class="uk-container uk-container-center">
            <%@include file="common/header.jsp" %>
            <main class="main-content">
                <div class="uk-clearfix">
                    <c:set var="keyword" value="${param.keyword}"/>
                    <section class="content result-page">
                        <div class="title">Result search for: ${keyword}</div>
                        <hr>
                        <c:choose>
                            <c:when test="${requestScope.listObj.size() > 0}">
                                <c:forEach items="${requestScope.listObj}" var="post">
                                    <div class="article mt20 uk-clearfix">
                                        <div class="title"><a href="home?id=${post.id}" title="${post.title}">${post.title}</a></div>
                                        <div class="main-img">
                                            <img src="${post.image}" alt="Eye digital">
                                        </div>
                                        <div class="description">
                                            ${post.description.substring(0,500)}
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="article mt20 uk-clearfix">
                                    <div class="title">Kết quả tìm kiếm không tồn tại!</div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="pagination mt30  uk-clearfix" >
                            <c:set var="pageNum" value="${(param.page != null&& param.page.matches('^[0-9+]$')) ? param.page : 1}"/>
                            <c:set var="startPage" value="${requestScope.startPage}"/>
                            <c:set var="endPage" value="${requestScope.endPage}"/>
                            <c:set var="totalPage" value="${requestScope.totalPage}"/>
                            <!--Nếu số bản ghi không hiển thị hết trong cùng 1 trang thì hiển thị paging-->
                            <c:if test="${totalPage gt 1}">
                                <a href="search?page=1&keyword=${keyword}">&laquo;</a>
                                <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i"> 
                                    <a class="${(pageNum eq i) ? "active" : ""}" href="search?page=${i}&keyword=${keyword}">${i}</a>
                                </c:forEach> 
                                <a href="search?page=${totalPage}&keyword=${keyword}">&raquo;</a>
                            </c:if>
                        </div>
                    </section>
                    <aside class="right-sidebar">
                        <div class="recent-news">
                            <div class="title">Digital News</div>
                            <div class="description">
                                <a href="home?id=${requestScope.lastPostId}" title="">${requestScope.shortDesc}</a>
                            </div>
                        </div>
                        <div class="search-news">
                            <div class="title">Search</div>
                            <div class="search-tile">
                                <form action="search">
                                    <input type="text" name="keyword" value="${param.keyword}" required="" pattern=".*\S+.*" 
                                           class="keyword" placeholder="Enter keyword...">
                                    <button type="submit">Go</button>
                                </form>
                            </div>
                        </div>
                        <div class="top-news">
                            <div class="title">Last Articles</div>
                            <ul class="recent-articles">
                                <c:forEach items="${requestScope.listTop5Post}" var="recentPost">
                                    <li><a href="home?id=${recentPost.id}" title="">${recentPost.title}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </aside>
                </div>
            </main>
            <%@include file="common/footer.jsp" %>
        </div>
    </body>
</html>