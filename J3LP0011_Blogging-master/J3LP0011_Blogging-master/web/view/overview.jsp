<%-- 
    Document   : overview
    Created on : Jan 25, 2021, 9:09:24 AM
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
                                    <h1 class="page-title">Overview - My Blog</h1>
                                </div>

                                <div class="content">
                                    <div class="section">
                                        <div class="content">
                                            <table class="table"> <!-- can be bordered, striped, hover, condensed -->
                                                <thead>
                                                    <tr>
                                                        <th  colspan="3">NOVEMBER 2015</th>
                                                        <th  class="align-right">Date</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.listObj}" var="blog">
                                                        <tr >
                                                            <td width="60%"><a href="detail?id=${blog.id}">${blog.title}</a></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td class="align-right">
                                                                <fmt:formatDate pattern="dd-MM-yyyy" value="${blog.created_at}"/>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                
                                <!-- PAGING START -->
                                <div class="pagination" style="margin-top: 30px">
                                    <c:set var="pageNum" value="${(param.page != null && param.page.matches('^[0-9+]$')) ? param.page : 1}"/>
                                    <c:set var="startPage" value="${requestScope.startPage}"/>
                                    <c:set var="endPage" value="${requestScope.endPage}"/>
                                    <c:set var="totalPage" value="${requestScope.totalPage}"/>
                                    <!--Nếu số bản ghi không hiển thị hết trong cùng 1 trang thì hiển thị paging-->
                                    <c:if test="${totalPage gt 1}">
                                        <a href="overview?page=1">&laquo;</a>
                                        <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
                                            <a class="${(pageNum eq i) ? "active" : ""}" href="overview?page=${i}">${i}</a>
                                        </c:forEach>
                                        <a href="overview?page=${totalPage}">&raquo;</a>
                                    </c:if>
                                </div>
                                <!-- PAGING END -->
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


