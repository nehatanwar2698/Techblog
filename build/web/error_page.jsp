

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Sorry ! something went wrong</title>
      
       <!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
            .banner-background{
                clip-path: polygon(0 0, 100% 0, 100% 30%, 100% 94%, 70% 100%, 31% 96%, 0 100%, 0% 30%);
            }
        </style>
    </head>
    <body>
       <div class="container text-center">
            <!--for image responsive img-fluid--> 
            <img src="img/error.png" class="img-fluid" alt=""/>
            <h3 class="display-3">Sorry! something went wrong...</h3>
            <%= exception %>
            <a href="index.jsp" class="btn primary-background btn-lg text-white mt-3">Home</a>
        </div>
    </body>
</html>
