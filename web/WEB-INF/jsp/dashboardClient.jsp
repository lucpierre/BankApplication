<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="dependencies_css.jsp"%>
        <title>Espace client</title>
    </head>
    
    <body>
        <div class="container-fluid row">
            <!-- Include du menu-->
            <%@include file="menuClient.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Tableau de bord : ${last_name}</h2>
                    </div>

                    <div class="card-deck">
                        <div class="card">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/img/hand_coin.png" alt="">
                            <div class="card-body">
                                <h5 class="card-title">Comptes</h5>
                                <p class="card-text">Gérer votre compte courant.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux comptes</a></p>
                            </div>
                        </div>
                        <div class="card">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/img/hand_pig.png" alt="">
                            <div class="card-body">
                                <h5 class="card-title">Livrets</h5>
                                <p class="card-text">Gérer votre livret courant.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux livrets</a></p>
                            </div>
                        </div>
                        <div class="card">
                            <img class="card-img-top" src="${pageContext.request.contextPath}/img/hand_bank.png" alt="">
                            <div class="card-body">
                                <h5 class="card-title">Transactions</h5>
                                <p class="card-text">Gérer vos virements.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux transactions</a></p>
                            </div>
                        </div>
                    </div>
                </section>
                            
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Aperçu des contrats</h2>
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

                </section>

                
            </div>
  
        </div>
                                
        <%@include file="dependencies_js.jsp"%>
    
    </body>
</html>
