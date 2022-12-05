<%-- 
    Document   : index
    Created on : Mar 1, 2021, 11:48:59 PM
    Author     : Hoang Van Tue
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Photographer - Home Page</title>
        <%@include file="common/head.jsp" %>    <!-- This is Head File -->
    </head>
    <body data-pid="410915065" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="common/header.jsp" %>  <!-- This is Header File -->

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <div class="section article">
                                        <div class="content">
                                            <div class="img-simple span12 ">
                                                <div class="image">
                                                    <a rel="nofollow" title="Lorem ipsum dolor sit amet">
                                                        <img alt="" src="/kingphotos.com/view/images/home/main-img.jpg">
                                                    </a>
                                                </div>
                                                <div class="image-caption">
                                                    <p class="sub2">Lorem ipsum dolor sit amet</p>
                                                </div> 
                                            </div>

                                        </div>
                                    </div>
                                    <div class="section">
                                        <div class="content">
                                            <c:set var="listObj" value="${requestScope.listObj}"/>
                                            <c:set var="listSize" value="${listObj.size()}"/>
                                            <c:set var="maxRow" value="${(listSize - 1) / 3}"/>
                                            <c:forEach begin="0" end="${maxRow}" var="row">
                                                <ul class="thumbnails column-article-section">
                                                    <c:forEach begin="${row*3}" end="${((row*3 + 2) < (listSize - 1)) ? (row*3 + 2) : (listSize - 1)}" var="i">
                                                        <li class="span4">
                                                            <div class="img-simple span12 ">
                                                                <div class="image">
                                                                    <a rel="nofollow" >
                                                                        <img alt="${listObj.get(i).altText}" src="${listObj.get(i).image}">
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <h4>
                                                                <a rel="nofollow" href="${listObj.get(i).link}">${listObj.get(i).title}</a>
                                                            </h4>
                                                            <p>${listObj.get(i).description}</p>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </c:forEach>
                                        </div>

                                        <div class="pagination mt30  pull-right" >
                                            <c:set var="pageNum" value="${(param.page != null&& param.page.matches('^[0-9+]$')) ? param.page : 1}"/>
                                            <c:set var="startPage" value="${requestScope.startPage}"/>
                                            <c:set var="endPage" value="${requestScope.endPage}"/>
                                            <c:set var="totalPage" value="${requestScope.totalPage}"/>
                                            <!--Nếu số bản ghi không hiển thị hết trong cùng 1 trang thì hiển thị paging-->
                                            <c:if test="${totalPage gt 1}">
                                                <a href="home?page=1">&laquo;</a>
                                                <c:forEach begin="${startPage}" end="${endPage}" step="1" var="i"> 
                                                    <a class="${(pageNum eq i) ? "active" : ""}" href="home?page=${i}">${i}</a>
                                                </c:forEach> 
                                                <a href="home?page=${totalPage}">&raquo;</a>
                                            </c:if>
                                        </div>

                                    </div>
                                    <div class="section article">
                                        <div class="heading">
                                            <h3>About me</h3>
                                        </div>

                                        <div class="content">
                                            <p><span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip
                                                    ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue
                                                    duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim</span></p>    </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@include file="common/social-network.jsp" %>  <!-- This is Social Network File -->

                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="common/footer.jsp" %>      <!-- This is Footer File -->

        </div>
    </body>
</html>