<%-- 
    Document   : header
    Created on : Mar 1, 2021, 11:59:13 PM
    Author     : Hoang Van Tue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
    <div class="container">
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
                            <li class=" active " style="">
                                <a rel="nofollow" href="home">My front page</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="gallery?groupGallery=1">Gallery 1</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="gallery?groupGallery=2">Gallery 2</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="gallery?groupGallery=3">Gallery 3</a>
                            </li><li class="  " style="">
                                <a rel="nofollow" href="contact">Contact</a>
                            </li>                
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- this is the Menu content -->
        <div class="title-wrapper">
            <div class="title-wrapper-inner">
                <a rel="nofollow" class="logo " href="home">
                </a>
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>  <!-- these are the titles -->
    </div>
</div>  <!-- this is the Header content -->
