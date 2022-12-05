<%-- 
    Document   : menu
    Created on : Jan 17, 2021, 8:14:01 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Sushi Restaurant - Menu and Price list</title>
        <%@include file="common/head.jsp" %>    
    </head>
    <body data-pid="410908035" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <!-- this is the Header Wrapper -->
            <%@include file="common/header.jsp" %>
            <script>
                document.querySelector('#header #topMenu > li:nth-child(2)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper list list-prices">
                                <div class="heading">
                                    <h1 class="page-title">Menu and Price list</h1>
                                </div>

                                <div class="content">
                                    <c:forEach items="${requestScope.listObj}" var="listObj">                                                                            
                                        <div class="section">
                                            <div class="content">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th>${listObj.name}</th>
                                                            <th class="align-right">Price</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>${listObj.shortDesc}</td>
                                                            <td class="align-right">€${listObj.price}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <p>${listObj.detailDesc}</p>
                                            </div>
                                        </div>
                                   </c:forEach>
                                    
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
                                        <a href="menu?page=1">&laquo;</a>
                                        <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
                                            <a class="${(pageNum eq i) ? "active" : ""}" href="menu?page=${i}">${i}</a>
                                        </c:forEach>
                                        <a href="menu?page=${totalPage}">&raquo;</a>
                                    </c:if>
                                </div>
                                <!-- PAGING END -->
                        </div>
                        <%@include file="common/social-network.jsp" %>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <!-- this is the Footer Wrapper -->
            <%@include file="common/footer.jsp" %>
        </div>
    </body>
</html>