<%-- 
    Document   : downloaddetails
    Created on : Apr 1, 2024, 8:32:11 AM
    Author     : Mangala sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>download Page</title>
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
                           <h1> DOWNLOAD FILE</h1>
                        </div>
                        <div class="card-body">

                           <form action="DownServlet" method="post" enctype="multipart/form-data">
<!--                                <div class="form-group">
                                    <label for="user_name">Title</label>
                                    <input name="dTitle" type="text" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Enter name">-->

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Choose file to Download</label>
                                    <input name="dFile" type="file" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">

                                </div>
                               
                                <button type="submit"  class="btn" id="bitu" >DOWNLOAD</button>
                            </form>
                        </div>
                    </div>
                </div></div>
      
          
        

    </body>
</html>