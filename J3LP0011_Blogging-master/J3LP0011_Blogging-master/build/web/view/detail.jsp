<%-- 
    Document   : detail
    Created on : Jan 25, 2021, 9:09:31 AM
    Author     : hoang
--%>

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
                                <div class="content">
                                    <!--<div class="section">-->
                                    <c:set var="blog" value="${requestScope.blog}"/>
                                    <div class="content section">
                                        <div class="avatar">
                                            <i class="icon-pencil icon-4x" title="${blog.title}"></i>
                                        </div>
                                        <div class="blog-post-body section"><!-- change class item-->
                                            <div class="controls">
                                                <span class="date-text"><fmt:formatDate pattern="dd-MM-yyyy" value="${blog.created_at}"/></span>
                                            </div>
                                            <div class="heading">
                                                <h1 class="page-title">
                                                    ${blog.title}<!-- remove tag <a>-->
                                                </h1>
                                            </div>
                                            <div class="content">
                                                <c:choose>
                                                    <c:when test="${blog.type eq 'article'}">
                                                        <div class="img-simple span6 pull-left">
                                                            <div class="image">
                                                                <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979646._szw1280h1280_.jpg">
                                                                    <img src="${blog.image}"></a>
                                                            </div>
                                                        </div>

                                                        <p>${blog.description}</p>

                                                    </c:when>
                                                    <c:when test="${blog.type eq 'quote'}">
                                                        <blockquote class="pull-right">
                                                            <p>${blog.description}</p>
                                                            <small><cite title="${blog.author}">${blog.author}</cite></small>
                                                        </blockquote>
                                                    </c:when>
                                                    <c:when test="${blog.type eq 'photo'}">
                                                        <div class="img-simple  ">
                                                            <div class="image">
                                                                <a rel="nofollow" data-ss="imagemodal" data-href="http://cdn.simplesite.com/i/2b/ac/283445309157387307/i283445314544979644._szw1280h1280_.jpg">
                                                                    <img src="${blog.image}"></a>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                        <ul class="pager">
                                            <li><a rel="nofollow" href="overview">Overview</a></li>
                                        </ul>
                                    </div>
                                    <!--</div>-->
                                </div>
                            </div>
                        </div>
                        <%@include file="common/social-network.jsp" %>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="common/footer.jsp" %>
        </div>
        <!--<input type="hidden" id="anti-forgery-token" value="vFZIp11QDd7w1cZjYdzwVVw3rTHgQi1lpMMqomvLq/qGfx85dADIn6rd+jb5+yvdIjnIKNejlFu6vxL7J8Np5QtYxMO7KxUwpKwR1V4MTCZvfvBVhll5sGimLd7DS4WTYgLaoyK+AfpiYPfJlTfD4VlLDnc4aUkyu0u2h6GbOOJSUwXs1LZ3H/lwNbmNQWcngM400FNVEqERIEJkQmMs1V0a3yE5f+bY2/CvfJ48RfbrCqnL2iJwFAVWFXS9uEVcEIDwN6N9464sGf8+yoweVl4xlsm/nZ90cnSKbLg3UwlHzrBh3duF3dxkhnYMtVz0mpq/JRQkyH9QUM6LsGK62tEzdPRln3gqXEVJCRReMz6lE07y+w1hf9b4vgh2H99OqeB8sCIQjhiki0fgi4ztjAQI6rIGYIR5ue9e51AHkUCmw1Sq+9LZvaIvHXFkyqFmeOPCYsJrtgoytUNDrsV4Mg==">-->
        <!--        <div id="sm2-container" class="movieContainer high_performance" style="z-index: 10000; position: fixed; width: 8px; height: 8px; bottom: 0px; left: 0px; overflow: hidden; visibility: hidden;"><embed name="sm2movie" id="sm2movie" src="/Images/sm297/soundmanager2_flash9.swf" quality="high" allowscriptaccess="always" bgcolor="#ffffff" pluginspage="www.macromedia.com/go/getflashplayer" title="JS/Flash audio component (SoundManager 2)" type="application/x-shockwave-flash" wmode="transparent" haspriority="true">
                </div>-->
    </body>
</html>


