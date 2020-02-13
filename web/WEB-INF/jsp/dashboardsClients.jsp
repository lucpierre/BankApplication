<%-- 
    Document   : accueil.jsp
    Created on : 30 janv. 2020, 15:20:12
    Author     : clepaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Dashboards : Clients</title>
    </head>
    <body>
        <div class="row">
            <%@include file="menuClients.jsp"%>
            <div class="col-9">
                <div class=container>
                    <h2><u>Tableau de bord</u></h2>
                    <div class="row">
                        <div class="col-4">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/img/hand_coin.png" class="card-img-top" alt="">
                                <div class="card-body">
                                  <h5 class="card-title">Comptes</h5>
                                  <p class="card-text">Gérer votre compte courant.</p>
                                  <a href="#" class="btn btn-primary">Accéder aux comptes</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/img/hand_pig.png" class="card-img-top" alt="">
                                <div class="card-body">
                                  <h5 class="card-title">Livrets</h5>
                                  <p class="card-text">Gérer votre livret courant.</p>
                                  <a href="#" class="btn btn-primary">Accéder aux livrets</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/img/hand_bank.png" class="card-img-top" alt="">
                                <div class="card-body">
                                  <h5 class="card-title">Transactions</h5>
                                  <p class="card-text">Gérer vos virements.</p>
                                  <a href="#" class="btn btn-primary">Accéder aux transactions</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=container>
                    <h2> <u>Aperçu des contrats</u></h2>
                </div>
                <table class="table">
                    <thead class="header">
                        <tr class="contents">    
                            <th scope="col">Propriétaire</th>
                            <th scope="col">Type de contrat</th>
                            <th scope="col">Numéro de contrat</th>
                            <th scope="col">Solde</th>
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
