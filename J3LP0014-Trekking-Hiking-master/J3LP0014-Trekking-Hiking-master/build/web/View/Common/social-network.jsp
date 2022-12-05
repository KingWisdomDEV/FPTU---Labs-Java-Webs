<%-- 
    Document   : social-network
    Created on : Jan 13, 2021, 11:44:30 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="right" class="span3">
    <div class="sidebar">
        <div class="wrapper share-box">
            <div class="heading">
                <h4>Share this page</h4>
            </div>
            <div class="content">
                <span>
                    <ul>
                        <c:forEach items="${requestScope.listSocialObj}" var="refSocial">
                            <li><a id="share-facebook" href="${refSocial.link}"><i class="icon-facebook-sign"></i><span>Share on ${refSocial.name}</span></a></li>
                            
                        </c:forEach>
         
<!--                        <li><a id="share-twitter" href="http://us-123hiking.simplesite.com/#"><i class="icon-twitter-sign"></i><span>Share on Twitter</span></a></li>
                        <li><a id="share-google-plus" href="http://us-123hiking.simplesite.com/#"><i class="icon-google-plus-sign"></i><span>Share on Google+</span></a></li>    -->
                    </ul>
                </span>
            </div>
        </div>
    </div>
</div>