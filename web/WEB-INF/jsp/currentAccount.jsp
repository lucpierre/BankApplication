<%-- 
    Document   : currentAccount
    Created on : 6 févr. 2020, 20:40:31
    Author     : Charles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Current Account</title>
    </head>
    <body>
        <div class="row">
            <%@include file="menuClients.jsp"%>
            <div class="col-9">
                <div class=container>
                    <h2 ><u>Compte courant</u></h2>
                    <div class="row">
                        <fieldset>
                            <h1>Hello world!</h1> 
                        </fieldset> 
                    </div>
                </div>
                <%@include file="lastDeals.jsp"%>
            </div>
          </div>       
    </body>
</html>
