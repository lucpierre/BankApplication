<%-- 
    Document   : passboookA
    Created on : 6 févr. 2020, 21:00:55
    Author     : Charles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
       <title>Passbook A</title>
    </head>
    <body>
        <div class="row">
            <%@include file="menuClients.jsp"%>
            <div class="col-9">
                <div class=container>
                    <h2><u>Livret A</u></h2>
                    <fieldset>
                        <h4>Hello world!</h4>
                    </fieldset>
                </div>
                <%@include  file="lastsDeals.jsp"%>
            </div>
          </div>      
    </body>
</html>
