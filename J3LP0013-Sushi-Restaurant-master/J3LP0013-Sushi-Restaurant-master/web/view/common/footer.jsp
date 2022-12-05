<%-- 
    Document   : footer
    Created on : Jan 17, 2021, 8:21:01 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid footer-wrapper" id="footer"> <!-- this is the Footer Wrapper -->
    <div class="container">
        <div class="footer-info">
            <div class="footer-powered-by">
                <a rel="nofollow" href="http://www.simplesite.com/">Created with SimpleSite</a>
            </div>
        </div>
        <div class="footer-page-counterr" >
            <c:set var="views" value="${sessionScope.views}"/>
            <c:forEach begin="0" end="${views.length()-1}" var="i">
                <span class="footer-page-counterr-item">${views.charAt(i)}</span>
            </c:forEach>
        </div>
    </div>
</div>  <!-- this is the Footer content -->
