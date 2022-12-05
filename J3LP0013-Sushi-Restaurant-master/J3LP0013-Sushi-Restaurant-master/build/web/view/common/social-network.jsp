<%-- 
    Document   : social-network
    Created on : Jan 17, 2021, 8:21:15 PM
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
                            <li><a id="share-facebook" href="${refSocial.link}"><i class="${refSocial.icon}"></i><span>Share on ${refSocial.name}</span></a></li>
                        </c:forEach>
                    </ul>
                </span>
            </div>
        </div>
    </div>
</div>