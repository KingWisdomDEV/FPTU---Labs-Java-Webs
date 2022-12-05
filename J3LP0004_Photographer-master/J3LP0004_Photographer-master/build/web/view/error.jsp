<%-- 
    Document   : error
    Created on : Mar 2, 2021, 11:58:39 AM
    Author     : Hoang Van Tue
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Photographer - Contact</title>
        <%@include file="common/head.jsp" %>    <!-- This is Head File -->
    </head>
    <body>
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <%@include file="common/header.jsp" %>  <!-- This is Header File -->

            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                       <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper map-page">
                                <div class="heading">
                                    <h1 class="page-title">Error: ${requestScope.error}!!!</h1>
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