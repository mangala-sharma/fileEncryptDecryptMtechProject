<%-- 
    Document   : accont
    Created on : Mar 20, 2024, 8:37:17 AM
    Author     : Mangala sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.thesis.entities.Customer"%>
<%@page import="com.thesis.helper.ConnectionProvider"%>
<%
    Customer cuser=(Customer)session.getAttribute("currentUser");
    if(cuser==null){
        response.sendRedirect("login.jsp");
    }
%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user profile</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
         <link href="css/procss.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body><nav>
        <h1>WELCOME <%=(String)cuser.getName()%></h1>
       
        <a class="rd" href="LogoutServlet">Logout</a>
        </nav>
        <div class="imgdp">
           <div>
            <img src="./images/uploadimg.jpg" >        
            <a href="uploaddetails.jsp" class="bt">ENCRYPT AND UPLOAD</a>
           </div>  
        <div>
            <img src="./images/imagesdnld.jpg">
           <a href="downloaddetails.jsp" class="bt">DECRYPT AND DOWNLOAD</a>
        </div>
    </body>
</html>
