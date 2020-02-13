<%-- 
    Document   : managementClients
    Created on : 6 févr. 2020, 20:51:49
    Author     : Charles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <title>Management Clients</title>
    </head>
    <body>
        <div class="row">
            <%@include file="menuAdvisor.jsp"%>
            <div class="col-9">
                <div class=container>
                    <h2 id="contrat" > <u>Clients</u></h2>
                </div>
                <table class="table">
                    <thead class="header">
                        <tr class="contents">    
                            <th scope="col">N° Client</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Prénom</th>
                            <th scope="col">Téléphone</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="contents">
                            <td>

                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
          </div>
    </body>
</html>
