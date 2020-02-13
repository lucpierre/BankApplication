<%-- 
    Document   : dashboardsAdvisor
    Created on : 6 févr. 2020, 19:59:26
    Author     : Charles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <title>Dashboards : Advisor</title>
    </head>
    <body>
        <div class="row">
            <%@include file="menuAdvisor.jsp"%>
            <div class="col-9">
                <div class=container>
                    <h2><u>Tableau de bord</u></h2>
                    <div class="row">
                        <div class="col-4">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/img/man.png" class="card-img-top"  alt="">
                                <div class="card-body">
                                  <h5 class="card-title">Clients</h5>
                                  <p class="card-text">Gérer la liste des clients.</p>
                                  <a href="#" class="btn btn-primary">Accéder aux clients</a>
                                </div>
                            </div>
                        </div>
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
                                <img src="${pageContext.request.contextPath}/img/phone.png" class="card-img-top" alt="">
                                <div class="card-body">
                                  <h5 class="card-title">Messages</h5>
                                  <p class="card-text">Gérer vos conversations.</p>
                                  <a href="#" class="btn btn-primary">Accéder aux messages</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
          </div>     
        </div>
    </body>
</html>