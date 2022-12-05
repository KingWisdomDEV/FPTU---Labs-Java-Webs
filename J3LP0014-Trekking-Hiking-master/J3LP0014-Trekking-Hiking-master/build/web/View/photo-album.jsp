<%-- 
    Document   : photo-album
    Created on : Jan 5, 2021, 2:53:45 PM
    Author     : hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" class="">
    <head>
        <title>Photoalbum - Trekking and Hiking</title>
        <%@include file="Common/head.jsp" %>
    </head>
    <body data-pid="411163283" data-iid="">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="Common/header.jsp" %> <!-- this is the Header Wrapper -->
            <script>
                document.querySelector('#header #topMenu > li:nth-child(3)').className = "active";
            </script>
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper photo-album photo-album-compact">
                                <div class="heading">
                                    <h1 class="page-title">Photo Album</h1>
                                </div>
                                <c:set scope="request" var="photo" value="${requestScope.listObj}" />
                                <div class="content"> <!-- Slideshow -->
                                    <div class="section">
                                        <div class="content">
                                            <div class="slideshow"  data-ss="albumslideshow">
                                                <img id="btn-play"  src="/Trekking_and_Hiking/View/Image/play.png"/>
<!--                                                <object width="100%" height="425px" id="flash-2303" type="application/x-shockwave-flash" data="./Photoalbum - us-123hiking.simplesite.com_files/fotoalbum20110225b.swf" style="visibility: visible;">
                                                    <param name="wmode" value="transparent">
                                                    <param name="allowfullscreen" value="true">
                                                    <param name="quality" value="best">
                                                    <param name="allowscriptaccess" value="always">
                                                    <param name="flashvars" value="mode=normal&amp;xmlurl=http%3A%2F%2Fwww.simplesite.com%2Fuserpages%2Fpages%2FPhotoAlbumSlideShowXml.aspy%3Fid%3D411163283%26cid%3D10723027&amp;imageid=95199546">
                                                </object>-->
                                                <img id="show-img" width="80%" src="/Trekking_and_Hiking/View/Image/Photo/pic1.jpg">
                                                <img id="btn-pause" style="display: none" src="/Trekking_and_Hiking/View/Image/pause.png"/>
                                            </div>                    
                                        </div>
                                    </div>
                                    <div class="section"> 
                                        <div class="content">
                                            <c:forEach begin="0" end="${photo.size()-1}" var="i">
                                                <c:if test="${i % 4 == 0}">
                                                    <ul class="thumbnails" data-ss="">
                                                    </c:if>
                                                    <li class="span3">
                                                        <div>
                                                            <div class="thumbnail" onclick='changeImage("${photo.get(i).getImage()}")'>
                                                                <a rel="nofollow" href="javascript:void(0)" >
                                                                    <img src="${photo.get(i).getImage()}"></a>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <c:if test="${i % 4 == 3 || i == photo.size()-1}">
                                                    </ul>
                                                </c:if>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@include file="Common/social-network.jsp" %><!-- this is the Social Network Tile -->
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <%@include file="Common/footer.jsp" %> <!-- this is the Footer Wrapper -->
        </div>
    </body>
</html>