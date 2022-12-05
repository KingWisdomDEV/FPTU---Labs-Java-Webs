<%-- 
    Document   : trekking-links
    Created on : Jan 5, 2021, 2:53:56 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Trekking Links - Trekking and Hiking</title>
        <%@include file="Common/head.jsp" %>
    </head>
    <body data-pid="411163294" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="Common/header.jsp" %> <!-- this is the Header Wrapper -->
            <script>
                document.querySelector('#header #topMenu > li:nth-child(4)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper list list-links">
                                <div class="heading">
                                    <h1 class="page-title">Trekking Links</h1>
                                </div>

                                <div class="content">
                                    <c:forEach items="${requestScope.listObj}" var="refLink">                                        
                                        <div class="section">
                                            <div class="content">
                                                <div class="span12">
                                                    <div class="item">
                                                        <div class="heading">
                                                            <h4><a rel="nofollow" target="_blank" href="${refLink.link}">${refLink.title}</a></h4>
                                                        </div>
                                                        <div class="content">
                                                            <p>${refLink.short_desc}</p>                    
                                                        </div>
                                                    </div>
                                                </div>
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
                                    <a href="trekking-link?page=1">&laquo;</a>
                                    <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
                                        <a class="${(pageNum eq i) ? "active" : ""}" href="trekking-link?page=${i}">${i}</a>
                                    </c:forEach>
                                    <a href="trekking-link?page=${totalPage}">&raquo;</a>
                                </c:if>
                            </div>
                            <!-- PAGING END -->
                        </div>
                        <%@include file="Common/social-network.jsp" %><!-- this is the Social Network Tile -->
                    </div>                    
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="Common/footer.jsp" %> <!-- this is the Footer Wrapper -->
        </div>
    </body>
</html>