<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../dependencies_css.jsp"%>
        <title>Espace conseiller</title>
    </head>
    
    <body>
        <div class="container-fluid row">
            <!-- Include du menu-->
            <%@include file="menuAdvisor.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Tableau de bord</h2>
                    </div>

                    <div class="card-deck">
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/img/man.png" class="card-img-top"  alt="">
                            <div class="card-body">
                              <h5 class="card-title">Clients</h5>
                              <p class="card-text">Gérer la liste des clients.</p>
                              <a href="#" class="btn btn-primary">Accéder aux clients</a>
                            </div>
                        </div>

                        <div class="card">
                            <img src="${pageContext.request.contextPath}/img/hand_coin.png" class="card-img-top" alt="">
                            <div class="card-body">
                              <h5 class="card-title">Comptes</h5>
                              <p class="card-text">Gérer votre compte courant.</p>
                              <a href="#" class="btn btn-primary">Accéder aux comptes</a>
                            </div>
                        </div>

                        <div class="card">
                            <img src="${pageContext.request.contextPath}/img/phone.png" class="card-img-top" alt="">
                            <div class="card-body">
                              <h5 class="card-title">Messages</h5>
                              <p class="card-text">Gérer vos conversations.</p>
                              <a href="#" class="btn btn-primary">Accéder aux messages</a>
                            </div>
                        </div>
                    </div>
                </section>
                            
            </div>
  
        </div>
                                
        <%@include file="../dependencies_js.jsp"%>
    
    </body>
</html>
