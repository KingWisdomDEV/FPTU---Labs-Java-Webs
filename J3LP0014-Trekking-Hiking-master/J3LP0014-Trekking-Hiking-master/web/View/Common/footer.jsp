<%-- 
    Document   : footer.jsp
    Created on : Jan 5, 2021, 2:47:59 PM
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
            <%--<jsp:useBean class="common.SessionCounter" id="viewed" scope="application" />--%>
            <c:set var="views" value="${sessionScope.views}"/>
            <c:forEach begin="0" end="${views.length()-1}" var="i">
                <span class="footer-page-counterr-item">${views.charAt(i)}</span>
            </c:forEach>
        </div>
            <!--<div id="css_simplesite_com_fallback" class="hide"></div>-->
    </div>
</div>  <!-- this is the Footer content -->
