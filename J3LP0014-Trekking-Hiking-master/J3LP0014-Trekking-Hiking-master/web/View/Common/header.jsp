<%-- 
    Document   : header.jsp
    Created on : Jan 5, 2021, 2:47:35 PM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
    <div class="container">
        <div class="title-wrapper">
            <div class="title-wrapper-inner">
                <a rel="nofollow" class="logo " href="home"></a>
                <div class="title ">
                    Trekking and Hiking
                </div>
                <div class="subtitle">
                    Welcome to our website
                </div>
            </div>
        </div>  <!-- these are the titles -->
        <div class="navbar navbar-compact">
            <div class="navbar-inner">
                <div class="container">
                    <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                    <a rel="nofollow" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" title="Toggle menu">
                        <span class="menu-name">Menu</span>
                        <span class="menu-bars">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </span>
                    </a>

                    <!-- Everything you want hidden at 940px or less, place within here -->
                    <div class="nav-collapse collapse">
                        <ul class="nav" id="topMenu" data-submenu="horizontal">
                            <li class="" style="">
                                <a rel="nofollow" href="home">Front page</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="our-diary">Our Diary</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="photo-album">Photoalbum</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="trekking-link">Trekking Links</a>
                            </li>               
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- this is the Menu content -->
    </div>
</div>  <!-- this is the Header content -->
