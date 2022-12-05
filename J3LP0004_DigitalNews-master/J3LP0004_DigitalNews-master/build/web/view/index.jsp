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
        <title>Digital News - Home Page</title>
        <%@include file="common/head.jsp" %>
    </head>
    <body>
        <div class="uk-container uk-container-center">
            <%@include file="common/header.jsp" %>
            <main class="main-content">
                <div class="uk-clearfix">
                    <c:set var="post" value="${requestScope.post}"/>
                    <section class="content">
                        <div class="article">
                            <div class="title">${post.title}</div>
                            <div class="main-img">
                                <img src="${post.image}" alt="Eye digital">
                            </div>
                            <div class="description">
                                ${post.description}
                            </div>
                            <div class="signature">
                                <div class="icon1"><img src="/digitalnews.com/view/images/comment.gif" alt=""></div>
                                <div class="icon2"><img src="/digitalnews.com/view/images/timeicon.gif" alt=""></div>
                                <span>${post.author} | <fmt:formatDate pattern="MMM dd yyyy hh:mm a" value="${post.createdDate}"/></span>
                            </div>
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