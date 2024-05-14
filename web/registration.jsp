<%-- 
    Document   : registration
    Created on : Mar 17, 2024, 10:46:02 AM
    Author     : Mangala sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
         <link href="css/logcss.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
    </head>
    <body>
  <div class="container">
                <div class="col-md-6 offset-md-3">
                    
                        <div style="background-color:transparent;"class="card">
                        <div class="card-header text-center text-white">
                            <span class="fa fa-3x fa-user-circle"></span>
                            <br>
                           <h1> Register here</h1>
                        </div>
                        <div class="card-body">

                            <form  action="RegisterServlet" method="POST">
                                <div class="form-group">
                                    <label for="user_name">user name</label>
                                    <input name="user_name" type="text" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Enter name">

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="user_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="user_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="form-check">
                                    <input name="check" type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">agree terms and conditions</label>
                                </div><br>
                                <button type="submit"  class="btn" >Submit</button>
                            </form>
                        </div>
                    </div>
                </div></div>
      
          
        

    </body>
</html>
