<%-- 
    Document   : index
    Created on : Mar 17, 2024, 10:37:40 AM
    Author     : Mangala sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/thecss.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    </head>
    <body>
        <div class="container1">
            <h1 class="fontcolor" >Welcome!</h1><h3 class="fontcolor">to the world of <span class="auto-input"></span></h3></div>
            <div class="container2">
        <a href="registration.jsp"class="fontcolor">Sign up</a>
        <a href="login.jsp"class="fontcolor">Login here</a></div>
        
        <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>

  <script>
    let typed = new Typed(".auto-input", {
      strings: [ "Cryptography"],
      typeSpeed: 100,
      backSpeed: 100,
      loop: true
    })
  </script>
        
    </body>
</html>
